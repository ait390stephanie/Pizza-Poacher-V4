var module = angular.module('pizzapoacher'); 
  
  module.config(['$routeProvider', function($routeProvider) {
	  $routeProvider.when('/login', {
            templateUrl: '/guest/login-user.html',
            controller: 'LoginUserController as loginCtrl'
            }).
            when('/pizzapoacher', {
                templateUrl: '/guest/pizzapoacher.html',
                controller: 'PizzaPoacherController as ppCtrl'
                }).
            when('/about', {
                templateUrl: '/guest/about.html',
                controller: 'AboutController as aboutCtrl'
                }).
            when('/firststeps', {
                templateUrl: '/guest/firststeps.html',
                controller: 'FirstStepsController as stepsCtrl'
                }).
            when('/accounts', {
                templateUrl: '/guest/accounts.html',
                controller: 'AccountsController as accountsCtrl'
                }).
            when('/contact', {
                templateUrl: '/guest/contact.html',
                controller: 'ContactController as contactCtrl'
                }).
            otherwise({
            redirectTo: '/pizzapoacher'
            });
    }]);
   
  module.controller('MainController', ['$scope', 'PageService', function($scope, PageService){
	    var mainCtrl = this;
	    
	    mainCtrl.page=PageService.getPage();
	    
	    mainCtrl.setPage = function(name) {
	    	PageService.setPage(name);
	    	mainCtrl.page=PageService.getPage();
	    }
	    
	    $scope.$on('PAGE_CHANGED', function() {
	    	mainCtrl.page=PageService.getPage();
	    });

  }]);
