<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>  
<html>  
<head>  
<meta charset="utf-8">  
<title>上传结果</title>  
</head>  
<body>  
<img alt="" src="${fileUrl }" />  
</body>  
</html>  