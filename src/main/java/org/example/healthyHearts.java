package org.example;

public class healthyHearts extends Game {


    public void play() {

        int age;
        int hrMax;
        int hrUpper;
        int hrLower;

        System.out.print("Age :: ");
        age = myScanner.nextInt();

        hrMax = 220-age;
        hrUpper = (int) Math.ceil(hrMax * 0.85);
        hrLower = (int) Math.floor(hrMax * 0.5);

        System.out.printf("Target HR zone is %d - %d bpm\n", hrLower, hrUpper);

    }

}
