package com.icss.hr.common;

/**
 * 分页工具类
 * 
 * @author 李波
 *
 */
public class Pager {

	private int recordCount;// 总记录数

	private int pageSize = 10;// 每页多少条

	private int pageCount;// 共几页

	private int pageNum;// 当前是第几页
	
	private int start ;//起始的位置

	public Pager(int recordCount, int pageSize, int pageNum) {
		super();
		this.recordCount = recordCount;
		this.pageSize = pageSize;
		this.pageNum = pageNum;

		// 计算共几页
		this.pageCount = this.recordCount / this.pageSize;
		if (this.recordCount % this.pageSize != 0) {
			this.pageCount++;
		}
		//计算当前页码
		if (this.pageNum <1) {
			this.pageNum = 1;
		}
		
		if (this.pageNum >this.pageCount) {
			this.pageNum = this.pageCount;
		}
		//计算起始位置
		this.start = (this.pageNum -1)*this.pageSize +1;
	}
	
	public Pager(int recordCount, int pageNum) {
		super();
		this.recordCount = recordCount;
		this.pageNum = pageNum;

		// 计算共几页
		this.pageCount = this.recordCount / this.pageSize;
		if (this.recordCount % this.pageSize != 0) {
			this.pageCount++;
		}
		//计算当前页码
		if (this.pageNum <1) {
			this.pageNum = 1;
		}
		
		if (this.pageNum >this.pageCount) {
			this.pageNum = this.pageCount;
		}
		//计算起始位置
		this.start = (this.pageNum -1)*this.pageSize +1;
	}

	/**
	 * @return recordCount
	 */
	public int getRecordCount() {
		return recordCount;
	}

	/**
	 * @return pageSize
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * @return pageCount
	 */
	public int getPageCount() {
		return pageCount;
	}

	/**
	 * @return pageNum
	 */
	public int getPageNum() {
		return pageNum;
	}

	/**
	 * @return start
	 */
	public int getStart() {
		return start;
	}
	
	public static void main(String[] args) {
		Pager pager = new Pager(43, 10, 6);
		System.out.println(pager.getStart());
	}

}
