package wlg.webapi;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.AbstractJsonpResponseBodyAdvice;

/**
 * 加callback 转 jsonp 支持跨域
 */
@ControllerAdvice(basePackages = "java.wlg.webapi.web")
public class JsonpResponseBodyAdvice extends AbstractJsonpResponseBodyAdvice {
  public JsonpResponseBodyAdvice() {
    super("callback", "jsonp");
  }
}
