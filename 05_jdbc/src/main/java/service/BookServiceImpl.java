package service;

import common.ActionForward;
import dao.BookDAO;
import jakarta.servlet.http.HttpServletRequest;

public class BookServiceImpl implements BookService {

  // Field
  private BookDAO bookDAO = BookDAO.getInstance();
  
  @Override
  public ActionForward getBooks(HttpServletRequest request) {
    
    // 데이터베이스에서 가져온 List<BookDTO> 을 JSP 로 보내기 위해서 request 에 저장한 뒤 forward 한다.
    
    request.setAttribute("books", bookDAO.getBooks());
    
    return new ActionForward("/book/list.jsp", false);
    
  }

  @Override
  public ActionForward getBookByNo(HttpServletRequest request) {
    
    // 전달된 bookNo 와 일치하는 책 정보를 데이터베이스로부터 가져와서 JSP 로 전달하기 위해 request 에 저장한 뒤 forward 한다.
    
    int bookNo = Integer.parseInt(request.getParameter("bookNo"));
    
    request.setAttribute("book", bookDAO.getBookByNo(bookNo));
    
    return new ActionForward("/book/detail.jsp", false);
    
  }

}
