package com.erp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vo.EmpVO;
@Controller
@RequestMapping("/erp/*")
public class EmpController {
	Logger logger = Logger.getLogger(EmpController.class);
	@Autowired(required=false)
	public EmpLogic empLogic = null;
	@GetMapping("doEmp")
	public String doEmp(HttpServletRequest req,HttpServletResponse res) {
		logger.info("doEmp 호출 성공");
		EmpVO eVO = new EmpVO();
		empLogic.doEmp(eVO);
		return "redirect:empInsertOk.jsp";
	}
}









