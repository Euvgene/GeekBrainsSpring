<%@ page import="com.evgenii.jee.Product" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
    <title>Product</title>
</head>
<body>

<h3>Product info</h3>
<table border="1" width="500" align="center">
    <tr bgcolor="#ff8c00">
        <th><b>Product ID</b></th>
        <th><b>Product Title</b></th>
        <th><b>Product Cost</b></th>
    </tr>
    <%
        ArrayList<Product> product =
                (ArrayList<Product>) request.getAttribute("product");
        for (Product p : product) {%>
    <tr>
        <td><%=p.getId()%>
        </td>
        <td><%=p.getTitle()%>
        </td>
        <td><%=p.getCost() + " р."%>
        </td>
    </tr>
    <%}%>
</table>
<hr/>
</body>
</html>

