package entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
 

/**
 * Order entity. @author MyEclipse Persistence Tools
 */

public class Order implements java.io.Serializable {

	// Fields
	 
	private String orderNumber;
	private String orderGoods;
	private String orderClientName;
	private String orderClientTel;
	private String orderClientAddress;
	private Double orderMoney;
	private Date orderTime;
	private String orderState;
	private List list = new ArrayList();

	// Constructors

	/** default constructor */
	public Order() {
	}

	/** minimal constructor */
	public Order(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	/** full constructor */
	public Order(String orderNumber, String orderGoods, String orderClientName,
			String orderClientTel, String orderClientAddress,
			Double orderMoney, Date orderTime, String orderState) {
		this.orderNumber = orderNumber;
		this.orderGoods = orderGoods;
		this.orderClientName = orderClientName;
		this.orderClientTel = orderClientTel;
		this.orderClientAddress = orderClientAddress;
		this.orderMoney = orderMoney;
		this.orderTime = orderTime;
		this.orderState = orderState;
	}

	// Property accessors

	public String getOrderNumber() {
		return this.orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getOrderGoods() {
		return this.orderGoods;
	}

	public void setOrderGoods(String orderGoods) {
		this.orderGoods = orderGoods;
	}

	public String getOrderClientName() {
		return this.orderClientName;
	}

	public void setOrderClientName(String orderClientName) {
		this.orderClientName = orderClientName;
	}

	public String getOrderClientTel() {
		return this.orderClientTel;
	}

	public void setOrderClientTel(String orderClientTel) {
		this.orderClientTel = orderClientTel;
	}

	public String getOrderClientAddress() {
		return this.orderClientAddress;
	}

	public void setOrderClientAddress(String orderClientAddress) {
		this.orderClientAddress = orderClientAddress;
	}

	public Double getOrderMoney() {
		return this.orderMoney;
	}

	public void setOrderMoney(Double orderMoney) {
		this.orderMoney = orderMoney;
	}

	public Date getOrderTime() {
		return this.orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public String getOrderState() {
		return this.orderState;
	}

	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}

}