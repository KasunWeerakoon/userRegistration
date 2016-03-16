<%@ page import="java.util.ResourceBundle" %>
<%--
  Created by IntelliJ IDEA.
  User: kasunb
  Date: 3/8/2016
  Time: 9:30 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<html>
<head>
    <title></title>

</head>
<body>
<%--<%--%>
    <%--ResourceBundle interlizeMsg=(ResourceBundle)request.getAttribute("interlizeMsg");--%>
    <%--pageContext.setAttribute("interlizeMsg",interlizeMsg);--%>
<%--%>--%>
    <P>${name} : ${JSONObj.get("name")}</P>
    <P>${age} : ${JSONObj.get("age")}</P>
    <P>${addr} : ${JSONObj.get("addr")}</P>
    <P>${email} : ${JSONObj.get("email")}</P>
    <P>${tpNo} : ${JSONObj.get("tpNo")}</P>
    <P>${NIC} : ${JSONObj.get("NIC")}</P>

</body>
</html>
