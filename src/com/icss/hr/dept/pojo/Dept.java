package com.icss.hr.dept.pojo;

/***
 * 
 * ����ʵ����
 * @author �
 *
 */
public class Dept {

	private int deptId;
	private String deptName;
	private String deptLoc;
	/**
	 * @return deptId
	 */
	public int getDeptId() {
		return deptId;
	}
	/**
	 * @param deptId Ҫ���õ� deptId
	 */
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	/**
	 * @return deptName
	 */
	public String getDeptName() {
		return deptName;
	}
	/**
	 * @param deptName Ҫ���õ� deptName
	 */
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	/**
	 * @return deptLoc
	 */
	public String getDeptLoc() {
		return deptLoc;
	}
	/**
	 * @param deptLoc Ҫ���õ� deptLoc
	 */
	public void setDeptLoc(String deptLoc) {
		this.deptLoc = deptLoc;
	}
	/* ���� Javadoc��
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Dept [deptId=" + deptId + ", deptName=" + deptName + ", deptLoc=" + deptLoc + "]";
	}
	public Dept(int deptId, String deptName, String deptLoc) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		this.deptLoc = deptLoc;
	}
	public Dept(String deptName, String deptLoc) {
		super();
		this.deptName = deptName;
		this.deptLoc = deptLoc;
	}
	public Dept() {
		super();
	}
	
	
	
	
	
	
}
