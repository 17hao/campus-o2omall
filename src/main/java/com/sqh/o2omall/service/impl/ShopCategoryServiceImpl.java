package com.sqh.o2omall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sqh.o2omall.dao.ShopCategoryDao;
import com.sqh.o2omall.entity.ShopCategory;
import com.sqh.o2omall.service.ShopCategoryService;
import com.sqh.o2omall.util.PageCalculator;

/**
 * 店铺类别业务接口实现类
 *
 * @author sqh
 * @date 2018/12/25
 */
@Service
public class ShopCategoryServiceImpl implements ShopCategoryService {
	@Autowired
	private ShopCategoryDao shopCategoryDao;

	@Override
	public List<ShopCategory> getShopCategoryList(ShopCategory shopCategoryCondition, int pageIndex, int pageSize) {
		// 前台页面插入的pageIndex（第几页）， 而dao层是使用 rowIndex （第几行） ，所以需要转换一下
		int rowIndex = PageCalculator.calculatorRowIndex(pageIndex, pageSize);
		return shopCategoryDao.selectShopCategory(shopCategoryCondition, rowIndex, pageSize);
	}

}
