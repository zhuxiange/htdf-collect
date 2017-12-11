package com.xxl.job.executor.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.xxl.job.executor.service.jobhandler.cimiss.htdf.D_REGION_HH;
import com.xxl.job.executor.service.jobhandler.cimiss.htdf.NationRealTimeHourData;

@RunWith(SpringRunner.class)
@SpringBootTest
public class XxlJobExecutorExampleBootApplicationTests {

	@Autowired
	public NationRealTimeHourData nd;

	@Autowired
	// public B_GNSS_MET_STATION sta;
//	public B_SOIL_STATION sta;
//	public B_AIR_STATION sta;
//	public D_NATIONAL_HH sta;
	public D_REGION_HH sta;

	@Test
	public void test() throws Exception {
		System.out.println(sta.execute());
		// System.out.println(CimissInterfaceCons.STA_INFO_GLB.getStaInfoByRegionCode.toString());

	}

}