package com.xxl.job.executor.service.jobhandler.cimiss.htdf.baseinfo;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.xxl.job.core.handler.annotation.JobHander;
import com.xxl.job.executor.service.jobhandler.cimiss.htdf.CollectBase;

/**
 * 采集土壤站点
 * 
 * @author LinShu
 *
 */
@JobHander(value = "b_soil_station")
@Service
public class B_SOIL_STATION extends CollectBase {


	@SuppressWarnings("unused")
	private static final Logger Logger = LoggerFactory.getLogger(B_SOIL_STATION.class);

	@Override
	protected Map<String, Object> param() {
		Map<String, Object> map = super.param();
		map.put("interfaceId", "getStaInfoByNetCodes");
		map.put("elements",
				"Station_Id_C,Station_Name,Admin_Code_CHN,Town_code,NetCode,Country,Province,City,Cnty,Town,Station_levl,Lat,Lon,Alti");
		map.put("dataCode", "STA_INFO_GLB");
		map.put("netCodes", "13");
		return map;
	}
}
