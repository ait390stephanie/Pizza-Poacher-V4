package pizzapoacher.servlet;

import java.io.IOException;

import javax.servlet.http.*;

import pizzapoacher.session.MySession;

@SuppressWarnings("serial")
public class LogoutServlet extends HttpServlet {
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    String result = null;
    
    try {
      MySession.logout(request);
      result="OK";
      response.addHeader("Access-Control-Allow-Origin", "*");
      response.setContentType("application/json");
      response.getWriter().println(result);
    } catch(Exception e) {
      e.printStackTrace();
      response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
      response.getWriter().println(e.getMessage());
    }
  }
}
