package com.sqh.o2omall.exceptions;

/**
 * 店铺操作异常类
 *
 * @author sqh
 * @date 2018/12/16
 */
public class ShopOperationException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ShopOperationException(String msg) {
		super(msg);
	}
}
