package com.mvc1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.util.MyBatisCommonFactory;

public class TestDao {
	Logger logger = Logger.getLogger(TestDao.class);
	//물리적으로 떨어져 있는 오라클  서버와 연결통로만 맺게 해주는 객체임.
	//두번째는 오라클 서버에 쿼리문을 요청하는데 필요한 SqlSession객체 생성시
	//의존관계에 있는 클래스 임.
	SqlSessionFactory sqlSessionFactory = null;
	/*
	 * Dao에서  MyBatis를 활용하여 오라클 서버에 접속(MyBatis에서 대신 해줌.)하고
	 * 쿼리문을 요청하기 위해 myBatis에서 제공하는 클래스를 객체 주입 받아야 함.
	 * 생성자에서 초기화하기 
	 * 생성자가 하는 역할이 멤버변수의 초기화이므로 생성자안에서 SqlSessionFactory객체를
	 * 주입받는다.
	 * myBatis Layer에서 오라클 서버와 커넥션을 맺는 것과 쿼리문을 요청하고 그 응답을 받는 일
	 * 까지 모두 담당하므로 이것과 관련된 하나의 이상이라도 존재하면  NullPointerException이
	 * 발생하므로 디버깅시 주의할 것.
	 */
	public TestDao() {
		sqlSessionFactory =
		MyBatisCommonFactory.getSqlSessionFactory();
	}
	/*
	 * crud이름(TestController->TestLogic) = 메소드이름 = 쿼리문 아이디 통일
	 * 
	 */
	public List<Map<String, Object>> subjectList() {
		logger.info("subjectList 호출 성공");
		//NullPointerException이 발생하면 화면을 확인할 수 없으므로
		//페이지 이동시 어떤 화면에서 에러가 발생했는지를 파악하기 힘듦.
		List<Map<String, Object>> subList = new ArrayList<>();
		try {
			SqlSession sqlSession = sqlSessionFactory.openSession();
			subList = sqlSession.selectList("subjectList");
		} catch (Exception e) {
			e.printStackTrace();//stack영역에 저장되는 에러메시지  history를 출력
		}
		return subList;
	}
	//수험 번호 채번하는 메소드 구현
	public String getExamNo() {
		logger.info("getExamNo 호출 성공");
		String exam_no = null;
		try {
			SqlSession sqlSession = sqlSessionFactory.openSession();
			exam_no = sqlSession.selectOne("getExamNo");
		} catch (Exception e) {
			e.printStackTrace();//stack영역에 저장되는 에러메시지  history를 출력
		}
		return exam_no;
	}
	//시험 응시 정보 등록
	public int exeamReceipt(Map<String, Object> pMap) {
		logger.info("exeamReceipt 호출 성공");
		int result = 0;
		try {
			SqlSession sqlSession = sqlSessionFactory.openSession();
			result = sqlSession.update("examReceipt",pMap);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();//stack영역에 저장되는 에러메시지  history를 출력
		}
		return result;
	}
	public List<Map<String, Object>> swDesignExam(Map<String, Object> pMap) {
		logger.info("swDesignExam 호출 성공");
		List<Map<String, Object>> designList = new ArrayList<>();
		try {
			SqlSession sqlSession = sqlSessionFactory.openSession();
			designList = sqlSession.selectList("swDesignExam",pMap);
			logger.info("pMap==>"+pMap);
			designList.add(pMap);
			logger.info("designList.get(0)==>"+designList.get(0));
/*
 * pMap==>{key=[com.vo.SwDesignVO@70737060, com.vo.SwDesignVO@29585fc5, com.vo.SwDesignVO@1eed11e4, com.vo.SwDesignVO@2ec5217b]}
 * [{key=[com.vo.SwDesignVO@70737060, com.vo.SwDesignVO@29585fc5, com.vo.SwDesignVO@1eed11e4, com.vo.SwDesignVO@2ec5217b]}]			
 */
		} catch (Exception e) {
			e.printStackTrace();//stack영역에 저장되는 에러메시지  history를 출력
		}
		return designList;
	}
	public String isOk(Map<String, Object> pMap) {
		String msg = null;
		try {
		//NullPointException발생시 확인 할 내용 - xml문서에 작성된 프로시저나 DML구문	
			SqlSession sqlSession = sqlSessionFactory.openSession();
			msg = sqlSession.selectOne("isOk",pMap);	
			logger.info("msg:"+msg);
		} catch (Exception e) {
			e.printStackTrace();//Line번호, 호출 경로 확인
		}
		return msg;
	}

}
