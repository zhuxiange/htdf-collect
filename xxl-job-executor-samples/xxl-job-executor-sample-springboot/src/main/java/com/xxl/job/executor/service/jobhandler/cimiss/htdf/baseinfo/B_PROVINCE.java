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
 * 采集省份编码
 * 
 * @author LinShu
 *
 */
@JobHander(value = "b_province")
@Service
public class B_PROVINCE extends CollectBase {

	public B_PROVINCE() {
		super(DBConstant.ORACLE);
	}

	@SuppressWarnings("unused")
	private static final Logger Logger = LoggerFactory.getLogger(B_PROVINCE.class);

	@Override
	protected Map<String, Object> param() {
		Map<String, Object> map = new HashMap<>();
		map.put("sql", "select * from PROVINCECODE");
		return map;
	}
}
