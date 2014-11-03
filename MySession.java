package pizzapoacher.session;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class MySession {

  // SECURITY
  /**. Private constructor to avoid instantiation.  */
  private MySession() {}

  // ADMIN PROFILE
  private static String USER_PROFILE = "user-profile";

  public static UserProfile getUserProfile(HttpSession session) {
    return (UserProfile) session.getAttribute(USER_PROFILE);
  }

  public static void setUserProfile(HttpSession session, UserProfile userProfile) {
    session.setAttribute(USER_PROFILE, userProfile);
  }

   // USER CHECK
  public static boolean isUserLogged(ServletRequest request) {
    HttpSession session = null;
    if (request instanceof HttpServletRequest) {
      session = ((HttpServletRequest) request).getSession();
    }
    synchronized (session) {
      UserProfile userProfile = getUserProfile(session);
      if (userProfile != null)
        return true;
    }
    return false;
  }

  // MASTER CHECK
  public static boolean isMasterLogged(ServletRequest request) {
    HttpSession session = null;
    if (request instanceof HttpServletRequest) {
      session = ((HttpServletRequest) request).getSession();
    }
    if (session==null) {
      return false;
    }
    synchronized (session) {
      UserProfile userProfile = getUserProfile(session);
      if (userProfile != null&&userProfile.isMaster())
        return true;
    }
    return false;
  }
  
    //  LOGOUT  
  public static boolean logout(ServletRequest request) {
    HttpSession session = null;
    if (request instanceof HttpServletRequest) {
      session = ((HttpServletRequest) request).getSession();
    }
    if (session==null)
      return false;
    synchronized (session) {
      session.removeAttribute(USER_PROFILE);
    }
    return true;
  }

}
