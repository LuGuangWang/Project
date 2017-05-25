package wlg.test;

public class NewTest2 {
  
  public static void main(String[] args) {
    System.out.println(testReturn());
    
//    testCycle();
  }

  static int testReturn() {
    int s = 1;
    try{
      return s;
    }finally{
      s = 2;
    }
  }

  static void testCycle() {
    for(int i = 0;i<3;i++){
      while(i<2){
        System.out.println("j:" + i);
        break;
      }
      System.out.println("i:" + i);
    }
  }
}
