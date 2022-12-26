package com.cookey.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.cookey.controller.Criteria;
import com.cookey.domain.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO {

	private static final Logger log 
	   = LoggerFactory.getLogger(BoardDAOImpl.class);

	// 디비연결 및 mapper 연결처리 객체 
	@Inject
	private SqlSession sqlSession;
	
	static final String NAMESPACE="com.cookey.mapper.BoardMapper";
	
	
	@Override
	public void create(BoardVO vo) throws Exception {
		log.info(" 정보 전달받아서 mapper 호출 ");
		// 정보 전달받아서 mapper를 거쳐서 DB에 저장
		//sqlSession.insert("com.cookey.mapper.BoardMapper.createBoard", vo);
		sqlSession.insert(NAMESPACE+".createBoard", vo);
		
		log.info(" mapper에서 처리 후 이동 ");		
	}

	 // 게시물 목록 조회
	@Override
	public List<BoardVO> listAll(Criteria cri) throws Exception {
		log.info(" listAll() 호출 ");
		// mapper 해당 sql 호출
		//return sqlSession.selectList(NAMESPACE+".listAll");
		
		List<BoardVO> boardList = sqlSession.selectList(NAMESPACE+".listAll", cri);
		
		return boardList;
	}

	// 게시물 총 갯수
	@Override
	public int listCount() throws Exception {
		return sqlSession.selectOne(NAMESPACE+".listCount");
	}

	@Override
	public BoardVO getBoard(Integer bno) throws Exception {
		// mapper에 있는 sql 호출
		BoardVO vo = sqlSession.selectOne(NAMESPACE+".getBoard", bno);
		
		return vo;
	}

	@Override
	public void updateBoard(BoardVO VO) throws Exception {
		// mapper - sql 호출
		sqlSession.update(NAMESPACE+".updateBoard", VO);
		
	}

	@Override
	public void removeBoard(Integer bno) throws Exception {
		
		sqlSession.delete(NAMESPACE+".deleteBoard", bno);
		
	}


	@Override
	public void updateBoardCnt(Integer bno) throws Exception {
		sqlSession.update(NAMESPACE+".updateBoardCnt",bno);
	}

}
