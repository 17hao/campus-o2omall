package com.sqh.o2omall.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sqh.o2omall.entity.ShopCategory;

/**
 * 店铺类别数据接口
 *
 * @author sqh
 * @date 2018/12/25
 */
public interface ShopCategoryDao {
	/**
	 * 根据查询条件获取分页列表
	 * 1.首页展示一级目录（parent_id为null的店铺类别）
	 * 2.进入一级菜单加载对应的子目录
	 * 3.店铺只能挂在2级类别下
	 * 
	 * @param shopCategoryCondition 查询条件
	 * @param rowIndex				从第几行开始取
	 * @param pageSize				取几行
	 * @return
	 */
	List<ShopCategory> selectShopCategory(@Param("shopCategoryCondition") ShopCategory shopCategoryCondition,
			@Param("rowIndex") int rowIndex, @Param("pageSize") int pageSize);
}
