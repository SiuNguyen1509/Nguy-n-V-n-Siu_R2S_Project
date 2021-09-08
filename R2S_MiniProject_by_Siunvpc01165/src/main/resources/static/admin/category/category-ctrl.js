app.controller("category-ctrl", function($scope, $http) {
	$scope.items = [];
	$scope.cates = [];
	$scope.form = {};

	$scope.initialize = function() {
		//load products
		$http.get("/rest/products").then(resp => {
			$scope.items = resp.data;
			
			$scope.items.forEach(item => {
				item.createDate = new Date(item.createDate)
			});

		});
		//load categories
		$http.get("/rest/categories").then(resp => {
			$scope.cates = resp.data;

		});
	}
	$scope.initialize();

	$scope.reset = function() {
		$scope.form = {

		}
	}
	$scope.reset();

	$scope.edit = function(item) {
		$scope.form = angular.copy(item);
		$(".nav-tabs a:eq(0)").tab('show')
	}

	$scope.create = function() {
		var item = angular.copy($scope.form);
		$http.post(`/rest/categories`, item).then(resp => {
			resp.data.createDate = new Date(resp.data.createDate)
			$scope.items.push(resp.data);
			$scope.reset();
			alert("thêm sản phẩm thành công")
		}).catch(error => {
			alert("Thêm sản phẩm không thành công !!!")
			console.log("Error", error);
		})
	}


	$scope.delete = function(item) {

		$http.delete(`/rest/categories/delete/${item.id}`).then(resp => {
			var index = $scope.items.findIndex(p => p.id == item.id);
			$scope.items.splice(index, 1);
			$scope.reset();
			alert("xóa danh mục sản phẩm  thành công !")
		}).catch(error => {
			alert("xóa danh mục sản phẩm không thành công !!!")
			console.log("Error", error);
		})
	}

	// Phân trang
	$scope.pager = {
		page: 0,
		size: 10,
		get items() {
			var start = this.page * this.size;
			return $scope.items.slice(start, start + this.size);
		},
		get count() {
			return Math.ceil(1.0 * $scope.items.length / this.size)
		},
		first(){
			
			this.page = 0;
		},
		prev(){
			this.page --;
		},
		next(){
			this.page ++;
		},
		last(){
			this.page = this.count -1 ;
		}
		
	}
})