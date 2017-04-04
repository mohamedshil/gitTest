<%-- 
    Document   : view
    Created on : 27-02-2017, 19:47:48
    Author     : auron
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.Mapper.OrdersMapper"%>
<%@page import="com.Entity.Orders"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>view of OrderMaps </title>


    </head>
    <body>
        <% OrdersMapper AllOrder = new OrdersMapper(); %>


        <%
            ArrayList<Orders> viewtOrder = AllOrder.getAllOrder();
            for (Orders order : viewtOrder) {
                out.print("<div>");
                out.print("<h2>" + order.getOno() + "</h2>");
                out.print("<h2>" + order.getEid() + "</h2>");
                out.print("<h2>" + order.getCid() + "</h2>");
                out.print("<h2>" + order.getWname() + "</h2>");
                out.print("<h2>" + order.getSname() + "</h2>");
                out.print("<h2>" + order.getRname() + "</h2>");

                out.print("</div>");
            }
        %>

    </body>
</html>
