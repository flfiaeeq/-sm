<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="zh-CN">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="stylesheet" type="text/css" href="./Style/skin.css" />
    <style type="text/css">
        table{
            height: 80px;
            background-size: contain;
        }
        .img-td a img{
            height: 80px;
        }

    </style>
    <script type="text/javascript">
        function logout() {
            if(window.confirm('您确定要退出吗？')) {
                top.location = 'Login.jsp';
            }
        }       
    </script>
</head>
    <body>
        <table cellpadding="0" width="100%" height="64" background="./Images/top_top_bg.gif">
            <tr valign="top">
              <c:if test="${empty userinfo}">
                <td class="img-td" width="50%"><a href="javascript:void(0)"><img style="border:none" src="./Images/logo.png" /></a></td>
                <td width="30%" style="padding-top:13px;font:15px Arial,SimSun,sans-serif;color:#FFF"><a href="resource/sys/myinfo/view.html" style="color:red;" target="main">您没有登录重新登录！</td>
                <td style="padding-top:10px;" align="right"><img style="border:none" src="./Images/index.gif" onclick="javascript:top.location='index.html'" /></td>
                <td style="padding-top:10px;" align="center"><img style="border:none" src="./Images/out.gif" onclick="logout();" /></td>
            </c:if>
             <c:if test="${!empty userinfo}">
            <td class="img-td" width="50%"><a href="javascript:void(0)"><img style="border:none" src="./Images/logo.png" /></a></td>
                <td width="30%" style="padding-top:13px;font:15px Arial,SimSun,sans-serif;color:#FFF">您好，管理员：<a href="resource/sys/myinfo/view.html" style="color:red;" target="main">${userinfo.empName}</a>&nbsp;先生，欢迎登陆使用！</td>
                <td style="padding-top:10px;" align="right"><img style="border:none" src="./Images/index.gif" onclick="javascript:top.location='index.html'" /></td>
                <td style="padding-top:10px;" align="center"><img style="border:none" src="./Images/out.gif" onclick="logout();" /></td>
              </c:if>
                
            </tr>
        </table>
    </body>
</html>