<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="pt-br">
<head><link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">   
    <link href="<c:url value="/resources/css/icon.css" />" rel="stylesheet">   
    <link href="<c:url value="/resources/css/materialize.min.css" />" rel="stylesheet">   
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">  
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>.: Historico de Gastos :.</title>
</head>
<body> 
    <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
        <a class="navbar-brand" href="/SistemaFinanceiro">Planilha Pessoal</a>
        <ul class="navbar-nav">
        <li class="nav-item">
            <a class="nav-link" href="/SistemaFinanceiro/historicoGastos">Historico de Gastos</a>
          </li>
        </ul>  
    </nav>

    <div class="main">
        <div class="row">
          <div id="man" class="col s12">
            <div class="card material-table">
              <div class="table-header">
                <span class="table-title">Lista de Clientes</span>
                <div class="actions">
                  <a href="#addClientes" class="modal-trigger waves-effect btn-flat nopadding"><i class="material-icons">person_add</i></a>
                  <a href="#" class="search-toggle waves-effect btn-flat nopadding"><i class="material-icons">search</i></a>
                </div>
              </div>
              <table id="datatable">
                <thead>
                  <tr>
                    <th>Nome da Tabela</th> 
                    <th>Ações</th>
                  </tr>
                </thead>
                <tbody>
                <c:if test="${not empty lista}">
                   <c:forEach var="listValue" items="${lista}">              
                        <td>${listValue}</td>
                        <td>
                        <i class="material-icons">description</i>
                        <i class="material-icons">delete</i></td></td>  
                        </td>
                      </tr>
                   </c:forEach>
                </c:if>
           <!--    <tr>
                    <td>Tiger Nixon</td>
                    <td>System Architect</td>
                    <td>Edinburgh</td>
                    <td>61</td>
                    <td>2011/04/25</td>
                    <td>$320,800</td>
                    <td><i class="material-icons">description</i>
                     <i class="material-icons">delete</i></td></td>                 
                  </tr>
                  <tr>
                    <td>Garrett Winters</td>
                    <td>Accountant</td>
                    <td>Tokyo</td>
                    <td>63</td>
                    <td>2011/07/25</td>
                    <td>$170,750</td>
                  </tr>
                -->
                </tbody>
              </table>
            </div>
          </div>
        </div>
      </div>
</body>
<script src="<c:url value="/resources/js/jquery.min.js" />"></script> 
<script src="<c:url value="/resources/js/jquery.dataTables.min.js" />"></script> 
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script> 
<script src="<c:url value="/resources/js/bootstrap.min.js.map.js" />"></script> 
<script src="<c:url value="/resources/js/modalScript.js" />"></script> 
<script src="<c:url value="/resources/js/tabelaPaginacao.js" />"></script> 

</html>