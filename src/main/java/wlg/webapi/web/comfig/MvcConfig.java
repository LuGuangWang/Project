package wlg.webapi.web.comfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("security/home");
        registry.addViewController("/").setViewName("security/home");
        registry.addViewController("/hello").setViewName("security/hello");
        registry.addViewController("/login").setViewName("security/login");
    }
}