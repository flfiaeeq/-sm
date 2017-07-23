package entity;

import java.sql.Date;

 

/**
 * ClientPlan entity. @author MyEclipse Persistence Tools
 */

public class ClientPlan implements java.io.Serializable {

	// Fields

	private String planId;
	private String planCreater;
	private Date planTargetTime;
	private String planContext;
	private Date planCreateTime;
	private String planController;
	private Date planUpdateTime;
	private Long planDel;

	// Constructors

	/** default constructor */
	public ClientPlan() {
	}

	/** minimal constructor */
	public ClientPlan(String planId) {
		this.planId = planId;
	}

	/** full constructor */
	public ClientPlan(String planId, String planCreater, Date planTargetTime,
			String planContext, Date planCreateTime, String planController,
			Date planUpdateTime, Long planDel) {
		this.planId = planId;
		this.planCreater = planCreater;
		this.planTargetTime = planTargetTime;
		this.planContext = planContext;
		this.planCreateTime = planCreateTime;
		this.planController = planController;
		this.planUpdateTime = planUpdateTime;
		this.planDel = planDel;
	}

	// Property accessors

	public String getPlanId() {
		return this.planId;
	}

	public void setPlanId(String planId) {
		this.planId = planId;
	}

	public String getPlanCreater() {
		return this.planCreater;
	}

	public void setPlanCreater(String planCreater) {
		this.planCreater = planCreater;
	}

	public Date getPlanTargetTime() {
		return this.planTargetTime;
	}

	public void setPlanTargetTime(Date planTargetTime) {
		this.planTargetTime = planTargetTime;
	}

	public String getPlanContext() {
		return this.planContext;
	}

	public void setPlanContext(String planContext) {
		this.planContext = planContext;
	}

	public Date getPlanCreateTime() {
		return this.planCreateTime;
	}

	public void setPlanCreateTime(Date planCreateTime) {
		this.planCreateTime = planCreateTime;
	}

	public String getPlanController() {
		return this.planController;
	}

	public void setPlanController(String planController) {
		this.planController = planController;
	}

	public Date getPlanUpdateTime() {
		return this.planUpdateTime;
	}

	public void setPlanUpdateTime(Date planUpdateTime) {
		this.planUpdateTime = planUpdateTime;
	}

	public Long getPlanDel() {
		return this.planDel;
	}

	public void setPlanDel(Long planDel) {
		this.planDel = planDel;
	}

}