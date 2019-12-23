<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>.: Pagina Inicial :.</title>
</head>

<h3>Status da Conexão do Banco: ${db}</h3>

<h4>Lista de Tabelas Disponiveis</h4>
<c:if test="${not empty lista}">
    <ul>
        <c:forEach var="listValue" items="${lista}">
            <li>${listValue}</li>
        </c:forEach>
    </ul>
</c:if>

</body>
</html>