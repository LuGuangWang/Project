package wlg.arithmetic;

/**
 * 字符串处理，去掉开头，结尾的空格,
 * 中间的空格合成一个,要求只遍历一遍。
 * 如：输入”hello   word “ ，输出“hello word”。
 */
public class GetStrWord {
    public static void main(String[] args) {
        String s = "hello   word  ";
        char[] chrs = s.toCharArray();
        StringBuilder res = new StringBuilder();
        String ress = null;

        res.append(' ');
        for(int i=0;i<chrs.length;i++){
            if(chrs[i] != ' '){
                res.append(chrs[i]);
            }else if(res.charAt(res.length()-1) != chrs[i]){
                res.append(chrs[i]);
            }
        }

        if(res.length()>1 && res.charAt(res.length()-1) == ' '){
            ress = res.substring(1,res.length()-1);
        }else{
            ress = res.substring(1,res.length());
        }

        System.out.println(ress);
    }
}
