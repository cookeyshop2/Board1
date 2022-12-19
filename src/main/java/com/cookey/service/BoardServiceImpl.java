package com.cookey.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.cookey.controller.Criteria;
import com.cookey.domain.BoardVO;
import com.cookey.persistence.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService {
	
	// DAO 객체 주입
	@Inject
	private BoardDAO dao;

	@Override
	public void boardCreate(BoardVO vo) throws Exception {
		dao.create(vo);
	}

	// 게시물 목록 조회
	@Override
	public List<BoardVO> getBoardListAll(Criteria cri) throws Exception {
		List<BoardVO> boardList = dao.listAll(cri);
		
		return boardList;
	}
	
//	// 게시물 목록 조회
//	@Override
//	public List<BoardVO> getBoardListAll(Criteria cri) throws Exception {
//		return dao.listAll(cri);
//	}
	
	// 게시물 총 갯수
	@Override
	public int listCount() throws Exception {
		return dao.listCount();
	}

	@Override
	public BoardVO readBoard(Integer bno) throws Exception {
		BoardVO vo = dao.getBoard(bno);
		
		return vo;
	}

	@Override
	public void updateBoard(BoardVO vo) throws Exception {
		dao.updateBoard(vo);		
	}

	@Override
	public void deleteBoard(Integer bno) throws Exception {
		dao.removeBoard(bno);
	}

	@Override
	public void updateBoardCount(Integer bno) throws Exception {
		dao.updateBoardCnt(bno);
	}

}
