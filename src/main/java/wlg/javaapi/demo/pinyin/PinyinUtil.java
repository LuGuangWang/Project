package wlg.javaapi.demo.pinyin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

import com.google.common.base.Verify;

/**
 * 目前使用Pinyin4j用来获取一个汉语句子（这里的句子泛指多个汉字的组合）的拼音。
 */
public class PinyinUtil {
  private static HanyuPinyinOutputFormat format;

  /**
   * 多音字到XDF术语拼音的对照表。把多音字的在XDF对应的拼音加到这里。
   */
  public final static Map<Character, String> xdfZi;

  static {
    xdfZi = new HashMap<>();
    xdfZi.put('无', "wu");
  }

  static {
    format = new HanyuPinyinOutputFormat();
    format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
    format.setVCharType(HanyuPinyinVCharType.WITH_V);
  }
  
  /**
   * 获取一个句子在XDF的读音。
   */
  public static JuziPinyin xdfJuziToPy(String juzi) {
    List<JuziPinyin> pys = juziToPys(juzi, xdfZi);
    Verify.verify(pys.size() == 1, "'%s' has more than one pinyin: %s", juzi, pys);
    return pys.get(0);
  }
  
  /**
   * 获取一个句子在XDF的读音简写。
   */
  public static String xdfJuziToAcronym(String juzi) {
    return xdfJuziToPy(juzi).toAcronym();
  }

  /**
   * 获取一个句子的读音。
   */
  public static List<JuziPinyin> juziToPys(String juzi) {
    return juziToPys(juzi, null);
  }

  /**
   * 获取一个汉语句子对应的汉语拼音。因为汉语有多音字， 汉语拼音可能为多个。
   * 
   * @param juzi 汉语句子
   * @parm map 汉字到指定拼音的对照表
   * @return 对应的汉语拼音
   */
  public static List<JuziPinyin> juziToPys(String juzi, Map<Character, String> map) {
    List<String> seq = new ArrayList<>();
    List<JuziPinyin> table = new ArrayList<>();
    juziToPys(juzi, 0, seq, table, map);
    Verify.verify(table.size() > 0, "No pinyin is found for '%s'", juzi);
    return table;
  }

  /**
   * 获取一个汉字的拼音。
   * 
   * @param zi 汉字
   * @param map 汉字到指定拼音的对照表
   * @return 对应的汉语拼音
   */
  public static List<String> ziToPys(char zi, Map<Character, String> map) {
    if (map == null) return ziToPys(zi);
    String pinyin = map.get(zi);
    if (pinyin != null) return Arrays.asList(pinyin);
    return ziToPys(zi);
  }

  /**
   * 获取一个汉字的拼音。因为汉语有多音字， 汉语拼音可能为多个。如果字符{@code zi}不是一个汉字，直接返回{@code zi}本身。
   */
  public static List<String> ziToPys(char zi) {
    String[] array;
    try {
      array = PinyinHelper.toHanyuPinyinStringArray(zi, format);
      if (array == null) return Arrays.asList(String.valueOf(zi));
      List<String> pys = Arrays.asList(array);
      /*
       * Pinyin4j does not remove dupicates even if HanyuPinyinToneType.WITHOUT_TONE is specified.
       * For example, it returns [hao3, hao4] for 好 with tone. It returns [hao, hao] without tone.
       */
      return pys.stream().distinct().collect(Collectors.toList());
    } catch (BadHanyuPinyinOutputFormatCombination e) {
      throw new RuntimeException(e);
    }
  }
  
  /**
   * 获取一个句子的拼音缩写。
   * 
   * @param juzi 汉语句子
   * @param py  对饮的汉语拼音
   */
  public static String juziToAcronym(String juzi, String py) {
    return juziToAcronym(juzi, py, null);
  }
  
  /**
   * 获取一个句子的拼音缩写。
   * 
   * @param juzi 汉语句子
   * @param py  对饮的汉语拼音
   * @parm map 汉字到指定拼音的对照表
   */
  public static String juziToAcronym(String juzi, String py, Map<Character, String> map) {
    for (JuziPinyin item : juziToPys(juzi, map))
      if (item.toPinyin().equals(py)) return item.toAcronym();
    return null;
  }

  private static void juziToPys(String juzi, int idx, List<String> seq, List<JuziPinyin> table,
      Map<Character, String> map) {
    if (idx == juzi.length()) {
      List<String> complete = new ArrayList<>(seq);
      JuziPinyin juziPy = new JuziPinyin(complete);
      table.add(juziPy);
      return;
    }
    char zi = juzi.charAt(idx);
    for (String py : ziToPys(zi, map)) {
      seq.add(py);
      juziToPys(juzi, idx + 1, seq, table, map);
      seq.remove(seq.size() - 1);
    }
  }
}
