package com.example.relationaldataaccess;

import java.util.Arrays;
import java.util.List;

public class Demo {
  public static void main(String[] args) {
    List<Integer> list = Arrays.asList(2, 3, 5, 4, 1, 8, 10, 9, 7, 6);
//    list.stream().filter(i->i>5).forEach(System.out::println);
    System.out.println(list);
   String a="abc";
    System.out.print(a);
   char[] b=a.toCharArray();
   System.out.print(b);
  }
}
