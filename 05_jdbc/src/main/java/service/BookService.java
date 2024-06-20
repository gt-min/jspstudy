package service;

import common.ActionForward;
import jakarta.servlet.http.HttpServletRequest;

public interface BookService {
  ActionForward getBooks(HttpServletRequest request);
  ActionForward getBookByNo(HttpServletRequest request);
  
}
