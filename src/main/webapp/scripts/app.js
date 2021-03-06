
var app = angular.module("indexapp", [ "ngRoute", "ngCookies","tm.pagination"],function($httpProvider){
	$httpProvider.defaults.headers.post['Content-Type'] = "application/x-www-form-urlencoded;charset=utf-8";
//    $httpProvider.defaults.headers.post["Content-Type"] = "application/json";
    $httpProvider.defaults.headers.post['X-Requested-With'] = 'XMLHttpRequest';
    $httpProvider.defaults.transformRequest = [function(data) {  
        /**  
         * The workhorse; converts an object to x-www-form-urlencoded serialization.  
         * @param {Object} obj  
         * @return {String}  
         */  
        var param = function(obj) {  
            var query = '';  
            var name, value, fullSubName, subName, subValue, innerObj, i;  
   
            for (name in obj) {  
                value = obj[name];  
   
                if (value instanceof Array) {  
                    for (i = 0; i < value.length; ++i) {  
                        subValue = value[i];  
                        fullSubName = name + '[' + i + ']';  
                        innerObj = {};  
                        innerObj[fullSubName] = subValue;  
                        query += param(innerObj) + '&';  
                    }  
                } else if (value instanceof Object) {  
                    for (subName in value) {  
                        subValue = value[subName];  
                        fullSubName = name + '[' + subName + ']';  
                        innerObj = {};  
                        innerObj[fullSubName] = subValue;  
                        query += param(innerObj) + '&';  
                    }  
                } else if (value !== undefined && value !== null) {  
                    query += encodeURIComponent(name) + '='  
                            + encodeURIComponent(value) + '&';  
                }  
            }  
   
            return query.length ? query.substr(0, query.length - 1) : query;  
        };  
   
        return angular.isObject(data) && String(data) !== '[object File]'  
                ? param(data)  
                : data;  
    }];  
})

app.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/midify-user', {
		// controller : 'aController',
		controllerAs : 'home',
		templateUrl : 'app/midify-user.html'
	}).when('/', {
		// controller : 'bController',
		controllerAs : 'schools',
		templateUrl : 'app/electrical-goods.html'
	}).when('/men', {
		// controller : 'cController',
		controllerAs : 'classrooms',
		templateUrl : 'app/men.html'
	}).when('/women', {
		// controller : 'dController',
		controllerAs : 'activities',
		templateUrl : 'app/women.html'
	}).when('/shopCart', {
		// controller : 'dController',
		controllerAs : 'activities',
		templateUrl : 'app/shopcart.html'

	})
} ]);
