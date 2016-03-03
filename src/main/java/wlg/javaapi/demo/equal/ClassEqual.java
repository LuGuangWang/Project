package wlg.javaapi.demo.equal;

public class ClassEqual {

  public static void main(String[] args) {
    Property classA = new Property("W");
    Property classB = new Property("W");
    
    if(classA.equals(classB)){
      System.out.println("同一对象："+classA.hashCode()+"/"+classB.hashCode()+"/"+classA+"/"+classB);
    }else{
      System.out.println("不同对象："+classA.hashCode()+"/"+classB.hashCode()+"/"+classA+"/"+classB);
    }
    
    if(classA == classB){
      System.out.println("同一对象："+classA.hashCode()+"/"+classB.hashCode()+"/"+classA+"/"+classB);
    }else{
      System.out.println("不同对象："+classA.hashCode()+"/"+classB.hashCode()+"/"+classA+"/"+classB);
    }
  }

}
