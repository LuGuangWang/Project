package wlg.test;

import java.util.HashMap;
import java.util.Map;

/**
 * 字符串模式匹配。有一个字符串(由词加空格组成)
 * 如"桃子 苹果 苹果 桃子"， 输入一个匹配模式，
 * 比如 cffc, 来判断该字符串是否符合该模式。
 * <p>
 * 1. pattern = "cffc", str="桃子 苹果 苹果 桃子" 返回 ture
 * 2. pattern = "ccff", str="桃子 苹果 苹果 桃子" 返回 false
 * 3. pattern = "fccf", str="苹果 桃子 桃子 苹果" 返回 ture
 */
public class PatternStrTool {
    public static void main(String[] args) {
        String str = "桃子 苹果 苹果 桃子";
        String pattern = "ccf";
        boolean flag = isPattern(str, pattern);
        System.out.println("is pattern:" + flag);
    }

    private static boolean isPattern(String str, String pattern) {
        boolean flag = false;
        Map<String, Character> dic = new HashMap<>();

        if (str != null && str.length() > 0) {
            String[] words = str.split(" ");
            if(words.length==pattern.length()){
                for (int i = 0; i < words.length; i++) {
                    char old = dic.merge(words[i], pattern.charAt(i), (oldVal, newVal) -> {
                        return oldVal;
                    });

                    flag = old == pattern.charAt(i);

                    if (!flag) {
                        break;
                    }
                }
            }
        }
        return flag;
    }


}
