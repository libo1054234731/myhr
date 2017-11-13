package com.icss.hr.dept.pojo;

/***
 * 
 * 部门实体类
 * @author 李波
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
	 * @param deptId 要设置的 deptId
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
	 * @param deptName 要设置的 deptName
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
	 * @param deptLoc 要设置的 deptLoc
	 */
	public void setDeptLoc(String deptLoc) {
		this.deptLoc = deptLoc;
	}
	/* （非 Javadoc）
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
