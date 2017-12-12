package com.xxl.job.executor.service.jobhandler.cimiss.htdf.data;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.xxl.job.core.handler.annotation.JobHander;
import com.xxl.job.executor.service.jobhandler.cimiss.htdf.CollectBase;

/**
 * 采集土壤资料数据
 * 
 * @author LinShu
 *
 */
@JobHander(value = "d_soil")
@Service
public class D_SOIL extends CollectBase {


	@SuppressWarnings("unused")
	private static final Logger Logger = LoggerFactory.getLogger(D_SOIL.class);

	/* 
	 * TODO 时间得处理
	 */
	@Override
	protected Map<String, Object> param() {
		Map<String, Object> map = super.param();
		map.put("dataCode", "AGME_CHN_SOIL_HOR");
		map.put("interfaceId", "getAgmeEleByTime");
		map.put("times", "20171207010000");
		map.put("elements",
				"Station_Id_C,Year,Mon,Day,Hour,Min,Soil_Indi,Soil_Depth_BelS,SVWC,SRHU,SWWC,SVMS");
		return map;
	}
}
