app.controller('loginController', ['$scope', '$window', '$location', '$state', 'loginService',
	function ($scope, $window, $location, $state, loginService) {

	function init(){
		$scope.loginData={};
        $window.localStorage.removeItem("user");   
	}
	
	init();
	
	$scope.logIn = function() {
		
		loginService.logIn($scope.loginData).then(
				function(response){
					if(response.data.role=="ADMIN"){
						var user = [];
	                    user.push(response.data);
	                    $window.localStorage.setItem("user", JSON.stringify(user));
						$state.go('admin');
					}else if(response.data.role=="BUYER"){
						var user = [];
	                    user.push(response.data);
	                    $window.localStorage.setItem("user", JSON.stringify(user));
	                    $state.go('admin');
					}
					else
						$state.transitionTo('other');
				},
				function(response){
					alert("Unsuccessful login.");
				}
		);
	}
}]);