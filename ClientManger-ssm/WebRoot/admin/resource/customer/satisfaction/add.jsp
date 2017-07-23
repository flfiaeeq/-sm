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
    
    <title>My JSP 'add.jsp' starting page</title>
    
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
                        <tr><td height="31"><div class="title">客户满意度</div></td></tr>
                    </table>
                </td>
                <td width="16" valign="top" background="admin/Images/mail_right_bg.gif"><img src="../../Images/nav_right_bg.gif" width="16" height="29" /></td>
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
											<form action="addClientSatisfaction.do?clientId=${satisfaction.clientId}" method="post">
											<table width="90%" class="cont">
											
												<tr>
													<td width="2%">&nbsp;</td>
													<td width="10%">客户姓名：</td>
													<td width="25%">
													 ${satisfaction.clientName}
													</td>
 

													<td width="10%">客户编码：</td>
													<td width="25%"><input id="clientId" type="text" value="${satisfaction.clientId}"/></td>
													<td></td>
													<td width="2%">&nbsp;</td>
													<td><input name="clientId" id="clientId" type="button" onclick="getClientID()" 

value="查询1"/></td>
													<input type="submit" value="查询"/>
												</tr>
												   
												<tr>
													<td width="2%">&nbsp;</td>
													<td>性别：</td>
													<td>${satisfaction.clientSex}</td>
													<td>客户类型：</td>
													<td>${satisfaction.clientType}</td>
													<td></td>
													<td width="2%">&nbsp;</td>
												</tr>
												<tr>
													 <td width="2%">&nbsp;</td>
													<td width="10%">消费次数：</td>
													<td width="25%">${satisfaction.clientBuyNum}</td>
													
													<td width="10%">客户状态：</td>
													<td width="25%">${satisfaction.clientState}</td>
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
						<!-- 代下订单开始 -->
						<tr>
                            <td width="2%">&nbsp;</td>
                            <td width="96%" align="center">
                                <table width="100%">
									<tr>
                                        <td colspan="2">
                                             
												<br/>
												<font style="font-size:13pt; font-weight:700">客户满意度调查</font>
												<br/><br/>
                                                <table width="90%"  class="cont tr_color">
                                                    <tr>
														<td width="2%">&nbsp;</td>
														<td width="13%">质量满意度：</td>
														<td width="25%"><input name="clientZlmyd" type="text" size="1"/>%</td>
														<td width="13%">服务满意度：</td>
														<td width="25%"><input name="clientFwmyd" type="text" size="1"/>%</td>
														<td></td>
														<td width="2%">&nbsp;</td>
													</tr>
													<tr>
														<td width="2%">&nbsp;</td>
														<td>性价满意度：</td>
														<td><input name="clientXjmyd" type="text" size="1" />%</td>
														<td>总体满意度：</td>
														<td><input name="clientZtmyd" type="text" size="1" />%</td>
														<td></td>
														<td width="2%">&nbsp;</td>
													</tr>
													<tr>
														 <td width="2%">&nbsp;</td>
														<td>客户反馈：</td>
														<td colspan="4"><textarea name="clientBackInfo" style="width:700px;height:100px;" placeholder=""></textarea></td>
														<td width="2%">&nbsp;</td>
													</tr>
													<tr>
														<td colspan="7" align="center">
														<input type="submit" value="提交调查"/>
														 
<!--														<input type="button" onclick="location.href='result.html'" value="提交调查"/>&nbsp;&nbsp;&nbsp;-->
															<a href="findAllClient.do?type=satisfaction"><input type="button" onclick="location.href='list.html'" value="返回列表"/></a>
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
                        <!-- 代下订单结束 -->
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
  <script type="text/javascript" language="javascript">
  	function getClientID(){
	
   	var p=document.getElementById("clientId").value;
   	alert(p);
   	alert("fdd");
   	
 	location.href="/ClinetManger/findClientSatisfaction.do?method=aa&clientId="+p;
  
}
  </script>