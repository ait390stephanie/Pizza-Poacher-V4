var module = angular.module('pizzapoacher'); 

module.controller('PizzaPoacherController', ['$http', '$scope', 'PageService',
  function($http, $scope, PageService) {
	var ppCtrl=this;
	PageService.setPage("pizzapoacher");
	}
]);
