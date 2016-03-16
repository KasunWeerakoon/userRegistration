<%@ page import="java.nio.file.Path" %>
<%@ page import="java.nio.file.Paths" %>
<%@ page import="java.nio.charset.Charset" %>
<%@ page import="java.util.List" %>
<%@ page import="java.nio.file.Files" %>

<%--
  Created by IntelliJ IDEA.
  User: kasunb
  Date: 3/4/2016
  Time: 2:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.io.BufferedWriter" %>
<%@ page import="java.util.Enumeration" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Arrays" %>
<%--<jsp:include page="/User.UserList"/>--%>
<html>
<head>
    <title></title>

</head>
<body>
<%--<%--%>
<%--String message=(String)request.getAttribute("message");--%>
<%--pageContext.setAttribute("msg",message);--%>
<%

    //pw.println("Hello user");
//
//      Iterator it = UserServlet.dataTable.entrySet().iterator();
//        while(it.hasNext()){
////          Integer.getInteger(it.next().toString())
//            String s = datalist.get(1);
//            for (String s1 : Arrays.asList(s.split(","))) {
//                pw.println(s1);
//                System.out.println(s1);
//                bw.newLine();
//            }
//            ;
//        }
//      Enumeration<String> keys = UserServlet.dataTable.keys();
//      while (keys.hasMoreElements()){
//        String key=keys.nextElement();

//      }

%>
<ul>
    <c:forEach items="${dataList}" var="d" varStatus="i">
        <li>
            <c:out value="${nameList.get(i.index)}"></c:out>
            <form name="frm" method="get" action="userDetails">
                <input type="hidden" value="${dataList.get(i.index)}" name="hdnbt"/>
                <input class="submit" type="submit" name="bt" value="Details"/>
            </form>
        </li>
    </c:forEach>
</ul>

<%--<p>1${message}</p>--%>
<%--<p>2<%= request.getAttribute("message")%></p>--%>
<%--%>--%>
<%--<%=message%>--%>

<%--<p>${data}</p>--%>
<%--<p>Hello, <c:out value="${data}"></c:out></p>--%>
<%--<p>2,${data}</p>--%>

<%--Servlet communicated message to JSP: ${message}--%>
<%--<p> message <c:out value="${message}"></c:out> </p>--%>
<%--Servlet communicated message to JSP: <%=msg%>--%>
</body>
</html>
