package com.retto.practices16;

import java.util.*;

class Solution {
    public String convert(String s, int numRows) {
        
        List<StringBuilder> rows = new ArrayList<>();
        for(int i=0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }

        List<StringBuilder> travels = new ArrayList<>();
        for(int i=0; i < numRows; i++) {
            travels.add(rows.get(i));
        }
        for(int i=numRows-2; i > 0; i--) {
            travels.add(rows.get(i));
        }

        char[] chars = s.toCharArray();
        for(int i=0; i < chars.length; i++) {
            int mod = i % travels.size();
            travels.get(mod).append(chars[i]);
        }
        
        StringBuilder output = new StringBuilder();
        for(int i=0; i < numRows; i++) {
            output.append(rows.get(i).toString());
        }

        return output.toString();
    }
}