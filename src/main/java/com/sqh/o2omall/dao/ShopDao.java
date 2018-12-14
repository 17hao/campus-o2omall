package com.sqh.o2omall.dao;

import com.sqh.o2omall.entity.Shop;

/**
 * 店铺数据接口
 *
 * @author sqh
 * @date 2018/12/14
 */
public interface ShopDao {
	/**
	 * 新增店铺
	 * 
	 * @param shop
	 * @return
	 */
	int insertShop(Shop shop);

	/**
	 * 更新店铺
	 * 
	 * @param shop
	 * @return
	 */
	int updateShop(Shop shop);
}
