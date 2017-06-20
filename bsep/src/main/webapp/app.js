'use strict';
var app = angular.module('app', ['ui.router','ngAnimate','ngTouch','ngSanitize','rgkevin.datetimeRangePicker','ui.bootstrap']);
app.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
	$urlRouterProvider.otherwise('/login');
    
    $stateProvider
	    .state('login', {
	    	url : '/login',
	      	templateUrl : 'home/login.html',
	        controller : 'loginController'
	    })
	    
	    .state('catalog', {
	    	url : '/catalog',
	    	templateUrl : 'home/catalog.html',
	    	controller : 'catalogController'
	    })
    
	    .state('catalog.bed', {
	    	url : '/bed',
	    	templateUrl : 'home/bed.html',
	    })
	    
	    .state('catalog.chair', {
	    	url : '/chair',
	    	templateUrl : 'home/chair.html',
	    })
    
	    .state('catalog.shelf', {
	    	url : '/shelf',
	    	templateUrl : 'home/shelf.html',
	    })
	    
	    .state('signup', {
	    	url : '/signup',
	    	templateUrl : 'home/signup.html',
	    	controller : 'signupController',
	    })
	    
	    .state('activation', {
	    	url : '/activation?id',
	      	templateUrl : 'home/activation.html',
	        controller : 'activationController'
	    })
	    
	    .state('notification', {
	    	url : '/notification',
	      	templateUrl : 'home/notification.html'
	    })
	    
	    .state('admin', {
	    	url : '/admin',
	    	templateUrl : 'admin/admin.html',
	    	controller : 'adminController'
	    })
	    
	    .state('buyer', {
	    	url : '/buyer',
	    	templateUrl : 'buyer/buyer.html',
	    	controller : 'buyerController'
	    })
	    
	    .state('admin.bed', {
			 url : '/bed',
			 templateUrl : 'admin/bed.html',
			 controller : 'adminController'
		 })
		 
		 .state('admin.chair', {
			 url : '/chair',
			 templateUrl : 'admin/chair.html',
			 controller : 'adminController'
		 })
		 
		 .state('admin.shelf', {
			 url : '/shelf',
			 templateUrl : 'admin/shelf.html',
			 controller : 'adminController'
		 })
	    
	    .state('admin.basket', {
			 url : '/basket',
			 templateUrl : 'admin/basket.html',
			 controller : 'adminController'
		 });


}]);