package com.mvc1;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.vo.SwDesignVO;

public class TestLogic {
	Logger logger = Logger.getLogger(TestLogic.class);
	TestDao tDao = new TestDao();
	public List<Map<String,Object>> subjectList(){
		logger.info("subjectList 호출 성공");
		List<Map<String,Object>> subList = null;
		subList  = tDao.subjectList();
		return subList;
	}
	public int examReceipt(Map<String, Object> pMap) {
		logger.info("examReceipt호출 성공");
		int result = 0;
		String exam_no = "0";//수험번호 채번하여 담기
		exam_no = tDao.getExamNo();//select건
		logger.info("exam_no:"+exam_no);
		//위에서 채번한 수험번호를  파라미터에 넣기
		pMap.put("exam_no",exam_no);
		//시험 응시 접수 처리 - insert건
		//0이면 접수 실패, 1이면 접수 성공
		result = tDao.exeamReceipt(pMap);//위에서 수험번호가 담겼으므로 호출 가능
		return result;
	}
	public List<Map<String,Object>> swDesignExam(Map<String, Object> pMap) {
		logger.info("swDesignExam 호출 성공");
		List<Map<String,Object>> designList = null;
		/*
		 * 파라미터 pMap에는 프로시저 호출시 resultMap속성이 담기고
		 * 리턴타입 List에는 프로시저 호출 시 selectList를 사용하면 map에 담긴 정보를
		 * 다시 List에 자동으로 담아줌.
		 */
		designList = tDao.swDesignExam(pMap);
		return designList;
	}
	public String isOk(Map<String, Object> pMap) {
		logger.info("isOk 호출 성공");
		String msg = null;
		msg = tDao.isOk(pMap);
		return msg;
	}
}







