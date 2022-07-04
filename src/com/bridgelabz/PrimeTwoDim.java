package com.bridgelabz;

public class PrimeTwoDim {
    int[][] primeNoArray = new int[10][100];

    public void primeNo() {
        for(int i=2; i<1000; i++) {
            int count = 0;
            for(int j=2; j<=i; j++) {
                if(i%j == 0) {
                    count++;
                }
                if(count == 2) {
                    break;
                }
            }
            if(count==1) {
                int index1 = i/100;
                int index2 = i%100 -1 ;
                primeNoArray[index1][index2] = i;
            }
        }
    }

    public void show() {
        System.out.println("Row 1st");
        System.out.println();
        int rowNo = 1;
        for(int[] list: primeNoArray) {
            rowNo++;
            for(int prime: list) {
                if(prime == 0) {
                    continue;
                }
                System.out.print(prime + " ");
            }
            System.out.println();
            if(rowNo == 11) {
                return;
            }
            System.out.println("Row " + rowNo+"nd");
            System.out.println();
        }
    }
}

