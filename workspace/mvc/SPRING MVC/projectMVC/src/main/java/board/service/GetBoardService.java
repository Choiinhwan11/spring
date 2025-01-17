package board.service;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.control.CommandProcess;

import board.bean.BoardDTO;
import board.dao.BoardDAO;

public class GetBoardService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse reponse) throws Throwable {
		int seq = Integer.parseInt(request.getParameter("seq"));
		
		//DB
		BoardDAO boardDAO = BoardDAO.getInstance();
		BoardDTO boardDTO = boardDAO.getBoard(seq);
		
		//BoardDTO  => JSON으로 변환 (ajax는 객체를 읽을 수 없다..)
		JSONObject json = new JSONObject();	// json {} 생성
		
		json.put("seq", boardDTO.getSeq());
		json.put("id", boardDTO.getId());
		json.put("name", boardDTO.getName());
		json.put("email", boardDTO.getEmail());
		json.put("subject", boardDTO.getSubject());
		json.put("content", boardDTO.getContent());
		json.put("ref", boardDTO.getRef());
		json.put("lev", boardDTO.getLev());
		json.put("step", boardDTO.getStep());
		json.put("pseq", boardDTO.getPseq());
		json.put("reply", boardDTO.getReply());
		json.put("hit", boardDTO.getHit());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
		json.put("logtime", sdf.format(boardDTO.getLogtime()));	//Date => String 변환
		
		request.setAttribute("json", json);
		
		return "getBoard.jsp";
	}

}
