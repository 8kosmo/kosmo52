package com.kosmo.spring7;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController{
    private static final Logger logger = LogManager.getLogger(HelloController.class);
    @RequestMapping("/")
    public String index(){
        logger.info("index 호출 성공");
        return "Hello spring-boot world!!!";
    }
    @RequestMapping("/{num}")
    public String test(@PathVariable int num){
        logger.info("test 호출 성공");
        int hap = 0;
        for(int i=1;i<=10;i++){
            hap = hap+i;
        }
        return "total : "+hap;
    }
}