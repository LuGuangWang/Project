package wlg.javaapi.io;

import java.io.ByteArrayInputStream;
import java.io.PushbackInputStream;
 
/**
 * 缓存的新应用之一就是回推（pushback）的实现。回推用于输入流，以允许读取字节，然后再将它们返回（回推）到流中。
 * PushbackInputStream类实现了这一思想，提供了一种机制，可以“偷窥”来自输入流的内容而不对它们进行破坏。
 */
public class PushbackInputStreamDemo {
    public static void main(String[] args) throws Exception {
        String s = "abcdefg";
        /*
         * PushbackInputStream pbin = new PushbackInputStream(in,3)
         * 这个构造函数创建的对象一次可以回推一个缓存
         */
        try (ByteArrayInputStream in = new ByteArrayInputStream(s.getBytes());
                        PushbackInputStream pbin = new PushbackInputStream(in, 3)) {
            byte[] buffer = new byte[3];
            while ((pbin.read(buffer)) != -1) {
                System.out.println(new String(buffer));
                if(new String(buffer).equals("abc"))pbin.unread(new byte[]{'M','N','O'});
                buffer = new byte[3];
            }
        }
    }
}