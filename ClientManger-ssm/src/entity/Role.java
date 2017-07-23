package entity;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Role entity. @author MyEclipse Persistence Tools
 */

public class Role implements java.io.Serializable {

	// Fields

	private String roleId;
	private String roleName="";
	private BigDecimal roleState=new BigDecimal(0);
	private String roleDept="";
	private String roleRemark="";
	private String roleController="";
	private Date roleUpdateTime=new Date(0);
	private BigDecimal roleDel=new BigDecimal(0);
	
	private List<Menu> menu=new ArrayList<Menu>();
	
	
	// Constructors
	
	
	public List<Menu> getMenu() {
		return menu;
	}

	public void setMenu(List<Menu> menu) {
		this.menu = menu;
	}

	/** default constructor */
	public Role() {
	}

	/** minimal constructor */
	public Role(String roleId) {
		this.roleId = roleId;
	}

	/** full constructor */
	public Role(String roleId, String roleName, BigDecimal roleState,
			String roleDept, String roleRemark, String roleController,
			Date roleUpdateTime, BigDecimal roleDel) {
		this.roleId = roleId;
		this.roleName = roleName;
		this.roleState = roleState;
		this.roleDept = roleDept;
		this.roleRemark = roleRemark;
		this.roleController = roleController;
		this.roleUpdateTime = roleUpdateTime;
		this.roleDel = roleDel;
	}

	// Property accessors

	public String getRoleId() {
		return this.roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public BigDecimal getRoleState() {
		return this.roleState;
	}

	public void setRoleState(BigDecimal roleState) {
		this.roleState = roleState;
	}

	public String getRoleDept() {
		return this.roleDept;
	}

	public void setRoleDept(String roleDept) {
		this.roleDept = roleDept;
	}

	public String getRoleRemark() {
		return this.roleRemark;
	}

	public void setRoleRemark(String roleRemark) {
		this.roleRemark = roleRemark;
	}

	public String getRoleController() {
		return this.roleController;
	}

	public void setRoleController(String roleController) {
		this.roleController = roleController;
	}

	public Date getRoleUpdateTime() {
		return this.roleUpdateTime;
	}

	public void setRoleUpdateTime(Date roleUpdateTime) {
		this.roleUpdateTime = roleUpdateTime;
	}

	public BigDecimal getRoleDel() {
		return this.roleDel;
	}

	public void setRoleDel(BigDecimal roleDel) {
		this.roleDel = roleDel;
	}

}