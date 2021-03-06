package com.xxl.job.executor.service.jobhandler.cimiss.htdf.statistics;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.xxl.job.core.handler.annotation.JobHander;
import com.xxl.job.executor.service.jobhandler.cimiss.htdf.CollectBase;
import com.xxl.job.executor.util.constant.DBConstant;

/**
 * 采集雷电历史强度统计(日)
 * 
 * @author LinShu
 *
 */
@JobHander(value = "s_flashlight_intensity_dd")
@Service
public class S_FLASHLIGHT_INTENSITY_DD extends CollectBase {

	public S_FLASHLIGHT_INTENSITY_DD() {
		super(DBConstant.ORACLE);
	}

	@SuppressWarnings("unused")
	private static final Logger Logger = LoggerFactory.getLogger(S_FLASHLIGHT_INTENSITY_DD.class);

	@Override
	protected Map<String, Object> param() {
		Map<String, Object> map = new HashMap<>();
		map.put("sql", "select * from DATA_FLASHLIGHTINTENSITY_DAY");
		return map;
	}
}
