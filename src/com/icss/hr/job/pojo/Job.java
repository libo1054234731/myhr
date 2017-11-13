package com.icss.hr.job.pojo;
/**
 * 职务实体类
 * @author 李波
 *
 */
public class Job {

	private int jobId;
	private String jobName;
	private int jobMinSal;
	private int jobMaxSal;
	/**
	 * @return jobId
	 */
	public int getJobId() {
		return jobId;
	}
	/**
	 * @param jobId 要设置的 jobId
	 */
	public void setJobId(int jobId) {
		this.jobId = jobId;
	}
	/**
	 * @return jobName
	 */
	public String getJobName() {
		return jobName;
	}
	/**
	 * @param jobName 要设置的 jobName
	 */
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	/**
	 * @return jobMinSal
	 */
	public int getJobMinSal() {
		return jobMinSal;
	}
	/**
	 * @param jobMinSal 要设置的 jobMinSal
	 */
	public void setJobMinSal(int jobMinSal) {
		this.jobMinSal = jobMinSal;
	}
	/**
	 * @return jobMaxSal
	 */
	public int getJobMaxSal() {
		return jobMaxSal;
	}
	/**
	 * @param jobMaxSal 要设置的 jobMaxSal
	 */
	public void setJobMaxSal(int jobMaxSal) {
		this.jobMaxSal = jobMaxSal;
	}
	/* （非 Javadoc）
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Job [jobId=" + jobId + ", jobName=" + jobName + ", jobMinSal=" + jobMinSal + ", jobMaxSal="
				+ jobMaxSal + "]";
	}
	public Job(int jobId, String jobName, int jobMinSal, int jobMaxSal) {
		super();
		this.jobId = jobId;
		this.jobName = jobName;
		this.jobMinSal = jobMinSal;
		this.jobMaxSal = jobMaxSal;
	}
	public Job(String jobName, int jobMinSal, int jobMaxSal) {
		super();
		this.jobName = jobName;
		this.jobMinSal = jobMinSal;
		this.jobMaxSal = jobMaxSal;
	}
	public Job() {
		super();
	}
	
	
}
