package entity;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


/**
 * Menu entity. @author MyEclipse Persistence Tools
 */

public class Menu implements java.io.Serializable {

	// Fields

	private String menuId;
	private String menuName="";
	private String menuFather="";
	private BigDecimal menuState=new BigDecimal(0);
	private String menuUrl="";
	private String menuRemark="";
	private BigDecimal menuDel=new BigDecimal(0);
	private String menuController="";
	private Date menuUpdateTime=new Date(0);

	
	private List<Role> role=new ArrayList<Role>();
	
	// Constructors


	/** default constructor */
	public Menu() {
	}

	public List<Role> getRole() {
		return role;
	}

	public void setRole(List<Role> role) {
		this.role = role;
	}

	/** minimal constructor */
	public Menu(String menuId) {
		this.menuId = menuId;
	}

	/** full constructor */
	public Menu(String menuId, String menuName, String menuFather,
			BigDecimal menuState, String menuUrl, String menuRemark,
			BigDecimal menuDel, String menuController, Date menuUpdateTime) {
		this.menuId = menuId;
		this.menuName = menuName;
		this.menuFather = menuFather;
		this.menuState = menuState;
		this.menuUrl = menuUrl;
		this.menuRemark = menuRemark;
		this.menuDel = menuDel;
		this.menuController = menuController;
		this.menuUpdateTime = menuUpdateTime;
	}

	// Property accessors

	public String getMenuId() {
		return this.menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	public String getMenuName() {
		return this.menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuFather() {
		return this.menuFather;
	}

	public void setMenuFather(String menuFather) {
		this.menuFather = menuFather;
	}

	public BigDecimal getMenuState() {
		return this.menuState;
	}

	public void setMenuState(BigDecimal menuState) {
		this.menuState = menuState;
	}

	public String getMenuUrl() {
		return this.menuUrl;
	}

	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}

	public String getMenuRemark() {
		return this.menuRemark;
	}

	public void setMenuRemark(String menuRemark) {
		this.menuRemark = menuRemark;
	}

	public BigDecimal getMenuDel() {
		return this.menuDel;
	}

	public void setMenuDel(BigDecimal menuDel) {
		this.menuDel = menuDel;
	}

	public String getMenuController() {
		return this.menuController;
	}

	public void setMenuController(String menuController) {
		this.menuController = menuController;
	}

	public Date getMenuUpdateTime() {
		return this.menuUpdateTime;
	}

	public void setMenuUpdateTime(Date menuUpdateTime) {
		this.menuUpdateTime = menuUpdateTime;
	}

}