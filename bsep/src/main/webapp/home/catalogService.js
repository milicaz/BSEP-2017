app.service('catalogService', ['$http', function($http){
	
	var urlBed='/beds';
	var urlChair = '/chairs';
	var urlShelf = '/shelfs';
	
	this.findAllBed = function(){
		return $http.get(urlBed);
	}
	
	this.findAllChair = function(){
		return $http.get(urlChair);
	}
	
	this.findAllShelf = function(){
		return $http.get(urlShelf);
	}
	
}]);
