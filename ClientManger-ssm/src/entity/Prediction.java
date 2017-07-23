package entity;

import java.math.BigDecimal;
import java.sql.Date;

/**
 * Prediction entity. @author MyEclipse Persistence Tools
 */

public class Prediction implements java.io.Serializable {

	// Fields
    
	private String predictionTitle;
	private Date predictionTargetTime;
	private String predictionDept;
	private BigDecimal predictionDeptScale;
	private BigDecimal predictionClientNum;
	private String predictionFileUrl;
	private String predictionFileName;
	private Date predictionCreateTime;
	private String predictionCreater;
	private Byte predictionDel;
    
	// Constructors

	/** default constructor */
	public Prediction() {
	}

	/** minimal constructor */
	public Prediction(String predictionTitle) {
		this.predictionTitle = predictionTitle;
	}

	/** full constructor */
	public Prediction(String predictionTitle, Date predictionTargetTime,
			String predictionDept, BigDecimal predictionDeptScale,
			BigDecimal predictionClientNum, String predictionFileUrl,
			String predictionFileName, Date predictionCreateTime,
			String predictionCreater, Byte predictionDel) {
		this.predictionTitle = predictionTitle;
		this.predictionTargetTime = predictionTargetTime;
		this.predictionDept = predictionDept;
		this.predictionDeptScale = predictionDeptScale;
		this.predictionClientNum = predictionClientNum;
		this.predictionFileUrl = predictionFileUrl;
		this.predictionFileName = predictionFileName;
		this.predictionCreateTime = predictionCreateTime;
		this.predictionCreater = predictionCreater;
		this.predictionDel = predictionDel;
	}

	// Property accessors

	public String getPredictionTitle() {
		return this.predictionTitle;
	}

	public void setPredictionTitle(String predictionTitle) {
		this.predictionTitle = predictionTitle;
	}

	public Date getPredictionTargetTime() {
		return this.predictionTargetTime;
	}

	public void setPredictionTargetTime(Date predictionTargetTime) {
		this.predictionTargetTime = predictionTargetTime;
	}

	public String getPredictionDept() {
		return this.predictionDept;
	}

	public void setPredictionDept(String predictionDept) {
		this.predictionDept = predictionDept;
	}

	public BigDecimal getPredictionDeptScale() {
		return this.predictionDeptScale;
	}

	public void setPredictionDeptScale(BigDecimal predictionDeptScale) {
		this.predictionDeptScale = predictionDeptScale;
	}

	public BigDecimal getPredictionClientNum() {
		return this.predictionClientNum;
	}

	public void setPredictionClientNum(BigDecimal predictionClientNum) {
		this.predictionClientNum = predictionClientNum;
	}

	public String getPredictionFileUrl() {
		return this.predictionFileUrl;
	}

	public void setPredictionFileUrl(String predictionFileUrl) {
		this.predictionFileUrl = predictionFileUrl;
	}

	public String getPredictionFileName() {
		return this.predictionFileName;
	}

	public void setPredictionFileName(String predictionFileName) {
		this.predictionFileName = predictionFileName;
	}

	public Date getPredictionCreateTime() {
		return this.predictionCreateTime;
	}

	public void setPredictionCreateTime(Date predictionCreateTime) {
		this.predictionCreateTime = predictionCreateTime;
	}

	public String getPredictionCreater() {
		return this.predictionCreater;
	}

	public void setPredictionCreater(String predictionCreater) {
		this.predictionCreater = predictionCreater;
	}

	public Byte getPredictionDel() {
		return this.predictionDel;
	}

	public void setPredictionDel(Byte predictionDel) {
		this.predictionDel = predictionDel;
	}

}