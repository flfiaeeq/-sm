package entity;

import java.math.BigDecimal;
import java.sql.Date;

/**
 * Emp entity. @author MyEclipse Persistence Tools
 */

public class Emp implements java.io.Serializable {

	// Fields

	private String empId;
	private String empName="";
	private String empSex="";
	private String empPhone="";
	private Long empState=0l;
	private String empLoginName="";
	private String empPassword="";
	private String empDept="";
	private String empRole="";
	private Date empUpdateTime=new Date(0);
	private String empController="";
	private BigDecimal empDel=new BigDecimal(0);
	private String empRemark="";
	private Byte empUpdatePass=0;

	// Constructors

	/** default constructor */
	public Emp() {
	}

	/** minimal constructor */
	public Emp(String empId, String empName, String empSex, String empPhone,
			Long empState, BigDecimal empDel) {
		this.empId = empId;
		this.empName = empName;
		this.empSex = empSex;
		this.empPhone = empPhone;
		this.empState = empState;
		this.empDel = empDel;
	}

	/** full constructor */
	public Emp(String empId, String empName, String empSex, String empPhone,
			Long empState, String empLoginName, String empPassword,
			String empDept, String empRole, Date empUpdateTime,
			String empController, BigDecimal empDel, String empRemark,
			Byte empUpdatePass) {
		this.empId = empId;
		this.empName = empName;
		this.empSex = empSex;
		this.empPhone = empPhone;
		this.empState = empState;
		this.empLoginName = empLoginName;
		this.empPassword = empPassword;
		this.empDept = empDept;
		this.empRole = empRole;
		this.empUpdateTime = empUpdateTime;
		this.empController = empController;
		this.empDel = empDel;
		this.empRemark = empRemark;
		this.empUpdatePass = empUpdatePass;
	}

	// Property accessors

	public String getEmpId() {
		return this.empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return this.empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpSex() {
		return this.empSex;
	}

	public void setEmpSex(String empSex) {
		this.empSex = empSex;
	}

	public String getEmpPhone() {
		return this.empPhone;
	}

	public void setEmpPhone(String empPhone) {
		this.empPhone = empPhone;
	}

	public Long getEmpState() {
		return this.empState;
	}

	public void setEmpState(Long empState) {
		this.empState = empState;
	}

	public String getEmpLoginName() {
		return this.empLoginName;
	}

	public void setEmpLoginName(String empLoginName) {
		this.empLoginName = empLoginName;
	}

	public String getEmpPassword() {
		return this.empPassword;
	}

	public void setEmpPassword(String empPassword) {
		this.empPassword = empPassword;
	}

	public String getEmpDept() {
		return this.empDept;
	}

	public void setEmpDept(String empDept) {
		this.empDept = empDept;
	}

	public String getEmpRole() {
		return this.empRole;
	}

	public void setEmpRole(String empRole) {
		this.empRole = empRole;
	}

	public Date getEmpUpdateTime() {
		return this.empUpdateTime;
	}

	public void setEmpUpdateTime(Date empUpdateTime) {
		this.empUpdateTime = empUpdateTime;
	}

	public String getEmpController() {
		return this.empController;
	}

	public void setEmpController(String empController) {
		this.empController = empController;
	}

	public BigDecimal getEmpDel() {
		return this.empDel;
	}

	public void setEmpDel(BigDecimal empDel) {
		this.empDel = empDel;
	}

	public String getEmpRemark() {
		return this.empRemark;
	}

	public void setEmpRemark(String empRemark) {
		this.empRemark = empRemark;
	}

	public Byte getEmpUpdatePass() {
		return this.empUpdatePass;
	}

	public void setEmpUpdatePass(Byte empUpdatePass) {
		this.empUpdatePass = empUpdatePass;
	}

}