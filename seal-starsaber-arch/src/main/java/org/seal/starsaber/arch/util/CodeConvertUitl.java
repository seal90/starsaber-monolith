package org.seal.starsaber.arch.util;

/**
 * @author seal
 * @version v1.0.0
 * @description
 * @createTime 2018-10-01 09:03:07
 */
public class CodeConvertUitl{

    public static String unicodeToCn(String unicode) {
        String[] strs = unicode.split("\\\\u");
        StringBuilder val = new StringBuilder(strs.length);
        for (int i = 1; i < strs.length; i++) {
            val.append((char) Integer.valueOf(strs[i], 16).intValue());
        }
        return val.toString();
    }

    public static String cnToUnicode(String cn) {
        char[] chars = cn.toCharArray();
        StringBuilder val = new StringBuilder(chars.length);
        for(char c : chars){
            val.append("\\u").append(Integer.toString(c, 16));
        }
        return val.toString();
    }

}
