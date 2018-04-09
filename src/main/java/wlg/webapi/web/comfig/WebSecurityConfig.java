package wlg.webapi.web.comfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//@Configuration
//@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
  @Override
  protected void configure(HttpSecurity http) throws Exception {
//    http.antMatcher("/**")
//        .authorizeRequests()
//        .anyRequest()
////        .antMatchers("/**").hasRole("USER");//指定用户访问地址
//        .authenticated()
//        .and()
//        .formLogin()
//        .loginPage("/login")
//        .permitAll()
//        .and()
//        .logout()
//        .permitAll();
//    http.csrf().disable();
  }

  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//    auth.inMemoryAuthentication().withUser("user").password("password").roles("USER");
  }
}
