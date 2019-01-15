package com.tcs;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
    	int hourglassSum = 0;
    	List<Integer> list = new ArrayList<>(16);
    	for(int i= 0; i < 4 ; i++) {
    		for(int j = 0; j< 4; j++) {
    			for(int a = i ; a < i+3; a++) {
    				for(int b = j ; b < j+3; b++) {
    					if(a != i+1 || (b != j && b != j+2)) {
    						//System.out.print(arr[a][b]);
    						hourglassSum += arr[a][b];
    					}
    					//else
    						//System.out.print("*");
    				}
    			//System.out.println();
    			}
    			//System.out.println("hourglassSum: "+hourglassSum);
    			//hourglassSum = 0;
    			list.add(hourglassSum);
    			hourglassSum = 0;
    			//System.out.println("\n");
    		}
    		//System.out.println("\n\n");
    	}
    	return list.stream().max(Comparator.comparing(Integer::valueOf)).get();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new PrintWriter(System.out));
        

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            //scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

