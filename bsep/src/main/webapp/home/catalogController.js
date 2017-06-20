app.controller('catalogController', ['$scope', '$window', '$location', 'catalogService', '$stateParams', '$state',
	function ($scope, $window, $location, catalogService, $stateParams, $state) {
	
	catalogService.findAllBed().then (
			function(response) {
				console.log(response.data);
				$scope.bed = response.data;
			}
	)
	
	catalogService.findAllChair().then (
			function(response) {
				console.log(response.data);
				$scope.chairs = response.data;
			}
	)
	
	catalogService.findAllShelf().then (
			function(response) {
				console.log(response.data);
				$scope.shelfs = response.data;
			}
	)
}]);