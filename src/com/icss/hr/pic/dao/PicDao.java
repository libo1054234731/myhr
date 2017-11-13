package com.icss.hr.pic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.icss.hr.common.DbUtil;
import com.icss.hr.pic.pojo.Pic;

/**
 * 图片dao
 * 
 * @author 李波
 *
 */
public class PicDao {

	/**
	 * 插入数据
	 * 
	 * @throws SQLException
	 */
	public void insert(Pic pic) throws SQLException {

		Connection con = DbUtil.getConnection();

		String sql = "insert into pic values (pic_seq.nextval,?,?,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);

		pstmt.setString(1, pic.getPicName());
		pstmt.setString(2, pic.getPicInfo());
		pstmt.setLong(3, pic.getPicSize());
		pstmt.setString(4, pic.getPicAuthor());
		pstmt.setBinaryStream(5, pic.getPicData(), (int) pic.getPicSize());// 必须传入数据流大小
		pstmt.setTimestamp(6, new Timestamp(pic.getPicDatetime().getTime()));
		pstmt.executeUpdate();
		pstmt.close();
		con.close();

	}

	public List<Pic> query() throws SQLException {

		Connection con = DbUtil.getConnection();

		String sql = "select * from pic order by pic_datetime desc";
		PreparedStatement pstmt = con.prepareStatement(sql);

		ResultSet set = pstmt.executeQuery();

		ArrayList<Pic> list = new ArrayList<>();

		while (set.next()) {
			Pic pic = new Pic(set.getInt(1), set.getString(2), set.getString(3), set.getLong(4), set.getString(5), null,
					set.getTimestamp(7));
			list.add(pic);

		}

		set.close();
		pstmt.close();
		con.close();

		return list;
	}

	/**
	 * 根据Id查询图片数据
	 * 
	 * @throws SQLException
	 */
	public Pic queryPic(int picId) throws SQLException {

		Connection con = DbUtil.getConnection();

		String sql = "select * from pic where pic_id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, picId);

		ResultSet rs = pstmt.executeQuery();

		Pic pic = null;
		if (rs.next()) {
			pic = new Pic();
			pic.setPicName(rs.getString("pic_name"));
			pic.setPicData(rs.getBinaryStream("pic_data"));
		}

		rs.close();
		pstmt.close();
		con.close();
		return pic;

	}

	public void delPid(int picId) throws SQLException {

		Connection con = DbUtil.getConnection();

		String sql = "DELETE FROM pic WHERE pic_id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, picId);

		pstmt.executeUpdate();

		pstmt.close();
		con.close();
		

	}

}
