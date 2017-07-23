package entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Server entity. @author MyEclipse Persistence Tools
 */

public class Server implements java.io.Serializable {

	// Fields  serverHandleContext

	private String serverName;
	private String serverType;
	private String serverClientName;
	private String serverClientTel;
	private String serverContext;
	private String serverRemark;
	private Integer serverState;
	private Date serverCreateTime;
	private Date serverUpdateTime;
	private String serverCreater;
	private String serverController;
	private String serverHandler;
	private String serverHandleContext;
	private String serverBackContext;
	private Integer serverDel;
	private String serverBackState;
	public String getServerName() {
		return serverName;
	}
	public void setServerName(String serverName) {
		this.serverName = serverName;
	}
	public String getServerType() {
		return serverType;
	}
	public void setServerType(String serverType) {
		this.serverType = serverType;
	}
	public String getServerClientName() {
		return serverClientName;
	}
	public void setServerClientName(String serverClientName) {
		this.serverClientName = serverClientName;
	}
	public String getServerClientTel() {
		return serverClientTel;
	}
	public void setServerClientTel(String serverClientTel) {
		this.serverClientTel = serverClientTel;
	}
	public String getServerContext() {
		return serverContext;
	}
	public void setServerContext(String serverContext) {
		this.serverContext = serverContext;
	}
	public String getServerRemark() {
		return serverRemark;
	}
	public void setServerRemark(String serverRemark) {
		this.serverRemark = serverRemark;
	}
	public Integer getServerState() {
		return serverState;
	}
	public void setServerState(Integer serverState) {
		this.serverState = serverState;
	}
	public Date getServerCreateTime() {
		return serverCreateTime;
	}
	public void setServerCreateTime(Date serverCreateTime) {
		this.serverCreateTime = serverCreateTime;
	}
	public Date getServerUpdateTime() {
		return serverUpdateTime;
	}
	public void setServerUpdateTime(Date serverUpdateTime) {
		this.serverUpdateTime = serverUpdateTime;
	}
	public String getServerCreater() {
		return serverCreater;
	}
	public void setServerCreater(String serverCreater) {
		this.serverCreater = serverCreater;
	}
	public String getServerController() {
		return serverController;
	}
	public void setServerController(String serverController) {
		this.serverController = serverController;
	}
	public String getServerHandler() {
		return serverHandler;
	}
	public void setServerHandler(String serverHandler) {
		this.serverHandler = serverHandler;
	}
	public String getServerHandleContext() {
		return serverHandleContext;
	}
	public void setServerHandleContext(String serverHandleContext) {
		this.serverHandleContext = serverHandleContext;
	}
	public String getServerBackContext() {
		return serverBackContext;
	}
	public void setServerBackContext(String serverBackContext) {
		this.serverBackContext = serverBackContext;
	}
	public Integer getServerDel() {
		return serverDel;
	}
	public void setServerDel(Integer serverDel) {
		this.serverDel = serverDel;
	}
	public String getServerBackState() {
		return serverBackState;
	}
	public void setServerBackState(String serverBackState) {
		this.serverBackState = serverBackState;
	}
	public Server() {
		super();
	}
	public Server(String serverName, String serverType,
			String serverClientName, String serverClientTel,
			String serverContext, String serverRemark, Integer serverState,
			Date serverCreateTime, Date serverUpdateTime, String serverCreater,
			String serverController, String serverHandler,
			String serverHandleContext, String serverBackContext,
			Integer serverDel, String serverBackState) {
		super();
		this.serverName = serverName;
		this.serverType = serverType;
		this.serverClientName = serverClientName;
		this.serverClientTel = serverClientTel;
		this.serverContext = serverContext;
		this.serverRemark = serverRemark;
		this.serverState = serverState;
		this.serverCreateTime = serverCreateTime;
		this.serverUpdateTime = serverUpdateTime;
		this.serverCreater = serverCreater;
		this.serverController = serverController;
		this.serverHandler = serverHandler;
		this.serverHandleContext = serverHandleContext;
		this.serverBackContext = serverBackContext;
		this.serverDel = serverDel;
		this.serverBackState = serverBackState;
	}
	

}