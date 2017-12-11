package com.xxl.job.executor.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.ListOrderedMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class CimissUtil {

	private static final Logger Logger = LoggerFactory.getLogger(CimissUtil.class);

	public static List<Map<String, Object>> getCimissData(Map<String, Object> map, String wsdl, String targetNamespace,
			String timeoutInMilliSeconds) {
		if (!map.isEmpty()) {
			String params = "";
			for (String para : map.keySet()) {
				params = params + para + "=" + map.get(para) + "&";
			}
			/* 调用接口 */
			String rstData = WebsUtil.getWsString("callAPI_to_serializedStr", params.substring(0, params.length() - 1),
					wsdl, targetNamespace, timeoutInMilliSeconds);
			// 实况数据转换
			List<Map<String, Object>> li = CimissUtil.getListMap(rstData);
			return li;
		}
		return null;
	}

	/**
	 * 数据处理
	 * 
	 * @param rstData
	 * @return
	 */
	public static List<Map<String, Object>> getListMap(String rstData) {
		List<Map<String, Object>> cimissData = new ArrayList<Map<String, Object>>();
		rstData = "[" + rstData + "]";
		// 解析返回的json
		JSONArray jsonArr = JSONArray.fromObject(rstData);
		List<Map<String, Object>> ls = new ArrayList<Map<String, Object>>();
		Iterator<JSONObject> it = jsonArr.iterator();
		boolean status = true;
		while (it.hasNext()) {
			JSONObject json2 = it.next();
			Map<String, Object> map = parseJSON2Map(json2.toString());
			String returnCode = map.get("returnCode") + "";
			String returnMessage = map.get("returnMessage") + "";
			if (!returnCode.equals("0")) {
				Logger.error("获取cimiss数据异常(returnCode:" + returnCode + ")：" + returnMessage);
				status = false;
			}
			ls.add(map);
		}
		if (status) {
			jsonArr = JSONArray.fromObject(ls.get(0).get("DS"));
			it = jsonArr.iterator();
			while (it.hasNext()) {
				JSONObject json2 = it.next();
				Map<String, Object> map = parseJSON2Map(json2.toString());
				// 处理数据时间+8
				// map.put("Datetime",
				// DateUtils.getDateHourAdd(DateUtils.getDate(map.get("Datetime")+"",DateUtils.FORMAT_yyyy_MM_dd_hh_mm_ss),
				// 8));
				cimissData.add(map);
			}
		}
		ls.clear();
		it = null;
		jsonArr.clear();
		return cimissData;
	}

	/**
	 *
	 * json转换map. <br>
	 * 详细说明
	 *
	 * @param jsonStr
	 *            json字符串
	 * @return
	 * @return Map<String,Object> 集合
	 * @throws @author
	 *             slj
	 */
	public static Map<String, Object> parseJSON2Map(String jsonStr) {
		ListOrderedMap map = new ListOrderedMap();
		// 最外层解析
		JSONObject json = JSONObject.fromObject(jsonStr);
		for (Object k : json.keySet()) {
			Object v = json.get(k);
			// 如果内层还是数组的话，继续解析
			if (v instanceof JSONArray) {
				List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
				Iterator<JSONObject> it = ((JSONArray) v).iterator();
				while (it.hasNext()) {
					JSONObject json2 = it.next();
					list.add(parseJSON2Map(json2.toString()));
				}
				map.put(k.toString(), list);
			} else {
				map.put(k.toString(), v);
			}
		}
		return map;
	}

}
