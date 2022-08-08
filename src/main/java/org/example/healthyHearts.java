package org.example;

public class healthyHearts extends Game {

    private int age;
    private int heartRateMax;
    private int heartRateUpper;
    private int heartRateLower;

    public void play() {

        System.out.print("Age :: ");
        age = myScanner.nextInt();

        heartRateMax = 220-age;
        heartRateUpper = (int) (heartRateMax * 0.85);
        heartRateLower = (int) (heartRateMax * 0.5);

        System.out.printf("Target HR zone is %d - %d bpm\n", heartRateLower, heartRateUpper);


    }

}
