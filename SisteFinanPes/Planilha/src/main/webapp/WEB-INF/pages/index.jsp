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
<div class="custom-select" style="width:200px;">
<form:select path="country" >
   <form:option value="NONE" label="Selecione um Valor da Base"/>
   <form:options items="${countryList}" />
</form:select>
</div>

<button class="trigger">Inserir Gasto</button>
<div class="modal">
    <div class="modal-content">
        <span class="close-button">×</span>
        <h3>Menu em Construção para Inserção de Gastos</h3>
    </div>
</div>


</body>
<script src="<c:url value="/resources/js/modalScript.js" />"></script> 
</html>