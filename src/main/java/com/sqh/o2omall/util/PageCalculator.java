package com.sqh.o2omall.util;

/**
 * 计算分页的工具类
 *
 * @author sqh
 * @date 2018/12/25
 */
public class PageCalculator {
	/**
	 * 根据页数和每页数量查询行数
	 * 
	 * @param pageIndex 页码数
	 * @param pageSize  每页数量
	 * @return
	 */
	public static int calculatorRowIndex(int pageIndex, int pageSize) {
		return (pageIndex > 0) ? (pageIndex - 1) * pageSize : 0;
	}
}
