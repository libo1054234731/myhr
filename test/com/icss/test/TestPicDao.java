package com.icss.test;

import java.util.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Date;
import java.util.Iterator;

import org.junit.Test;

import com.icss.hr.pic.dao.PicDao;
import com.icss.hr.pic.pojo.Pic;

import oracle.net.aso.b;

/**
 * Õº∆¨¿‡≤‚ ‘
 * 
 * @author ¿Ó≤®
 *
 */
public class TestPicDao {

	private PicDao dao = new PicDao();

	@Test
	public void testIn() throws FileNotFoundException, SQLException {

		File file = new File("e:\\1.jpg");

		FileInputStream fis = new FileInputStream(file);

		Pic pic = new Pic("1.jpg", "Œ‚“‡∑≤’’∆¨3", file.length(), "jack", fis, new Date());
		dao.insert(pic);
	}

	@Test
	public void testQuery() throws SQLException {

		List<Pic> list = dao.query();

		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Pic pic = (Pic) iterator.next();
			System.out.println(pic);
		}

	}

	@Test
		public void testQueryPic() throws SQLException, IOException{
			
			Pic pic = dao.queryPic(1);
			System.out.println(pic.getPicName()+","+pic.getPicData());
			
			InputStream is = pic.getPicData();
			
			FileOutputStream file = new FileOutputStream("E:\\3.jpg");
			
			byte [] b = new byte[1024*8];
			int len = is.read(b);
			
			while (len!= -1) {
				file.write(b,0,len);
				len = is.read(b);
			}
			file.close();
			is.close();
		}

}
