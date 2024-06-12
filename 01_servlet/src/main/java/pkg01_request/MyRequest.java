package pkg01_request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


public class MyRequest extends HttpServlet {
  
  private static final long serialVersionUID = 1L;

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    System.out.println("doGet()");
    
    int age = Integer.parseInt(request.getParameter("age"));
    
    // TODO Auto-generated method stub
    response.getWriter().append("Served at: ").append("age : " + age);
    
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    System.out.println("doPost()");
    
    // doGet() 메소드 호출
    doGet(request, response);
    
  }

}
