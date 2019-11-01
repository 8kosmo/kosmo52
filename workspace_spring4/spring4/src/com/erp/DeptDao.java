package com.erp;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.dao.DataAccessException;

import com.vo.DeptVO;
import com.vo.EmpVO;

public class DeptDao {
	Logger logger = Logger.getLogger(DeptDao.class);
	public SqlSessionTemplate sqlSessionTemplate = null;
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	public void deptUpdate(DeptVO dVO) throws DataAccessException{
		logger.info("deptUpdate 호출 성공");
		dVO = new DeptVO();
		dVO.setDeptno(67);
		dVO.setDname("개발3팀");
		dVO.setLoc("인천");
		sqlSessionTemplate.update("deptUpdate", dVO);
	}
}
