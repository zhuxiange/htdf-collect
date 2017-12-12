package com.xxl.job.executor.service.jobhandler.cimiss.htdf.data;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.xxl.job.core.handler.annotation.JobHander;
import com.xxl.job.executor.service.jobhandler.cimiss.htdf.CollectBase;

/**
 * 采集国家站1小时
 * 
 * @author LinShu
 *
 */
@JobHander(value = "d_national_hh")
@Service
public class D_NATIONAL_HH extends CollectBase {


	@SuppressWarnings("unused")
	private static final Logger Logger = LoggerFactory.getLogger(D_NATIONAL_HH.class);

	@Override
	protected Map<String, Object> param() {
		Map<String, Object> map = super.param();
		map.put("dataCode", "SURF_CHN_MUL_HOR_N");
		map.put("interfaceId", "getSurfEleByTime");
		map.put("times", "20171206000000");//时间得处理
		map.put("staLevels", "012");
		map.put("elements",
				"STATION_ID_C,Station_Id_d,Lat,Lon,Alti,PRS_Sensor_Alti,WIN_S_Sensor_Heigh,Station_Type,Station_levl,Admin_Code_CHN,Year,Mon,Day,Hour,PRS,PRS_Sea,PRS_Change_3h,PRS_Change_24h,PRS_Max,PRS_Max_OTime,PRS_Min,PRS_Min_OTime,TEM,TEM_Max,TEM_Max_OTime,TEM_Min,TEM_Min_OTime,TEM_ChANGE_24h,TEM_Max_24h,TEM_Min_24h,DPT,RHU,RHU_Min,RHU_Min_OTIME,VAP,PRE_1h,PRE_3h,PRE_6h,PRE_12h,PRE_24h,PRE_Arti_Enc_CYC,PRE,EVP_Big,WIN_D_Avg_2mi,WIN_S_Avg_2mi,WIN_D_Avg_10mi,WIN_S_Avg_10mi,WIN_D_S_Max,WIN_S_Max,WIN_S_Max_OTime,WIN_D_INST,WIN_S_INST,WIN_D_INST_Max,WIN_S_Inst_Max,WIN_S_INST_Max_OTime,WIN_D_Inst_Max_6h,WIN_S_Inst_Max_6h,WIN_D_Inst_Max_12h,WIN_S_Inst_Max_12h,GST,GST_Max,GST_Max_Otime,GST_Min,GST_Min_OTime,GST_Min_12h,GST_5cm,GST_10cm,GST_15cm,GST_20cm,GST_40Cm,GST_80cm,GST_160cm,GST_320cm,LGST,LGST_Max,LGST_Max_OTime,LGST_Min,LGST_Min_OTime,VIS_HOR_1MI,VIS_HOR_10MI,VIS_Min,VIS_Min_OTime,VIS,CLO_Cov,CLO_Cov_Low,CLO_COV_LM,CLO_Height_LoM,CLO_FOME_1,CLO_Fome_2,CLO_Fome_3,CLO_Fome_4,CLO_FOME_5,CLO_FOME_6,CLO_FOME_7,CLO_Fome_8,CLO_Fome_Low,CLO_FOME_MID,CLO_Fome_High,WEP_Now,WEP_Past_CYC,WEP_Past_1,WEP_Past_2,SCO,Snow_Depth,Snow_PRS,FRS_1st_Top,FRS_1st_Bot,FRS_2nd_Top,FRS_2nd_Bot");
		return map;
	}
}
