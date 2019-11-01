package com.kosmo.spring7;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DeptController{
    private static final Logger logger = LogManager.getLogger(DeptController.class);
    @RequestMapping("/{name}.do")
    public String test(@PathVariable String name){
        logger.info("test 호출 성공");
        return "dept/deptList";
    }
}