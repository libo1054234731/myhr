package com.icss.hr.analysis.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import com.icss.hr.common.DbUtil;

/**
 * 数据分析dao
 * @author 李波
 *
 */
public class AnaDao {

	public List<HashMap<String, Object>> queryEmpCount() throws SQLException{
		Connection conn = DbUtil.getConnection();
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT d.dept_name,COUNT(e.emp_id),MAX(e.emp_salary),MIN(e.emp_salary),AVG(e.emp_salary) ");
		sql.append("FROM emp e ");
		sql.append("RIGHT OUTER JOIN dept d ON e.emp_dept_id=d.dept_id ");
		sql.append("GROUP BY d.dept_name ");

		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		ResultSet rs = pstmt.executeQuery();
		
		
		List<HashMap<String , Object>> list = new ArrayList<>();
		
		while (rs.next()) {
			HashMap<String, Object> map = new HashMap<>();
			map.put("deptName", rs.getString(1));
			map.put("empCount", rs.getInt(2));
			map.put("empMax", rs.getDouble(3));
			map.put("empMin", rs.getDouble(4));
			map.put("empAvg", rs.getDouble(5));
			list.add(map);
		}
		rs.close();
		pstmt.close();
		conn.close();
		return list;
	}	
	
}
