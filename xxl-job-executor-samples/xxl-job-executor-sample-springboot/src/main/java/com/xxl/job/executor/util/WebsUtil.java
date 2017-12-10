package com.xxl.job.executor.util;

import javax.xml.namespace.QName;

import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.rpc.client.RPCServiceClient;
import org.springframework.beans.factory.annotation.Autowired;

public class WebsUtil {  
	  /*
	   * web service请求服务，获取数据（返回序列化字符串）
	   */
	  public static String getWsString( String method, String params,String wsdl,String targetNamespace,String  timeoutInMilliSeconds) {
	    Class[] returnTypes = new Class[] { String.class } ;
	    return (String)getWsData(method, params, returnTypes, wsdl, targetNamespace,  timeoutInMilliSeconds) ;
	  }

	  public String[][] getWsArray( String method, String params ,String wsdl,String targetNamespace,String  timeoutInMilliSeconds) {
	    Class[] returnTypes = new Class[]{ String[][].class };
	    return (String[][])this.getWsData(method, params, returnTypes, wsdl, targetNamespace,  timeoutInMilliSeconds) ;
	  }

	  public void outputRst( String[][] data ) {
	    if( data.length < 1 ) {
	      return ;
	    }
	    //第1行为各字段名
	    for( int iCol = 0; iCol < data[0].length; iCol ++ ) {
	      System.out.print( data[0][iCol] + "\t" ) ;
	    }
	    System.out.println() ;
	    System.out.println("-----------------------------------------------------------------------------------------") ;
	    //第2行开始为要素值
	    for( int iRow = 1; iRow < data.length; iRow ++ ) {
	      for( int iCol = 0; iCol < data[iRow].length; iCol ++ ) {
	        System.out.print( data[iRow][iCol] + "\t" ) ;
	      }
	      System.out.println() ;
	      //DEMO中，最多只输出10行
	      if( iRow > 10 ) {
	        System.out.println( "......" ) ;
	        break ;
	      }
	    }
	  }
	  
	  /**
	   * 获取cimiss接口数据
	   * @param method
	   * @param params
	   * @param returnTypes
	   * @return
	   */
	  private static Object getWsData( String method, String params, Class returnTypes[] ,String wsdl,String targetNamespace,String  timeoutInMilliSeconds) {
	    Object response = null ;
	    try {
	      RPCServiceClient wsClient = new RPCServiceClient() ;
	      Options options = wsClient.getOptions() ;
	      options.setTimeOutInMilliSeconds( Long.parseLong(timeoutInMilliSeconds)) ;
	      EndpointReference end = new EndpointReference( wsdl );
	      options.setTo(end);
	      QName qN = new QName( targetNamespace, method );
	      String[] param = { params } ;
	      response = wsClient.invokeBlocking( qN, param, returnTypes )[0] ;
	      wsClient.cleanupTransport();
	    } catch (AxisFault e) {
	      e.printStackTrace();
	    }
	    return response;
	  }
	   
}
