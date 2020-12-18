//服务层
app.service('nineService',function($http){
	    	
	//读取列表数据绑定到表单中
	this.findAll=function(){
		return $http.get('../nine/findAll.do');		
	}
	//分页 
	this.findPage=function(page,rows){
		return $http.get('../nine/findPage.do?page='+page+'&rows='+rows);
	}
	//查询实体
	this.findOne=function(id){
		return $http.get('../nine/findOne.do?id='+id);
	}
	//增加 
	this.add=function(entity){
		return  $http.post('../nine/add.do',entity );
	}
	//修改 
	this.update=function(entity){
		return  $http.post('../nine/update.do',entity );
	}
	//删除
	this.dele=function(ids){
		return $http.get('../nine/delete.do?ids='+ids);
	}
	//搜索
	this.search=function(page,rows,searchEntity){
		return $http.post('../nine/search.do?page='+page+"&rows="+rows, searchEntity);
	}    	
});
