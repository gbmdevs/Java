<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">   
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

<h4>Combo box vindo do Banco de Dados</h4><br>
<span class="dropdown-box">
<form:select path="country" class="dropbox-estilo" disabled>
   <form:option value="NONE" label="Selecione um Valor da Base"/>
   <form:options items="${countryList}" />
</form:select>
</span>

</body>
</html>