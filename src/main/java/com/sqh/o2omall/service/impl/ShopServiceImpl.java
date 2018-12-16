package com.sqh.o2omall.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.sqh.o2omall.dao.ShopDao;
import com.sqh.o2omall.dto.ShopExecution;
import com.sqh.o2omall.entity.Shop;
import com.sqh.o2omall.enums.OperationStatusEnum;
import com.sqh.o2omall.enums.ShopStateEnum;
import com.sqh.o2omall.exceptions.ShopOperationException;
import com.sqh.o2omall.service.ShopService;

public class ShopServiceImpl implements ShopService {
	@Autowired
	private ShopDao shopDao;

	@Override
	public ShopExecution addShop(Shop shop, MultipartFile shopImg) {
		// 判断添加的店铺是否为空
		if (shop == null) {
			return new ShopExecution(ShopStateEnum.NULL_SHOP_INFO);
		} else {
			try {
				shop.setCreateTime(new Date());
				shop.setLastEditTime(new Date());
				// 判断店铺添加是否成功
				int effectedNum = shopDao.insertShop(shop);
				if (effectedNum <= 0) {
					throw new ShopOperationException(ShopStateEnum.EDIT_ERROR.getStateInfo());
				} else {
					try {
						// 判断上传的图片是否为空
						if (shopImg == null) {
							throw new ShopOperationException(OperationStatusEnum.PIC_EMPTY.getStateInfo());
						} else {
							// 添加图片
							addImg(shop, shopImg);
							effectedNum = shopDao.updateShop(shop);
							if (effectedNum <= 0) {
								throw new ShopOperationException(OperationStatusEnum.PIC_UPLOAD_ERROR.getStateInfo());
							}
						}
					} catch (Exception e) {
						throw new ShopOperationException(ShopStateEnum.EDIT_ERROR.getStateInfo());
					}
				}
			} catch (Exception e) {
				throw new ShopOperationException(ShopStateEnum.EDIT_ERROR.getStateInfo());
			}
			return null;
		}
	}

	/**
	 * 为店铺添加图片
	 * 
	 * @param shop
	 * @param shopImg
	 */
	private void addImg(Shop shop, MultipartFile shopImg) {
	}
}
