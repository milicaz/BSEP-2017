app.service('adminService', ['$http', function($http){
	
	var urlBed='/beds';
	var urlChair = '/chairs';
	var urlShelf = '/shelfs';
	var urlOrderedBed = '/orderedBed';
	var urlOrderedChair = '/orderedChair';
	var urlBasket = '/baskets';	
	
	this.findAllBed = function(){
		return $http.get(urlBed);
	}
	
	this.findAllChair = function(){
		return $http.get(urlChair);
	}
	
	this.findAllShelf = function(){
		return $http.get(urlShelf);
	}
	
	this.saveBed= function(bed){
    	return $http.post(urlOrderedBed, bed);
    }
	
	this.saveChair= function(chair){
    	return $http.post(urlOrderedChair, chair);
    }
	
	this.saveBasket = function(basket){
    	return $http.post(urlBasket, basket);
    }
	
	this.findAllBasket = function() {
		return $http.get(urlBasket);
	}
	
	this.deleteBed = function(id) {
		return $http.delete(urlOrderedBed+"?id"+id);
	}
	
}]);