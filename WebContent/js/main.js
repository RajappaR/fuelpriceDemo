var app = angular.module('demoApp', [
	'ngRoute', 'ngMap', 'ngCookies'
]);

/**
 * Configure the Routes
 */
app.config([ '$routeProvider', function($routeProvider) {
	$routeProvider
		// Home
		.when("/", {
			templateUrl : "partials/home.html",
			controller : "HomeCtrl"
		})
		// Pages
		//See Logs
		.when("/see_log", {
			templateUrl : "partials/see_log.html",
			controller : "LogCtrl"
		})
		//Save Logs
		.when("/save_log", {
			templateUrl : "partials/save_log.html",
			controller : "LogCtrl"
		})
		//Near By
		.when("/nearby", {
			templateUrl : "partials/nearby.html",
			controller : "MapCtrl"
		})
		// else 404
		.otherwise("/404", {
			templateUrl : "partials/404.html",
			controller : "HomeCtrl"
		});
} ]);

//LogCtrl
app.controller('LogCtrl', function($scope, $location, $http,$cookies) {
	$scope.logDetails = [];
	var logs = [];
	/*
	 * This function is used to submit the Logs.
	 */
	$scope.submitDetails = function(log){
		
		//http request to backend to sumbit the Logs to DB
		console.log(log);
		log.date = formatDate(new Date());
		console.log(log);
		alert("Log Information Saved Succefully");
		$location.path("/");
		
		//
		
		/*var req = {
				 method: 'POST',
				 url: 'Backend REST url',
				 headers: {
				   'Content-Type': undefined,
				   'Access-Control-Allow-Origin' : '*'
				 },
				 data : log,				 
				}

				$http(req).then(function(data){
					console.log(data)
				}, function(){
					console.log("Failure");
				});		*/
	}
	/*
	 * This function is used to get the Logs.
	 */
	
		$http.get("./logs.json").success(
				function(data) {
					$scope.logDetails = data.data;
					//$scope.$apply();
				});

	
	/*
	 * This function is used to convert the date to our specified format.
	 */
	function formatDate(date) {
		  var hours = date.getHours();
		  var minutes = date.getMinutes();
		  var ampm = hours >= 12 ? 'pm' : 'am';
		  hours = hours % 12;
		  hours = hours ? hours : 12; // the hour '0' should be '12'
		  minutes = minutes < 10 ? '0'+minutes : minutes;
		  var strTime = hours + ':' + minutes + ' ' + ampm;
		  return date.getMonth()+1 + "/" + date.getDate() + "/" + date.getFullYear() + "  " + strTime;
		}

		
	
});

/**
 * Controls the Map
 */
app.controller('MapCtrl', function($scope, $location, $http,$cookies,$anchorScroll) {
	var map;
	$scope.service;
	var infowindow;

	var markers = [];
	
	//assigning current location stored in cokkies to local variable
	$scope.center =$cookies.get("curLoc");
	
	/*
	 * This function is used to get Near by Gas stations by using 
	 * Google places API.
	 */
	function initialize() {
		var pyrmont = new google.maps.LatLng($scope.center.split(',')[0], $scope.center.split(',')[1]);

		map = new google.maps.Map(document.getElementById('map'), {
			center : pyrmont,
			zoom : 11
		});

		var request = {
			location : pyrmont,
			radius : '10000',
			type : [ 'gas_station' ]
		};

		$scope.service = new google.maps.places.PlacesService(map);
		$scope.service.nearbySearch(request, callback);
	}

	/*
	 * Callback function placeservice.
	 */
	function callback(results, status) {
		if (status == google.maps.places.PlacesServiceStatus.OK) {
			for (var i = 0; i < results.length; i++) {
				var place = results[i];
				//Adding places as markers to local variable
				markers.push(place);
			}
			//Assigning scope variable to local markers array
			$scope.markerss = markers;
			//Telling Angular for change in scope value
			$scope.$apply();
		}
	}
	//calling places api service API
	initialize();
	$scope.showInfo = false;
	/*
	 * This function is used to Display the Gas station details when marker clicked.
	 */
	$scope.showDetail = function(e, pin) {
		$location.hash('bottom');
		$scope.service.getDetails({
	          placeId: pin.place_id
	        }, function(place, status) {
	          if (status === google.maps.places.PlacesServiceStatus.OK) {
	            	 console.log(place);  
	            	 
	            	 $scope.currentPin = place;
	            	 $scope.showInfo = true;
	            	 $scope.$apply();
	            	 $anchorScroll();
	          }
	        });
	      // call $anchorScroll()
	      
		//console.log(pin);
	};

});

/**
 * Controls all other Pages
 */
app.controller('HomeCtrl', function($scope, $location, $http,$window,$cookies) {


	
	$scope.isLocationAllowd = false;
	$scope.currentLocation = null;

	/*
	 * Getting the Current Location of user
	 */
		if (navigator.geolocation) {

			$window.navigator.geolocation
				.getCurrentPosition(
					function(location) {
						console.log(location);
						$scope.isLocationAllowd = true;
						$scope.currentLocation = location;
						getcity($scope.currentLocation.coords.latitude, $scope.currentLocation.coords.longitude);
						$cookies.put("curLoc",$scope.currentLocation.coords.latitude+","+$scope.currentLocation.coords.longitude);
						console.log($cookies.get("curLoc"));
						
					},
					function(error) {
						$scope.isLocationAllowd = false;
						console.log("Error");
						console.log(error);
					}, {
						timeout : 10000
					});

		} else {
			console.log("Error");
		}

	//Initializing cities	
	$scope.cities = [];
	$http.get("./city.json").success(
			function(data) {
				console.log(data)
				$scope.cities = data.data;
			});
	$scope.showPrice = false;
	$scope.fuelData = null;
	$scope.fetch = function(city) {
		//console.log(city);
		//Getting Fuel Price from JSON
		$http.get("./data.json").success(
			function(data) {
				console.log(data)
				angular.forEach(data.data, function(value, key) {
					console.log(key + ': ' + value.city);
					if (value.city == city) {
						$scope.fuelData = value;
						$scope.selectedcity = $scope.city;
						$scope.showPrice = true;
					}
				});
			});

	}
	
	//Difference of Price from previeus day
	$scope.change = function(oldPrice,newPrice){
		return (oldPrice-newPrice).toFixed(2);
	}
	
	/*
	 * This function is used to the city from co-ordinates.
	 */
	function getcity(lat,lng){
		var geocoder = new google.maps.Geocoder();

	    var latlng = new google.maps.LatLng(lat, lng);
	    var city;
	    geocoder.geocode({'latLng': latlng}, function(results, status) {
	      if (status == google.maps.GeocoderStatus.OK) {	   
	        if (results[1]) {
	             for (var i=0; i<results[0].address_components.length; i++) {
	            for (var b=0;b<results[0].address_components[i].types.length;b++) {	
	                if (results[0].address_components[i].types[b] == "locality") {
	                    //this is the object you are looking for
	                    city= results[0].address_components[i];
	                    console.log(results[0]);
	                    break;
	                }
	            }
	        }
	             $scope.city = city.long_name;
	             $scope.fetch(city.long_name);
	        } else {
	         
	        }
	      } else {
	        
	      }
	    });
	}
	var d = new Date();
	$scope.currDate = formatDate(d);
	d.setDate(d.getDate()-1);
	$scope.prvDate = formatDate(d);
	function formatDate(date) {
		  return  date.getDate() + "/" + (date.getMonth()+1) + "/" +date.getFullYear();
		}
});