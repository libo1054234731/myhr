package com.icss.hr.common;

/**
 * ��ҳ������
 * 
 * @author �
 *
 */
public class Pager {

	private int recordCount;// �ܼ�¼��

	private int pageSize = 10;// ÿҳ������

	private int pageCount;// ����ҳ

	private int pageNum;// ��ǰ�ǵڼ�ҳ
	
	private int start ;//��ʼ��λ��

	public Pager(int recordCount, int pageSize, int pageNum) {
		super();
		this.recordCount = recordCount;
		this.pageSize = pageSize;
		this.pageNum = pageNum;

		// ���㹲��ҳ
		this.pageCount = this.recordCount / this.pageSize;
		if (this.recordCount % this.pageSize != 0) {
			this.pageCount++;
		}
		//���㵱ǰҳ��
		if (this.pageNum <1) {
			this.pageNum = 1;
		}
		
		if (this.pageNum >this.pageCount) {
			this.pageNum = this.pageCount;
		}
		//������ʼλ��
		this.start = (this.pageNum -1)*this.pageSize +1;
	}
	
	public Pager(int recordCount, int pageNum) {
		super();
		this.recordCount = recordCount;
		this.pageNum = pageNum;

		// ���㹲��ҳ
		this.pageCount = this.recordCount / this.pageSize;
		if (this.recordCount % this.pageSize != 0) {
			this.pageCount++;
		}
		//���㵱ǰҳ��
		if (this.pageNum <1) {
			this.pageNum = 1;
		}
		
		if (this.pageNum >this.pageCount) {
			this.pageNum = this.pageCount;
		}
		//������ʼλ��
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
