package com.vlm.oracletutorial.nutsandbolts;
public class ArithmeticDemo {

     public static void main (String[] args){
          
          int result = 1+2; // result is now 3
          System.out.println(result);

          --result; // result is now 2
          System.out.println(result);

          result*=2; // result is now 4
          System.out.println(result);

          result/=2; // result is now 2
          System.out.println(result);

          result+=8; // result is now 10
          result%=7; // result is now 3
          System.out.println(result);
          
          int aNumber = 3;
          if (aNumber >= 0) {
        	    if (aNumber == 0) {
        	        System.out.println("first string");
        	    } else {
        	    	System.out.println("second string");
        	    }
          }
          System.out.println("third string");

     }
}