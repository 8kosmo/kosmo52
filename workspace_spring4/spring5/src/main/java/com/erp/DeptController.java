package com.erp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class DeptController{
	@Autowired(required=false)
	public DeptLogic deptLogic = null;
}
