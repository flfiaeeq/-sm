package entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Problem entity. @author MyEclipse Persistence Tools
 */

public class Problem implements java.io.Serializable {

	// Fields

	private String problemTitle;
	private String problemType;
	private String problemReply;
	private String problemRemark;
	private String problemCreater;
	private Date problemCreateTime;
	private String problemController;
	private Date problemUpdateTime;
	private BigDecimal problemDel;

	// Constructors

	/** default constructor */
	public Problem() {
	}

	/** minimal constructor */
	public Problem(String problemTitle) {
		this.problemTitle = problemTitle;
	}

	/** full constructor */
	public Problem(String problemTitle, String problemType,
			String problemReply, String problemRemark, String problemCreater,
			Date problemCreateTime, String problemController,
			Date problemUpdateTime, BigDecimal problemDel) {
		this.problemTitle = problemTitle;
		this.problemType = problemType;
		this.problemReply = problemReply;
		this.problemRemark = problemRemark;
		this.problemCreater = problemCreater;
		this.problemCreateTime = problemCreateTime;
		this.problemController = problemController;
		this.problemUpdateTime = problemUpdateTime;
		this.problemDel = problemDel;
	}

	// Property accessors

	public String getProblemTitle() {
		return this.problemTitle;
	}

	public void setProblemTitle(String problemTitle) {
		this.problemTitle = problemTitle;
	}

	public String getProblemType() {
		return this.problemType;
	}

	public void setProblemType(String problemType) {
		this.problemType = problemType;
	}

	public String getProblemReply() {
		return this.problemReply;
	}

	public void setProblemReply(String problemReply) {
		this.problemReply = problemReply;
	}

	public String getProblemRemark() {
		return this.problemRemark;
	}

	public void setProblemRemark(String problemRemark) {
		this.problemRemark = problemRemark;
	}

	public String getProblemCreater() {
		return this.problemCreater;
	}

	public void setProblemCreater(String problemCreater) {
		this.problemCreater = problemCreater;
	}

	public Date getProblemCreateTime() {
		return this.problemCreateTime;
	}

	public void setProblemCreateTime(Date problemCreateTime) {
		this.problemCreateTime = problemCreateTime;
	}

	public String getProblemController() {
		return this.problemController;
	}

	public void setProblemController(String problemController) {
		this.problemController = problemController;
	}

	public Date getProblemUpdateTime() {
		return this.problemUpdateTime;
	}

	public void setProblemUpdateTime(Date problemUpdateTime) {
		this.problemUpdateTime = problemUpdateTime;
	}

	public BigDecimal getProblemDel() {
		return this.problemDel;
	}

	public void setProblemDel(BigDecimal problemDel) {
		this.problemDel = problemDel;
	}

}