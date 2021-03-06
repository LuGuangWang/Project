package wlg.webapi.web.comfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import wlg.webapi.WebInterceptor;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
    registry.addViewController("/home").setViewName("security/home");
    registry.addViewController("/").setViewName("security/home");
    registry.addViewController("/hello").setViewName("security/hello");
    registry.addViewController("/login").setViewName("security/login");
  }
  
  @Override
  public void addInterceptors(InterceptorRegistry registry) {
	  registry.addInterceptor(new WebInterceptor());
	  super.addInterceptors(registry);
  }
}
