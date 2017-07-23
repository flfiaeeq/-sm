package entity;

import java.math.BigDecimal;
import java.sql.Date;

/**
 * Performance entity. @author MyEclipse Persistence Tools
 */

public class Performance implements java.io.Serializable {

	// Fields

	private String perfId;
	private String perfDept;
	private String perfEmp;
	private BigDecimal perfRank;
	private String perfRemark;
	private String perfController;
	private Date perfUpdateTime;
	private BigDecimal perfDel;
    private String[] ids;
	// Constructors

	/** default constructor */
	public Performance() {
	}

	/** minimal constructor */
	public Performance(String perfId) {
		this.perfId = perfId;
	}

	/** full constructor */
	public Performance(String perfId, String perfDept, String perfEmp,
			BigDecimal perfRank, String perfRemark, String perfController,
			Date perfUpdateTime, BigDecimal perfDel) {
		this.perfId = perfId;
		this.perfDept = perfDept;
		this.perfEmp = perfEmp;
		this.perfRank = perfRank;
		this.perfRemark = perfRemark;
		this.perfController = perfController;
		this.perfUpdateTime = perfUpdateTime;
		this.perfDel = perfDel;
	}

	// Property accessors

	public String getPerfId() {
		return this.perfId;
	}

	public void setPerfId(String perfId) {
		this.perfId = perfId;
	}

	public String getPerfDept() {
		return this.perfDept;
	}

	public void setPerfDept(String perfDept) {
		this.perfDept = perfDept;
	}

	public String getPerfEmp() {
		return this.perfEmp;
	}

	public void setPerfEmp(String perfEmp) {
		this.perfEmp = perfEmp;
	}

	public BigDecimal getPerfRank() {
		return this.perfRank;
	}

	public void setPerfRank(BigDecimal perfRank) {
		this.perfRank = perfRank;
	}

	public String getPerfRemark() {
		return this.perfRemark;
	}

	public void setPerfRemark(String perfRemark) {
		this.perfRemark = perfRemark;
	}

	public String getPerfController() {
		return this.perfController;
	}

	public void setPerfController(String perfController) {
		this.perfController = perfController;
	}

	public Date getPerfUpdateTime() {
		return this.perfUpdateTime;
	}

	public void setPerfUpdateTime(Date perfUpdateTime) {
		this.perfUpdateTime = perfUpdateTime;
	}

	public BigDecimal getPerfDel() {
		return this.perfDel;
	}

	public void setPerfDel(BigDecimal perfDel) {
		this.perfDel = perfDel;
	}

	public String[] getIds() {
		return ids;
	}

	public void setIds(String[] ids) {
		this.ids = ids;
	}
    
}