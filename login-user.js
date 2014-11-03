var module = angular.module('pizzapoacher'); 

module.controller('LoginUserController', ['$http', '$scope', '$window', 'PageService', 
  function($http, $scope, $window, PageService) {
	var loginCtrl=this;
	PageService.setPage("login");
	loginCtrl.userEmail='';
	loginCtrl.password='';
	
	loginCtrl.logging = false;
	loginCtrl.errorMessage = null;
	
	loginCtrl.error = function(message, details) {
		loginCtrl.errorMessage = message;
		loginCtrl.errorDetails = details;
		loginCtrl.logging = false;
	}
	
	loginCtrl.login = function() {
		loginCtrl.logging = true;
		data=$scope.newUser;
		console.log("User data: "+JSON.stringify(data));
		loginCtrl.errorMessage = null;
		loginCtrl.loginSuccess = null;
 		return $http.post('/loginuser',
 	 		    data,
 	 		    {responseType:"application/json"})
 	 		    	.success(function(data, status) {
 	 			    	if (data !== null) {
 	 			    		loginCtrl.logging = false;
 	 			    		loginCtrl.loginSuccess="Success!";
 	 			    		loginCtrl.loginSuccessDetails="User "+data.name+" is logged.";
 	 			    		if (DEBUG) console.log("SUCCESS"+JSON.stringify(data)  || "Request succeeded");
 	 			    		$window.location.href = "/master/main.html";
 	 			    	    } else {
 	 			    	    	if (DEBUG) console.log("ERROR: Request succeeded but with empty data.");
 	 			    	    	loginCtrl.error("Connection error, try again.","Empty data returned as result");
 	 			    	    }
 	 			    }).error(function(data, status) {
 	 			    	if (DEBUG) console.log(data || "Request failed");
 	 			    	loginCtrl.error("Connection error, try again.", "Error returned as result");
 	 		        });
	}
	    
	}]);
