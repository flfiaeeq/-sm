<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html xmlns="http://www.w3.org/1999/xhtml" lang="zh-CN">
<head>
	<base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="stylesheet" type="text/css" href="admin/Style/skin.css" />	    
</head>
    <body>
        <table width="100%" border="0" cellpadding="0" cellspacing="0">
            <!-- 头部开始 -->
            <tr>
                <td width="17" valign="top" background="admin/Images/mail_left_bg.gif">
                    <img src="admin/Images/left_top_right.gif" width="17" height="29" />
                </td>
                <td valign="top" background="admin/Images/content_bg.gif">
                    <table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" background="admin/Images/content_bg.gif">
                        <tr><td height="31"><div class="title">服务处理</div></td></tr>
                    </table>
                </td>
                <td width="16" valign="top" background="admin/Images/mail_right_bg.gif"><img src="admin/Images/nav_right_bg.gif" width="16" height="29" /></td>
            </tr>
            <!-- 中间部分开始 -->
            <tr>
                <!--第一行左边框-->
                <td valign="middle" background="admin/Images/mail_left_bg.gif">&nbsp;</td>
                <!--第一行中间内容-->
                <td valign="top" bgcolor="#F7F8F9">
                    <table style="width:100%" width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
                        <!-- 空白行-->
                        <tr><td colspan="2" valign="top">&nbsp;</td><td>&nbsp;</td><td valign="top">&nbsp;</td></tr>
						<tr>
							<td colspan="4">
								<form class="clearfix">
									<div style="float:left">
										<p style="float:left; margin-left:30px;"><label>服务名称：</label><input class="text" style="width:80px;"/></p>&nbsp;&nbsp;&nbsp;
										<p style="float:left; margin-left:30px;"><label>服务类型：</label>
											<select>
												<option>不限</option>
												<option>咨询服务</option>
												<option>售前服务</option>
												<option>售后服务</option>
												<option>投诉服务</option>
											</select>
										</p>&nbsp;&nbsp;&nbsp;
										<p style="float:left; margin-left:30px;"><label>服务状态：</label>
											<select>
												<option>不限</option>
												<option>待提交</option>
												<option>待分配</option>
												<option>待处理</option>
												<option>待反馈</option>
												<option>已反馈</option>
											</select>
										</p>&nbsp;&nbsp;&nbsp;
                                        <p style="float:left; margin-left:30px;"><label>操作时间：</label><input class="text" style="width:80px;"/> - <input class="text" style="width:80px;"/></p>&nbsp;&nbsp;&nbsp;
										<p style="float:left; margin-left:30px;"><input type="button" class="btn" value="查询"/></p>
									</div>
									<div style="float:right">
									</div>
								</form>
							<td>
						</tr>
                        <!-- 一条线 -->
                        <tr>
                            <td height="40" colspan="4">
                                <table width="100%" height="1" border="0" cellpadding="0" cellspacing="0" bgcolor="#CCCCCC">
                                    <tr><td></td></tr>
                                </table>
                            </td>
                        </tr>
                        <!-- 列表展示开始 -->
                        <tr>
                            <td width="2%">&nbsp;</td>
                            <td width="96%">
                                <table width="100%">
                                    <tr>
                                        <td colspan="2">
                                            <form action="" method="">
                                                <table width="100%"  class="cont tr_color">
                                                    <tr>
                                                        <th>序号</th>
                                                        <th>选择</th>
                                                        <th>服务名称</th>
                                                        <th>服务类型</th>
                                                        <th>当前状态</th>
														<th>最后操作时间</th>
                                                        <th>操作者</th>
                                                        <th>待处理人</th>
                                                        <th>操作</th>
                                                    </tr>
                                                    <c:set var="i" value="0"></c:set>
                                                    <c:forEach var="server" items="${list}">
                                                    <c:set var="i" value="${i+1}"></c:set>  
                                                    <tr align="center" class="d">
                                                   		<td>${i}</td>
                                                        <td><input type="checkbox" value="" /></td>
                                                        <td><a href="view.html">${server.serverName}</a></td>
                                                        <td>${server.serverType}</td>
                                                        <td><c:if test="${server.serverState==0}">
                                                        	待提交
                                                        </c:if>
                                                        <c:if test="${server.serverState==1}">
                                                        	待分配
                                                        </c:if>
                                                        <c:if test="${server.serverState==2}">
                                                        	待处理
                                                        </c:if>
                                                        <c:if test="${server.serverState==3}">
                                                        	待反馈
                                                        </c:if>
                                                        <c:if test="${server.serverState==4}">
                                                        	已反馈
                                                        </c:if>
                                                        <c:if test="${server.serverState==5}">
                                                        	已归档
                                                        </c:if>
                                                        
                                                        </td>
                                                        <td>${server.serverUpdateTime}</td>
														<td>${server.serverController}</td>
                                                        <td>${server.serverHandler}</td>
                                                        <td>
                                                        	<a href="fidnByNameServer2.do?serverName=${server.serverName}&&flag=handle">处理</a>&nbsp;&nbsp;
                                                        	<a href="fidnByNameServer2.do?serverName=${server.serverName}&&flag=view">详情</a>&nbsp;&nbsp;
														</td>
                                                    </tr>
                                                     </c:forEach>
                                                    
                                                </table>
                                            </form>
                                        </td>
                                    </tr>
                                </table>
                            </td>
                            <td width="2%">&nbsp;</td>
                        </tr>
                        <!--列表展示结束 -->
                        <tr>
                            <td height="40" colspan="4">
                                <table width="100%" height="1" border="0" cellpadding="0" cellspacing="0" bgcolor="#CCCCCC">
                                    <tr><td></td></tr>
                                </table>
                            </td>
                        </tr>
                        <tr>
                            <td width="2%">&nbsp;</td>
                            <td width="51%" class="left_txt">
                           		<input type="button" value="全选" />&nbsp;&nbsp;&nbsp;
                                <input type="button" value="反选" />
                            	
                            
                            
                            <div style="float:right;"><b>
                                <a href="findByPageServer2.do?page=1">首页</a>&nbsp;&nbsp;&nbsp;
								<a href="findByPageServer2.do?page=${currentPage-1}">上一页</a>&nbsp;&nbsp;&nbsp;
								<a href="findByPageServer2.do?page=${currentPage-1}">&lt;&lt;</a>&nbsp;&nbsp;&nbsp;
															
									<c:forEach var="p1" begin="1" end="${sumPage}">
		             					<a href="findByPageServer2.do?page=${p1}">${p1}</a>&nbsp;&nbsp;&nbsp;
	               					</c:forEach>
								<a href="findByPageServer2.do?page=${currentPage+1}">&gt;&gt;</a>&nbsp;&nbsp;&nbsp;
								<a href="findByPageServer2.do?page=${currentPage+1}">下一页</a>&nbsp;&nbsp;&nbsp;
								<a href="findByPageServer2.do?page=${sumPage}">尾页</a>&nbsp;&nbsp;&nbsp;
								每页显示${page}条&nbsp;&nbsp;&nbsp;
								当前 ${currentPage}/${sumPage} 页&nbsp;&nbsp;&nbsp;
								共${sumCount}条
                            </b></div>
                            
                            </td>
                            <td>&nbsp;</td><td>&nbsp;</td>
                        </tr>
                    </table>
                </td>
                <td background="admin/Images/mail_right_bg.gif">&nbsp;</td>
            </tr>
            <!-- 底部部分 -->
            <tr>
                <td valign="bottom" background="admin/Images/mail_left_bg.gif">
                    <img src="admin/Images/buttom_left.gif" width="17" height="17" />
                </td>
                <td background="admin/Images/buttom_bgs.gif">
                    <img src="admin/Images/buttom_bgs.gif" width="17" height="17">
                </td>
                <td valign="bottom" background="admin/Images/mail_right_bg.gif">
                    <img src="admin/Images/buttom_right.gif" width="16" height="17" />
                </td>           
            </tr>
        </table>
    </body>
</html>