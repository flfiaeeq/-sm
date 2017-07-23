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

  </head>
  
  <body>
            <table width="100%" border="0" cellpadding="0" cellspacing="0">
            <!-- 头部开始 -->
            <tr>
                <td width="17" valign="top" background="../../../Images/mail_left_bg.gif">
                    <img src="../../../Images/left_top_right.gif" width="17" height="29" />
                </td>
                <td valign="top" background="../../../Images/content_bg.gif">
                    <table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" background="./../../../Images/content_bg.gif">
                        <tr><td height="31"><div class="title">查看详情</div></td></tr>
                    </table>
                </td>
                <td width="16" valign="top" background="../../../Images/mail_right_bg.gif"><img src="../../../Images/nav_right_bg.gif" width="16" height="29" /></td>
            </tr>
            <!-- 中间部分开始 -->
            <tr>
                <!--第一行左边框-->
                <td valign="middle" background="../../../Images/mail_left_bg.gif">&nbsp;</td>
                <!--第一行中间内容-->
                <td valign="top" bgcolor="#F7F8F9">
                    <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
                        <!-- 空白行-->
                        <tr><td colspan="2" valign="top">&nbsp;</td><td>&nbsp;</td><td valign="top">&nbsp;</td></tr>
                        <tr>
                            <td colspan="4">
                               
                            </td>
                        </tr>
                        <!-- 一条线 -->
                        <tr>
                            <td height="40" colspan="4">
                                <table width="100%" height="1" border="0" cellpadding="0" cellspacing="0" bgcolor="#CCCCCC">
                                    <tr><td></td></tr>
                                </table>
                            </td>
                        </tr>
                        <!-- 展示详情开始 -->
                        <tr>
                            <td width="2%">&nbsp;</td>
                            <td width="96%">
                                <table width="100%">
                                    <tr>
                                        <td colspan="2">
                                            <form action="" method="">
                                                <table width="100%"class="cont">
                                                    <tr>
														<td width="2%">&nbsp;</td>
														<td width="10%">客户编码：</td>
														<td width="25%">${satisfaction.clientId}</td>
														<td width="10%">客户类型：</td>
														<td width="25%">${satisfaction.clientType}</td>
														<td></td>
														<td width="2%">&nbsp;</td>
													</tr>
													<tr>
														<td width="2%">&nbsp;</td>
														<td>客户姓名：</td>
														<td>${satisfaction.clientName}</td>
														<td>性别：</td>
														<td>${satisfaction.clientSex}</td>
														<td></td>
														<td width="2%">&nbsp;</td>
													</tr>
													<tr>
														 <td width="2%">&nbsp;</td>
														<td>消费次数：</td>
														<td>${satisfaction.clientBuyNum}</td>
														
														<td>客户状态：</td>
														      <c:if test="${satisfaction.clientState eq '0'}">
                                                        <td>正常</td>
                                                       	 </c:if>
                                                       	  <c:if test="${satisfaction.clientState eq '1'}">
                                                        <td>禁用</td>
                                                       	 </c:if>
														<td></td>
														<td width="2%">&nbsp;</td>
													</tr>
													<tr>
														<td width="2%">&nbsp;</td>
														<td>质量满意度：</td>
														<td>${satisfaction.clientZlmyd}</td>
														<td>服务满意度：</td>
														<td>${satisfaction.clientFwmyd}</td>
														<td></td>
														<td width="2%">&nbsp;</td>
													</tr>
													<tr>
														<td width="2%">&nbsp;</td>
														<td>性价满意度：</td>
														<td>${satisfaction.clientXjmyd}</td>
														<td>总体满意度：</td>
														<td>${satisfaction.clientZtmyd}</td>
														<td></td>
														<td width="2%">&nbsp;</td>
													</tr>
													<tr>
														<td width="2%">&nbsp;</td>
														<td>客户反馈：</td>
														<td colspan="4">${satisfaction.clientBackInfo}</td>
														<td width="2%">&nbsp;</td>
													</tr>
                                                    <tr>
                                                        <td>&nbsp;</td>
                                                        <td colspan="4" align="center">
															<a href="findAllClient.do?type=satisfaction"><input class="btn"  type="button" value="返回" /></a>
															
														</td>
                                                        <td></td>
                                                        <td>&nbsp;</td>
                                                    </tr>
                                                </table>
                                            </form>
                                        </td>
                                    </tr>
                                </table>
                            </td>
                            <td width="2%">&nbsp;</td>
                        </tr>
                        <!-- 展示详情结束 -->
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
                                
                            </td>
                            <td>&nbsp;</td><td>&nbsp;</td>
                        </tr>
                    </table>
                </td>
                <td background="../../../Images/mail_right_bg.gif">&nbsp;</td>
            </tr>
            <!-- 底部部分 -->
            <tr>
                <td valign="bottom" background="../../../Images/mail_left_bg.gif">
                    <img src="../../../Images/buttom_left.gif" width="17" height="17" />
                </td>
                <td background="../../../Images/buttom_bgs.gif">
                    <img src="../../../Images/buttom_bgs.gif" width="17" height="17">
                </td>
                <td valign="bottom" background="../../../Images/mail_right_bg.gif">
                    <img src="../../../Images/buttom_right.gif" width="16" height="17" />
                </td>           
            </tr>
        </table>
  </body>
</html>
