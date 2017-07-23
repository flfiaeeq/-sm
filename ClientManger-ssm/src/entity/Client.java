package entity;

import java.math.BigDecimal;
import java.sql.Date;
 
/**
 * Client entity. @author MyEclipse Persistence Tools
 */

public class Client implements java.io.Serializable {

	// Fields

	private String clientId;
	private String clientName;
	private String clientSex;
	private Date clientBirth;
	private String clientType;
	private BigDecimal clientState;
	private String clientTel;
	private String clientOffice;
	private String clientEmail;
	private String clientHome;
	private String clientAddress;
	private String clientRemark;
	private String clientCreater;
	private Date clientCreateTime;
	private String clientController;
	private Date clientUpdateTime;
	private String clientServer;
	private BigDecimal clientBuyNum;
	private Double clientBuyMoney;
	private String clientTrust;
	private Long clientValue;
	private Date clientSurvey;
	private String clientZlmyd;
	private String clientFwmyd;
	private String clientXjmyd;
	private String clientZtmyd;
	private String clientBackInfo;
	private Long clientDel;
	 
	// Constructors

	/** default constructor */
	public Client() {
	}

	/** minimal constructor */
	public Client(String clientId) {
		this.clientId = clientId;
	}

	/** full constructor */
	public Client(String clientId, String clientName, String clientSex,
			Date clientBirth, String clientType, BigDecimal clientState,
			String clientTel, String clientOffice, String clientEmail,
			String clientHome, String clientAddress, String clientRemark,
			String clientCreater, Date clientCreateTime,
			String clientController, Date clientUpdateTime,
			String clientServer, BigDecimal clientBuyNum,
			Double clientBuyMoney, String clientTrust, Long clientValue,
			Date clientSurvey, String clientZlmyd, String clientFwmyd,
			String clientXjmyd, String clientZtmyd, String clientBackInfo,
			Long clientDel) {
		this.clientId = clientId;
		this.clientName = clientName;
		this.clientSex = clientSex;
		this.clientBirth = clientBirth;
		this.clientType = clientType;
		this.clientState = clientState;
		this.clientTel = clientTel;
		this.clientOffice = clientOffice;
		this.clientEmail = clientEmail;
		this.clientHome = clientHome;
		this.clientAddress = clientAddress;
		this.clientRemark = clientRemark;
		this.clientCreater = clientCreater;
		this.clientCreateTime = clientCreateTime;
		this.clientController = clientController;
		this.clientUpdateTime = clientUpdateTime;
		this.clientServer = clientServer;
		this.clientBuyNum = clientBuyNum;
		this.clientBuyMoney = clientBuyMoney;
		this.clientTrust = clientTrust;
		this.clientValue = clientValue;
		this.clientSurvey = clientSurvey;
		this.clientZlmyd = clientZlmyd;
		this.clientFwmyd = clientFwmyd;
		this.clientXjmyd = clientXjmyd;
		this.clientZtmyd = clientZtmyd;
		this.clientBackInfo = clientBackInfo;
		this.clientDel = clientDel;
	}

	// Property accessors

	public String getClientId() {
		return this.clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getClientName() {
		return this.clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getClientSex() {
		return this.clientSex;
	}

	public void setClientSex(String clientSex) {
		this.clientSex = clientSex;
	}

	public Date getClientBirth() {
		return this.clientBirth;
	}

	public void setClientBirth(Date clientBirth) {
		this.clientBirth = clientBirth;
	}

	public String getClientType() {
		return this.clientType;
	}

	public void setClientType(String clientType) {
		this.clientType = clientType;
	}

	public BigDecimal getClientState() {
		return this.clientState;
	}

	public void setClientState(BigDecimal clientState) {
		this.clientState = clientState;
	}

	public String getClientTel() {
		return this.clientTel;
	}

	public void setClientTel(String clientTel) {
		this.clientTel = clientTel;
	}

	public String getClientOffice() {
		return this.clientOffice;
	}

	public void setClientOffice(String clientOffice) {
		this.clientOffice = clientOffice;
	}

	public String getClientEmail() {
		return this.clientEmail;
	}

	public void setClientEmail(String clientEmail) {
		this.clientEmail = clientEmail;
	}

	public String getClientHome() {
		return this.clientHome;
	}

	public void setClientHome(String clientHome) {
		this.clientHome = clientHome;
	}

	public String getClientAddress() {
		return this.clientAddress;
	}

	public void setClientAddress(String clientAddress) {
		this.clientAddress = clientAddress;
	}

	public String getClientRemark() {
		return this.clientRemark;
	}

	public void setClientRemark(String clientRemark) {
		this.clientRemark = clientRemark;
	}

	public String getClientCreater() {
		return this.clientCreater;
	}

	public void setClientCreater(String clientCreater) {
		this.clientCreater = clientCreater;
	}

	public Date getClientCreateTime() {
		return this.clientCreateTime;
	}

	public void setClientCreateTime(Date clientCreateTime) {
		this.clientCreateTime = clientCreateTime;
	}

	public String getClientController() {
		return this.clientController;
	}

	public void setClientController(String clientController) {
		this.clientController = clientController;
	}

	public Date getClientUpdateTime() {
		return this.clientUpdateTime;
	}

	public void setClientUpdateTime(Date clientUpdateTime) {
		this.clientUpdateTime = clientUpdateTime;
	}

	public String getClientServer() {
		return this.clientServer;
	}

	public void setClientServer(String clientServer) {
		this.clientServer = clientServer;
	}

	public BigDecimal getClientBuyNum() {
		return this.clientBuyNum;
	}

	public void setClientBuyNum(BigDecimal clientBuyNum) {
		this.clientBuyNum = clientBuyNum;
	}

	public Double getClientBuyMoney() {
		return this.clientBuyMoney;
	}

	public void setClientBuyMoney(Double clientBuyMoney) {
		this.clientBuyMoney = clientBuyMoney;
	}

	public String getClientTrust() {
		return this.clientTrust;
	}

	public void setClientTrust(String clientTrust) {
		this.clientTrust = clientTrust;
	}

	public Long getClientValue() {
		return this.clientValue;
	}

	public void setClientValue(Long clientValue) {
		this.clientValue = clientValue;
	}

	public Date getClientSurvey() {
		return this.clientSurvey;
	}

	public void setClientSurvey(Date clientSurvey) {
		this.clientSurvey = clientSurvey;
	}

	public String getClientZlmyd() {
		return this.clientZlmyd;
	}

	public void setClientZlmyd(String clientZlmyd) {
		this.clientZlmyd = clientZlmyd;
	}

	public String getClientFwmyd() {
		return this.clientFwmyd;
	}

	public void setClientFwmyd(String clientFwmyd) {
		this.clientFwmyd = clientFwmyd;
	}

	public String getClientXjmyd() {
		return this.clientXjmyd;
	}

	public void setClientXjmyd(String clientXjmyd) {
		this.clientXjmyd = clientXjmyd;
	}

	public String getClientZtmyd() {
		return this.clientZtmyd;
	}

	public void setClientZtmyd(String clientZtmyd) {
		this.clientZtmyd = clientZtmyd;
	}

	public String getClientBackInfo() {
		return this.clientBackInfo;
	}

	public void setClientBackInfo(String clientBackInfo) {
		this.clientBackInfo = clientBackInfo;
	}

	public Long getClientDel() {
		return this.clientDel;
	}

	public void setClientDel(Long clientDel) {
		this.clientDel = clientDel;
	}

}