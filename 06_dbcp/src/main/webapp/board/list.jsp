<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="contextPath" value="<%=request.getContextPath()%>" />
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
</head>
<body>

  <div>총 ${total}개</div>

  <div>
    <a href="${contextPath}/list.do?page=1&sort=DESC&display=${display}">내림차순</a>
    <span> | </span>
    <a href="${contextPath}/list.do?page=1&sort=ASC&display=${display}">오름차순</a>
  </div>
  
  <div>
    <select id="display">
      <option>20</option>
      <option>50</option>
      <option>100</option>      
    </select>
  </div>
  <script>
    const display = document.getElementById('display');
    display.value = ${display};
    display.addEventListener('change', evt=>{
      location.href = '${contextPath}/list.do?page=1&sort=${sort}&display=' + display.value;
    })
  </script>

  <table border="1">
    <thead>
      <tr>
        <td></td>
        <td>게시글번호</td>
        <td>제목</td>
        <td>작성일자</td>
      </tr>
    </thead>
    <tbody>
      <c:forEach items="${boardList}" var="board">
        <tr>
          <td><input type="checkbox" class="each-chk"></td>
          <td>${board.board_no}</td>
          <td>${board.title}</td>
          <td>${board.create_dt}</td>
        </tr>
      </c:forEach>
    </tbody>
    <tfoot>
      <tr>
        <td colspan="4"></td>
      </tr>
    </tfoot>
  </table>

</body>
</html>