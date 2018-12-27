package com.sqh.o2omall.web.shopadmin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 店铺管理员控制器
 *
 * @author sqh
 * @date 2018/12/25
 */
@Controller
@RequestMapping(value = "shopadmin", method = { RequestMethod.GET })
public class ShopAdminController {
	/**
	 * 店铺管理员控制器
	 * 
	 * @return
	 */
	@RequestMapping(value = "shopoperation")
	public String shopOperation() {
		return "shop/shopoperation";
	}
}
