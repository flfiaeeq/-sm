package service.Impl;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;

import mapper.EmpMapper;
import mapper.ServerMapper;

import org.springframework.stereotype.Service;

import entity.Server;

import service.EmpService;
import service.ServerService;

@Service("serverServiceImpl")
public class ServerServiceImpl implements ServerService {
	@Resource(name = "serverMapper")
	private ServerMapper serverMapper = null;
	public ServerMapper getServerMapper() {
		return serverMapper;
	}
	public void setServerMapper(ServerMapper serverMapper) {
		this.serverMapper = serverMapper;
	}
	//1.服务创建
	public List findAllServer() {
		return serverMapper.findAllServer();
	}
	public void deleteServer(String serverName) {
		serverMapper.deleteServer(serverName);
	}
	public Server findByNameServer(String serverName) {
		return serverMapper.findByNameServer(serverName);
	}
	public int saveServer(Server s) {
		return serverMapper.saveServer(s);
	}
	public void updateServer(Server s) {
		serverMapper.updateServer(s);		
	}
	public List findByPageServer(int first,int last) {		
		return serverMapper.findByPageServer(first, last);
	}
	public int findCount() {
		return serverMapper.findCount();
	}
	public void serverSubmit(Server s) {
		serverMapper.serverSubmit(s);
		
	}
	//批量删除
	public void  deleteAllServer(String[] check) throws Exception {
		if(check==null){
			System.out.println("null");
		}else{
			String[] split = check[0].split(",");
			
			for(String checxBox:split){
				String name=new String(checxBox.getBytes("iso8859-1"),"utf-8");
				
				serverMapper.deleteServer(name);
				System.out.println("good");
			}
		}
	}

	//2.服务分配
	public List findByPageServer1(int first, int last) {
		return serverMapper.findByPageServer1(first, last);
	}
	public int findCount1() {
		return serverMapper.findCount1();
	}
	public void serverAssign(Server s) {
		serverMapper.serverAssign(s);
	}
	
	//3.服务处理
	public List findByPageServer2(int first, int last) {
		return serverMapper.findByPageServer2(first, last);
	}
	public int findCount2() {
		return serverMapper.findCount2();
	}
	
	public void serverHandle(Server s) {
		serverMapper.serverHandle(s);
	}
	//4.服务反馈
	public List findByPageServer3(int first, int last) {
		return serverMapper.findByPageServer3(first, last);
	}
	public int findCount3() {
		return serverMapper.findCount3();
	}
	public void serverFeedBack(Server s) {
		serverMapper.serverFeedBack(s);
	}
	//5.服务归档
	public List findByPageServer4(int first, int last) {
		return serverMapper.findByPageServer4(first, last);
	}	
	public int findCount4() {
		return serverMapper.findCount4();
	}
	public void serverFile(Server s) {
		serverMapper.serverFile(s);
	}
	

	
}
