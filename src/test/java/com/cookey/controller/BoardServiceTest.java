package com.cookey.controller;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cookey.domain.BoardVO;
import com.cookey.persistence.BoardDAO;
import com.cookey.service.BoardService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class BoardServiceTest {

//	@Inject
//	private BoardDAO dao;
	
	@Inject
	private BoardService service;
	
	@Test
	public void 글쓰기서비스() throws Exception {
		BoardVO vo = new BoardVO();
		vo.setTitle("1번글");
		vo.setContent("1번 글 내용");
		vo.setWriter("작성자");
		
		service.boardCreate(vo);
	}
	
	
	
}
