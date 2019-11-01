package com.erp;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vo.EmpVO;
//@Service
public class EmpLogic {
	Logger logger = Logger.getLogger(EmpLogic.class);
	//@Autowired
	public DeptDao deptDao = null;
	public void setDeptDao(DeptDao deptDao) {
		this.deptDao = deptDao;
	}
	public EmpDao empDao = null;
	public void setEmpDao(EmpDao empDao) {
		this.empDao = empDao;
	}
	public void eudEmp(EmpVO eVO) {
		try {
			empDao.empInsert(null);			
			deptDao.deptUpdate(null);
		} catch (Exception e) {
			throw e;
		}
	}

}
