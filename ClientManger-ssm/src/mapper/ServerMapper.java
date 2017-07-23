package mapper;

import java.util.List;

import entity.Server;

public interface ServerMapper {
	//1.服务创建
	public int saveServer(Server s);
	public void deleteServer(String serverName);
	public void updateServer(Server s);
	public void serverSubmit(Server s);
	public Server findByNameServer(String serverName);
	public List findAllServer();
	public List findByPageServer(int first,int last);	
	public int findCount();
	//2.服务分配
	public List findByPageServer1(int first,int last);
	public int findCount1();
	public void serverAssign(Server s);
	//3.服务处理
	public List findByPageServer2(int first,int last);
	public int findCount2();
	public void serverHandle(Server s);
	//4.服务反馈
	public List findByPageServer3(int first,int last);
	public int findCount3();
	public void serverFeedBack(Server s);
	//5.服务归档
	public List findByPageServer4(int first,int last);
	public int findCount4();
	public void serverFile(Server s);
}
