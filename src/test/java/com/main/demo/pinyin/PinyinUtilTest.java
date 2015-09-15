package com.main.demo.pinyin;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import net.sourceforge.pinyin4j.PinyinHelper;

import org.junit.Test;

import test.AbstractBaseTest;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.truth.Truth;

public class PinyinUtilTest extends AbstractBaseTest{
  @Test
  public void testToHanyuPinyinStringArray() {
    String hanzis = "中国";
    Map<String, List<String>> ziToPinyins = new HashMap<>();
    ziToPinyins.put("中", Lists.newArrayList("zhong1", "zhong4"));
    ziToPinyins.put("国", Lists.newArrayList("guo2"));
    int i;
    int len = hanzis.length();
    for (i = 0; i < len; i++) {
      String zi = hanzis.substring(i, i + 1);
      String[] pys = PinyinHelper.toHanyuPinyinStringArray(zi.charAt(0));
      assertTrue(Iterables.elementsEqual(ziToPinyins.get(zi), Arrays.asList(pys)));
    }
  }

  @Test
  public void testZiToPys() {
    Truth.assertThat(PinyinUtil.ziToPys('都')).containsExactly("dou", "du");
    Truth.assertThat(PinyinUtil.ziToPys('沙')).containsExactly("sha");
    Truth.assertThat(PinyinUtil.ziToPys('律')).containsExactly("lv");
    Truth.assertThat(PinyinUtil.ziToPys('好')).containsExactly("hao");
  }

  @Test
  public void testJuziToPys() {
    List<JuziPinyin> juziPys = PinyinUtil.juziToPys("长沙");
    assertTrue(Iterables.elementsEqual(juziPys.stream()
                                              .map(py -> py.toPinyin())
                                              .collect(Collectors.toList()),
                                       Lists.newArrayList("zhangsha", "changsha")));
    assertEquals("lvliang", PinyinUtil.juziToPys("吕梁").get(0).toPinyin());
    System.out.println(PinyinUtil.juziToPys("广安"));
  }

  @Test
  public void testJuziPinyin() {
    JuziPinyin py = new JuziPinyin("shang", "hai");
    log.info("result:{}","SH");
    assertEquals("SH", py.toAcronym());
  }
  
  @Test
  public void testXdfJuziToAcronym() {
    Truth.assertThat(PinyinUtil.xdfJuziToAcronym("海龙")).isEqualTo("HL");
  }
}
