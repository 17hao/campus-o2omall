package com.sqh.o2omall.service;

import org.springframework.web.multipart.MultipartFile;

import com.sqh.o2omall.dto.ShopExecution;
import com.sqh.o2omall.entity.Shop;

/**
 * 店铺业务接口
 *
 * @author sqh
 * @date 2018/12/25
 */
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
