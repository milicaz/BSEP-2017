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
	    
	    .state('helloAdmin', {
	    	url : '/helloAdmin',
	    	templateUrl : 'hello.html'
	    })
	    
	    .state('helloBuyer', {
	    	url : '/helloBuyer',
	    	templateUrl : 'hello1.html'
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
	    });


}]);