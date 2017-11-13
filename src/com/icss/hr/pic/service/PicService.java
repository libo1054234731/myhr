package com.icss.hr.pic.service;

import java.sql.SQLException;
import java.util.List;

import com.icss.hr.pic.dao.PicDao;
import com.icss.hr.pic.pojo.Pic;

/**
 * Í¼Æ¬ÒµÎñ²ã
 * @author Àî²¨
 *
 */
public class PicService {

	private PicDao dao= new PicDao() ;
	public void addPic(Pic pic) throws SQLException {
		dao.insert(pic);
	}
	public List<Pic> queryPic() throws SQLException {
		return dao.query();
	}
	public Pic queryPicById(int picId) throws SQLException {
		return dao.queryPic(picId);
	}
	
	public void delPic(int picId) throws SQLException {
		dao.delPid(picId);
	}
	
}
