package com.xxl.job.executor.service.jobhandler.cimiss.htdf.data;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.xxl.job.core.handler.annotation.JobHander;
import com.xxl.job.executor.service.jobhandler.cimiss.htdf.CollectBase;
import com.xxl.job.executor.util.constant.DBConstant;

/**
 * 雷电定位
 * 
 * @author LinShu
 *
 */
@JobHander(value = "d_flashlight")
@Service
public class D_FLASHLIGHT extends CollectBase {

	public D_FLASHLIGHT() {
		super(DBConstant.ORACLE);
	}

	@SuppressWarnings("unused")
	private static final Logger Logger = LoggerFactory.getLogger(D_FLASHLIGHT.class);

	@Override
	protected Map<String, Object> param() {
		Map<String, Object> map = new HashMap<>();
		map.put("sql", "select * from DATA_FLASHLIGHT");
		return map;
	}
}
