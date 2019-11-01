package com.erp;

import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class DeptController extends MultiActionController {
	public DeptLogic deptLogic = null;
	public void setDeptLogic(DeptLogic deptLogic) {
		this.deptLogic = deptLogic;
	}
}
