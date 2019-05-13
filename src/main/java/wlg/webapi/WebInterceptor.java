package wlg.webapi;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 处理跨域
 */
public class WebInterceptor implements HandlerInterceptor {
  private Logger log = LoggerFactory.getLogger(WebInterceptor.class);

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {
	log.info("===========test");  
	  
    // 处理跨域问题 有安全隐患
    response.setHeader("X-Frame-Options", "ALLOW-FROM");
    //添加add_header时，需要指定always，否则当接口4xx和5xx时，浏览器依旧会报跨域问题
    response.setHeader("Access-Control-Allow-Origin", "* always");
    response.setHeader("Access-Control-Allow-Headers",
                       "Origin, X-Requested-With, Content-Type, Accept");
    return true;
  }

  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
      ModelAndView modelAndView) throws Exception {
    // log.debug("interceptor  postHandle---------------------->");
  }

  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
      Object handler, Exception ex) throws Exception {
    // log.debug("interceptor  afterCompletion---------------------->");
  }
}
