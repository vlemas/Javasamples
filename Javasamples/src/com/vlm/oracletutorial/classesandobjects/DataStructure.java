package com.vlm.oracletutorial.classesandobjects;

import java.util.function.Function;

public class DataStructure{
    
    // Create an array
    private final static int SIZE = 15;
    private static int[] arrayOfInts = new int[SIZE];
    
    public DataStructure() {
        // fill the array with ascending integer values
        for (int i = 0; i < SIZE; i++) {
            arrayOfInts[i] = i;
        }
    }
    
   
    
    interface DataStructureIterator extends java.util.Iterator<Integer>  { } 

    // Inner class implements the DataStructureIterator interface,
    // which extends the Iterator<Integer> interface
    
    private class EvenIterator implements DataStructureIterator {
        
        // Start stepping through the array from the beginning
        private int nextIndex = 0;
        
        public boolean hasNext() {
            
            // Check if the current element is the last in the array
            return (nextIndex <= SIZE - 1);
        }        
        
        public Integer next() {
            
            // Record a value of an even index of the array
            Integer retValue = Integer.valueOf(arrayOfInts[nextIndex]);
            
            // Get the next even element
            nextIndex += 2;
            return retValue;
        }
    }
    
    public void printEven() {
        
        // Print out values of even indices of the array
        DataStructureIterator iterator = this.new EvenIterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }
 
    public void print(DataStructureIterator iterator) {
    	//Print out values of the array depending on implementation of iterator
    	while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }
    
    public void print(Function<Integer, Boolean> iterator) {
    	//Recreate print(DataStructureIterator iterator) using a Function 
    	
    	int nextIndex = 0;
    	 
    	while (nextIndex <= SIZE - 1) {
    		Integer retValue = Integer.valueOf(arrayOfInts[nextIndex]);
    	   	if (iterator.apply(nextIndex)) {
    		System.out.print(retValue + " ");
    		}
    		nextIndex += 1;
    	}
        
        System.out.println();
    }
    
    
    public static  Boolean isEvenIndex(Integer index) {
    	if (index % 2 == 0) {
    		return true;
    	} else {
    		return false;
    	}
    }
    public static  Boolean isOddIndex(Integer index) {
    	if (index % 2 != 0) {
    		return true;
    	} else {
    		return false;
    	}
    } 
    public static void main(String s[]) {
        
        // Fill the array with integer values and print out only
        // values of even indices
        DataStructure ds = new DataStructure();
        ds.printEven();
        DataStructureIterator iterator = ds.new EvenIterator();
        ds.print(iterator);
        //[print only odd values using anonymous inner class
        ds.print(new DataStructureIterator() {
        	 // Start stepping through the array from the beginning
            private int nextIndex = 1;
            
            public boolean hasNext() {
                
                // Check if the current element is the last in the array
                return (nextIndex <= SIZE - 1);
            }        
            
            public Integer next() {
                
                // Record a value of an even index of the array
                Integer retValue = Integer.valueOf(arrayOfInts[nextIndex]);
                
                // Get the next even element
                nextIndex += 2;
                return retValue;
            }
        });
        System.out.println("print even index elements using a Lambda function");
        ds.print(value -> (value % 2) == 0);
        System.out.println("print odd index elements using a Lambda function");
        ds.print(value -> (value % 2) != 0);
        
        System.out.println("print even index elements using a method reference");
        ds.print(DataStructure::isEvenIndex);
        ds.print(DataStructure::isOddIndex);
    }
}