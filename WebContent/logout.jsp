<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	session.removeAttribute("empLoginName");
%>
<script type="text/javascript">
	window.top.location.href = 'login.html';
</script>