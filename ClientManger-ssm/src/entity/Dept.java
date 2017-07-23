package entity;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Dept entity. @author MyEclipse Persistence Tools
 */

public class Dept implements java.io.Serializable {

	// Fields

	private String deptId;
	private String deptShortName="";
	private String deptAllName="";
	private String deptFather="";
	private String deptIntro="";
	private String deptRemark="";
	private String deptAdmin="";
	private String deptController="";
	private Date deptUpdateTime=new Date(0);
	private BigDecimal deptDel=new BigDecimal(0);
	
	//qu
	private List emps=new ArrayList(0);
	

	// Constructors

	public List getEmps() {
		return emps;
	}

	public void setEmps(List emps) {
		this.emps = emps;
	}

	/** default constructor */
	public Dept() {
	}

	/** minimal constructor */
	public Dept(String deptId, String deptShortName, String deptAllName) {
		this.deptId = deptId;
		this.deptShortName = deptShortName;
		this.deptAllName = deptAllName;
	}

	/** full constructor */
	public Dept(String deptId, String deptShortName, String deptAllName,
			String deptFather, String deptIntro, String deptRemark,
			String deptAdmin, String deptController, Date deptUpdateTime,
			BigDecimal deptDel) {
		this.deptId = deptId;
		this.deptShortName = deptShortName;
		this.deptAllName = deptAllName;
		this.deptFather = deptFather;
		this.deptIntro = deptIntro;
		this.deptRemark = deptRemark;
		this.deptAdmin = deptAdmin;
		this.deptController = deptController;
		this.deptUpdateTime = deptUpdateTime;
		this.deptDel = deptDel;
	}

	// Property accessors

	public String getDeptId() {
		return this.deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getDeptShortName() {
		return this.deptShortName;
	}

	public void setDeptShortName(String deptShortName) {
		this.deptShortName = deptShortName;
	}

	public String getDeptAllName() {
		return this.deptAllName;
	}

	public void setDeptAllName(String deptAllName) {
		this.deptAllName = deptAllName;
	}

	public String getDeptFather() {
		return this.deptFather;
	}

	public void setDeptFather(String deptFather) {
		this.deptFather = deptFather;
	}

	public String getDeptIntro() {
		return this.deptIntro;
	}

	public void setDeptIntro(String deptIntro) {
		this.deptIntro = deptIntro;
	}

	public String getDeptRemark() {
		return this.deptRemark;
	}

	public void setDeptRemark(String deptRemark) {
		this.deptRemark = deptRemark;
	}

	public String getDeptAdmin() {
		return this.deptAdmin;
	}

	public void setDeptAdmin(String deptAdmin) {
		this.deptAdmin = deptAdmin;
	}

	public String getDeptController() {
		return this.deptController;
	}

	public void setDeptController(String deptController) {
		this.deptController = deptController;
	}

	public Date getDeptUpdateTime() {
		return this.deptUpdateTime;
	}

	public void setDeptUpdateTime(Date deptUpdateTime) {
		this.deptUpdateTime = deptUpdateTime;
	}

	public BigDecimal getDeptDel() {
		return this.deptDel;
	}

	public void setDeptDel(BigDecimal deptDel) {
		this.deptDel = deptDel;
	}

}