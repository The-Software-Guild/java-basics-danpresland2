package org.example;

public class HealthyHearts implements Game {


    /**
     *
     */
    @Override
    public void play() {
        System.out.println("**************");
        System.out.println("Healthy Hearts");

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
