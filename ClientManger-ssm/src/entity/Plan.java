package entity;

import java.math.BigDecimal;
import java.sql.Date;

/**
 * Plan entity. @author MyEclipse Persistence Tools
 */

public class Plan implements java.io.Serializable {

	// Fields

	private String planId;
	private String planCreater;
	private Date planTargetTime;
	private String planContext;
	private BigDecimal planState;
	private String planController;
	private Date planUpdateTime;
	private String planHandler;
	private BigDecimal planDel;

	// Constructors

	/** default constructor */
	public Plan() {
	}

	/** minimal constructor */
	public Plan(String planId) {
		this.planId = planId;
	}

	/** full constructor */
	public Plan(String planId, String planCreater, Date planTargetTime,
			String planContext, BigDecimal planState, String planController,
			Date planUpdateTime, String planHandler, BigDecimal planDel) {
		this.planId = planId;
		this.planCreater = planCreater;
		this.planTargetTime = planTargetTime;
		this.planContext = planContext;
		this.planState = planState;
		this.planController = planController;
		this.planUpdateTime = planUpdateTime;
		this.planHandler = planHandler;
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

	public BigDecimal getPlanState() {
		return this.planState;
	}

	public void setPlanState(BigDecimal planState) {
		this.planState = planState;
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

	public String getPlanHandler() {
		return this.planHandler;
	}

	public void setPlanHandler(String planHandler) {
		this.planHandler = planHandler;
	}

	public BigDecimal getPlanDel() {
		return this.planDel;
	}

	public void setPlanDel(BigDecimal planDel) {
		this.planDel = planDel;
	}

}