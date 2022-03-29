<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Ola Mundo!</title>
    
    <script language="javascript">      
      var list = [];

      function trocou(){
        var index;
        index = document.getElementById("listaBuscador").selectedIndex;          
        console.log("Trocou o index: " + index);
        console.log("Email selecionado: ");
        if(index - 1 < 0) {
          document.getElementById("campoTexto1").value = "";
        }else{
          document.getElementById("campoTexto1").value = list[index - 1];
        }
      }

      function carrega(){
	      <c:forEach items="${messageStore.listEmails}" var="seat">
             console.log("Entrou no loop");
	           var arr = [];
	           arr.push("<c:out value="${seat}" />");
	           list.push(arr);
	      </c:forEach>
        console.log("Lista :" + list);
      }

   </script>
  </head>
  <body onload="carrega()">
    <h2><s:property value="messageStore.message" /></h2>
    <br>
    <h2><s:select label="Qual buscador favorito?" 
    id="listaBuscador"
		headerKey="-1" headerValue="Selecione seu buscador"
		list="messageStore.listBuscadores" onchange="trocou()" /></h2>
    <br>
    Email: <s:textfield id="campoTexto1" name = "to" />

  </body>
</html>