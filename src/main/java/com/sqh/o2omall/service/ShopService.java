package com.sqh.o2omall.service;

import org.springframework.web.multipart.MultipartFile;

import com.sqh.o2omall.dto.ShopExecution;
import com.sqh.o2omall.entity.Shop;

public interface ShopService {
	/**
	 * 添加店铺
	 * 
	 * @param shop
	 * @param shpoImg
	 * @return
	 */
	ShopExecution addShop(Shop shop, MultipartFile shpoImg);
}
