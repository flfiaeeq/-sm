<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 

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
                        <tr><td height="31"><div class="title">菜单管理</div></td></tr>
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
                    <table style="width:100%" width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
                        <!-- 空白行-->
                        <tr><td colspan="2" valign="top">&nbsp;</td><td>&nbsp;</td><td valign="top">&nbsp;</td></tr>
						<tr>
							<td colspan="4">
								<form class="clearfix">
									<div style="float:left">
										<p style="float:left; margin-left:30px;"><label>菜单名称：</label><input class="text" list="rolelist" style="width:80px;"/></p>&nbsp;&nbsp;&nbsp;
										<p style="float:left; margin-left:30px;"><label>上级菜单：</label>
											<select>
												<option value="0">不限</option>
												<option>顶级菜单</option>
												<option>系统设置</option>
												<option>销售管理</option>
												<option>客户管理</option>
												<option>服务管理</option>
												<option>订单管理</option>
												<option>合同管理</option>
											</select>
										</p>&nbsp;&nbsp;&nbsp;
										<p style="float:left; margin-left:30px;"><input type="button" class="btn" value="查询"/></p>
									</div>
									<div style="float:right">
										<input type="button" onclick='window.location="findMenuFather.do"' class="btn" value="菜单添加"/> 
										<input type="button" class="btn" value="批量删除"/>	
									</div>
								</form>
								<datalist id="rolelist">
									<option>系统设置</option>
									<option>销售管理</option>
									<option>客户管理</option>
									<option>服务管理</option>
									<option>订单管理</option>
									<option>合同管理</option>
									<option>个人信息</option>
									<option>公告管理</option>
								</datalist>
							<td>
						</tr>
                        <!-- 一条线 -->
                        <tr>
                            <td height="40" colspan="4">
                                <table width="100%" height="1" border="0" cellpadding="0" cellspacing="0" bgcolor="#CCCCCC">
                                    <tr><td></td></tr>
                                </table>
                            </td>
                        </tr>
                        <!-- 列表展示开始 -->
                        <tr>
                            <td width="2%">&nbsp;</td>
                            <td width="96%">
                                <table width="100%">
                                    <tr>
                                        <td colspan="2">
                                            <form action="" method="">
                                                <table width="100%"  class="cont tr_color">
                                                    <tr>
                                                        <th>序号</th>
                                                        <th>选择</th>
                                                        <th>菜单名称</th>
                                                        <th>父级菜单</th>
														<th>子菜单数量</th>
                                                        <th>菜单资源路径</th>
                                                        <th>当前状态</th>
                                                        <th>操作</th>
                                                    </tr>
                                                
                                           	<c:forEach var="aa" items="${findAllMenu}">
										       <tr align="center" class="d">
                                                   		<td>1</td>
                                                        <td><input type="checkbox" value="" /></td>
                                                        <td><a href="findMenu.do?menuId=${aa.menuId}">${aa.menuName}</a></td>
														<td>${aa.menuFather}</td>
														<c:forEach var="i" items="${findFuZi}">
															<c:if test="${aa.menuFather eq i.menuFather}"><td>${aa.menuState}/${fn:length(i.menuNames)}</td></c:if>																			
														</c:forEach>
                                                        <td>${aa.menuUrl}</td>
                                                       <c:if test="${aa.menuState==1}"> <td>启用</td></c:if>
                                                       <c:if test="${aa.menuState==0}"> <td>禁用</td></c:if>
                                                        <td>
															<a href="updateMenu.do?menuId=${aa.menuId}&menuState=0">禁用</a>&nbsp;&nbsp;
															<a href="updateMenu.do?menuId=${aa.menuId}&menuState=1">启用</a>&nbsp;&nbsp;
                                                        	<a href="findMenu.do?menuId=${aa.menuId}&flag=updateMenu">修改</a>&nbsp;&nbsp;
                                                            <a href="deleteMenu.do?menuId=${aa.menuId}">删除</a>
														</td>
                                                    </tr>
										  		 </c:forEach>
										  		 
                                             </table>
                                            </form>
                                        </td>
                                    </tr>
                                </table>
                            </td>
                            <td width="2%">&nbsp;</td>
                        </tr>
                        <!--列表展示结束 -->
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
                           		<input type="button" value="全选" />&nbsp;&nbsp;&nbsp;
                                <input type="button" value="反选" />
                            	<div style="float:right;">
									<b>
									首页&nbsp;&nbsp;&nbsp;
									上一页&nbsp;&nbsp;&nbsp;
									&lt;&lt;&nbsp;&nbsp;&nbsp;
									<font style="font-size:15pt">1</font>&nbsp;&nbsp;&nbsp;
									<a href="#">2</a>&nbsp;&nbsp;&nbsp;
									<a href="#">3</a>&nbsp;&nbsp;&nbsp;
									<a href="#">4</a>&nbsp;&nbsp;&nbsp;
									<a href="#">5</a>&nbsp;&nbsp;&nbsp;
									<a href="#">6</a>&nbsp;&nbsp;&nbsp;
									<a href="#">7</a>&nbsp;&nbsp;&nbsp;
									<a href="#">&gt;&gt;</a>&nbsp;&nbsp;&nbsp;
									<a href="#">下一页</a>&nbsp;&nbsp;&nbsp;
									<a href="#">尾页</a>&nbsp;&nbsp;&nbsp;
									每页显示10条&nbsp;&nbsp;&nbsp;
									当前 4/23 页&nbsp;&nbsp;&nbsp;
									共225条
									</b>
								</div>
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