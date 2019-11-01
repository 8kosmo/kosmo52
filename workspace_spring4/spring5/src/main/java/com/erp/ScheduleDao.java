package com.erp;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ScheduleDao {
	Logger logger = LoggerFactory.getLogger(ScheduleDao.class);
	@Autowired(required=false)
	private SqlSessionTemplate sqlSessionTemplate = null;
	public List<Map<String, Object>> zdoList() {
		// TODO Auto-generated method stub
		List<Map<String,Object>> zdoList = null;
		zdoList = sqlSessionTemplate.selectList("zdoList");
		return zdoList;
	}
	public List<Map<String, Object>> siguList(String zdo) {
		logger.info("siguList 호출 성공 : "+zdo);
		List<Map<String,Object>> siguList = null;
		siguList = sqlSessionTemplate.selectList("siguList",zdo);
		return siguList;
	}
	public List<Map<String, Object>> dongList(String sigu) {
		// TODO Auto-generated method stub
		List<Map<String,Object>> dongList = null;
		dongList = sqlSessionTemplate.selectList("dongList",sigu);
		return dongList;
	}
	
}
