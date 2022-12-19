package com.cookey.service;

import java.util.List;

import com.cookey.controller.Criteria;
import com.cookey.domain.BoardVO;

public interface BoardService {
	
	public void boardCreate(BoardVO vo) throws Exception;
	
	// 게시글 목록 조회
	public List<BoardVO> getBoardListAll(Criteria cri) throws Exception;
	
	// 게시물 총 갯수
	public int listCount() throws Exception;
	
	public BoardVO readBoard(Integer bno) throws Exception;
	
	public void updateBoard(BoardVO vo) throws Exception;
	
	public void deleteBoard(Integer bno) throws Exception;
	
	public void updateBoardCount(Integer bno) throws Exception;
	
	}
