package org.dzmitry.kapachou;

public class StringCompression {

    public static void main(String[] args) {
        System.out.println(compress(new char[] { 'a', 'a', 'a', 'b', 'b', 'b', 'a', 'a'}));
    }


    public static int compress(char[] chars) {
        if (chars.length == 0) return 0;
        if (chars.length == 1) return 1;

        StringBuilder compression = new StringBuilder();
        int cursor = 1;
        int index = 1;
        for (int i = 0; i < chars.length; i++) {
            compression.append(chars[i]);
            while (cursor < chars.length && chars[i] == chars[cursor]) {
                ++cursor;
            }
            if (cursor - i > 1) {
                compression.append(cursor - i);
                char[] charDigits = String.valueOf(cursor - i).toCharArray();
                for (int c = 0; c < charDigits.length; c++) {
                    chars[index + c]= charDigits[c];
                }
            }
            index = cursor + 1;
            i = cursor - 1;
        }
        System.out.println(compression);
        System.out.println(chars);
        return compression.length();
    }


}
