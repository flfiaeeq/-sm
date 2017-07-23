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
                    <table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" background="./admin/Images/content_bg.gif">
                        <tr><td height="31"><div class="title">员工授权</div></td></tr>
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
                        <!-- 员工信息开始 -->
                        <tr>
                            <td width="2%">&nbsp;</td>
                            <td width="96%" align="center">
                                <table width="100%">
                                    <tr>
                                        <td colspan="2">
											<br/>
											<font style="font-size:13pt; font-weight:700">员工信息</font>
											<br/><br/>
											<form action="updateEmp.do" method="post">
                                            <input type="text" value="empRole1" name="flag"/>
											<table width="90%" class="cont">
												<tr>
													<td width="2%">&nbsp;</td>
													<td width="10%">员工编码：</td>
													<td width="25%"><input class="text" value="${sessionScope.findEmp.empId}" placeholder="异步联动" name="empId" /></td>
													<td width="10%">员工姓名：</td>
													<td width="25%"><input class="text" type="text" value="${sessionScope.findEmp.empName}" placeholder="真实姓名"  name="empName"/></td>
													<td></td>
													<td width="2%">&nbsp;</td>
												</tr>
												<tr>
													<td width="2%">&nbsp;</td>
													<td>性&nbsp;&nbsp;&nbsp;&nbsp;别：</td>
													<td>${sessionScope.findEmp.empSex}</td>
													<td>联系方式：</td>
													<td>${sessionScope.findEmp.empPhone}</td>
													<td></td>
													<td width="2%">&nbsp;</td>
												</tr>
												<tr>
													<td width="2%">&nbsp;</td>
													<td>账号状态：</td>
													
													<c:if test="${findMenu.menuState==0}"> <td>禁用</td> </c:if> 
                                                    <c:if test="${findMenu.menuState==1}"><td>启用</td> </c:if> 
													<td>所属部门：</td>
													<td>${sessionScope.findEmp.empDept}</td>
													<td></td>
													<td width="2%">&nbsp;</td>
												</tr>
												<tr>
													<td>&nbsp;</td>
													<td>备注信息：</td>
													<td colspan="3">${sessionScope.findEmp.empRemark}</td>
													<td></td>
													<td>&nbsp;</td>
												</tr>
												<tr>
													<td width="2%">&nbsp;</td>
													<td>角色身份：</td>
													<td colspan="3">${sessionScope.findEmp.empRole}<td>
													<td></td>
													<td width="2%">&nbsp;</td>
												</tr>
											</table>
                                        </td>
                                    </tr>
								</table>
							</td>
						</tr>
						 <!-- 员工信息结束 -->
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
						<!-- 员工授权开始 -->
						<tr>
                            <td width="2%">&nbsp;</td>
                            <td width="96%" align="center">
                                <table width="100%">
									<tr>
                                        <td colspan="2">
<%--                                             <form action="updateEmp.do" method="post">--%>
<%--                                            <input type="text" value="empRole1" name="flag"/>--%>
												<br/>
												<font style="font-size:13pt; font-weight:700">员工授权</font>
												<br/><br/>
												<table width="100%"  class="cont tr_color">
                                                    <tr>
                                                        <th>序号</th>
                                                        <th>选择</th>
                                                        <th>角色名称</th>
                                                        <th>最后操作时间</th>
                                                        <th>最后操作者</th>
                                                        <th>当前状态</th>
                                                    </tr>
                                                    <c:forEach var="aa" items="${findAllRole}">
													    
													         <tr align="center" class="d">
                                                   		<td>1</td>
                                                        <td><input type="radio" name="empRole" value=" ${aa.roleName}" /></td>
                                                        <td><a href="findRole.do?roleId=${aa.roleId}"> ${aa.roleName}</a></td>
                                                        <td> ${aa.roleDept}</td>
                                                        <td>  ${aa.roleUpdateTime}</td>
                                                        <td> ${aa.roleController}</td>
                                                        <c:if test="${aa.roleState==1}"> <td>启用</td></c:if>
                                                       <c:if test="${aa.roleState==0}"> <td>禁用</td></c:if>
														</td>
                                                    </tr>
													   </c:forEach>
                                                     
                                                </table>
<%--                                            </form>--%>
                                        </td>
                                    </tr>
                                </table>
                            </td>
                            <td width="2%">&nbsp;</td>
                        </tr>
						<tr>
							<td></td>
								<td colspan="2" align="center">
<%--									<input class="btn" onclick="location='result.html'" type="button" value="提交" />&nbsp;&nbsp;&nbsp;--%>
										<input class="btn" type="submit" value="提交" />&nbsp;&nbsp;&nbsp;
									<input class="btn" onclick="location='findEmp.do'" type="button" value="返回" />
								</td>
							<td></td>
						</tr>
                        <!-- 员工授权结束 -->
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
                    </form>
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