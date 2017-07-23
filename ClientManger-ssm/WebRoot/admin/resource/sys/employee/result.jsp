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
                               <h1>员工信息录入成功！</h1>
                            </td>
                        </tr>
						<tr>
							<td>&nbsp;</td>
							<td colspan="2" align="center"></td>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td colspan="4" align="center">
								<a href="findDeptShortName.do?flag=addEmp">继续录入</a>&nbsp;&nbsp;&nbsp;
								<a href="findEmp.do?empId=${findEmp.empId}&flag=updateEmp">返回修改</a>&nbsp;&nbsp;&nbsp;
								<a href="findEmp.do?empId=${findEmp.empId}&flag=shouquan">赋予角色</a>&nbsp;&nbsp;&nbsp;
								<a href="findAllEmp.do">展示列表</a>
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
                                            <form action="" method="">
                                                 <table width="100%"class="cont">
                                                    <tr>
                                                        <td width="2%">&nbsp;</td>
                                                        <td width="8%">员工编码：</td>
                                                        <td width="25%">${findEmp.empId}</td>
														<td width="8%">员工姓名：</td>
                                                        <td width="25%">${findEmp.empName}</td>
                                                        <td></td>
                                                        <td width="2%">&nbsp;</td>
                                                    </tr>
													<tr>
                                                        <td width="2%">&nbsp;</td>
                                                        <td>性&nbsp;&nbsp;&nbsp;&nbsp;别：</td>
                                                        <td>${findEmp.empSex}</td>
														<td>联系方式：</td>
                                                        <td>${findEmp.empPhone}</td>
                                                        <td></td>
                                                        <td width="2%">&nbsp;</td>
                                                    </tr>
													<tr>
                                                        <td width="2%">&nbsp;</td>
                                                        <td>账&nbsp;&nbsp;&nbsp;&nbsp;号：</td>
                                                        <td>${findEmp.empLoginName}</td>
														<td>账号状态：</td>
														<c:if test="${emp.empState==1}"> <td>启用</td></c:if>
                                                      	<c:if test="${emp.empState==0}"> <td>禁用</td></c:if>
                                                        <td></td>
                                                        <td width="2%">&nbsp;</td>
                                                    </tr>
                                                    <tr>
                                                        <td width="2%">&nbsp;</td>
														<td>所属部门：</td>
														<td>${findEmp.empDept}</td>
														<td>角色身份：</td>
                                                        <td>${findEmp.empRole}</td>
                                                        <td></td>
                                                        <td width="2%">&nbsp;</td>
                                                    </tr>
                                                    <tr>
                                                        <td width="2%">&nbsp;</td>
                                                        <td>备注信息：</td>
                                                        <td colspan="3">${findEmp.empRemark}</td>
                                                        <td></td>
                                                        <td width="2%">&nbsp;</td>
                                                    </tr>
													 <tr>
                                                        <td width="2%">&nbsp;</td>
                                                        <td>最后修改时间：</td>
                                                        <td>${findEmp.empUpdateTime}</td>
														<td>操作者：</td>
                                                        <td>${findEmp.empController}</td>
                                                        <td></td>
                                                        <td width="2%">&nbsp;</td>
                                                    </tr>
                                                    <tr style="height:70px">
                                                        <td>&nbsp;</td>
                                                        <td colspan="4" align="center">
															<input class="btn" onclick="location='findAllEmp.do'" type="button" value="返回" />
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