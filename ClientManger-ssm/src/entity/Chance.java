package entity;

import java.math.BigDecimal;
import java.sql.Date;

/**
 * Chance entity. @author MyEclipse Persistence Tools
 */

public class Chance implements java.io.Serializable {

	// Fields

	private String chanceId;
	private String chanceName;
	private String chanceType;
	private String chanceContext;
	private String chanceRemark;
	private String chanceCreater;
	private Date chanceCreateTime;
	private String chanceController;
	private Date chanceUpdateTime;
	private String chanceEmp;
	private BigDecimal chanceDel;

	// Constructors

	/** default constructor */
	public Chance() {
	}

	/** minimal constructor */
	public Chance(String chanceId) {
		this.chanceId = chanceId;
	}

	/** full constructor */
	public Chance(String chanceId, String chanceName, String chanceType,
			String chanceContext, String chanceRemark, String chanceCreater,
			Date chanceCreateTime, String chanceController,
			Date chanceUpdateTime, String chanceEmp, BigDecimal chanceDel) {
		this.chanceId = chanceId;
		this.chanceName = chanceName;
		this.chanceType = chanceType;
		this.chanceContext = chanceContext;
		this.chanceRemark = chanceRemark;
		this.chanceCreater = chanceCreater;
		this.chanceCreateTime = chanceCreateTime;
		this.chanceController = chanceController;
		this.chanceUpdateTime = chanceUpdateTime;
		this.chanceEmp = chanceEmp;
		this.chanceDel = chanceDel;
	}

	// Property accessors

	public String getChanceId() {
		return this.chanceId;
	}

	public void setChanceId(String chanceId) {
		this.chanceId = chanceId;
	}

	public String getChanceName() {
		return this.chanceName;
	}

	public void setChanceName(String chanceName) {
		this.chanceName = chanceName;
	}

	public String getChanceType() {
		return this.chanceType;
	}

	public void setChanceType(String chanceType) {
		this.chanceType = chanceType;
	}

	public String getChanceContext() {
		return this.chanceContext;
	}

	public void setChanceContext(String chanceContext) {
		this.chanceContext = chanceContext;
	}

	public String getChanceRemark() {
		return this.chanceRemark;
	}

	public void setChanceRemark(String chanceRemark) {
		this.chanceRemark = chanceRemark;
	}

	public String getChanceCreater() {
		return this.chanceCreater;
	}

	public void setChanceCreater(String chanceCreater) {
		this.chanceCreater = chanceCreater;
	}

	public Date getChanceCreateTime() {
		return this.chanceCreateTime;
	}

	public void setChanceCreateTime(Date chanceCreateTime) {
		this.chanceCreateTime = chanceCreateTime;
	}

	public String getChanceController() {
		return this.chanceController;
	}

	public void setChanceController(String chanceController) {
		this.chanceController = chanceController;
	}

	public Date getChanceUpdateTime() {
		return this.chanceUpdateTime;
	}

	public void setChanceUpdateTime(Date chanceUpdateTime) {
		this.chanceUpdateTime = chanceUpdateTime;
	}

	public String getChanceEmp() {
		return this.chanceEmp;
	}

	public void setChanceEmp(String chanceEmp) {
		this.chanceEmp = chanceEmp;
	}

	public BigDecimal getChanceDel() {
		return this.chanceDel;
	}

	public void setChanceDel(BigDecimal chanceDel) {
		this.chanceDel = chanceDel;
	}

}