package com.sqh.o2omall.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.sqh.o2omall.BaseTest;
import com.sqh.o2omall.entity.Area;

public class AreaTest extends BaseTest {
	@Autowired
	private AreaDao areaDao;

	@Test
	public void queryArea() {
		List<Area> areaList = areaDao.queryArea();
		assertEquals(2, areaList.size());
	}
}
