package entity;

import java.math.BigDecimal;
import java.sql.Date;

/**
 * Notice entity. @author MyEclipse Persistence Tools
 */

public class Notice implements java.io.Serializable {

	// Fields

	private String noticeId;
	private String noticeTitle="";
	private String noticeType="";
	private BigDecimal noticeState=new BigDecimal(0);
	private String noticeIssuser="";
	private String noticeContext="";
	private Date noticeIssueTime=new Date(0);
	private BigDecimal noticeDel=new BigDecimal(0);
	private Date noticeUpdateTime=new Date(0);
	private Date noticeAddTime=new Date(0);
	private Byte noticeDept=0;

	// Constructors

	/** default constructor */
	public Notice() {
	}

	/** minimal constructor */
	public Notice(String noticeId) {
		this.noticeId = noticeId;
	}

	/** full constructor */
	public Notice(String noticeId, String noticeTitle, String noticeType,
			BigDecimal noticeState, String noticeIssuser, String noticeContext,
			Date noticeIssueTime, BigDecimal noticeDel, Date noticeUpdateTime,
			Date noticeAddTime, Byte noticeDept) {
		this.noticeId = noticeId;
		this.noticeTitle = noticeTitle;
		this.noticeType = noticeType;
		this.noticeState = noticeState;
		this.noticeIssuser = noticeIssuser;
		this.noticeContext = noticeContext;
		this.noticeIssueTime = noticeIssueTime;
		this.noticeDel = noticeDel;
		this.noticeUpdateTime = noticeUpdateTime;
		this.noticeAddTime = noticeAddTime;
		this.noticeDept = noticeDept;
	}

	// Property accessors

	public String getNoticeId() {
		return this.noticeId;
	}

	public void setNoticeId(String noticeId) {
		this.noticeId = noticeId;
	}

	public String getNoticeTitle() {
		return this.noticeTitle;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	public String getNoticeType() {
		return this.noticeType;
	}

	public void setNoticeType(String noticeType) {
		this.noticeType = noticeType;
	}

	public BigDecimal getNoticeState() {
		return this.noticeState;
	}

	public void setNoticeState(BigDecimal noticeState) {
		this.noticeState = noticeState;
	}

	public String getNoticeIssuser() {
		return this.noticeIssuser;
	}

	public void setNoticeIssuser(String noticeIssuser) {
		this.noticeIssuser = noticeIssuser;
	}

	public String getNoticeContext() {
		return this.noticeContext;
	}

	public void setNoticeContext(String noticeContext) {
		this.noticeContext = noticeContext;
	}

	public Date getNoticeIssueTime() {
		return this.noticeIssueTime;
	}

	public void setNoticeIssueTime(Date noticeIssueTime) {
		this.noticeIssueTime = noticeIssueTime;
	}

	public BigDecimal getNoticeDel() {
		return this.noticeDel;
	}

	public void setNoticeDel(BigDecimal noticeDel) {
		this.noticeDel = noticeDel;
	}

	public Date getNoticeUpdateTime() {
		return this.noticeUpdateTime;
	}

	public void setNoticeUpdateTime(Date noticeUpdateTime) {
		this.noticeUpdateTime = noticeUpdateTime;
	}

	public Date getNoticeAddTime() {
		return this.noticeAddTime;
	}

	public void setNoticeAddTime(Date noticeAddTime) {
		this.noticeAddTime = noticeAddTime;
	}

	public Byte getNoticeDept() {
		return this.noticeDept;
	}

	public void setNoticeDept(Byte noticeDept) {
		this.noticeDept = noticeDept;
	}

}