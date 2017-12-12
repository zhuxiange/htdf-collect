package com.xxl.job.executor.service.jobhandler.cimiss.htdf.baseinfo;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.xxl.job.core.handler.annotation.JobHander;
import com.xxl.job.executor.service.jobhandler.cimiss.htdf.CollectBase;
import com.xxl.job.executor.util.constant.DBConstant;

/**
 * TODO 待向工提供，这个是国家站的数据
 * 采集区域站站点
 * 
 * @author LinShu
 *
 */
@JobHander(value = "b_region_station")
@Service
public class B_REGION_STATION extends CollectBase {

	public B_REGION_STATION() {
		super(DBConstant.ORACLE);
	}

	@SuppressWarnings("unused")
	private static final Logger Logger = LoggerFactory.getLogger(B_REGION_STATION.class);

	@Override
	protected Map<String, Object> param() {
		Map<String, Object> map = new HashMap<>();
		map.put("sql", "select * from STA_AWS");
		return map;
	}
}
