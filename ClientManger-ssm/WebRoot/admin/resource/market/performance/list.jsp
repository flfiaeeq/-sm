<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="zh-CN">
	<head>
	<script type="text/javascript">
	  function allcheck(){
	  
	  var CheckBox=document.getElementsByName("ids");
	   for(i=0;i<CheckBox.length;i++){
                    CheckBox[i].checked=true;
                };
	  
	      
	  }
	 function Nocheck(){
	    var CheckBox=document.getElementsByName("ids");
	   for(i=0;i<CheckBox.length;i++){
                    CheckBox[i].checked=false;
                };
	  
	  }
	
	</script>
	    <base href="<%=basePath%>">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link rel="stylesheet" type="text/css" href="admin/Style/skin.css" />
	</head>
	<body>
	
		<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<!-- 头部开始 -->
			<tr>
				<td width="17" valign="top"
					background="admin/Images/mail_left_bg.gif">
					<img src="admin/Images/left_top_right.gif" width="17" height="29" />
				</td>
				<td valign="top" background="admin/Images/content_bg.gif">
					<table width="100%" height="31" border="0" cellpadding="0"
						cellspacing="0" background="admin/Images/content_bg.gif">
						<tr>
							<td height="31">
								<div class="title">
									销售绩效
								</div>
							</td>
						</tr>
					</table>
				</td>
				<td width="16" valign="top"
					background="admin/Images/mail_right_bg.gif">
					<img src="admin/Images/nav_right_bg.gif" width="16" height="29" />
				</td>
			</tr>
			<!-- 中间部分开始 -->
			<tr>
				<!--第一行左边框-->
				<td valign="middle" background="admin/Images/mail_left_bg.gif">
					&nbsp;
				</td>
				<!--第一行中间内容-->
				<td valign="top" bgcolor="#F7F8F9">
					<table style="width: 100%" width="100%" border="0" align="center"
						cellpadding="0" cellspacing="0">
						<!-- 空白行-->
						<tr>
							<td colspan="2" valign="top">
								&nbsp;
							</td>
							<td>
								&nbsp;
							</td>
							<td valign="top">
								&nbsp;
							</td>
						</tr>
						<tr>
							<td colspan="4">
								
									<div style="float: left">
										<p style="float: left; margin-left: 30px;">
											<label>
												姓名：
											</label>
											<input class="text" style="width: 80px;" />
										</p>
										&nbsp;&nbsp;&nbsp;
										<p style="float: left; margin-left: 30px;">
											<input type="button" class="btn" value="查询" />
										</p>
									</div>
									<div style="float: right">
										<input type="button" onclick='window.location="findAllDept.do?flagd=add"'
											class="btn" value="绩效添加" />
								
								<form action="deleteAllPerformance.do" method="post">
										<input type="submit"  value="批量删除" />

									</div>
								
								<td>
						</tr>
						<!-- 一条线 -->
						<tr>
							<td height="40" colspan="4">
								<table width="100%" height="1" border="0" cellpadding="0"
									cellspacing="0" bgcolor="#CCCCCC">
									<tr>
										<td></td>
									</tr>
								</table>
							</td>
						</tr>
						<!-- 销售绩效开始 -->
						<tr>
							<td width="2%">
								&nbsp;
							</td>
							<td width="96%">
								<table width="100%">
									<tr>
										<td colspan="2">
										
												<table width="100%" class="cont tr_color">
													<tr>
														<th>
															序号
														</th>
														<th>
															选择
														</th>
														<th>
															姓名
														</th>
														<th>
															部门
														</th>
														<th>
															绩效等级
														</th>
														<th>
															最后修改时间
														</th>
														<th>
															操作人
														</th>
														<th>
															操作
														</th>
													</tr>
													  <c:forEach var="aa" items="${showPerfor}">
													<tr align="center" class="d">
														<td>
															1
														</td>
														<td>
															<input type="checkbox" name="ids" value="${aa.perfId}" />
														</td>
														<td>
															${aa.perfEmp}
														</td>
														<td>
															${aa.perfDept}
														</td>
														<td>
															${aa.perfRank}
														</td>
														<td>
															${aa.perfDept}
														</td>
														<td>
															${aa.perfUpdateTime}
														</td>
														<td>
															<a href="findByIdPerformance.do?perfId=${aa.perfId}&&flag=edit">修改</a>&nbsp;&nbsp;
															<a href="deletePerformance.do?perfId=${aa.perfId}">删除</a>&nbsp;&nbsp;
															<a href="findByIdPerformance.do?perfId=${aa.perfId}&&flag=view">查看</a>
														</td>
													</tr>
													</c:forEach>
												</table>
											</form>
										</td>
									</tr>
								</table>
							</td>
							<td width="2%">
								&nbsp;
							</td>
						</tr>
						<!--销售绩效结束 -->
						<tr>
							<td height="40" colspan="4">
								<table width="100%" height="1" border="0" cellpadding="0"
									cellspacing="0" bgcolor="#CCCCCC">
									<tr>
										<td></td>
									</tr>
								</table>
							</td>
						</tr>
						<tr>
							<td width="2%">
								&nbsp;
							</td>
							<td width="51%" class="left_txt">
								<input type="button" value="全选" onclick="allcheck()" />
								&nbsp;&nbsp;&nbsp;
								<input type="button" value="反选" onclick="Nocheck()"/>
								<div style="float: right;">
									<b><a href="findAllPerformance.do?currentPage=1"> 首页</a> &nbsp;&nbsp;&nbsp; <a href="findAllPerformance.do?currentPage=${currentPagew-1}">上一 页</a>&nbsp;&nbsp;&nbsp;

                                        <c:forEach var="i" begin="1" end="${sumpage}">
                                         <c:if test="${i==currentPagew}">
										&lt;&lt;&nbsp;&nbsp;&nbsp; <font style="font-size: 15pt"><a href="findAllPerformance.do?currentPage=${i}">${i}</a></font>&nbsp;&nbsp;&nbsp;
										</c:if>
										 <c:if test="${i!=currentPagew}">
										<a href="findAllPerformance.do?currentPage=${i}">${i}</a>&nbsp;&nbsp;&nbsp;
										</c:if>
										</c:forEach>
										<a href="#">&gt;&gt;</a>
										
										&nbsp;&nbsp;&nbsp; <a href="findAllPerformance.do?currentPage=${currentPagew+1}">下一页</a>&nbsp;&nbsp;&nbsp;
										<a href="findAllPerformance.do?currentPage=${sumpage}">尾页</a>&nbsp;&nbsp;&nbsp; 每页

										显示${pages}条&nbsp;&nbsp;&nbsp; 当前 ${currentPagew}/${sumpage} 页&nbsp;&nbsp;&nbsp; 共${sumcount}条 </b>
								</div>
							</td>
							<td>
								&nbsp;
							</td>
							<td>
								&nbsp;
							</td>
						</tr>
					</table>
				</td>
				<td background="admin/Images/mail_right_bg.gif">
					&nbsp;
				</td>
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