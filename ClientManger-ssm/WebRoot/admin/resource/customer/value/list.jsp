<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
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
                    <table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" background="./admin/Images/content_bg.gif">
                        <tr><td height="31"><div class="title">客户价值</div></td></tr>
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
										<p style="float:left; margin-left:30px;"><label>客户姓名：</label><input class="text" style="width:80px;"/></p>&nbsp;&nbsp;&nbsp;
										<p style="float:left; margin-left:30px;"><label>客户类型：</label>
											<select>
												<option>不限</option>
												<option>普通客户</option>
												<option>银卡客户</option>
												<option>金卡客户</option>
												<option>VIP客户</option>
											</select>
										</p>&nbsp;&nbsp;&nbsp;
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
                                                        <th>客户姓名</th>
                                                        <th>性别</th>
                                                        <th>客户类型</th>
														<th>已消费次数</th>
														<th>消费总额</th>
                                                        <th>服务代表</th>
                                                        <th>操作</th>
                                                    </tr>
                                                    <c:set var="i" value="0"></c:set>
                                                     <c:forEach items="${showClient}" var="pa">
                                                     <c:set var="i" value="${i+1}"></c:set>
                                                    <tr align="center" class="d">
                                                   		<td>${i }</td>
														<td><input type="checkbox" value="" /></td>
                                                        <td><a href="findClientOrder.do?clientId=${pa.clientId }">${pa.clientName} </a></td>
                                                        <td>${pa.clientSex}</td>
                                                        <td>${pa.clientType}</td>
                                                        <td>${pa.clientBuyNum}</td>
                                                        <td>${pa.clientBuyMoney}</td>
														<td>${pa.clientController}</td>
                                                        <td>
															<a href="findClientOrder.do?clientId=${pa.clientId }">历史清单</a>
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
                                <a href="findAllClient.do?type=value&currentPage=1">首页</a>&nbsp;&nbsp;&nbsp;
								<a href="findAllClient.do?type=value&currentPage=${currentPage<2?1:currentPage-1 }">上一页</a>&nbsp;&nbsp;&nbsp;
								 <c:if test="${currentPage<7}">
       								<c:forEach begin="1" end="${sumPage<10?sumPage:10}" var="pageNum">
      
       									<a href="findAllClient.do?type=value&currentPage=${pageNum}">${pageNum}</a>
       								</c:forEach>
      							 </c:if>
       							 <c:if test="${currentPage>=7}">
       									 <c:forEach begin="${currentPage-5}" end="${currentPage+4>sumPage?sumPage:currentPage+4}" var="pageNum">
      
       										<a href="findAllClient.do?type=value&currentPage=${pageNum}">${pageNum}</a>
      									 </c:forEach>
       							 </c:if>
								<a href="findAllClient.do?type=value&currentPage=${currentPage>sumPage?sumPage:currentPage+1}">下一页</a>&nbsp;&nbsp;&nbsp;
								<a href="findAllClient.do?type=value&currentPage=${sumPage}">尾页</a>&nbsp;&nbsp;&nbsp;
								每页显示${pages }条&nbsp;&nbsp;&nbsp;
								当前 ${currentPage }/${sumPage } 页&nbsp;&nbsp;&nbsp;
								共${sumCount }条
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
