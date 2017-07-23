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
     <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="stylesheet" type="text/css" href="admin/Style/skin.css" />
    <title>My JSP 'assign.jsp' starting page</title>
    

                <td valign="top" background="admin/Images/content_bg.gif">
                    <table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" background="./admin/Images/content_bg.gif">
                        <tr><td height="31"><div class="title">机会分配</div></td></tr>
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
                        <!-- 机会信息详情开始 -->
                        <tr>
                            <td width="2%">&nbsp;</td>
                            <td width="96%">
                                <table width="100%">
                                    <tr>
                                        <td colspan="2">
											<br/>
											<font style="font-size:13pt; font-weight:700">机会信息</font>
											<br/><br/>
											 
                                            <form action="" method="">
                                                <table width="100%"class="cont">
                                                    <tr>
                                                     
                                                        <td width="2%">&nbsp;</td>
                                                        <td width="10%">客户姓名：</td>
                                                        <td width="25%">${c.clientName}</td>
                                                        <td width="10%"></td>
														<td width="25%"></td>
														<td></td>
                                                        <td width="2%">&nbsp;</td>
                                                    </tr>
                                                    <tr>
                                                        <td width="2%">&nbsp;</td>
                                                        <td>性别：</td>
                                                        <td>${c.clientSex}</td>
														<td>客户类型：</td>
                                                        <td>${c.clientType}</td>
														<td></td>
                                                        <td width="2%">&nbsp;</td>
                                                    </tr>
                                                    <tr>
                                                        <td width="2%">&nbsp;</td>
                                                        <td>分配状态：</td>
                                                        <c:if test="${empty c.clientServer}">
                                                        <td>未分配</td>
                                                        </c:if>
                                                        <c:if test="${!empty c.clientServer}">
                                                        <td>已分配</td>
                                                        </c:if>
                                                        <td>录入时间：</td>
                                                        <td>${c.clientCreateTime}</td>
														<td></td>
                                                        <td width="2%">&nbsp;</td>
                                                    </tr>
													<tr>
                                                        <td width="2%">&nbsp;</td>
                                                        <td>最后操作人：</td>
                                                        <td> ${c.clientController}</td>
														<td>最后修改时间：</td>
                                                        <td>${c.clientUpdateTime}</td>
                                                        <td></td>
                                                        <td width="2%">&nbsp;</td>
                                                    </tr>
													<tr>
                                                        <td>&nbsp;</td>
                                                        <td>机会内容：</td>
                                                        <td colspan="3">北京海淀金女士来电咨询我司氧气发生器的价格，有购买意向，需跟进。联系电话：13691234123</td>
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
						<!-- 机会信息结束 -->
						<!-- 空白行-->
                        <tr><td colspan="2" valign="top">&nbsp;</td><td>&nbsp;</td><td valign="top">&nbsp;</td></tr>
                        <tr>
                            <td colspan="4"></td>
                        </tr>
                        <!-- 一条线 -->
                        <tr>
                            <td height="40" colspan="4">
                                <table width="100%" height="1" border="0" cellpadding="0" cellspacing="0" bgcolor="#CCCCCC">
                                    <tr><td></td></tr>
                                </table>
                            </td>
                        </tr>
						<!-- 机会分配开始 -->
						<tr>
                            <td width="2%">&nbsp;</td>
                            <td width="96%" align="center">
                                <table width="100%">
									<tr>
                                        <td colspan="2">
                                            <form action="upateClientAssgin.do?clientId=${c.clientId}" method="post">
												<br/>
												<font style="font-size:13pt; font-weight:700">分配机会</font>
												<br/><br/>
                                                <table width="90%"  class="cont tr_color">
                                                    <tr>
														<td width="2%">&nbsp;</td>
														<td width="10%">分配给：</td>
														<td>
														
															<select size="6" name="clientServer">
															<c:forEach items="${role}" var="p">
																<option>${p.empName}</option>
														 	
																</c:forEach>
															</select>
															
														</td>
														<td width="2%">&nbsp;</td>
													</tr>
                                                    
													<tr>
														<td colspan="4" align="center">
															<input type="submit" value="提交"/>
<!--															<input type="button" onclick="location.href='result.html'" value="提交"/>&nbsp;&nbsp;&nbsp;-->
															<input type="button" onclick="location.href='list.html'" value="返回"/>
														</td>
													</tr>
													
                                                </table>
                                            </form>
                                        </td>
                                    </tr>
                                </table>
                            </td>
                            <td width="2%">&nbsp;</td>
                        </tr>
                        <!-- 机会分配结束 -->
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
