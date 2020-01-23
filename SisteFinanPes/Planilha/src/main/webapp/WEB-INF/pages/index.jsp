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
 
<button class="trigger">Inserir Gasto</button>

<div class="box">
    <h2> Lista Custumizavel</h2> 
    <ul>
        <c:forEach var="listValue" items="${lista}">
            <li><span>99</span>${listValue}</li>
        </c:forEach>  
     <!--   <li><span>1</span> Item</li>
        <li><span>2</span> Item</li>
        <li><span>3</span> Item</li>
        <li><span>4</span> Item</li>
        <li><span>5</span> Item</li> -->
     </ul>
 </div>

<div class="modal">
    <div class="modal-content">
        <span class="close-button">×</span>
        <h3>Menu em Construção para Inserção de Gastos</h3>
        
        <div class="form__group field">
            <input type="input" class="form__field" placeholder="Name" name="name" id='name' required />
            <label for="name" class="form__label">Name</label>
        </div>
        <br>
        <div class="custom-select" style="width:200px;">
           <form:select path="country" >
           <form:option value="NONE" label="Selecione um Valor da Base"/>
           <form:options items="${countryList}" />
        </form:select>

         
        </div>
    </div>
</div>


</body>
<script src="<c:url value="/resources/js/modalScript.js" />"></script> 
</html>