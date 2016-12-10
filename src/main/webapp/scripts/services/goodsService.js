app.service("goodsService",function($http){
	var service = {};
	service.getlist = function(data,callback){
		$http.post(path+"/loadelectgoods.do",data).success(function(data){
            callback(data);
        });
	}
	return service;
})