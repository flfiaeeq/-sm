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
    
    <title>My JSP 'view.jsp' starting page</title>
    
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
                        <tr><td height="31"><div class="title">历史清单</div></td></tr>
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
                        <!-- 一条线 -->
                        <tr>
                            <td height="40" colspan="4">
                                <table width="100%" height="1" border="0" cellpadding="0" cellspacing="0" bgcolor="#CCCCCC">
                                    <tr><td></td></tr>
                                </table>
                            </td>
                        </tr>
                        <!-- 客户信息开始 -->
                        <tr>
                            <td width="2%">&nbsp;</td>
                            <td width="96%" align="center">
                          
                                <table width="100%">
                                    <tr>
                                        <td colspan="2">
											<br/>
											<font style="font-size:13pt; font-weight:700">客户信息</font>
											<br/><br/>
											<table width="90%" class="cont">
												<tr>
												 
													<td width="2%">&nbsp;</td>
													<td>客户姓名：</td>
													<td>${c.clientName }</td>
													<td>性别：</td>
													<td>${c.clientSex }</td>
													<td></td>
													<td width="2%">&nbsp;</td>
												</tr>
												 
												<tr>
													<td width="2%">&nbsp;</td>
													<td width="10%">客户类型：</td>
													<td width="25%">${c.clientType }</td>
													<td width="10%">客户状态：</td>
													      <c:if test="${c.clientState eq '0'}">
                                                        <td>正常</td>
                                                       	 </c:if>
                                                       	  <c:if test="${c.clientState eq '1'}">
                                                        <td>禁用</td>
                                                       	 </c:if>
													<td></td>
													<td width="2%">&nbsp;</td>
												</tr>
												<tr>
													 <td width="2%">&nbsp;</td>
													<td width="10%">生日：</td>
													<td width="25%">${c.clientBirth }</td>
													<td width="10%">总体满意度：</td>
													<td width="25%">${c.clientZtmyd }</td>
													<td></td>
													<td width="2%">&nbsp;</td>
												</tr>
												<tr>
													 <td width="2%">&nbsp;</td>
													<td width="10%">信誉等级：</td>
													<td width="25%">${c.clientTrust }</td>
													<td width="10%">价值等级：</td>
													<td width="25%">${c.clientValue }</td>
													<td></td>
													<td width="2%">&nbsp;</td>
												</tr>
												 
											</table>
                                        </td>
                                    </tr>
								</table>
							</td>
						</tr>
						 <!-- 客户信息结束 -->
						 <!-- 空白行-->
                        <tr><td colspan="2" valign="top">&nbsp;</td><td>&nbsp;</td><td valign="top">&nbsp;</td></tr>
                        <!-- 一条线 -->
                        <tr>
                            <td height="40" colspan="4">
                                <table width="100%" height="1" border="0" cellpadding="0" cellspacing="0" bgcolor="#CCCCCC">
                                    <tr><td></td></tr>
                                </table>
                            </td>
                        </tr>
						<!-- 空白行-->
                        <tr><td colspan="2" valign="top">&nbsp;</td><td>&nbsp;</td><td valign="top">&nbsp;</td></tr>
						
                        
                        <!-- 列表展示开始 -->
                        <tr>
                            <td width="2%">&nbsp;</td>
                            <td width="96%">
                                <table width="100%">
                                    <tr>
                                        <td colspan="2">
											<br/>
											<font style="font-size:13pt; font-weight:700">历史清单</font>
											<br/><br/>
                                            <form action="" method="">
                                                <table width="100%"  class="cont tr_color">
                                                    <tr>
                                                        <th>序号</th>
                                                        <th>选择</th>
                                                        <th>订单类型/订单编号</th>
                                                        <th>商品</th>
                                                        <th>收货人</th>
                                                        <th>订单金额</th>
                                                        <th>下单时间</th>
                                                        <th>订单状态</th>
                                                    </tr>
                                                     <c:forEach items="${order}" var="o">
                                                    <tr align="center" class="d">
                                                   		<td>1</td>
                                                        <td><input type="checkbox" value="" /></td>
                                                        <td><a href="view.html"><br/>${o.order.orderNumber }</a></td>
                                                        <td>${o.order.orderGoods}</td>
                                                        <td>${o.order.orderClientName}</td>
                                                        <td>${o.order.orderMoney}</td>
                                                        <td>${o.order.orderTime}</td>
                                                        <td>${o.order.orderState}</td>
                                                    </tr>
                                                    </c:forEach>
                                                    	<a href="findAllClient.do?type=value"><input class="btn" onclick="location='../value/list.html'" type="button" value="返回" /></a>
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
