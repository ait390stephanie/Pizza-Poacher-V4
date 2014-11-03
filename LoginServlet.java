package pizzapoacher.servlet;

import java.io.IOException;

import javax.servlet.http.*;

import pizzapoacher.session.MySession;
import pizzapoacher.session.UserProfile;

@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    String result = null;
    
    try {
      String userEmail =request.getParameter("email");
      String userPassword=request.getParameter("password");
      if (userEmail!=null&&userPassword!=null&&
          userEmail.equals("solson7@gmu.edu")&&userPassword.equals("password")) {
        //fake login
        UserProfile userProfile = new UserProfile("solson7@gmu.edu", "Stephanie", null,"Olson", true);
        MySession.setUserProfile(request.getSession(), userProfile); 
        result = userProfile.toJsonString();
        
      } else {
        throw new RuntimeException("Not implemented yet");
      }
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
