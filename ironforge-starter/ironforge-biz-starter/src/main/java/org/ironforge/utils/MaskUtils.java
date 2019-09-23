package org.ironforge.utils;

import org.apache.commons.lang3.StringUtils;

public class MaskUtils {

  public static final char STAR = '*';

  public static String pre6suff4(String cardNo) {
    return middle_with_star(cardNo, 6, 4);
  }

  public static String middle_with_star(String simple, int prefixLength, int suffixLength) {
    int length = StringUtils.length(simple);

    if (length >= prefixLength + suffixLength) {
      StringBuilder sb = new StringBuilder();
      sb.append(StringUtils.substring(simple, 0, prefixLength));
      sb.append(StringUtils.repeat(STAR, length - prefixLength - suffixLength));
      sb.append(StringUtils.substring(simple, length - suffixLength));
      return sb.toString();
    }

    return simple;
  }

  public static String suffix4(String mobile) {
    return middle_with_star(mobile, 0, 4);
  }

  public static String fullMask(String cvv) {
    return middle_with_star(cvv, 0, 0);
  }
}
