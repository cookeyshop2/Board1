package com.cookey.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cookey.domain.BoardVO;
import com.cookey.domain.ReplyVO;
import com.cookey.service.BoardService;
import com.cookey.service.ReplyService;

@Controller
@RequestMapping("/board/*")
public class BoardController {

	private static final Logger log 
	   = LoggerFactory.getLogger(BoardController.class);
	
	// 서비스 객체 주입
	@Inject
	private BoardService service;
	
	// 댓글 서비스 객체 주입
	@Inject
	private ReplyService replyService;
	
	// 글쓰기 - GET
	// http://localhost:8088/board/register
	@RequestMapping(value = "/register",method = RequestMethod.GET)
	public void registerGET() throws Exception {
		log.info(" registerGET() 호출 ");
		
	}
	
	// 글쓰기 - POST
	@RequestMapping(value = "/register",method = RequestMethod.POST)
	public String registerPOST(BoardVO vo,RedirectAttributes rttr) throws Exception {
		log.info(" registerPOST() 호출 ");
		// 한글처리 (=> web.xml 필터로 처리) 
		// 전달된 정보 저장(글쓰기 정보)
		log.info(" 글쓰기 정보 : "+vo);
		
		// 서비스 동작 호출
		service.boardCreate(vo);
		log.info(" 글쓰기 완료! ");
		// 정보를 전달
		rttr.addFlashAttribute("result", "REGOK");		
		
		//return "/board/success";
		//return "redirect:/board/listAll?msg=ok";
		return "redirect:/board/listAll";
	}
	
	// http://localhost:8088/board/listAll
	// 글 리스트 - GET
	@RequestMapping(value = "/listAll",method = RequestMethod.GET)
	public String listAllGET(Model model, Criteria cri,
			HttpSession session) throws Exception {
		log.info(" listAllGET() 호출 ");
		
		// 디비에 저장되어 있는 모든 글정보를 가져와서
		// => 서비스 동작
		List<BoardVO> boardList = service.getBoardListAll(cri);
		//log.info(boardList+"");
		
		session.setAttribute("upFlag", "1"); // 0-false,1-true

		// 연결된 뷰페이지에 출력
		model.addAttribute("boardList", boardList);
		model.addAttribute("list", service.getBoardListAll(cri));
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.listCount());
		
		model.addAttribute("pageMaker", pageMaker);
		
		return "/board/listAll";
		
	}
	
	
	// http://localhost:8088/board/read?bno=1
	// 글 본문 보기 + // 글 조회수 증가
	@RequestMapping(value = "/read",method = RequestMethod.GET)
	//public void readGET(@ModelAttribute("bno") int bno) {
	public void readGET(@RequestParam("bno") int bno,Model model,
			HttpSession session) throws Exception {
		// @RequestParam => request.getParameter("이름");
		//  -> 유사한 동작을 수행(문자열,숫자,날짜 자동형 변환)
		log.info(" readGET() 호출 ");
		log.info(" bno : "+bno);
		
		//session.setAttribute("upFlag", "1"); // 0-false,1-true
		
		String upFlag = (String)session.getAttribute("upFlag");
		
		if( upFlag.equals("1") ) {
			// 글 조회수 1증가
			service.updateBoardCount(bno);
			session.setAttribute("upFlag", "0");			
		}
		
		// 글 번호를 가지고 서비스 - 글정보 가져오기 동작 호출
		BoardVO vo = service.readBoard(bno);
		//log.info(vo+"");
		// 가져온 데이터를  연결된 뷰페이지에 출력	
		model.addAttribute("vo", vo);
		
		// 댓글 조회
		List<ReplyVO> reply = null;
		reply = replyService.list(bno);
		model.addAttribute("reply", reply);
		
//		model.addAttribute("vo", service.readBoard(bno));
//		model.addAttribute(service.readBoard(bno));
		
	}
	
	// http://localhost:8088/board/modify?bno=4
	// 글 수정하기 (수정할 정보를 가져와서 view 페이지 출력)
	@RequestMapping(value = "/modify",method = RequestMethod.GET)
	public void modifyGET(@RequestParam("bno") int bno,Model model)  throws Exception{
		log.info(" modifyGET() 호출 ");
		
		log.info(" 수정할 글 번호 : "+bno);
		
		// bno에 해당하는 글정보를 가져와서 처리(서비스)
		model.addAttribute("uvo", service.readBoard(bno));	
	}
	
	// 글 수정하기(수정할 정보를 전달받아서 DB에 수정)
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyPOST(BoardVO vo,RedirectAttributes rttr) throws Exception {
		log.info(" modifyPOST() 호출 ");
		// 전달된 데이터 저장 (수정 데이터)
		// 확인
		//log.info(vo+"");
		
		// 전달받은 객체정보를 사용하여 데이터 수정 (서비스)
		service.updateBoard(vo);	
		
		// 처리 결과값을 전달
		rttr.addFlashAttribute("result", "MODOK");		
		
		return "redirect:/board/listAll";
	}
	
	
	// http://localhost:8088/board/remove
	// 글 삭제
	@RequestMapping(value="/remove",method = RequestMethod.POST)
	public String removePOST(@RequestParam("bno") int bno,RedirectAttributes rttr)throws Exception {
		// 전달된 정보 저장(bno)
		log.info("bno : "+bno);
		
		// bno를 사용하여 서비스-글삭제 
		service.deleteBoard(bno);
		//		service.deleteB(null); 에러 발생 호출
		
		// "글 삭제 완료" 메세지 출력 페이지 이동	
		rttr.addFlashAttribute("result", "DELOK");
		
		return "redirect:/board/listAll";		
	}
	
	
	
	
	
	
	
	

	
}
