<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${param.action }" name="pageRollForm" method="post">
		当前是第${requestScope.pageRoll.currPage }页|
		共${requestScope.pageRoll.pageCount }页|
		共${requestScope.pageRoll.tatalCount }条记录|
		<input type="hidden" name="currPage" value="${requestScope.pageRoll.currPage }"/>
		<input type="hidden" name="pageCount" value="${requestScope.pageRoll.pageCount}"/>
		<input type="button" value="首页" onclick="fistPage()"/>
		<input type="button" value="上一页" onclick="prevPage()"/>
		<input type="button" value="下一页" onclick="nextPage()"/>
		<input type="button" value="尾页" onclick="listPage()"/>
		<select name="goto_page" onchange="gotoPage">
			<c:forEach begin="1" end="${requestScope.pageRoll.pageCount }" var="i">
				<c:choose>
					<c:when test="${requestScope.pageRoll.currPage==i }">
						<option value="${i }" selected="selected">${i }</option>
					</c:when>
					<c:otherwise>
						<option value="${i }">${i }</option>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</select>
	</form>
	<script type="text/javascript">
		function fistPage(){
			var _currPage = document.pageRollForm.currPage.value;
			if(_currPage==1){
				alert("已经是第一页了")
				return;
			}
			document.pageRollForm.currPage.value = 1;
			document.pageRollForm.submit();
		}
		
		function prevPage(){
			var _currPage = document.pageRollForm.currPage.value;
			if(_currPage==1){
				return;
			}
			document.pageRollForm.currPage.value = --_currPage;
			document.pageRollForm.submit();
		}
		function nextPage(){
			
			var _currPage = document.pageRollForm.currPage.value;
			var _pageCount = document.pageRollForm.pageCount.value;
			if(_currPage==_pageCount){
				alert("已经是最后一页");
				return;
			}
			document.pageRollForm.currPage.value = ++_currPage;
			document.pageRollForm.submit();
		}
		function listPage(){
			var _currPage = document.pageRollForm.currPage.value;
			var _pageCount = document.pageRollForm.pageCount.value;
			if(_currPage==_pageCount){
				return;
			}
			document.pageRollForm.currPage.value=_pageCount;
			document.pageRollForm.submit();
		}
		function gotoPage(){
			var selectValue=document.pageRollForm.goto_page.value;
			document.pageRollForm.currPage.value=selectValue;
			document.pageRollForm.submit();
		}
	</script>
</body>
</html>