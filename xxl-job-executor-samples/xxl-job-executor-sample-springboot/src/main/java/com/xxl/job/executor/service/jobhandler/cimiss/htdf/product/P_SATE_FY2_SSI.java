package com.xxl.job.executor.service.jobhandler.cimiss.htdf.product;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.xxl.job.core.handler.annotation.JobHander;
import com.xxl.job.executor.service.jobhandler.cimiss.htdf.CollectBase;
import com.xxl.job.executor.util.constant.DBConstant;

/**
 * 采集FY-2G地面入射太阳辐射（SSI）产品
 * 
 * @author LinShu
 *
 */
@JobHander(value = "p_sate_fy2_ssi")
@Service
public class P_SATE_FY2_SSI extends CollectBase {

	public P_SATE_FY2_SSI() {
		super(DBConstant.CIMISS);
	}

	@SuppressWarnings("unused")
	private static final Logger Logger = LoggerFactory.getLogger(P_SATE_FY2_SSI.class);

	/*
	 * TODO 时间得处理
	 */
	@Override
	protected Map<String, Object> param() {
		Map<String, Object> map = super.param();
		map.put("dataCode", "SATE_GEO_PRODUCT_SSI_F2G");
		map.put("interfaceId", "getSateFileByTime");
		map.put("times", "20171207000000");
		map.put("elements",
				"DATA_Levl,SATE_Name,SATE_Sensor,SATE_Sensor_Chanl,Proj_Type,Prod_ID,Data_Area,SPAC_DPI,Time_DPI,PROD_PARA1,PROD_PARA2,Year,Mon,Day,Hour,Min,Second,FORMAT,FILE_NAME,FILE_NAME_ORIG,V_VFILE_NAME");
		return map;
	}
}
