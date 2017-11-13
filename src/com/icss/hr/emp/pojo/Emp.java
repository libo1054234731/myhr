package com.icss.hr.emp.pojo;

import java.sql.Date;

import com.icss.hr.dept.pojo.Dept;
import com.icss.hr.job.pojo.Job;

/**
 * Ա��ʵ����
 * @author �
 *
 */
public class Emp {

	private int empId;
	private String empName;
	private String empLoginName;
	private String empPwd;
	private String empEmail;
	private String empPhone;
	private double empSalary;
	private Date empHiredate;
	//����ö���
	private Dept dept;//���һ��ϵ
	private Job job;//���һ��ϵ
	
	private String empPic ;
	private String empInfo;
	public Emp() {
		super();
	}
	
	
	/**
	 * �޸����빹�캯��
	 * @param empLoginName
	 * @param empPwd
	 */
	public Emp(String empLoginName, String empPwd) {
		super();
		this.empLoginName = empLoginName;
		this.empPwd = empPwd;
	}



	public Emp(int empId, String empName, String empLoginName, String empPwd, String empEmail, String empPhone,
			double empSalary, Date empHiredate, Dept dept, Job job, String empPic, String empInfo) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empLoginName = empLoginName;
		this.empPwd = empPwd;
		this.empEmail = empEmail;
		this.empPhone = empPhone;
		this.empSalary = empSalary;
		this.empHiredate = empHiredate;
		this.dept = dept;
		this.job = job;
		this.empPic = empPic;
		this.empInfo = empInfo;
	}
	public Emp(String empName, String empLoginName, String empPwd, String empEmail, String empPhone,
			double empSalary, Date empHiredate, Dept dept, Job job, String empPic, String empInfo) {
		super();
		this.empName = empName;
		this.empLoginName = empLoginName;
		this.empPwd = empPwd;
		this.empEmail = empEmail;
		this.empPhone = empPhone;
		this.empSalary = empSalary;
		this.empHiredate = empHiredate;
		this.dept = dept;
		this.job = job;
		this.empPic = empPic;
		this.empInfo = empInfo;
	}
	/**
	 * @return empId
	 */
	public int getEmpId() {
		return empId;
	}
	/**
	 * @param empId Ҫ���õ� empId
	 */
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	/**
	 * @return empName
	 */
	public String getEmpName() {
		return empName;
	}
	/**
	 * @param empName Ҫ���õ� empName
	 */
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	/**
	 * @return empLoginName
	 */
	public String getEmpLoginName() {
		return empLoginName;
	}
	/**
	 * @param empLoginName Ҫ���õ� empLoginName
	 */
	public void setEmpLoginName(String empLoginName) {
		this.empLoginName = empLoginName;
	}
	/**
	 * @return empPwd
	 */
	public String getEmpPwd() {
		return empPwd;
	}
	/**
	 * @param empPwd Ҫ���õ� empPwd
	 */
	public void setEmpPwd(String empPwd) {
		this.empPwd = empPwd;
	}
	/**
	 * @return empEmail
	 */
	public String getEmpEmail() {
		return empEmail;
	}
	/**
	 * @param empEmail Ҫ���õ� empEmail
	 */
	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}
	/**
	 * @return empPhone
	 */
	public String getEmpPhone() {
		return empPhone;
	}
	/**
	 * @param empPhone Ҫ���õ� empPhone
	 */
	public void setEmpPhone(String empPhone) {
		this.empPhone = empPhone;
	}
	/**
	 * @return empSalary
	 */
	public double getEmpSalary() {
		return empSalary;
	}
	/**
	 * @param empSalary Ҫ���õ� empSalary
	 */
	public void setEmpSalary(double empSalary) {
		this.empSalary = empSalary;
	}
	/**
	 * @return empHiredate
	 */
	public Date getEmpHiredate() {
		return empHiredate;
	}
	/**
	 * @param empHiredate Ҫ���õ� empHiredate
	 */
	public void setEmpHiredate(Date empHiredate) {
		this.empHiredate = empHiredate;
	}
	/**
	 * @return dept
	 */
	public Dept getDept() {
		return dept;
	}
	/**
	 * @param dept Ҫ���õ� dept
	 */
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	/**
	 * @return job
	 */
	public Job getJob() {
		return job;
	}
	/**
	 * @param job Ҫ���õ� job
	 */
	public void setJob(Job job) {
		this.job = job;
	}
	/**
	 * @return empPic
	 */
	public String getEmpPic() {
		return empPic;
	}
	/**
	 * @param empPic Ҫ���õ� empPic
	 */
	public void setEmpPic(String empPic) {
		this.empPic = empPic;
	}
	/**
	 * @return empInfo
	 */
	public String getEmpInfo() {
		return empInfo;
	}
	/**
	 * @param empInfo Ҫ���õ� empInfo
	 */
	public void setEmpInfo(String empInfo) {
		this.empInfo = empInfo;
	}
	/* ���� Javadoc��
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Emp [empId=" + empId + ", empName=" + empName + ", empLoginName=" + empLoginName + ", empPwd=" + empPwd
				+ ", empEmail=" + empEmail + ", empPhone=" + empPhone + ", empSalary=" + empSalary + ", empHiredate="
				+ empHiredate + ", dept=" + dept + ", job=" + job + ", empPic=" + empPic + ", empInfo=" + empInfo + "]";
	}
	
	
	
	
	
}
