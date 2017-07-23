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
	<script src="admin/Js/prototype.lite.js" type="text/javascript"></script>
	<script src="admin/Js/moo.fx.js" type="text/javascript"></script>
	<script src="admin/Js/moo.fx.pack.js" type="text/javascript"></script>
    <link rel="stylesheet" type="text/css" href="admin/Style/skin.css" />
	<script type="text/javascript">
        window.onload = function () {
            var contents = document.getElementsByClassName('content');
            var toggles = document.getElementsByClassName('type');

            var myAccordion = new fx.Accordion(
            toggles, contents, {opacity: true, duration: 400}
            );
            myAccordion.showThisHideOpen(contents[0]);
            for(var i=0; i<document .getElementsByTagName("a").length; i++){
                var dl_a = document.getElementsByTagName("a")[i];
                    dl_a.onfocus=function(){
                        this.blur();
                    }
            }
        }
    </script>
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
                        <tr><td height="31"><div class="title">角色授权</div></td></tr>
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
                        <!-- 角色信息开始 -->
                        <tr>
                            <td width="2%">&nbsp;</td>
                            <td width="96%" align="center">
					<form action="shouQuan.do" method="post">
                                <table width="100%">
                                    <tr>
                                        <td colspan="2">
											<br/>
											<font style="font-size:13pt; font-weight:700">角色信息</font>
											<br/><br/>
											<table width="90%" class="cont">
												<tr>
													<td width="2%">&nbsp;</td>
													<td width="10%">角色编码：</td>
													<td width="25%"><input class="text"  value="${sessionScope.findRole.roleId}" placeholder="异步联动" name="roleId" /></td>
													<td width="10%">角色名称：</td>
													<td width="25%">
													 <select name="roleName">
																<c:forEach items="${findRoleName}" var="i">
	                                                                <option value="${i.roleName}">${i.roleName}</option>
                                                                </c:forEach>
															</select>
													</td>
													<td></td>
													<td width="2%">&nbsp;</td>
												</tr>
												<tr>
													<td width="2%">&nbsp;</td>
													<td>角色状态：</td>
													<td>${sessionScope.findRole.roleState}</td>
													
													<td>所属部门：</td>
													<td>${sessionScope.findRole.roleDept}</td>
													<td></td>
													<td width="2%">&nbsp;</td>
												</tr>
												<tr>
													<td width="2%">&nbsp;</td>
													<td>备注信息：</td>
													<td colspan="3">${sessionScope.findRole.roleRemark}</td>
													<td></td>
													<td width="2%">&nbsp;</td>
												</tr>
												<tr>
													<td width="2%">&nbsp;</td>
													<td>赋菜单：</td>
													<td colspan="4">
													<table border="0" style="width:100%">
														<tr>
														<c:forEach var="aa" items="${requestScope.findFuZi}" begin="0" step="1" end="2">
															<td style="width:30%; text-align:left; vertical-align:top">
																	<input type="checkbox" />${aa.menuFather}<br/>
																	<c:forEach var="bb" items="${aa.menuNames}">
																     &nbsp;&nbsp;&nbsp; <input type="checkbox" name="menuIds" value="${bb.menuId}" />${bb.menuName}<br/>
																   </c:forEach>
															</td>
													   </c:forEach>
														</tr>
														<tr>
														<c:forEach var="aa" items="${requestScope.findFuZi}" begin="3" step="1" end="5">
															<td style="width:30%; text-align:left; vertical-align:top">
																	<input type="checkbox"   />${aa.menuFather}<br/>
																	<c:forEach var="bb" items="${aa.menuNames}">
																     &nbsp;&nbsp;&nbsp; <input type="checkbox" name="menuIds" value="${bb.menuId}" />${bb.menuName}<br/>
																   </c:forEach>
															</td>
													   </c:forEach>
														</tr>
														<tr>
														<c:forEach var="aa" items="${requestScope.findFuZi}" begin="6" step="1" end="8">
															<td style="width:30%; text-align:left; vertical-align:top">
																	<input type="checkbox"/>${aa.menuFather}<br/>
																	<c:forEach var="bb" items="${aa.menuNames}">
																    &nbsp;&nbsp;&nbsp; <input type="checkbox" name="menuIds" value="${bb.menuId}" />${bb.menuName}<br/>
																   </c:forEach>
															</td>
													   </c:forEach>
														</tr>
														
													</table>
													</td>
													<td width="2%">&nbsp;</td>
												</tr>
												<tr>
													<td width="2%">&nbsp;</td>
													<td colspan="4" align="center">
<%--														<input class="btn" onclick="location='result.html'" type="button" value="提交" />&nbsp;&nbsp;&nbsp;--%>
														<input class="btn" type="submit" value="提交" />&nbsp;&nbsp;&nbsp;
														<input class="btn" onclick="location='findAllRole.do'" type="button" value="返回" />
													</td>
													<td></td>
													<td width="2%">&nbsp;</td>
												</tr>
											</table>
                                        </td>
                                    </tr>
								</table>
								</form>
							</td>
						</tr>
						 <!-- 角色信息结束 -->
	
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