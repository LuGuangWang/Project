package wlg.javaapi.annotation;


public class AnnotationMain {
  
  public void useAnnotation(@MyAnnotation(value="param") String param){
    System.out.println(param);
  }
  
  public static void main(String[] args) throws Exception {
    AnnotationMain a = new AnnotationMain();
    a.useAnnotation(null);
  }
}
