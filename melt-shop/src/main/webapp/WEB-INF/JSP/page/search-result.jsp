<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="alert alert-info">
	<p>found <strong>${productCount}</strong> products</p>
</div>
<jsp:include page="products.jsp" />