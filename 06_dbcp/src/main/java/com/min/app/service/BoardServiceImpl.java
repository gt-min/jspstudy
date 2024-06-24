package com.min.app.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.min.app.common.ActionForward;
import com.min.app.dao.BoardDAO;
import com.min.app.dao.BoardDAOImpl;
import com.min.app.dto.BoardDTO;
import com.min.app.utils.PageUtils;

import jakarta.servlet.http.HttpServletRequest;

public class BoardServiceImpl implements BoardService {

  // Field
  private BoardDAO boardDAO = BoardDAOImpl.getInstance();
  private PageUtils pageUtils = new PageUtils();
  
  @Override
  public ActionForward getBoardList(HttpServletRequest request) {
    
    // PageUtils's total
    int total = boardDAO.getBoardCount();
    
    // PageUtils's display
    Optional<String> optDisplay = Optional.ofNullable(request.getParameter("display"));
    int display = Integer.parseInt(optDisplay.orElse("20"));
    
    // PageUtils's page
    Optional<String> optPage = Optional.ofNullable(request.getParameter("page"));
    int page = Integer.parseInt(optPage.orElse("1"));
    
    // PageUtils' begin / end 계산
    pageUtils.setPaging(total, display, page);
    
    // sort
    Optional<String> optSort = Optional.ofNullable(request.getParameter("sort"));
    String sort = optSort.orElse("DESC");
    
    // 데이터베이스로 보낼 Map<String, Object> params 생성
    Map<String, Object> params = new HashMap<String, Object>();
    params.put("begin", pageUtils.getBegin());
    params.put("end", pageUtils.getEnd());
    params.put("sort", sort);
    
    // 데이터베이스에서 목록 가져오기
    List<BoardDTO> boardList = boardDAO.getBoardList(params);
    
    // registerBoard() 실행 이후인 경우, /board/list.jsp 로 성공/실패 메시지를 전달함
    if(request.getParameter("register") != null) {
      request.setAttribute("registerMessage", request.getParameter("register").equals("1") ? "게시글 추가 성공" : "게시글 추가 실패");
    }
    
    // /board/list.jsp 로 보낼 데이터 저장하기
    request.setAttribute("total", total);
    request.setAttribute("boardList", boardList);
    request.setAttribute("sort", sort);
    request.setAttribute("display", display);
    request.setAttribute("paging", pageUtils.getPaging(request.getRequestURI(), sort, display));
    
    // SELECT 이후에는 forward 로 이동한다.
    return new ActionForward("/board/list.jsp", false);
    
  }

  @Override
  public ActionForward getBoardByNo(HttpServletRequest request) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ActionForward registerBoard(HttpServletRequest request) {
    
    // 요청 파라미터
    String title = request.getParameter("title");
    String contents = request.getParameter("contents");
    
    // 데이터베이스로 전달할 BoardDTO 객체 생성
    BoardDTO board = BoardDTO.builder()
        .title(title)
        .contents(contents)
        .build();
    
    // 데이터베이스에 추가하기
    int result = boardDAO.insertBoard(board);
    
    // /board/list.jsp 로 redirect 이동하기
    return new ActionForward(request.getContextPath() + "/list.do?register=" + result, true);
    
  }

  @Override
  public ActionForward modifyBoard(HttpServletRequest request) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ActionForward removeBoard(HttpServletRequest request) {
    // TODO Auto-generated method stub
    return null;
  }

}
