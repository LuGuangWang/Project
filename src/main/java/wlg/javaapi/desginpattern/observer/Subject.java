package wlg.javaapi.desginpattern.observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {
  public final List<Observer> observers = new ArrayList<>();
  //增加观察者
  abstract void attach(Observer o);
  //减少观察者
  abstract void detach(Observer o);
  //发布通知
  abstract void publish();
}
