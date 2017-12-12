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
 * 采集风廓线雷达站点
 * 
 * @author LinShu
 *
 */
@JobHander(value = "b_windradar_station")
@Service
public class B_WINDRADAR_STATION extends CollectBase {

	public B_WINDRADAR_STATION() {
		super(DBConstant.ORACLE);
	}

	@SuppressWarnings("unused")
	private static final Logger Logger = LoggerFactory.getLogger(B_WINDRADAR_STATION.class);

	@Override
	protected Map<String, Object> param() {
		Map<String, Object> map = new HashMap<>();
		map.put("sql", "select * from STA_WPRD");
		return map;
	}
}
