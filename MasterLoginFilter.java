package pizzapoacher.session;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;


public class MasterLoginFilter implements Filter {

  /** The filter configuration. */
  private FilterConfig filterConfig;

  /** Process the filter request. If an admin is not logged redirect the request to the login page. If the user has no rights for the  operation report invalid access. */
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException,
      ServletException {
    // check if it is in a current session with the client
    if (!MySession.isMasterLogged(request)) {
      ((HttpServletResponse) response).sendRedirect("/guest/main.html#/login");
      return;
    }

    filterChain.doFilter(request, response);
  }

  /**
   * Return the current filter configuration.
   * @return a FilterConfig with the configuration.
   */
  public FilterConfig getFilterConfig() {
    return filterConfig;
  }

  /** Initialize the current filter configuration. */
  public void init(FilterConfig filterConfig) {
    this.filterConfig = filterConfig;
  }

  /** Destroy the filter */
  public void destroy() {}
}
