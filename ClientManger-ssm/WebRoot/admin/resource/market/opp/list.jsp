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
                        <tr><td height="31"><div class="title">机会列表</div></td></tr>
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
										<p style="float:left; margin-left:30px;"><label>员工姓名：</label><input class="text" style="width:80px;"/></p>&nbsp;&nbsp;&nbsp;
										<p style="float:left; margin-left:30px;"><input type="button" class="btn" value="查询"/></p>
									</div>
									<div style="float:right">
										<input type="button" onclick='window.location="admin/resource/market/opp/add.jsp"' class="btn" value="机会录入"/> 
										<input type="button" class="btn" value="批量删除"/>										
									
									</div>
								</form>
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
                        <!-- 机会列表开始 -->
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
                                                        <th>机会名称</th>
                                                        <th>机会类型</th>
                                                        <th>录入时间</th>
                                                        <th>录入人</th>
                                                        <th>操作</th>
                                                    </tr>
                                                    <c:set var="i" value="0">
													 </c:set>
                                                    <c:forEach var="aa" items="${showChance}">
                                              
  
                                                    <c:set var="i" value="${i+1}">
                                                       </c:set>
                                                    <tr align="center" class="d">
                                                   		<td>${i}</td>
                                                        <td><input type="checkbox" value="" /></td>
                                                        <td><a href="findByIdChance.do?flagC=view&&ChanceId=${aa.chanceId}">${aa.chanceName}</a></td>
                                                        <td>${aa.chanceType}</td>
                                                        <td>${aa.chanceCreateTime}</td>
                                                        <td>${aa.chanceCreater}</td>
                                                        <td>
                                                          <c:if test="${userinfo.empRole eq '销售经理'}">  
                                                              <c:if test="${empty aa.chanceEmp}">
															<a href="findByIdChance.do?flagC=assign&&ChanceId=${aa.chanceId}">分配</a>&nbsp;&nbsp;
															</c:if>
															 <c:if test="${!empty aa.chanceEmp}">
															<a href="findByIdChance.do?flagC=assign&&ChanceId=${aa.chanceId}">再分配</a>&nbsp;&nbsp;
															</c:if>
															</c:if>
                                                        	<a href="findByIdChance.do?flagC=edit&&ChanceId=${aa.chanceId}">修改</a>
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
                        <!--机会列表结束 -->
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
									<b><a href="findAllChance.do?currentPage=1"> 首页</a> &nbsp;&nbsp;&nbsp; <a href="findAllChance.do?currentPage=${currentPagew-1}">上一 页</a>&nbsp;&nbsp;&nbsp;

                                        <c:forEach var="i" begin="1" end="${sumpage}">
                                         <c:if test="${i==currentPagew}">
										&lt;&lt;&nbsp;&nbsp;&nbsp; <font style="font-size: 15pt"><a href="findAllChance.do?currentPage=${i}">${i}</a></font>&nbsp;&nbsp;&nbsp;
										</c:if>
										 <c:if test="${i!=currentPagew}">
										<a href="findAllChance.do?currentPage=${i}">${i}</a>&nbsp;&nbsp;&nbsp;
										</c:if>
										</c:forEach>
										<a href="#">&gt;&gt;</a>
										
										&nbsp;&nbsp;&nbsp; <a href="findAllChance.do?currentPage=${currentPagew+1}">下一页</a>&nbsp;&nbsp;&nbsp;
										<a href="findAllChance.do?currentPage=${sumpage}">尾页</a>&nbsp;&nbsp;&nbsp; 每页

										显示${pages}条&nbsp;&nbsp;&nbsp; 当前 ${currentPagew}/${sumpage} 页&nbsp;&nbsp;&nbsp; 共${sumcount}条 </b>
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