<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%--
  <c:set> 태그
  1. JSP Data Binding 영역 4개에 데이터를 저장하는 태그이다.
  2. 형식
    <c:set var="속성명" value="값" scope="영역"></c:set>
    <c:set var="속성명" value="값" scope="영역"/>
  3. scope 속성을 생략하면 page 범위가 사용된다.
--%>

<c:set var="a" value="1" scope="page" />
<c:set var="b" value="2" scope="request" />
<c:set var="c" value="3" scope="session" />
<c:set var="d" value="4" scope="application" />
<div>${a}, ${pageScope.a}</div>
<div>${b}, ${requestScope.b}</div>
<div>${c}, ${sessionScope.c}</div>
<div>${d}, ${applicationScope.d}</div>

<c:set var="contextPath" value="<%=request.getContextPath()%>" />
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<div>${contextPath}</div>

</body>
</html>