package com.sts3.pojo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dept/*")
public class DeptController {
	Logger logger = LoggerFactory.getLogger(DeptController.class);
	private DeptLogic deptLogic = null;
	public void setDeptLogic(DeptLogic deptLogic) {
		this.deptLogic = deptLogic;
	}
	@GetMapping("deptList")
	public String deptList() {
		logger.info("deptList호출 성공");
		deptLogic.deptList();
		return "dept/deptList";
	}
}
