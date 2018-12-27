/**
 * 
 */
$(function() {
	// 初始化店铺信息：店铺类别和区域信息，用于注册店铺
	var initUrl = "/o2omall/shopadmin/getshopinitinfo";
	// 注册店铺
	var registerShopUrl = "/o2omall/shopadmin/reigstershop";
	/*
	 * 获取店铺初始化信息：店铺类别和区域信息列表
	 */
	function getShopInitInfo() {
		$.getJSON(initUrl, function(data) {
			// 数据存在
			if (data.success) {
				var tempHtml = "";
				var tempAreaHtml = "";
				// 迭代店铺分类列表
				data.shopCategoryList.map(function(item, index) {
					tempHtml += '<option data-id="' + item.shopCategoryId
							+ '">' + item.shopCategoryName + '</option>';
				});
				// 迭代区域信息列表
				data.areaLit.map(function(item, index) {
					tempAreaHtml += '<option data-id="' + item.areaId + '">'
							+ item.areaName + '</option>';
				});
				$('#shop-catagory').html(tempHtml);
				$('#area').html(tempAreaHtml);
			}
		})
	}
})