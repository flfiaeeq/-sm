<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
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
                        <tr><td height="31"><div class="title">操作结果</div></td></tr>
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
                        <tr>
                            <td height="40" colspan="4" align="center">
                               	
                               <h1>机会添加成功！</h1>
                            </td>
                        </tr>
						<tr>
							<td>&nbsp;</td>
							<td colspan="2" align="center"></td>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td colspan="4" align="center">
								<a href="admin/resource/market/opp/add.jsp">继续添加</a>&nbsp;&nbsp;&nbsp;
								<a href="findByIdChance.do?flagC=edit&&ChanceId=${Chance.chanceId}">返回修改</a>&nbsp;&nbsp;&nbsp;
								<a href="assign.html">机会分配</a>&nbsp;&nbsp;&nbsp;
								<a href="findAllChance.do">机会列表</a>
							</td>
						</tr>
						<tr>
                            <td height="40" colspan="4" align="center"></td>
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
                                                        <td width="10%">机会名称：</td>
                                                        <td width="25%">${Chance.chanceName}</td>
                                                        <td width="10%"></td>
														<td width="25%"></td>
														<td></td>
                                                        <td width="2%">&nbsp;</td>
                                                    </tr>
                                                    <tr>
                                                        <td width="2%">&nbsp;</td>
                                                        <td>机会类型：</td>
                                                        <td>${Chance.chanceType}</td>
								
														<td></td>
                                                        <td width="2%">&nbsp;</td>
                                                    </tr>
                                                    <tr>
                                                        <td width="2%">&nbsp;</td>
                                                        <td>录入人：</td>
                                                        <td>${Chance.chanceCreater}</td>
                                                        <td>录入时间：</td>
                                                        <td>${Chance.chanceCreateTime}</td>
														<td></td>
                                                        <td width="2%">&nbsp;</td>
                                                    </tr>
													<tr>
                                                        <td width="2%">&nbsp;</td>
                                                        <td>最后操作人：</td>
                                                        <td>${Chance.chanceCreater}</td>
														<td>最后修改时间：</td>
                                                        <td>${Chance.chanceCreater}</td>
                                                        <td></td>
                                                        <td width="2%">&nbsp;</td>
                                                    </tr>
													<tr>
                                                        <td>&nbsp;</td>
                                                        <td>机会内容：</td>
                                                        <td colspan="3">${Chance.chanceContext}</td>
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
						<!-- 机会分配详情开始 -->
						<tr>
                            <td width="2%">&nbsp;</td>
                            <td width="96%" align="center">
                                <table width="100%">
									<tr>
                                        <td colspan="2">
                                            <form action="" method="">
												<br/>
												<font style="font-size:13pt; font-weight:700">分配机会</font>
												<br/><br/>
                                                <table width="90%"  class="cont tr_color">
                                                    <tr>
														<td width="2%">&nbsp;</td>
														<td width="10%">分配给：</td>
														<c:if test="${empty Chance.chanceEmp}">
														<td>未分配</td>
														</c:if>
														<c:if test="${!empty Chance.chanceEmp}">
														<td>已分配给：${Chance.chanceEmp}</td>
														</c:if>
														<td width="2%">&nbsp;</td>
													</tr>
                                                    
													<tr>
														<td colspan="4" align="center">
															<input type="button" onclick="location.href='findAllChance.do'" value="返回"/>
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
                        <!-- 机会分配详情结束 -->
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