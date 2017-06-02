package wlg.apiutil;

import java.util.regex.Pattern;

public class XssUtil {
  
  String stripXSS(String value) {
    if (value != null && value.length() > 0) {
      // Avoid anything between script tags
      Pattern scriptPattern = Pattern.compile("<script>(.*?)</script>", Pattern.CASE_INSENSITIVE);
      value = scriptPattern.matcher(value).replaceAll("");
      // Avoid anything in a
      // e­xpression
      scriptPattern = Pattern.compile("src[\r\n]*=[\r\n]*\\\'(.*?)\\\'",
                                      Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
      value = scriptPattern.matcher(value).replaceAll("");
      scriptPattern = Pattern.compile("src[\r\n]*=[\r\n]*\\\"(.*?)\\\"",
                                      Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
      value = scriptPattern.matcher(value).replaceAll("");
      // Remove any lonesome </script> tag
      scriptPattern = Pattern.compile("</script>", Pattern.CASE_INSENSITIVE);
      value = scriptPattern.matcher(value).replaceAll("");
      // Remove any lonesome <script ...> tag
      scriptPattern = Pattern.compile("<script(.*?)>", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE
                                                       | Pattern.DOTALL);
      value = scriptPattern.matcher(value).replaceAll("");
      // Avoid eval(...) e­xpressions
      scriptPattern = Pattern.compile("eval\\((.*?)\\)",
                                      Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
      value = scriptPattern.matcher(value).replaceAll("");
      // Avoid e­xpression(...) e­xpressions
      scriptPattern = Pattern.compile("e­xpression\\((.*?)\\)",
                                      Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
      value = scriptPattern.matcher(value).replaceAll("");
      // Avoid javascript:... e­xpressions
      scriptPattern = Pattern.compile("javascript:", Pattern.CASE_INSENSITIVE);
      value = scriptPattern.matcher(value).replaceAll("");
      // Avoid vbscript:... e­xpressions
      scriptPattern = Pattern.compile("vbscript:", Pattern.CASE_INSENSITIVE);
      value = scriptPattern.matcher(value).replaceAll("");
      // Avoid onload= e­xpressions
      scriptPattern = Pattern.compile("onload(.*?)=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE
                                                      | Pattern.DOTALL);
      value = scriptPattern.matcher(value).replaceAll("");

    }
    return value;
  }
}
