package board.service;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import board.dao.BoardDAO;

public class BoardDeleteService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse reponse) throws Throwable {
		System.out.println("BoardDeleteService class 도착");
		
		//데이터
		int seq = Integer.parseInt(request.getParameter("seq"));
	
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.deleteBoard(seq);
		
		System.out.println("BoardDeleteService return 전 도착");
		
		return "/board/boardDelete.jsp";
	}

}
