package com.sqh.o2omall.dao;

import java.util.List;

import com.sqh.o2omall.entity.Area;

/**
 * Area的Dao接口
 *
 * @author sqh
 * @date 2018/12/13
 */
public interface AreaDao {
	/**
	 * 获取区域列表
	 * 
	 * @return areaList
	 */
	List<Area> queryArea();
}
