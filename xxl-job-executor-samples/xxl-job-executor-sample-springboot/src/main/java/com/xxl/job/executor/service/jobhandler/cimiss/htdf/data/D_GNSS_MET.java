package com.xxl.job.executor.service.jobhandler.cimiss.htdf.data;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.xxl.job.core.handler.annotation.JobHander;
import com.xxl.job.executor.service.jobhandler.cimiss.htdf.CollectBase;

/**
 * 采集GNSS/MET观测资料数据
 * 
 * @author LinShu
 *
 */
@JobHander(value = "d_gnss_met")
@Service
public class D_GNSS_MET extends CollectBase {


	@SuppressWarnings("unused")
	private static final Logger Logger = LoggerFactory.getLogger(D_GNSS_MET.class);

	/* 
	 * TODO 时间得处理
	 * TODO 查询的站点需要处理
	 */
	@Override
	protected Map<String, Object> param() {
		Map<String, Object> map = super.param();
		map.put("dataCode", "UPAR_CHN_GPSMET_MUL");
		map.put("interfaceId", "getUparGpsEleByTimeAndStaID");
		map.put("times", "20171207030000");
		map.put("staIds", "54511,59114");
		map.put("elements",
				"Station_Id_C,Year,Mon,Day,Hour,Min,TZD,PRS,TEM,RHU,PRE_PRE_Fore");
		return map;
	}
}
