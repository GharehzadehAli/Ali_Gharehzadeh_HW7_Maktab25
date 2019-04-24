package com.company;

import java.util.Random;
import java.util.TreeSet;

public class Main {
    public static void unionGetter(TreeSet<Character> set1, TreeSet<Character> set2) {
        TreeSet<Character> set = new TreeSet<>();
        set.addAll(set1);
        set.addAll(set2);
        System.out.println(set);
    }

    public static void intersectionGetter(TreeSet<Character> set1, TreeSet<Character> set2){
        TreeSet<Character> temp=new TreeSet<>();
        set1.retainAll(set2);
        set2.retainAll(set1);
        System.out.println(set2);

    }

    public static void main(String[] args) {
        // write your code here
        TreeSet<Character> treeSet = new TreeSet<>();
        TreeSet<Character> treeSet1 = new TreeSet<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            treeSet.add((char) (random.nextInt(25) + 97));
            treeSet1.add((char) (random.nextInt(25) + 97));
        }
        System.out.println(treeSet);
        System.out.println(treeSet1);
        unionGetter(treeSet, treeSet1);
        intersectionGetter(treeSet,treeSet1);

    }
}
