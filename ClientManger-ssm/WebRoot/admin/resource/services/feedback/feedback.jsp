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
                        <tr><td height="31"><div class="title">反馈服务</div></td></tr>
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
						<!-- 服务信息开始 -->
						<tr>
                            <td width="2%">&nbsp;</td>
                            <td width="96%" align="center">
                                <table width="100%">
                                    <tr>
                                        <td colspan="2">
											<br/>
											<font style="font-size:13pt; font-weight:700">服务信息</font>
											<br/><br/>
											<table width="90%" class="cont">
												<tr>
														<td width="2%">&nbsp;</td>
														<td width="10%">服务名称：</td>
														<td width="30%" >${server.serverName}</td>
														
														<td width="12%">服务类型：</td>
														<td width="30%">${server.serverType}</td>
														<td></td>
														<td width="2%">&nbsp;</td>
													</tr>
													<tr>
														 <td width="2%">&nbsp;</td>
														<td>服务客户：</td>
														<td>${server.serverClientName}</td>
														
														<td>联系电话：</td>
														<td>${server.serverClientTel}</td>
														<td></td>
														<td width="2%">&nbsp;</td>
													</tr>
													<tr>
														<td width="2%">&nbsp;</td>
														<td>创建人：</td>
														<td>${server.serverCreater}</td>
														
														<td>创建时间：</td>
														<td>${server.serverCreateTime}</td>
														<td></td>
														<td width="2%">&nbsp;</td>
													</tr>
													<tr>
														<td width="2%">&nbsp;</td>
														<td>最后操作人：</td>
														<td>${server.serverController}</td>
														<td>最后操作时间：</td>
														<td>${server.serverUpdateTime}</td>
														<td></td>
														<td width="2%">&nbsp;</td>
													</tr>
													<tr>
														<td width="2%">&nbsp;</td>
														<td>服务内容：</td>
														<td colspan="3">${server.serverContext}</td>
														<td></td>
														<td width="2%">&nbsp;</td>
													</tr>
													<tr>
														<td width="2%">&nbsp;</td>
														<td>备注信息：</td>
														<td colspan="3">${server.serverRemark}</td>
														<td></td>
														<td width="2%">&nbsp;</td>
													</tr>
													<tr>
														<td width="2%">&nbsp;</td>
														<td>处理结果：</td>
														<td>已处理</td>
														<td></td>
														<td></td>
														<td></td>
														<td width="2%">&nbsp;</td>
													</tr>
													<tr>
														<td width="2%">&nbsp;</td>
														<td>处理说明：</td>
														<td colspan="3">${server.serverHandleContext}</td>
														<td></td>
														<td width="2%">&nbsp;</td>
													</tr>
													<tr>
														<td width="2%">&nbsp;</td>
														<td>待处理人：</td>
														<td>${server.serverHandler}</td>
														<td>服务当前状态：</td>
														<td>${server.serverState}</td>
														<td></td>
														<td width="2%">&nbsp;</td>
													</tr>
											</table>
                                        </td>
                                    </tr>
								</table>
							</td>
						</tr>
                        <!-- 服务信息结束 -->
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
						<!-- 服务反馈开始 -->
						<tr>
                            <td width="2%">&nbsp;</td>
                            <td width="96%" align="center">
                                <table width="100%">
									<tr>
                                        <td colspan="2">
                                            <form action="updateServer3.do" method="post">
                                             <input type="hidden" name="serverName" value="${server.serverName}">
                                             <input type="hidden" name="serverController" value="${userinfo.empName}">
												<br/>
												<font style="font-size:13pt; font-weight:700">反馈服务</font>
												<br/><br/>
                                                <table width="90%"  class="cont tr_color">
                                                    <tr>
														<td width="2%">&nbsp;</td>
														<td width="10%">反馈结果：</td>
														<td>
															<select name="serverState">
																<option value="3">未反馈</option>
																<option value="4">已反馈</option>
															</select>
														</td>
														<td width="2%">&nbsp;</td>
													</tr>
                                                    <tr>
														<td width="2%">&nbsp;</td>
														<td width="10%">反馈说明：</td>
														<td><textarea name="serverBackContext" value="${server.serverBackContext}" style="width:700px;height:100px;"></textarea></td>
														<td width="2%">&nbsp;</td>
													</tr>
													<tr>
														<td colspan="4" align="center">
															<input type="submit" value="提交"/>&nbsp;&nbsp;&nbsp;
															<a href="findByPageServer3.do"><input type="button" value="返回"/></a> 
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
                        <!-- 服务分配结束 -->
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