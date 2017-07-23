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
    
    <title>My JSP 'edit.jsp' starting page</title>
    
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
                    <table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" background="admin/Images/content_bg.gif">
                        <tr><td height="31"><div class="title">角色修改</div></td></tr>
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
                        <!-- 角色修改开始 -->
                        <tr>
                            <td width="2%">&nbsp;</td>
                            <td width="96%">
                                <table width="100%">
                                    <tr>
                                        <td colspan="2">
                                            <form action="upateClient.do?clientId=${c.clientId}" method="post">
                                                <table width="100%"class="cont">
                                                    <tr>
                                                        <td width="2%">&nbsp;</td>
                                                        <td width="10%">角色编码：</td>
                                                        <td width="25%"><input name="clientId" class="text" type="text" name="role_code" value="${c.clientId}" disabled readonly placeholder="增加时自动生成，不可更改" /></td>
                                                        <td></td>
                                                        <td width="2%">&nbsp;</td>
                                                    </tr>
                                                    <tr>
                                                        <td width="2%">&nbsp;</td>
                                                        <td width="10%">客户姓名：</td>
                                                        <td width="25%"><input name="clientName" class="text" value="${c.clientName}" placeholder="限长，非空必填" /></td>
                                                        <td></td>
                                                        <td width="2%">&nbsp;</td>
                                                    </tr>
                                                    <tr>
                                                        <td width="2%">&nbsp;</td>
                                                        <td>客户性别：</td>
                                                        <td>
 


                                                        
                                                        <c:if test="${c.clientSex eq '男'}">
                                                        <input type="radio" name="clientSex" value="male" checked="checked"/>男&nbsp;&nbsp;
 														 <input type="radio" name="clientSex" value="female" />女
                                                        </c:if>
                                                       
                                                        <c:if test="${c.clientSex eq '女'}">
                                                       <input type="radio" name="clientSex" value="female" checked="checked" />女
                                                        <input type="radio" name="clientSex" value="male"/>男&nbsp;&nbsp;
                                                	  	</c:if>
                                                	  	
<!--                                                        	<input type="radio" name="gender" value="male"/>男&nbsp;&nbsp;-->
<!--															<input type="radio" name="gender" value="female" checked="checked" />女-->
                                                        </td>
                                                        <td></td>
                                                        <td width="2%">&nbsp;</td>
                                                    </tr>
													<tr>
                                                        <td width="2%">&nbsp;</td>
                                                        <td>客户生日：</td>
                                                        <td><input name="clientBirth" class="text"  value="${c.clientBirth}"  placeholder="my97插件" /></td>
                                                        <td></td>
                                                        <td width="2%">&nbsp;</td>
                                                    </tr>
                                                    <tr>
                                                        <td width="2%">&nbsp;</td>
                                                        <td>客户类型：</td>
                                                        <td >
                                                        
                                                        	<select name="clientType">
                                                        	<option value="${c.clientType}" selected="selected">${c.clientType}</option>
                                                        		<c:forEach items="${ty}" var="t">
<!--                                                        		<c:if test="${t.clientType}==${c.clientType} ">-->
<!--                                                        		<option value="${c.clientType}" selected="selected">${c.clientType}</option>-->
<!--                                                        		</c:if>-->
                                                        		 
                                                        		 <option>${t.clientType}</option>
 											        		</c:forEach>
                                                            	 
                                                            
                                                            </select>
                                                        </td>
                                                        <td></td>
                                                        <td width="2%">&nbsp;</td>
                                                    </tr>
													<tr>
                                                        <td width="2%">&nbsp;</td>
                                                        <td>客户状态：</td>
                                                        <td >
                                                        	<select name="clientState">
                                                        		<c:if test="${t.clientState} eq 0">
                                                            	<option value="0" selected="selected">启用</option>
                                                            	</c:if>
                                                            	<option value="1">禁用</option>
                                                            	<c:if test="${t.clientState} eq 1">
                                                                <option value="1" selected="selected">禁用</option>
                                                                </c:if>
                                                                <option value="0" selected="selected">启用</option>
                                                            </select>
                                                        </td>
                                                        <td></td>
                                                        <td width="2%">&nbsp;</td>
                                                    </tr>
													<tr>
                                                        <td width="2%">&nbsp;</td>
                                                        <td>手机：</td>
                                                        <td><input name="clientTel" class="text" value="${c.clientTel}" placeholder="正则验证，唯一不重复" /></td>
                                                        <td></td>
                                                        <td width="2%">&nbsp;</td>
                                                    </tr>
													<tr>
                                                        <td width="2%">&nbsp;</td>
                                                        <td>办公电话：</td>
                                                        <td><input name="clientOffice" class="text" value="010-32456789" placeholder="正则验证" /></td>
                                                        <td></td>
                                                        <td width="2%">&nbsp;</td>
                                                    </tr>
													<tr>
                                                        <td width="2%">&nbsp;</td>
                                                        <td>电子邮箱：</td>
                                                        <td><input name="clientEmail" class="text" value="jinlingling@qq.com" placeholder="正则验证，唯一不重复" /></td>
                                                        <td></td>
                                                        <td width="2%">&nbsp;</td>
                                                    </tr>
													<tr>
                                                        <td width="2%">&nbsp;</td>
                                                        <td>家庭电话：</td>
                                                        <td><input name="clientHome" class="text" value="0722-23453421" placeholder="正则验证" /></td>
                                                        <td></td>
                                                        <td width="2%">&nbsp;</td>
                                                    </tr>
													<tr>
                                                        <td>&nbsp;</td>
                                                        <td>联系地址：</td>
                                                        <td><textarea name="clientAddress" placeholder="限长，如不填，数据库中默认值为暂无">北京市海淀区软件园XX楼</textarea></td>
                                                        <td></td>
                                                        <td>&nbsp;</td>
                                                    </tr>
													<tr>
                                                        <td>&nbsp;</td>
                                                        <td>备注信息：</td>
                                                        <td><textarea name="clientRemark" placeholder="限长，如不填，数据库中默认值为暂无">暂无</textarea></td>
                                                        <td></td>
                                                        <td>&nbsp;</td>
                                                    </tr>
                                                    <tr>
                                                        <td>&nbsp;</td>
                                                        <td colspan="2" align="center">
                                                        	<input type="submit" value="提交">
<!--                                                            <input class="btn" onclick="location='result.html'" type="button" value="提交" />&nbsp;&nbsp;&nbsp;-->
                                                            <a href="findAllClient.do?type"><input class="btn" onclick="location='list.html'" type="button" value="返回" /></a>
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
                        <!-- 角色修改结束 -->
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
