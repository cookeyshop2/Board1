package com.cookey.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cookey.domain.ReplyVO;
import com.cookey.service.ReplyService;

@Controller
@RequestMapping("/reply/*")
public class ReplyController {
	
	@Inject
	private ReplyService service;
	
	// 댓글 작성
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String posttWrite(ReplyVO vo) throws Exception {
		
		service.write(vo);
		
		return "redirect:/board/read?bno=" + vo.getBno();
	}

}