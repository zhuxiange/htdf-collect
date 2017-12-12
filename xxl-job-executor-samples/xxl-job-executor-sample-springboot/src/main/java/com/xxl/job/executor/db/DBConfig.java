package com.xxl.job.executor.db;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@PropertySource("classpath:/config/dbsource.properties")
public class DBConfig {
	private static final Logger Logger = LoggerFactory.getLogger(DBConfig.class);
	public static ComboPooledDataSource dataSource;
	public static String MYSQL = "1";
	public static String ORACLE = "2";
	//公共属性
	@Value("${c3p0.minPoolSize}")
	public String	minPoolSize;
	@Value("${c3p0.maxPoolSize}")
	public String	maxPoolSize;
	@Value("${c3p0.maxIdleTime}")
	public String	maxIdleTime;
	@Value("${c3p0.acquireIncrement}")
	public String	acquireIncrement;
	@Value("${c3p0.maxStatements}")
	public String	maxStatements;
	@Value("${c3p0.initialPoolSize}")
	public String	initialPoolSize;
	@Value("${c3p0.idleConnectionTestPeriod}")
	public String	idleConnectionTestPeriod;
	@Value("${c3p0.acquireRetryAttempts}")
	public String	acquireRetryAttempts;
	@Value("${c3p0.acquireRetryDelay}")
	public String	acquireRetryDelay;
	@Value("${c3p0.breakAfterAcquireFailure}")
	public String	breakAfterAcquireFailure;
	@Value("${c3p0.testConnectionOnCheckout}")
	public String	testConnectionOnCheckout;
	//库
	@Value("${c3p0.db1.jdbcUrl}")
	public  String	jdbcUrl1;
	@Value("${c3p0.db1.user}")
	public String	user1;
	@Value("${c3p0.db1.password}")
	public String	password1;
	@Value("${c3p0.db1.driverClass}")
	public String	driverClass1;
	
	@Value("${c3p0.db2.jdbcUrl}")
	public String	jdbcUrl2;
	@Value("${c3p0.db2.user}")
	public String	user2;
	@Value("${c3p0.db2.password}")
	public String	password2;
	@Value("${c3p0.db2.driverClass}")
	public String	driverClass2; 
	
	public Connection con = null;
	
	public Connection getConnection(String sign) {
		
		try {
			con = initDataSource1(sign).getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
			return con;
	}
	
	public List<Map<Object, Object>> select(String strSql,String sign) {
		Statement stmt = null;
		Vector<Map<Object, Object>> vec = new Vector<Map<Object, Object>>();
		ResultSet objRS = null;
		try {
			con = getConnection(sign);
			stmt = con.createStatement();
			objRS = stmt.executeQuery(strSql);
			ResultSetMetaData meta = objRS.getMetaData();
			while (objRS.next()) {
				HashMap<Object, Object> hash = new HashMap<Object, Object>();
				for (int i = 1; i <= meta.getColumnCount(); i++) {
					String temp = objRS.getString(meta.getColumnName(i));
					if (temp == null) {
						temp = "";
					}
					hash.put(meta.getColumnName(i), temp);
				}
				vec.add(hash);
			}
		} catch (SQLException e) {
			Logger.error("",e);

		} catch (Exception e) {
			Logger.error("",e);

		} finally {
			try {
				if (objRS != null) {
					objRS.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (con != null && !con.isClosed()) {
					con.close();
				}
			} catch (Exception e) {
				Logger.error("",e);

			}
		}
		return vec;
	}
	
	/**
	* 根据配置信息初始化连接池
	* @param dataConf
	*/
	public  DataSource initDataSource1(String sign){
		String url = jdbcUrl1;
		String name = driverClass1;
		String user = user1;
		String password = password1;
		String poolsize = initialPoolSize;
		String maxpoolsize = maxPoolSize;
		String maxidelTime = maxIdleTime;
		if("2".endsWith(sign)) {
			 url = jdbcUrl2;
			 name = driverClass2;
			 user = user2;
			 password = password2;
		}
	    dataSource = new ComboPooledDataSource();
	    dataSource.setJdbcUrl(url);
	try {
		dataSource.setDriverClass(name);
	} catch (PropertyVetoException e) {
		e.printStackTrace();
	}
		dataSource.setUser(user);
		dataSource.setPassword(password);
		dataSource.setInitialPoolSize(Integer.parseInt(poolsize));
		dataSource.setMaxPoolSize(Integer.parseInt(maxpoolsize));
		dataSource.setMaxIdleTime(Integer.parseInt(maxidelTime));
		Logger.info("连接池初始化成功!");
		return dataSource;
	}
	
}
