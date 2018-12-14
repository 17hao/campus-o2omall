package com.sqh.o2omall.dto;

import java.util.List;

import com.sqh.o2omall.entity.Shop;
import com.sqh.o2omall.enums.OperationStatusEnum;
import com.sqh.o2omall.enums.ShopStateEnum;

/**
 * UI展示页面用到的模型
 *
 * @author sqh
 * @date 2018/12/14
 */
public class ShopExecution {
	private int state;
	private String stateInfo;
	// 店铺数量
	private int count;
	// 增删店铺时操作的shop
	private Shop shop;
	private List<Shop> shopList;

	// 店铺操作失败的时候使用的构造方法
	public ShopExecution(ShopStateEnum stateEnum) {
		this.state = stateEnum.getState();
		this.stateInfo = stateEnum.getStateInfo();
	}

	// 店铺操作成功时候对应的基本操作状态
	public ShopExecution(OperationStatusEnum stateEnum, Shop shop) {
		this.state = stateEnum.getState();
		this.stateInfo = stateEnum.getStateInfo();
		this.shop = shop;
	}

	// 店铺操作成功时候对应的店铺状态
	public ShopExecution(ShopStateEnum stateEnum, Shop shop) {
		this.state = stateEnum.getState();
		this.stateInfo = stateEnum.getStateInfo();
		this.shop = shop;
	}

	// 店铺查询成功使用的构造方法
	public ShopExecution(OperationStatusEnum stateEnum, List<Shop> shopList) {
		this.state = stateEnum.getState();
		this.stateInfo = stateEnum.getStateInfo();
		this.shopList = shopList;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getStateInfo() {
		return stateInfo;
	}

	public void setStateInfo(String stateInfo) {
		this.stateInfo = stateInfo;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public List<Shop> getShopList() {
		return shopList;
	}

	public void setShopList(List<Shop> shopList) {
		this.shopList = shopList;
	}
}
