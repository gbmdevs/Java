<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <title>.: Estudo de Angular JS :.</title>
    <!--Inclusao das Libs em JavaScript-->
    <spring:url value="/resources/js/angular.min-1.7.8.js" var="angularJS" /> 
    <spring:url value="/resources/js/mainJS.js" var="mainJS" /> 
    
    <script src="${angularJS}"></script>
    <script src="${mainJS}"></script>
</head>
<body ng-app="app">
 <div ng-controller="Controle1">
  Ola {{nome}}
</div>
  <h2>.: Lista de Exemplo para Estudo :.</h2>
  <div ng-controller="Controle2">  
      <li ng-repeat="nomes in ListaSimples">
          {{$index + 1}}. Nome: {{nomes}}
      </li>
  </div>

  <h2>.: Lista de Exemplo para Estudo2 :.</h2>
  <div ng-controller="Controle3">
      <li ng-repeat="array in ArraySimples">
        {{array}}
      </li>
  </div>
</body>
</html>