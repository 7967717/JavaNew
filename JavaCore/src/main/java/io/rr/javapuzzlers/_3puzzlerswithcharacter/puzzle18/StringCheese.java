package io.rr.javapuzzlers._3puzzlerswithcharacter.puzzle18;

import java.io.UnsupportedEncodingException;

public class StringCheese {
    public static void main(String args[]) throws UnsupportedEncodingException {
        byte bytes[] = new byte[256];    
        for(int i = 0; i < 256; i++)
            bytes[i] = (byte)i;
        String str = new String(bytes);
        for(int i = 0, n = str.length(); i < n; i++)
            System.out.print((int)str.charAt(i) + " ");

        System.out.println();
        String str1 = new String(bytes, "ISO-8859-1");
        for(int i = 0, n = str1.length(); i < n; i++)
            System.out.print((int)str1.charAt(i) + " ");

    }
}
