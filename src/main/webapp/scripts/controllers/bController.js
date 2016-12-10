app.controller('bController', function($scope, $http, $cookies, goodsService) {
	/**
	 * 分页载体
	 * 
	 * @type {{}}
	 */
	$scope.pageConfig = {};
	$scope.jsonitem = {};
	// 查询
//	$scope.pageConfig = {
//		onChange : function() {
//			// console.dir("onchange");
//			$scope.jsonitem =  {
//				page : $scope.pageConfig.page,
//				rows : $scope.pageConfig.rows
//			};
//			$scope.jsonitemlist();
//		}
//	};
	$scope.jsonitemlist=function(){
        var param={
        		page:$scope.pageConfig.page,
        		
        		rows:$scope.pageConfig.rows,
        		
//        		title:$scope.jsonitem.title,
//        		             
//        		price:$scope.jsonitem.numIid
        };
        goodsService.getlist(param, function(data) {
    		$scope.cart = data;
    	});
    };
    $scope.initPage=function(){
        $scope.jsonitemlist();
    }

})
