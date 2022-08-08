package org.example;

public class summativeSums extends Game {

    public void play() {

        int[] a1 = { 1, 90, -33, -55, 67, -16, 28, -55, 15 };
        int[] a2 = { 999, -60, -77, 14, 160, 301 };
        int[] a3 = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130,
                140, 150, 160, 170, 180, 190, 200, -99 };

        int s1 = calcSum(a1);
        int s2 = calcSum(a2);
        int s3 = calcSum(a3);

        System.out.println("#1 : " + s1);
        System.out.println("#2 : " + s2);
        System.out.println("#3 : " + s3);
    }

    private int calcSum(int[] arr) {
        int sum = 0;

        for (int e : arr){
            sum += e;
        }

        return sum;
    }

}