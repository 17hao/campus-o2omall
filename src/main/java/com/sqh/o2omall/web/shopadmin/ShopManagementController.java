package com.sqh.o2omall.web.shopadmin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sqh.o2omall.dto.ShopExecution;
import com.sqh.o2omall.entity.Area;
import com.sqh.o2omall.entity.PersonInfo;
import com.sqh.o2omall.entity.Shop;
import com.sqh.o2omall.entity.ShopCategory;
import com.sqh.o2omall.enums.ShopStateEnum;
import com.sqh.o2omall.service.AreaService;
import com.sqh.o2omall.service.ShopCategoryService;
import com.sqh.o2omall.service.ShopService;
import com.sqh.o2omall.util.HttpServletRequestUtil;

/**
 * 店铺操作控制器
 *
 * @author sqh
 * @date 2018/12/25
 */
@Controller
@RequestMapping(value = "shopadmin")
public class ShopManagementController {
	@Autowired
	private ShopService shopService;

	@Autowired
	private ShopCategoryService shopCategoryService;

	@Autowired
	private AreaService areaService;

	/**
	 * 店铺信息初始化:店铺区域和店铺类别
	 * 
	 * @return
	 */
	@RequestMapping(value = "getshopinitinfo", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getShopInitInfo() {
		Map<String, Object> modelMap = new HashMap<>();
		List<Area> areaList = new ArrayList<>();
		List<ShopCategory> shopCategoryList = new ArrayList<>();
		try {
			shopCategoryList = shopCategoryService.getShopCategoryList(new ShopCategory(), 1, 99);
			areaList = areaService.getAreaList();
			modelMap.put("shopCategoryList", shopCategoryList);
			modelMap.put("areaList", areaList);
			modelMap.put("success", true);
		} catch (Exception e) {
			modelMap.put("success", false);
			modelMap.put("errMsg", e.getMessage());
		}
		return modelMap;
	}

	/**
	 * 注册店铺
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/registershop", method = RequestMethod.GET)
	@ResponseBody
	private Map<String, Object> registerShop(HttpServletRequest request) {
		Map<String, Object> modelMap = new HashMap<>();
		// 1.接收并转换相应的参数
		String shopStr = HttpServletRequestUtil.getString(request, "shopStr");
		// 使用jackson-databind，将jason转换为pojo
		ObjectMapper mapper = new ObjectMapper();
		Shop shop = null;
		try {
			shop = mapper.readValue(shopStr, Shop.class);
		} catch (Exception e) {
			// TODO: handle exception
			modelMap.put("success", false);
			modelMap.put("errMsg", e.getMessage());
			return modelMap;
		}

		// 2.注册店铺
		MultipartFile shopImg = null;
		if (shop != null) {
			PersonInfo owner = (PersonInfo) request.getSession().getAttribute("user");
			shop.setOwner(owner);
			ShopExecution se = shopService.addShop(shop, shopImg);
			if (se.getState() == ShopStateEnum.CHECK.getState()) {
				modelMap.put("success", true);

				// 注册成功，将店铺列表放到session
				@SuppressWarnings("unchecked")
				List<Shop> shopList = (List<Shop>) request.getSession().getAttribute("shpList");
				if (shopList != null && shopList.isEmpty()) {
					shopList = new ArrayList<>();
				}
				shopList.add(shop);
				request.getSession().setAttribute("shopList", shopList);
			} else {
				modelMap.put("success", false);
				modelMap.put("errMsg", se.getStateInfo());
			}
			return modelMap;
		} else {
			modelMap.put("success", false);
			modelMap.put("errMsg", ShopStateEnum.NULL_SHOP_INFO.getStateInfo());
			return modelMap;
		}
	}
}
