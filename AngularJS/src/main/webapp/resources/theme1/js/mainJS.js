var app = angular.module("app", []);
app.controller("Controle1", function($scope) {  
    $scope.nome="Mohzao acha o Guih Legal!" 
});

app.controller("Controle2", function($scope,$http){
  $http.get("http://localhost:7001/AngularMVC/users/jamal")
  .then(function(response){
       console.log(response.data);
       var membros = response.data;
       $scope.ListaSimples = membros;
  });
});



