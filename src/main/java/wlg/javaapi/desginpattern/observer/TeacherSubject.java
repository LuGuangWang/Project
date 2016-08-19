package wlg.javaapi.desginpattern.observer;

public class TeacherSubject extends Subject {

  @Override
  void attach(Observer o) {
    observers.add(o);
  }

  @Override
  void detach(Observer o) {
    observers.remove(o);
  }

  @Override
  void publish() {
    for(int i=0;i<observers.size();i++){
      observers.get(i).update();
    }
  }


}
