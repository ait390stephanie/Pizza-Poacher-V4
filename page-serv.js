var module = angular.module('pizzapoacher'); 

var siteDescription = {
	  'pizzapoacher':{'title':"PIZZA POACHER",
	    	'subtitle':' Your One-Stop-Shop for Pizza'},
	  'about':{'title':"ABOUT",
	    	'subtitle':' This website is delicious'},
	  'firststeps':{'title':"FIRST STEPS",
	        'subtitle':' Getting Started'},
	  'accounts':{'title':"ACCOUNTS",
	        'subtitle':'I have no idea what this is'},  
	  'contact':{'title':"CONTACT",
	    	'subtitle':' How to contact the administrators.'},  
	  'login':{'title':"LOGIN",
	        'subtitle':'Login or signup to access your page.'}
	  };


module.service('PageService', ['$rootScope', function($rootScope){
    var pageServ = this;
    
    pageServ.page = siteDescription.olympiad;
	  
    pageServ.setPage = function(name) {
    	pageServ.page = siteDescription[name];
    	$rootScope.$broadcast('PAGE_CHANGED');
	};
	
	pageServ.getPage = function() {
		return pageServ.page;
	}
    
	}]);
