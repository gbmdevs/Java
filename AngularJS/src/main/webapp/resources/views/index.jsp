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
</body>

</html>