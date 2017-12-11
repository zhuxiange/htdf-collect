
package com.xxl.job.executor.service.jobhandler;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHander;
import com.xxl.job.core.log.XxlJobLogger;
import com.xxl.job.executor.kafka.MsgConstants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.concurrent.TimeUnit;


/**
 * 任务Handler的一个Demo（Bean模式）
 *
 * 开发步骤：
 * 1、继承 “IJobHandler” ；
 * 2、装配到Spring，例如加 “@Service” 注解；
 * 3、加 “@JobHander” 注解，注解value值为新增任务生成的JobKey的值;多个JobKey用逗号分割;
 * 4、执行日志：需要通过 "XxlJobLogger.log" 打印执行日志；
 *
 * @author zhuxiange 2015-12-19 19:43:36
 */
@JobHander(value = "demoJobHandler")
@Service
public class DemoJobHandler extends IJobHandler
{
	
	@Autowired
	private KafkaTemplate kafkaTemplate;
	
	@SuppressWarnings("unchecked")
	@Override
	public ReturnT<String> execute(String... params) throws Exception
	{
		
		/*try{
			XxlJobLogger.log("XXL-JOB, Hello World.");
		
			for (int i = 0; i < 5; i++) {
				XxlJobLogger.log("beat at:" + i);
				TimeUnit.SECONDS.sleep(2);
			}
		} catch (Exception e) {
		    if (e instanceof InterruptedException) {
		        throw e;
		    }
		    XxlJobLogger.log("{}", e);
		}
		*/
		ListenableFuture result = null;
		try
		{
			result = kafkaTemplate.send(MsgConstants.TOPIC_MSG, MsgConstants.NATION_STATION_MSG, "cimiss获取到的json信息");
			if (result.isDone())
			{
				XxlJobLogger.log("{采集国家站站点成功}");
			}
			return ReturnT.SUCCESS;
		}
		catch (Exception e)
		{
			XxlJobLogger.log("{采集国家站站点失败}", e);
			return ReturnT.FAIL;
		}
		
	}
	
}
