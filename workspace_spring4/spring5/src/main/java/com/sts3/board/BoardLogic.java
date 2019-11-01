package com.sts3.board;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vo.BoardMasterVO;
import com.vo.BoardSubVO;
@Service
public class BoardLogic {
	Logger logger = Logger.getLogger(BoardLogic.class);
	@Autowired
	private BoardDao boardDao = null;
	int total = 0;
	public int getTot(BoardMasterVO bmVO) {
		total = 0;
		total = boardDao.getTotal(bmVO);
		return total;
	}	
	public int boardUpd(BoardMasterVO bmVO) {
		logger.info("boardUpd 호출 성공");
		int mresult = 0;
		mresult = boardDao.boardMUpd(bmVO);		
		return mresult;
	}	
	public List<Map<String,Object>> boardList(Map<String, Object> pMap) {
		logger.info("boardList 호출 성공 : "+pMap.get("bm_no"));
		List<Map<String,Object>> boardList = null;
		BoardMasterVO bmVO = new BoardMasterVO();
		total = getTot(bmVO);
		//현재 바라보는 페이지 번호
		int pageNumber = 0;//2
		//한 페이지에 뿌려질 수
		int pageSize = 0;//2
		//시작 번호
		int start = 0;
		//끝 번호
		int end = 0;
		String spageNumber = "";
		/*
		 * VO로 값을 받아서 전달할땐 타입체크를 따로 하지 않아도 되지만
		 * Map으로 받아서 처리할 땐 타입체크를 해야 함.
		 * 조인시에는 Map을 사용하는 것이 좋겠고 (왜냐하면 파라미터에 주소번지 하나만 넘기면 되니깐..)
		 * 테이블이 한  개 경우일땐 VO를 사용하는게 좋을 것이다.
		 */
		if(pMap.get("pageNumber")!=null) {
			spageNumber = pMap.get("pageNumber").toString();
			pageNumber=Integer.parseInt(spageNumber);
		}
		String spageSize = "";
		if(pMap.get("pageSize")!=null) {
			spageSize = pMap.get("pageSize").toString();
			pageSize=Integer.parseInt(spageSize);
		}
		if(pageNumber>0) {
			start = ((pageNumber-1)*pageSize)+1;
			end = pageNumber * pageSize;
			pMap.put("start",start);
			if(end > total) {
				pMap.put("end",total);
			}else {
				pMap.put("end",end);
			}
		}
		logger.info("start:"+start+", end : "+end);
		boardList = boardDao.boardList(pMap);
		//아래 조건은 검색 결과가 한 건인 경우 또는 수정버튼을 눌렀을 때에도 모두 해당되므로
		//조건으로 부적합함.
		int bm_no = 0;
		if(pMap.get("gubun")!=null && "hit".equals(pMap.get("gubun").toString())) {
			if(pMap.containsKey("bm_no")) {
				if(!pMap.isEmpty()) {
					bm_no = Integer.parseInt(pMap.get("bm_no").toString());
				}
			}
			boardDao.hitCount(bm_no);
		}
		return boardList;
	}
	public int boardAdd(Map<String, Object> pMap) {
		logger.info("boardList 호출 성공");
		int bm_no = 0;
		int bm_group  = 0;
		if(pMap.get("bm_group")!=null) {
			bm_group = Integer.parseInt(pMap.get("bm_group").toString());
		}
		int mresult = 0;
		int sresult = 0;
		bm_no = boardDao.getBmno();
		logger.info("새로 채번한 순번:"+bm_no);
		pMap.put("bm_no",bm_no);
		if(bm_group>0) {//너 댓글이니?
			boardDao.bmStepUpdate(pMap);
			int pos = 0;
			int step = 0;
			if(pMap.get("bm_pos")!=null) {
				pos = Integer.parseInt(pMap.get("bm_pos").toString());
			}
			pMap.put("bm_pos",pos+1);
			if(pMap.get("bm_step")!=null) {
				step = Integer.parseInt(pMap.get("bm_step").toString());
			}
			pMap.put("bm_step",pos+1);

		}
		else {//너 새글이지?
			bm_group = boardDao.getBmgroup();
			pMap.put("bm_group",bm_group);
			pMap.put("bm_pos",0);
			pMap.put("bm_step",0);
		}
		//공통 처리부분
		logger.info("글번호:"+pMap.get("bm_no"));
		logger.info("그룹번호:"+pMap.get("bm_group"));
		logger.info("차수:"+pMap.get("bm_pos"));
		logger.info("정렬순서:"+pMap.get("bm_step"));
		mresult = boardDao.boardMAdd(pMap);
		//첨부파일이 있을 때
		if(pMap.get("bs_file")!=null && pMap.get("bs_file").toString().length()>1) {
			pMap.put("bm_no",bm_no);
			sresult = boardDao.boardSAdd(pMap);
		}		
		return mresult;
	}
	public int boardDEL(Map<String, Object> pMap) {
		logger.info("boardDel 호출 성공");
		int result = 0;
		int mresult = 0;
		int sresult = 0;
		String filePath = "D:\\workspace_spring4\\spring5\\src\\main\\webapp\\pds\\";
		//File객체 생성시 경로정보가 필수 이므로 
		String filename = null;
		BoardMasterVO bmVO = new BoardMasterVO();
		BoardSubVO bsVO = new BoardSubVO();
		if(pMap.get("bm_no")!=null) {
			bsVO.setBm_no(Integer.parseInt(pMap.get("bm_no").toString()));
			bsVO.setBs_seq(1);
			bmVO.setBm_no(Integer.parseInt(pMap.get("bm_no").toString()));
		}
		//첨부파일이 있을 때
		if(pMap.get("bs_file")!=null 
		&& pMap.get("bs_file").toString().length()>1) {
			filename = pMap.get("bs_file").toString();
			String fullPath = filePath+filename;
			File file = new File(fullPath);
			if(file.exists()) {//그 파일이 서버에 존재하니?
				boolean isOk = file.delete();
				logger.info("삭제유무:"+isOk);
				int ibm_no = 0;
				sresult = boardDao.boardSDEL(bsVO);			
			}
		}
		//첨부파일이 없을 때
		
		//공통 처리부분
		mresult = boardDao.boardMDEL(bmVO);				
		return mresult;
	}
	public int boardDELALL(Map<String, Object> pMap) {
		logger.info("boardDELALL호출");
		//문자열을 토큰을 기준으로 썰어주는 클래스
		String bmnos = pMap.get("bmnos").toString();
		String bsfiles = pMap.get("bsfiles").toString();
		logger.info("bsfiles:"+bsfiles+", 길이:"+bsfiles.length());
		String bsfileArr[] = null;
		StringTokenizer st = new StringTokenizer(bmnos,",");
		//썰어진 문자열 갯수를 가지고 배열생성
		String emnoArr[] = new String[st.countTokens()];
		for(int i=0;i<emnoArr.length;i++) {
			//배열의 원소갯수만큼 초기화
			emnoArr[i] = st.nextToken();
		}
		int check=0;
		if(bsfiles.length()>0) {
			String filePath = "D:\\workspace_spring4\\spring5\\src\\main\\webapp\\pds\\";
			StringTokenizer st2 = new StringTokenizer(bsfiles,",");
			bsfileArr = new String[st2.countTokens()];
			//첨부파일에 대한 배열 초기화하는 코드
			for(int i=0;i<bsfileArr.length;i++) {
				//배열의 원소갯수만큼 초기화
				bsfileArr[i] = st2.nextToken();
			}
			///////// 첨부파일 삭제 처리하기 //////////
			String fullPath = null;
			for(int i=0;i<bsfileArr.length;i++) {
				fullPath = filePath+bsfileArr[i];
				File file = new File(fullPath);
				if(file.exists()) {//그 파일이 서버에 존재하니?
					boolean isOk = file.delete();
					logger.info("삭제유무:"+isOk);
					check=boardDao.boardSDELALL(emnoArr);			
				}
			}	
			//////// 첨부파일 삭제 처리 끝 /////////////
		}///////////end of if - 첨부파일이 있을 경우 처리
		else {
			check=-1;
		}
		if(check==-1 || check>0) {
			boardDao.boardMDELALL(emnoArr);			
		}
		return 0;
	}

}












