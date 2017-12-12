package com.xxl.job.executor.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 
 * @author ck
 *
 */
/*@Configuration
@PropertySource(value = {"classpath:cimiss.properties"},ignoreResourceNotFound = true,encoding = "utf-8")
*/
@Configuration
@PropertySource("classpath:/config/cimiss.properties")
public class CimissConfig {
	
	@Value("${cimiss.username}")
	public String	username;
	@Value("${cimiss.password}")
	public String		password;
	@Value("${cimiss.wsdl}")
	public String		wsdl;
	@Value("${cimiss.targetNamespace}")
	public String		targetNamespace;
	@Value("${cimiss.timeoutInMilliSeconds}")
	public String		timeoutInMilliSeconds;
	
	/*   @Bean    
	    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
	        return new PropertySourcesPlaceholderConfigurer();
	    }*/
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getWsdl() {
		return wsdl;
	}
	public void setWsdl(String wsdl) {
		this.wsdl = wsdl;
	}
	public String getTargetNamespace() {
		return targetNamespace;
	}
	public void setTargetNamespace(String targetNamespace) {
		this.targetNamespace = targetNamespace;
	}
	public String getTimeoutInMilliSeconds() {
		return timeoutInMilliSeconds;
	}
	public void setTimeoutInMilliSeconds(String timeoutInMilliSeconds) {
		this.timeoutInMilliSeconds = timeoutInMilliSeconds;
	}
	
	
}
