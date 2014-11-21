package java63.servlets.test01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

/* 웹 브라우저에게 출력하기
 * 
 * ServletRequest => 요청 정보를 다루는 도구함
 * ServletResopnse => 응답 정보를 다루는 도구 
 */
@WebServlet("/test01/Test01")
public class Test01 extends GenericServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(ServletRequest reqeuest, ServletResponse response)
      throws ServletException, IOException {
 
    //1.ServletRespones 도구를 사용하여 출력 스트림을 준비한다.
    PrintWriter out = response.getWriter();
    //2. 출력 스트림을 사용하여 웹 브라우저로 출력한다.
    out.println("아하 ~~ 안녕하세요 Hello 콘니찌와. 부네지와~");
  }
  

}
