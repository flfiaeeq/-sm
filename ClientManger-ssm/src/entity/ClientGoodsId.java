package entity;

import java.math.BigDecimal;
import java.util.List;

/**
 * ClientGoodsId entity. @author MyEclipse Persistence Tools
 */

public class ClientGoodsId implements java.io.Serializable {

	// Fields

	private String clientName;
	private String goodsId;
	private BigDecimal num;
	 
	private Order order;

	// Constructors

	/** default constructor */
	public ClientGoodsId() {
	}

	/** full constructor */
	

	// Property accessors

	public String getClientName() {
		return this.clientName;
	}

 

	public ClientGoodsId(String clientName, String goodsId, BigDecimal num,
			Order order) {
		super();
		this.clientName = clientName;
		this.goodsId = goodsId;
		this.num = num;
		this.order = order;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getGoodsId() {
		return this.goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public BigDecimal getNum() {
		return this.num;
	}

	public void setNum(BigDecimal num) {
		this.num = num;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	
	
 
 

//	public boolean equals(Object other) {
//		if ((this == other))
//			return true;
//		if ((other == null))
//			return false;
//		if (!(other instanceof ClientGoodsId))
//			return false;
//		ClientGoodsId castOther = (ClientGoodsId) other;
//
//		return ((this.getClientName() == castOther.getClientName()) || (this
//				.getClientName() != null
//				&& castOther.getClientName() != null && this.getClientName()
//				.equals(castOther.getClientName())))
//				&& ((this.getGoodsId() == castOther.getGoodsId()) || (this
//						.getGoodsId() != null
//						&& castOther.getGoodsId() != null && this.getGoodsId()
//						.equals(castOther.getGoodsId())))
//				&& ((this.getNum() == castOther.getNum()) || (this.getNum() != null
//						&& castOther.getNum() != null && this.getNum().equals(
//						castOther.getNum())))
//				&& ((this.getOrderNumber() == castOther.getOrderNumber()) || (this
//						.getOrderNumber() != null
//						&& castOther.getOrderNumber() != null && this
//						.getOrderNumber().equals(castOther.getOrderNumber())));
//	}

//	public int hashCode() {
//		int result = 17;
//
//		result = 37
//				* result
//				+ (getClientName() == null ? 0 : this.getClientName()
//						.hashCode());
//		result = 37 * result
//				+ (getGoodsId() == null ? 0 : this.getGoodsId().hashCode());
//		result = 37 * result
//				+ (getNum() == null ? 0 : this.getNum().hashCode());
//		result = 37
//				* result
//				+ (getOrderNumber() == null ? 0 : this.getOrderNumber()
//						.hashCode());
//		return result;
//	}

}