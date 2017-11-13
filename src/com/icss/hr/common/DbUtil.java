package com.icss.hr.common;



import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 数据库连接工具类
 * 
 * @author DLETC
 *
 */
public class DbUtil {

	// 静态的数据源对象dataSource
	private static ComboPooledDataSource dataSource;

	// 本地线程对象
	private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();

	// 设置连接池参数
	static {
		dataSource = new ComboPooledDataSource();

		try {
			// 数据库连接相关参数
			dataSource.setUser("myhr");// 用户名
			dataSource.setPassword("myhr");// 密码
			dataSource.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");// 连接字符串
			dataSource.setDriverClass("oracle.jdbc.driver.OracleDriver");

			// 连接池相关参数
			dataSource.setInitialPoolSize(10);// 初始连接数
			dataSource.setMaxPoolSize(20);// 最大连接数
			dataSource.setMinPoolSize(10);// 最小连接数
			dataSource.setMaxIdleTime(60);// 最大空闲时间60秒，连接对象60秒内没有使用才会被销毁

		} catch (PropertyVetoException e) {
			e.printStackTrace();
		} // 注册驱动
	}

	/**
	 * 通过连接池对象返回数据库连接
	 * 
	 * @throws SQLException
	 * 
	 */
	public static Connection getConnection() throws SQLException {

		Connection con = threadLocal.get();
		// 如果本地线程里面没有连接对象,就在连接池获得空闲连接
		if (con == null || con.isClosed()) {
			con = dataSource.getConnection();
			threadLocal.set(con);
		}

		// 测试 返回连接池剩余空闲连接数
		System.out.println("获得数据库连接,剩余的空闲" + dataSource.getNumIdleConnections());
		return con;
	}

	/***
	 * 统一关闭连接
	 */
	public static void close() {
		// 从本地线程里取出连接对象

		Connection conn = threadLocal.get();
		try {
			if (conn != null && !conn.isClosed()) {
				// 关闭连接
				conn.close();

				// 解除存储
				threadLocal.set(null);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
