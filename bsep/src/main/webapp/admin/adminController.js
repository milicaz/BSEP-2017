app.controller('adminController', ['$scope', '$window', '$location', 'adminService', '$stateParams', '$state',
	function ($scope, $window, $location, adminService, $stateParams, $state) {
	
	function init() {
	
	var result = JSON.parse(localStorage.getItem("user"));
    $scope.currentUser = result[0];
    //console.log($scope.user);
    $scope.currentOrder={};
    $scope.currentOrder1={};
    $scope.currentBasket = {};
    $scope.orderedBed = {};
	
	adminService.findAllBed().then (
			function(response) {
				//console.log(response.data);
				$scope.bed = response.data;
			}
	)
	
	adminService.findAllChair().then (
			function(response) {
				//console.log(response.data);
				$scope.chair = response.data;
			}
	);
	
	adminService.findAllShelf().then (
			function(response) {
				//console.log(response.data);
				$scope.shelf = response.data;
			}
			
	);
	};
	
	init();

	adminService.findAllBasket().then (
			
			function(response) {
				$scope.basket = response.data;
				//console.log($scope.basket);
				//var beds = [];
				$scope.i = 0;
				for(bas in $scope.basket){
					if($scope.basket[bas].user.email == $scope.currentUser.email){
//						beds.push(response.data);
//						console.log(beds);
						$scope.currentBasket[$scope.i] = $scope.basket[bas];
						$scope.i++;
					}
				}
//				//$scope.currentBasket.beds=beds;
//				$scope.currentBasket=beds.beds;
//				console.log($scope.currentBasket);
				//console.log($scope.i);
				console.log($scope.currentBasket);
			}
	);
		
	$scope.addBed = function(bed) {
		var orderBed={};
		orderBed.quantity=1;
		orderBed.bed=bed;
		orderBed.bedStatus='ORDERED';
		//console.log(orderBed);
		$scope.currentOrder.beds=[];
		adminService.saveBed(orderBed).then(
				function(response){
					$scope.currentOrder.beds.push(response.data);
					//console.log($scope.currentOrder);
					$scope.currentOrder.user = $scope.currentUser;
					adminService.saveBasket($scope.currentOrder).then (
						function(response){
						alert("Bed has been ordered");
						}
					);
				}
		);
	}
	
	$scope.addChair = function(chair) {
		var orderChair={};
		orderChair.quantity=1;
		orderChair.chair=chair;
		orderChair.chairStatus='ORDERED';
		//console.log(orderBed);
		$scope.currentOrder1.chairs=[];
		adminService.saveChair(orderChair).then(
				function(response){
					$scope.currentOrder1.chairs.push(response.data);
					//console.log($scope.currentOrder);
					$scope.currentOrder1.user = $scope.currentUser;
					adminService.saveBasket($scope.currentOrder1).then (
						function(response){
						alert("Chair has been ordered");
						}
					);
				}
		);
	}
	
	$scope.cancelBed = function(bed) {
		$scope.orderedBed = bed;
		for(be in $scope.orderedBed){
			console.log("Ordered bed" + be);
		}
		for(b in $scope.currentOrder){
			if(b == bed){
				adminService.deleteBed(bed.id).then (
					function(response){
						alert("Bed has been deleted");
					}	
				);
			}
		}
	}
	
	
	
}]);