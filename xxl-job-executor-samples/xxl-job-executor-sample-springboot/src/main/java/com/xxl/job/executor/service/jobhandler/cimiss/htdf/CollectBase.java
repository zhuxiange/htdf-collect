package com.xxl.job.executor.service.jobhandler.cimiss.htdf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.executor.db.DBConfig;
import com.xxl.job.executor.util.CimissConfig;
import com.xxl.job.executor.util.CimissUtil;
import com.xxl.job.executor.util.constant.DBConstant;

/**
 * 这是个采集的采集基础类,封装好了方法顺序,编辑参数param(),获取数据getData(),处理(即发送)数据<br>
 * 这三个方法在execute()里顺序执行，必要时在继承类里重写，互不影响;<br>
 * 目前必须重写的是param()
 * 
 * @author LinShu
 *
 */
public abstract class CollectBase extends IJobHandler {

	private static final Logger Logger = LoggerFactory.getLogger(CollectBase.class);

	@Autowired
	protected CimissConfig cimissConfig;

	@Autowired
	protected DBConfig dbConfig;

	// public abstract void lalal();
	/**
	 * 采集源的类型
	 */
	private String _type = "";

	public CollectBase(String type) {
		this._type = type;
	}

	@Override
	public ReturnT<String> execute(String... params) throws Exception {
		// 参数
		Map<String, Object> map = param();
		Logger.info(this.getClass().getSimpleName() + "--参数[ " + map + " ]");
		// 获取数据
		List<Map<String, Object>> li = getData(map);
		Logger.info(this.getClass().getSimpleName() + "--获取数据记录条数[ " + li.size() + " ]");
		// 处理(包括发送)
		handlerData(li);
		Logger.info(this.getClass().getSimpleName() + "--处理了");
		return new ReturnT<>(ReturnT.SUCCESS_CODE, "成功！");
	}

	/**
	 * 这个必须重写 <br>
	 * 这个是编写参数的方法，默认 添加了CIMISS三个参数
	 * userId、pwd这个是从配置文件获取的，默认是取cimiss.properties;dataFormat默认为json
	 * 
	 * @return
	 */
	protected Map<String, Object> param() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", cimissConfig.getUsername());
		map.put("pwd", cimissConfig.getPassword());
		map.put("dataFormat", "json");
		return map;
	}

	/**
	 * 这个是获取数据的方法，目前自动区别调用CimissUtil.getCimissData 获取cimiss;<br>
	 * dbConfig.select(String strSql, String sign) 获取数据库的<br>
	 * 需求变化时重写<br>
	 * 
	 * @see com.xxl.job.executor.util.CimissUtil.getCimissData
	 * @see List<Map<String, Object>> com.xxl.job.executor.db.DBConfig.select(String
	 *      strSql, String sign)
	 * @return
	 */
	protected List<Map<String, Object>> getData(Map<String, Object> map) {
		List<Map<String, Object>> rl = new ArrayList<>();
		// 获取数据

		switch (_type) {
		case DBConstant.CIMISS:
			rl = CimissUtil.getCimissData(map, cimissConfig.getWsdl(), cimissConfig.getTargetNamespace(),
					cimissConfig.getTimeoutInMilliSeconds());
			break;
		case DBConstant.ORACLE:
			rl = dbConfig.select(map.get("sql").toString(), DBConstant.ORACLE);
			break;
		case DBConstant.MYSQL:
			// rl = dbConfig.select(map.get("sql").toString(), DBConstant.MYSQL);
			// TODO 暂为实现
			break;
		}

		return rl;
	}

	/**
	 * 这个是处理获取到的数据接口，打算的的作用是将数据发送给kafa，目前只是实现打印，到时要改掉<br>
	 * 还需完善
	 * 
	 * @param list
	 */
	protected void handlerData(List<Map<String, Object>> list) {
		// 循环获取的数据
		for (Map<String, Object> map1 : list) {
			System.out.println("----------------");
			Set<String> m = map1.keySet();
			for (String s : m) {
				System.out.println(s + ":" + map1.get(s));
			}
		}
//		System.out.println(this.getClass().getSimpleName() + ":" + list.size());
	}

	/**
	 * 获取该类的采集源的类型
	 * 
	 * @return
	 */
	public String getType() {
		return _type;
	}
}
