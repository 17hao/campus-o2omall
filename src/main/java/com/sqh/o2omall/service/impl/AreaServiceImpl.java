package com.sqh.o2omall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sqh.o2omall.dao.AreaDao;
import com.sqh.o2omall.entity.Area;
import com.sqh.o2omall.service.AreaService;

/**
 * 区域业务接口实现
 *
 * @author sqh
 * @date 2018/12/25
 */
@Service
public class AreaServiceImpl implements AreaService {
	@Autowired
	private AreaDao areaDao;

	@Override
	public List<Area> getAreaList() {
		return areaDao.queryArea();
	}

}
