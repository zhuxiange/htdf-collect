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
 * 采集自动站站点
 * 
 * @author LinShu
 *
 */
@JobHander(value = "b_national_station")
@Service
public class B_NATIONAL_STATION extends CollectBase {

	public B_NATIONAL_STATION() {
		super(DBConstant.ORACLE);
	}

	@SuppressWarnings("unused")
	private static final Logger Logger = LoggerFactory.getLogger(B_NATIONAL_STATION.class);

	@Override
	protected Map<String, Object> param() {
		Map<String, Object> map = new HashMap<>();
		map.put("sql", "select * from STA_AWS");
		return map;
	}
}
