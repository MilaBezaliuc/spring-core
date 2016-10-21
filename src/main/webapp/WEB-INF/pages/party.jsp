<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Party!</title>
    <style type="text/css">
        <%@include file="../resources/style.css" %>
    </style>
</head>

<body>
<h1>Party Time!</h1>
<br>
<hr color="maroon">
<br>

<h3><a href="#openModal">Add new Dance</a></h3>
<br>

<!--MAIN-->

<c:if test="${!empty listOfDances}">
    <table>
        <tr>
            <th width="20"></th>
            <th width="190">Dance style</th>
            <th width="80">Man</th>
            <th width="80">Woman</th>
                <%--<th width="60">Edit</th>--%>
                <%--<th width="60">Delete</th>--%>
        </tr>
        <c:forEach items="${listOfDances}" var="item" varStatus="status">
            <tr>
                <td>${status.index+1}</td>
                <td>${item.style}</td>
                <td>${item.man.name}</td>
                <td>${item.woman.name}</td>
                    <%--<td><a href="<c:url value='/edit/${item.id}#openModal'/>" title="Edit">Edit</a></td>--%>
                    <%--<td><a href="<c:url value='/delete/${item.id}'/>">Delete</a></td>--%>
            </tr>
        </c:forEach>
    </table>
</c:if>

<%--<c:if test="${!empty listOfDances}">--%>
<%--<table>--%>
<%--<c:forEach items="${listOfWomen}" var="v" varStatus="status">--%>
<%--<tr><td>${v.name}</td></tr>--%>
<%--&lt;%&ndash;<option value="${v.name}">${v.name}</option>&ndash;%&gt;--%>
<%--</c:forEach>--%>
<%--</table>--%>
<%--</c:if>--%>
<div id="openModal" class="modalDialog">
    <div align="center">
        <a href="#" title="Close" class="close">X</a>

        <h2>Add new Dance</h2>
        <c:url var="addAction" value="/party/add"/>
        <form:form action="${addAction}">
            <table style="text-align: left">
                <tr bgcolor="white">
                    <td>Add new dance</td>
                        <%--<td><form:input path="style"/></td>--%>
                </tr>
                <tr bgcolor="white">
                    <td>
                        <select name="types">
                            <option value="Select woman">Select woman</option>
                            <c:forEach items="${listOfWomen}" var="v">
                                <option value="${v.name}">${v.name}</option>
                            </c:forEach>
                        </select>
                        <select name="types">
                            <option value="Select man">Select man</option>
                            <c:forEach items="${listOfMen}" var="m">
                                <option value="${m.name}">${m.name}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr bgcolor="white">
                    <td colspan="2">
                        <input type="submit"
                               value="<spring:message text="Add dance"/>"/>
                    </td>
                </tr>

            </table>
        </form:form>
    </div>
</div>

<div style="width: 100%; height: 30px; background-color: maroon; text-align:center">
    <span style="line-height: 30px"><p style="color: #eeeeee; font-size: small">PartyTime &copy; Mila Bezaliuc
        2016.</p></span>
</div>
</body>
</html>