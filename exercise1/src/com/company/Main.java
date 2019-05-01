package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner scanner=new Scanner(System.in);
        System.out.println("please enter a word");
        String input=scanner.next();
        combine(input);

    }

    public static void combine(String str) {
        char[] input = str.toCharArray();
        List resultList = new ArrayList();
        HashMap<Character, Integer> hashMap = getOccuringChar(str);
        Character keys[] = new Character[hashMap.size()];
        Integer values[] = new Integer[hashMap.size()];
        int index = 0;
        for (Map.Entry<Character, Integer> entry : hashMap.entrySet()) {
            keys[index] = entry.getKey();
            values[index] = entry.getValue();
            index++;
        }
        innerCombine(keys, values, 0, input, resultList);
        System.out.println(resultList);

    }

    static void innerCombine(Character[] keys, Integer[] values, int level, char[] result, List resultList) {
        if (level == result.length) {
            resultList.add(new String(result));
        }
        for (int i = 0; i < keys.length; i++) {
            if (values[i] == 0) {
                continue;
            }
            values[i]--;
            result[level] = keys[i];
            innerCombine(keys, values, level + 1, result, resultList);
            values[i]++;
        }
    }

    static HashMap<Character, Integer> getOccuringChar(String str) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        // Create an array of size 256 i.e. ASCII_SIZE
        int count[] = new int[256];

        int len = str.length();

        // Initialize count array index
        for (int i = 0; i < len; i++)
            count[str.charAt(i)]++;

        // Create an array of given String size
        char ch[] = new char[str.length()];
        for (int i = 0; i < len; i++) {
            ch[i] = str.charAt(i);
            int find = 0;
            for (int j = 0; j <= i; j++) {

                // If any matches found
                if (str.charAt(i) == ch[j])
                    find++;
            }

            if (find == 1) {
//                System.out.println("Number of Occurrence of " +
//                        str.charAt(i) + " is:" + count[str.charAt(i)]);
                hashMap.put(str.charAt(i), count[str.charAt(i)]);
            }

        }
        return hashMap;
    }
}

