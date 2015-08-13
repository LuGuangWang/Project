package com.main.demo.pinyin;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;


/**
 * 一个句子的一个汉语拼音。
 */
public class JuziPinyin {
  List<String> pys;
  private final static Pattern p = Pattern.compile("[\\(\\)/]");

  /**
   * 忽略<code>(/)</code>中的字符。
   */
  public JuziPinyin(List<String> pys) {
    this.pys = pys.stream().filter(py -> {
      Matcher matcher = p.matcher(py);
      return !matcher.matches();
    }).collect(Collectors.toList());
  }

  public JuziPinyin(String... pys) {
    this(Lists.newArrayList(pys));
  }

  public String toAcronym() {
    return pys.stream().map(py -> py.substring(0, 1).toUpperCase()).collect(Collectors.joining());
  }

  public String toPinyin() {
    StringBuilder sb = new StringBuilder();
    for (String py : pys)
      sb.append(py);
    return sb.toString();
  }

  @Override
  public String toString() {
    return "pinyin: " + toPinyin() + ", acronym: " + toAcronym();
  }
}
