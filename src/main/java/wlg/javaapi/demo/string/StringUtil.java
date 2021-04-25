package wlg.javaapi.demo.string;

public class StringUtil {

  //去除所有非汉字
  static void replaceChinese(){
    String str = "*%hell^你好12）（";
    str = str.replaceAll("[^\u4E00-\u9FA5]", "");
    System.out.println(str);
  }
  //是否是中文
  static boolean isChinese(String str){
    return str.replaceAll("[\u4E00-\u9FA5]*", "").length()==0;
  }
  
  //split
  static void splitStr(){
    String str = "TECH00112/李小双";
    String[] strs = str.split("/");
    for(String s:strs){
      if(isChinese(s)){
        System.out.println("chinese name:"+s);
      }else
        System.out.println("code:"+s);
    }
  }
  
  //去string中的.000
  static void replaceSpot(){
    String str = "8.000";
    System.out.println("小数："+str.replaceAll("\\.0*$", ""));
  }
  
  static void replaceKuohao(){
    String str = "你好（d)";
    str = str.replaceAll("\\(", "_").replaceAll("\\)", "_").replaceAll("\\（", "_").replaceAll("\\）", "_");
    System.out.println("----"+str);
  }
  
  //比较字符查差值
  static void compareValue(){
    String day1 = "2015-10-11";
    String day2 = "2015-11-1";
    System.out.println("差值："+day2.compareTo(day1));
  }
  
  static void matchDate(){
    String d = "2016-3-1至2016-5-28周一至周六上课周一至周六上课";
    String week = d.replaceFirst("^\\d+-\\d+-\\d+至\\d+-\\d+-\\d+","");
    String date = d.substring(0, d.length()-week.length());
    System.out.println("week:"+week);
    System.out.println("date:"+date);
  }
  
  static void matchTO(){
    String str = "2016.6.6-2016.7.1周一至周五9:00-12:00,13:30-16:30,17:30-20:30";
    String result = str.substring(0, str.length()-str.replaceFirst("^\\d+\\.\\d+\\.\\d+-\\d+\\.\\d+\\.\\d+", "").length());
    System.out.println("this result is matched:"+result);
  }
  
  public static void main(String[] args) {
//    replaceKuohao();
//    compareValue();
//    replaceChinese();
//    splitStr();
    isChinese("");
//    replaceSpot();
//    matchDate();
  }

}
