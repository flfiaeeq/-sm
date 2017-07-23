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
                               	
                               <h1>角色添加成功！</h1>
                            </td>
                        </tr>
						<tr>
							<td>&nbsp;</td>
							<td colspan="2" align="center"></td>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td colspan="4" align="center">
								<a href="findRoleDept.do">继续添加</a>&nbsp;&nbsp;&nbsp;
								<a href="findRole.do?roleId=${findRole.roleId}&flag=updateRole">返回修改</a>&nbsp;&nbsp;&nbsp;
								<a href="findRole.do?roleId=${findRole.roleId}&flag=shouquan">角色授权</a>&nbsp;&nbsp;&nbsp;
								<a href="findAllRole.do">展示列表</a>
							</td>
						</tr>
						<tr>
                            <td height="40" colspan="4" align="center"></td>
                        </tr>
                        <!-- 展示详情开始 -->
                        <tr>
                            <td width="2%">&nbsp;</td>
                            <td width="96%">
                                <table width="100%">
                                    <tr>
                                        <td colspan="2">
                                                <table width="100%"class="cont">
													<tr>
                                                        <td width="2%">&nbsp;</td>
                                                        <td width="8%">角色编码：</td>
                                                        <td width="25%">${findRole.roleId}</td>
														<td width="8%">角色名称：</td>
                                                        <td width="25%">${findRole.roleName}</td>
                                                        <td></td>
                                                        <td width="2%">&nbsp;</td>
                                                    </tr>
                                                    <tr>
                                                        <td width="2%">&nbsp;</td>
                                                        <td>角色状态：</td>
                                                         <c:if test="${findRole.roleState==1}"> <td>启用</td></c:if>
 														<c:if test="${findRole.roleState==0}"> <td>禁用</td></c:if>
														<td>所属部门：</td>
                                                        <td>${findRole.roleDept}</td>
                                                        <td></td>
                                                        <td width="2%">&nbsp;</td>
                                                    </tr>
                                                    <tr>
                                                        <td>&nbsp;</td>
                                                        <td>备注信息：</td>
                                                        <td colspan="3">${findRole.roleRemark}</td>
                                                        <td></td>
                                                        <td>&nbsp;</td>
                                                    </tr>
													<tr>
                                                        <td>&nbsp;</td>
                                                        <td>最后操作时间：</td>
                                                        <td>${findRole.roleUpdateTime}</td>
														<td>操作者：</td>
                                                        <td>${findRole.roleController}</td>
                                                        <td></td>
                                                        <td>&nbsp;</td>
                                                    </tr>
													<tr>
													<td width="2%">&nbsp;</td>
													<td>菜单权限：</td>
													<td colspan="4">
													<table border="0" style="width:100%">
														<tr>
															<td style="width:30%; text-align:left; vertical-align:top">
																<input type="checkbox" checked="checked" readOnly disabled />系统设置<br/>
																&nbsp;&nbsp;&nbsp;<input type="checkbox" checked="checked" readOnly disabled />个人信息<br/>
																&nbsp;&nbsp;&nbsp;<input type="checkbox" checked="checked" readOnly disabled />公告管理<br/>
																&nbsp;&nbsp;&nbsp;<input type="checkbox" checked="checked" readOnly disabled />组织机构<br/>
																&nbsp;&nbsp;&nbsp;<input type="checkbox" checked="checked" readOnly disabled />员工管理<br/>
																&nbsp;&nbsp;&nbsp;<input type="checkbox" checked="checked" readOnly disabled />角色管理<br/>
																&nbsp;&nbsp;&nbsp;<input type="checkbox" checked="checked" readOnly disabled />菜单管理<br/><br/>
															</td>
															<td style="width:35%; text-align:left; vertical-align:top">
																<input type="checkbox" checked="checked" readOnly disabled />销售管理<br/>
																&nbsp;&nbsp;&nbsp;<input type="checkbox" checked="checked" readOnly disabled />销售计划<br/>
																&nbsp;&nbsp;&nbsp;<input type="checkbox" checked="checked" readOnly disabled />销售预测<br/>
																&nbsp;&nbsp;&nbsp;<input type="checkbox" checked="checked" readOnly disabled />销售绩效<br/>
																&nbsp;&nbsp;&nbsp;<input type="checkbox" checked="checked" readOnly disabled />机会管理<br/>
																&nbsp;&nbsp;&nbsp;<input type="checkbox" checked="checked" readOnly disabled />联系人管理<br/><br/>
															</td>
															<td style="width:35%; text-align:left; vertical-align:top">
																<input type="checkbox" checked="checked" readOnly disabled />客户管理<br/>
																&nbsp;&nbsp;&nbsp;<input type="checkbox" checked="checked" readOnly disabled />客户资源管理<br/>
																&nbsp;&nbsp;&nbsp;<input type="checkbox" checked="checked" readOnly disabled />客户发展计划<br/>
																&nbsp;&nbsp;&nbsp;<input type="checkbox" checked="checked" readOnly disabled />客户价值管理<br/>
																&nbsp;&nbsp;&nbsp;<input type="checkbox" checked="checked" readOnly disabled />客户满意度管理<br/><br/>
															</td>
														</tr>
														<tr>
															<td style="width:30%; text-align:left; vertical-align:top">
																<input type="checkbox" checked="checked" readOnly disabled />服务管理<br/>
																&nbsp;&nbsp;&nbsp;<input type="checkbox" checked="checked" readOnly disabled />服务创建<br/>
																&nbsp;&nbsp;&nbsp;<input type="checkbox" checked="checked" readOnly disabled />服务分配<br/>
																&nbsp;&nbsp;&nbsp;<input type="checkbox" checked="checked" readOnly disabled />服务处理<br/>
																&nbsp;&nbsp;&nbsp;<input type="checkbox" checked="checked" readOnly disabled />服务反馈<br/>
																&nbsp;&nbsp;&nbsp;<input type="checkbox" checked="checked" readOnly disabled />服务归档<br/>
																&nbsp;&nbsp;&nbsp;<input type="checkbox" checked="checked" readOnly disabled />常见问题管理<br/><br/>
															</td>
															<td style="width:35%; text-align:left; vertical-align:top">
															
															</td>
															<td style="width:35%; text-align:left; vertical-align:top">
																
															</td>
														</tr>
													</table>
													</td>
													<td width="2%">&nbsp;</td>
												</tr>
                                                </table>
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