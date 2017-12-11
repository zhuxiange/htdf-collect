package com.xxl.job.executor.util.constant;

/**
 * cimiss的DatCode(资料代码) 使用 e.p. CimissDataCodeCons.STA_INFO_GLB.getValue()
 * 
 * @author LinShu
 */
public interface CimissInterfaceCons {
	// 站点
	/**
	 * 全球台站信息
	 */
	enum STA_INFO_GLB implements CimissInterfaceCons {
		/**
		 * 按照站号查询台站信息
		 */
		getStaInfoByStaId,

		/**
		 * 按照行政区域检索台站信息
		 */
		getStaInfoByRegionCode,

		/**
		 * 按照经纬度范围检索台站信息
		 */
		getStaInfoInRect,

		/**
		 * 按站网检索台站信息
		 */
		getStaInfoByNetCodes
	}

	// 数据资料
	// /**
	// * 中国地面逐小时资料（国家站）
	// */
	// enum SURF_CHN_MUL_HOR_N implements CimissInterfaceCons{
	// }
	//
	// /**
	// * 中国地面逐小时资料
	// */
	// SURF_CHN_MUL_HOR("SURF_CHN_MUL_HOR"),
	//
	// /**
	// * FY-2G沙尘指数图像产品
	// */
	// SATE_GEO_IMAGE_SANDINDEX_F2G("SATE_GEO_IMAGE_SANDINDEX_F2G"),
	//
	// /**
	// * FY-2G积雪覆盖（SNW）产品
	// */
	// SATE_GEO_PRODUCT_SNW_F2G("SATE_GEO_PRODUCT_SNW_F2G"),
	//
	// /**
	// * FY-2G地面入射太阳辐射（SSI）产品
	// */
	// SATE_GEO_PRODUCT_SSI_F2G("SATE_GEO_PRODUCT_SSI_F2G"),
	//
	// /**
	// * 中国GPS/MET数据要素
	// */
	// UPAR_CHN_GPSMET_MUL("UPAR_CHN_GPSMET_MUL"),
	//
	// /**
	// * 土壤水分逐小时要素资料
	// */
	// AGME_CHN_SOIL_HOR("AGME_CHN_SOIL_HOR"),
	//
	// /**
	// * CMPAS-V2.1融合降水分析快速数据小时产品（GRIB，5km）
	// */
	// SURF_CMPA_FAST_5KM("SURF_CMPA_FAST_5KM"),
	//
	// /**
	// * CLDAS2.0实时数据小时产品（5KM，GRIB）
	// */
	// NAFP_CLDAS2_0_RT_GRB("NAFP_CLDAS2.0_RT_GRB"),
	//
	// /**
	// * 全球海洋海面观测要素资料
	// */
	// OCEN_GLB_SHB("OCEN_GLB_SHB");

}
