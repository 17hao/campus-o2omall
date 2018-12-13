package com.sqh.o2omall.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.sqh.o2omall.BaseTest;
import com.sqh.o2omall.entity.Area;

public class AreaServiceTest extends BaseTest {
	@Autowired
	private AreaService areaService;

	@Test
	public void testGetAreaList() {
		List<Area> areaList = areaService.getAreaList();
		assertEquals("余杭", areaList.get(0).getAreaName());
	}
}
