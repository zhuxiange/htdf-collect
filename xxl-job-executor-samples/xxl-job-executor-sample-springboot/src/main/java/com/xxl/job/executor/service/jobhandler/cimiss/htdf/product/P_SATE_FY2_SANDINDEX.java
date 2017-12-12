package com.xxl.job.executor.service.jobhandler.cimiss.htdf.product;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.xxl.job.core.handler.annotation.JobHander;
import com.xxl.job.executor.service.jobhandler.cimiss.htdf.CollectBase;

/**
 * 采集FY-2G沙尘指数图像产品
 * 
 * @author LinShu
 *
 */
@JobHander(value = "p_sate_fy2_sandindex")
@Service
public class P_SATE_FY2_SANDINDEX extends CollectBase {

	@SuppressWarnings("unused")
	private static final Logger Logger = LoggerFactory.getLogger(P_SATE_FY2_SANDINDEX.class);

	/*
	 * TODO 时间得处理
	 */
	@Override
	protected Map<String, Object> param() {
		Map<String, Object> map = super.param();
		map.put("dataCode", "SATE_GEO_IMAGE_SANDINDEX_F2G");
		map.put("interfaceId", "getSateFileByTime");
		map.put("times", "20171207030000");
		map.put("elements",
				"DATA_Levl,SATE_Name,SATE_Sensor,SATE_Sensor_Chanl,Proj_Type,Prod_ID,Data_Area,SPAC_DPI,Time_DPI,PROD_PARA1,PROD_PARA2,Year,Mon,Day,Hour,Min,Second,FORMAT,FILE_NAME,FILE_NAME_ORIG,V_VFILE_NAME");
		return map;
	}
}
