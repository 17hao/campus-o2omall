package com.sqh.o2omall.service;

import java.util.List;

import com.sqh.o2omall.entity.ShopCategory;

/**
 * 店铺类别业务接口
 *
 * @author sqh
 * @date 2018/12/25
 */
public interface ShopCategoryService {
	/**
	 * 根据条件获取店铺类别分页列表
	 * 
	 * @param shopCategoryCondition 查询条件
	 * @param pageIndex             第几页
	 * @param pageSize              每页几条
	 * @return
	 */
	List<ShopCategory> getShopCategoryList(ShopCategory shopCategoryCondition, int pageIndex, int pageSize);
}
