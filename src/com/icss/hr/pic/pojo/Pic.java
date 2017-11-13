package com.icss.hr.pic.pojo;

import java.io.InputStream;
import java.util.Date;

/**
 * ͼƬʵ�幹����
 * @author �
 *
 */
public class Pic {

	private int picId;
	private String picName;
	private String picInfo;
	private long picSize;
	private String picAuthor;
	private InputStream picData;
	private Date picDatetime;
	/**
	 * @return picId
	 */
	public int getPicId() {
		return picId;
	}
	/**
	 * @param picId Ҫ���õ� picId
	 */
	public void setPicId(int picId) {
		this.picId = picId;
	}
	/**
	 * @return picName
	 */
	public String getPicName() {
		return picName;
	}
	/**
	 * @param picName Ҫ���õ� picName
	 */
	public void setPicName(String picName) {
		this.picName = picName;
	}
	/**
	 * @return picInfo
	 */
	public String getPicInfo() {
		return picInfo;
	}
	/**
	 * @param picInfo Ҫ���õ� picInfo
	 */
	public void setPicInfo(String picInfo) {
		this.picInfo = picInfo;
	}
	/**
	 * @return picSize
	 */
	public long getPicSize() {
		return picSize;
	}
	/**
	 * @param picSize Ҫ���õ� picSize
	 */
	public void setPicSize(long picSize) {
		this.picSize = picSize;
	}
	/**
	 * @return picAuthor
	 */
	public String getPicAuthor() {
		return picAuthor;
	}
	/**
	 * @param picAuthor Ҫ���õ� picAuthor
	 */
	public void setPicAuthor(String picAuthor) {
		this.picAuthor = picAuthor;
	}
	/**
	 * @return picData
	 */
	public InputStream getPicData() {
		return picData;
	}
	/**
	 * @param picData Ҫ���õ� picData
	 */
	public void setPicData(InputStream picData) {
		this.picData = picData;
	}
	/**
	 * @return picDatetime
	 */
	public Date getPicDatetime() {
		return picDatetime;
	}
	/**
	 * @param picDatetime Ҫ���õ� picDatetime
	 */
	public void setPicDatetime(Date picDatetime) {
		this.picDatetime = picDatetime;
	}
	public Pic() {
		super();
	}
	public Pic(String picName, String picInfo, long picSize, String picAuthor, InputStream picData, Date picDatetime) {
		super();
		this.picName = picName;
		this.picInfo = picInfo;
		this.picSize = picSize;
		this.picAuthor = picAuthor;
		this.picData = picData;
		this.picDatetime = picDatetime;
	}
	public Pic(int picId, String picName, String picInfo, long picSize, String picAuthor, InputStream picData,
			Date picDatetime) {
		super();
		this.picId = picId;
		this.picName = picName;
		this.picInfo = picInfo;
		this.picSize = picSize;
		this.picAuthor = picAuthor;
		this.picData = picData;
		this.picDatetime = picDatetime;
	}
	/* ���� Javadoc��
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Pic [picId=" + picId + ", picName=" + picName + ", picInfo=" + picInfo + ", picSize=" + picSize
				+ ", picAuthor=" + picAuthor + ", picData=" + picData + ", picDatetime=" + picDatetime + "]";
	}
	
	
	
	
}
