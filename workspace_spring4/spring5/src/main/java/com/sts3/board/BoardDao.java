package com.sts3.board;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vo.BoardMasterVO;
import com.vo.BoardSubVO;
@Service
public class BoardDao {
	//Logger logger = Logger.getLogger(BoardDao.class);
	Logger logger = LoggerFactory.getLogger(BoardDao.class);
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate = null;
	public int hitCount(int bm_no) {
		logger.info("hitCount호출 성공");
		int result = 0;
		try {
			bm_no = sqlSessionTemplate.update("hitCount", bm_no);
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return result;
	}
	public List<Map<String,Object>> boardList(Map<String, Object> pMap) {
		logger.info("boardList 호출 성공"+sqlSessionTemplate);
		List<Map<String,Object>> boardList = new ArrayList<>();
		boardList = sqlSessionTemplate.selectList("boardList",pMap);
		return boardList;
	}
	public int getTotal(BoardMasterVO bmVO) {
		int tot = 0;
		try {
			tot = sqlSessionTemplate.selectOne("getTotal",bmVO);
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return tot;
	}
	public int getBmno() {
		int bm_no = 0;
		try {
			bm_no = sqlSessionTemplate.selectOne("getBmno");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bm_no;
	}
	/*
	 * 컨트롤 계층에서 값을 받아올때는 request.getParameter를 생략하기 위해 
	 * @RequestParam을 사용하였다.
	 * 그러나 Dao에서 마이바티스와 연결할 땐 VO타입으로 전달해야 하므로
	 * VO객체를 생성해서 값을 담아주어야 함.
	 */
	public int bmStepUpdate(Map<String, Object> pMap) {
		logger.info("bmStepUpdate 호출 성공");
		logger.info("bm_group:"+pMap.get("bm_group")+", bm_step:"+pMap.get("bm_step"));
		int result = 0;
		BoardMasterVO bmVO = new BoardMasterVO();
		int ibm_group = 0;
		if(pMap.get("bm_group")!=null) {
			ibm_group = Integer.parseInt(pMap.get("bm_group").toString());
		}
		int ibm_step = 0;
		if(pMap.get("bm_step")!=null) {
			ibm_step = Integer.parseInt(pMap.get("bm_step").toString());
		}
		bmVO.setBm_group(ibm_group);
		bmVO.setBm_step(ibm_step);
		try {
			result = sqlSessionTemplate.update("bmStepUpdate",bmVO);
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return result;		
	}
	public int getBmgroup() {
		int bm_group = 0;
		try {
			bm_group = sqlSessionTemplate.selectOne("getBmgroup");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bm_group;
	}
	public int boardMAdd(Map<String, Object> pMap) {
		logger.info("boardMAdd 호출 성공");
		int result = 0;
		try {
			result = sqlSessionTemplate.update("boardMAdd",pMap);
			logger.info("result:"+result);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return result;
	}
	public int boardSAdd(Map<String, Object> pMap) {
		logger.info("boardSAdd 호출 성공");
		int result = 0;
		try {
			result = sqlSessionTemplate.update("boardSAdd",pMap);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return result;
	}
	public int boardMUpd(BoardMasterVO bmVO) {
		logger.info("boardMUpd 호출 성공");
		int result = 0;
		try {
			result = sqlSessionTemplate.update("boardMUpd",bmVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public int boardSDEL(BoardSubVO bsVO) {
		logger.info("boardSDel 호출 성공");
		int result = 0;
		try {
			result = sqlSessionTemplate.delete("boardSDEL",bsVO);
			logger.info("sub result:"+result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public int boardMDEL(BoardMasterVO bmVO) {
		logger.info("boardMDel 호출 성공");
		int result = 0;
		try {
			result = sqlSessionTemplate.delete("boardMDEL",bmVO);			
			logger.info("master result:"+result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public int boardSDELALL(String[] emnoArr) {
		logger.info("boardSDELALL 호출 성공");
		List<Integer> list = new ArrayList<>();
		int result = 0;
		for(int i=0;i<emnoArr.length;i++) {
			list.add(Integer.parseInt(emnoArr[i]));
		}
		result=sqlSessionTemplate.delete("boardSDELALL",list);
		return result;
	}
	public void boardMDELALL(String[] emnoArr) {
		logger.info("boardMDELALL 호출 성공");
		List<Integer> list = new ArrayList<>();
		for(int i=0;i<emnoArr.length;i++) {
			list.add(Integer.parseInt(emnoArr[i]));
		}
		sqlSessionTemplate.delete("boardMDELALL",list);
	}	

}







