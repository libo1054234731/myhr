package com.icss.hr.emp.service;

import java.sql.SQLException;
import java.util.List;

import com.icss.hr.common.Pager;
import com.icss.hr.emp.dao.EmpDao;
import com.icss.hr.emp.pojo.Emp;

public class EmpService {

	private EmpDao dao = new EmpDao();

	public Emp queryByLoginName(String empLoginName) throws SQLException {
		return dao.queryByLoginName(empLoginName);
	}

	/**
	 * �����û�������,��֤��¼
	 * 
	 * @param empLoginName
	 * @param empPwd
	 * @return ����1�����û��������� ����2����������� ����3������¼�ɹ�
	 * @throws SQLException
	 */
	public int checkLongin(String empLoginName, String empPwd) throws SQLException {
		Emp emp = dao.queryByLoginName(empLoginName);
		if (emp == null) {
			return 1;
		} else if (!empPwd.equals(emp.getEmpPwd())) {
			return 2;
		} else {
			return 3;
		}
	}
	

	
	public void addEmp(Emp emp) throws SQLException {
		dao.insert(emp);
	}

	public void updateEmp(Emp emp) throws SQLException {
		dao.update(emp);
	}

	public void deleteEmp(int empId) throws SQLException {
		dao.delete(empId);
	}

	public Emp queryEmpById(int empId) throws SQLException {
		return dao.queryById(empId);
	}

	public List<Emp> queryEmpByPage(Pager pager) throws SQLException {
		return dao.queryByPage(pager);
	}

	public Emp queryEmpByLoginName(String empLoginName) throws SQLException {
		return dao.queryByLoginName(empLoginName);
	}
	public int getEmpCount() throws SQLException {
		return dao.getCount();
	}
	
	public void upDateEmpPwd(Emp emp) throws SQLException {
		dao.updatePwd(emp);
	}
	//�޸��û�ͷ��
	public void updateEmpPic(String empLoginName,String empPic) throws SQLException {
		dao.updateEmpPic(empLoginName, empPic);
	}
	

}