package pizzapoacher.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pizzapoacher.session.MySession;
import pizzapoacher.session.UserProfile;

@SuppressWarnings("serial")
public class GetUserInfoServlet extends HttpServlet {
  public void doGet(HttpServletRequest request, HttpServletResponse resp)
      throws IOException {
    try {
      UserProfile userProfile = MySession.getUserProfile(request.getSession());
      
      String callback=request.getParameter("callback");
      resp.setContentType("application/json");
      resp.getWriter().println(callback+"("+userProfile.infoToJsonString()+");");
    } catch(Exception e) {
      resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
    }
  }

}
