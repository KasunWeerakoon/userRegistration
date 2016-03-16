<%@ page import="java.util.ResourceBundle" %>
<%--
  Created by IntelliJ IDEA.
  User: kasunb
  Date: 3/4/2016
  Time: 10:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
<H2 func="" ></H2>
<%--<script>--%>
      <%--function callMe(){--%>
      <%--$.ajax({--%>
      <%--type: "GET",--%>
      <%--url: "/servlet",--%>
      <%--data: { methodToInvoke: "sayHello" , data: "Abc" }--%>
      <%--}).done(function( msg ) {--%>
      <%--alert( "Data Saved: " + msg );--%>
      <%--});--%>
      <%--}--%>
<%--</script>--%>
<form action="/" method="get">
    <input name="language" type="hidden" value="${cookieValue}"  >
    <P>Change the Language to </P> <input type="submit" value="${cookieValue}">
</form>
<%--<%--%>
    <%--ResourceBundle msg=(ResourceBundle)session.getAttribute("interlizeMsg");--%>
    <%--request.setAttribute("msg",msg);--%>
    <%--System.out.println(msg.getString("line1"));--%>
<%--%>--%>
<br>
<a href="/user">${line1}</a><br>
<a href="/userList">${line2}</a>
</body>
</html>
