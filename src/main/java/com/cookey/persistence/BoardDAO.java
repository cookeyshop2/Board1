package com.cookey.persistence;

import java.util.List;

import com.cookey.controller.Criteria;
import com.cookey.domain.BoardVO;

public interface BoardDAO {
	
	// 글쓰기 (create)
	public void create(BoardVO vo) throws Exception;
	
	// 글 리스트 (select - list)
	public List<BoardVO> listAll(Criteria cri) throws Exception;
	
	// 게시물 총 개수
	public int listCount() throws Exception;
	
	// 글 내용 (select - read)
	public BoardVO getBoard(Integer bno) throws Exception;
	
	// 글 수정 (update)
	public void updateBoard(BoardVO VO) throws Exception;
	
	// 글 삭제 (delete)
	public void removeBoard(Integer bno) throws Exception;
	
	// 글 조회수 1증가
	public void updateBoardCnt(Integer bno) throws Exception;
		
}
