package com.erp;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.vo.DeptVO;
import com.vo.EmpVO;
@Service
public class DeptDao {
	Logger logger = Logger.getLogger(DeptDao.class);
	@Autowired(required=false)
	public SqlSessionTemplate sqlSessionTemplate = null;
	public void deptInsert(DeptVO dVO) throws DataAccessException{
		logger.info("deptInsert 호출 성공");
		sqlSessionTemplate.update("deptInsert", dVO);
	}
}
