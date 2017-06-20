app.service('activationService', ['$http', function($http){

	var url='/profiles';
	var userUrl='/users';
	
	this.findOne = function(id){
		return $http.get(url + '?id=' + id);
	}
	
	this.saveUser = function(user){
		return $http.post(userUrl, user);
	}
	
	this.deleteProfile = function(id){
		return $http.delete(url + "?id=" + id);
	}

}]);