package wlg.javaapi.desginpattern.observer;

public class ObserverMain {
  
  public static void main(String[] args) {
    Subject subject = new TeacherSubject();
    subject.attach(new Stu1Observer());
    subject.attach(new Stu2Observer());
    subject.publish();
  }
  
}
