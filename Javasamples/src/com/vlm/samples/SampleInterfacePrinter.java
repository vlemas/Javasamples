package com.vlm.samples;
public class SampleInterfacePrinter {
     
 public void print(SampleInterface firstInterface){
  firstInterface.singleMethod("apple");
 }
 
 public static void main(String args[]){
  SampleInterfacePrinter printer=new SampleInterfacePrinter();
  printer.print((String param) -> {System.out.println("My lambda says "+ param);});
 }
}