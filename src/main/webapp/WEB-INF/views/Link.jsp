<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf8">
    <title><spring:message code="label.title" /></title>
</head>
<body>

<a href="<c:url value="/logout" />">
    <spring:message code="label.logout" />
</a>

<h2><spring:message code="label.title" /></h2>

<form:form method="post" action="add" commandName="link">

    <table>
        <tr>
            <td><form:label path="author">
                <spring:message code="label.author" />
            </form:label></td>
            <td><form:input path="author" /></td>
        </tr>
        <tr>
            <td><form:label path="longlink">
                <spring:message code="label.longlink" />
            </form:label></td>
            <td><form:input path="longlink" /></td>
        </tr>
        <tr>
            <td><form:label path="shortlink">
                <spring:message code="label.shortlink" />
            </form:label></td>
            <td><form:input path="shortlink" /></td>
        </tr>
        <tr>
            <td><form:label path="count">
                <spring:message code="label.count" />
            </form:label></td>
            <td><form:input path="count" /></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit"
                                   value="<spring:message code="label.addlink"/>" /></td>
        </tr>
    </table>
</form:form>

<h3><spring:message code="label.links" /></h3>
<c:if test="${!empty linkList}">
    <table class="data">
        <tr>
            <th><spring:message code="label.author" /></th>
            <th><spring:message code="label.shortlink" /></th>
            <th><spring:message code="label.count" /></th>
            <th>&nbsp;</th>
        </tr>
        <c:forEach items="${linkList}" var="link">
            <tr>
                <td>${link.author}, ${link.longlink}</td>
                <td>${link.shortlink}</td>
                <td>${link.count}</td>
                <td><a href="delete/${link.id}"><spring:message code="label.delete" /></a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

</body>
</html>