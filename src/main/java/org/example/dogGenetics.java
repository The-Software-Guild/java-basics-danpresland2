package org.example;

import java.util.ArrayList;
import java.util.Random;

public class dogGenetics extends Game{


    private ArrayList<String> dogBreeds = new ArrayList<>();

    public void play() {
        initDogBreeds();

        String dogName;

        System.out.print("Dog name :: ");
        dogName = myScanner.nextLine();
        System.out.println();


        ArrayList<String> dogBreedComposition = new ArrayList<>();
        ArrayList<Integer> dogBreedPrcnt = new ArrayList<>();

        Random rand = new Random();

        int sum = 0;
        dogBreedPrcnt.add(0);
        for (int i=0; i<4; i++) {
            sum += dogBreedPrcnt.get(i);
            dogBreedPrcnt.add(rand.nextInt(0, 100 - sum));
        }
        sum += dogBreedPrcnt.get(dogBreedPrcnt.size()-1);
        dogBreedPrcnt.add(100-sum);
        dogBreedPrcnt.remove(0);

        for (int i=0; i<5; i++){
            String tmpBreed = dogBreeds.get(rand.nextInt(dogBreeds.size()));
            dogBreedComposition.add(tmpBreed);
            dogBreeds.remove(tmpBreed);
        }

        System.out.printf("Well then, I have this highly reliable report on %s's " +
                "prestigious background right here.\n", dogName);
        System.out.printf("\n%s is:\n", dogName);

        //print results
        for (int i=0; i<5; i++){
            System.out.printf("%d\t %s\n", dogBreedPrcnt.get(i), dogBreedComposition.get(i));
        }

    }

    private void initDogBreeds() {
        dogBreeds.add("Chihuahua");
        dogBreeds.add("Australian Shepherd");
        dogBreeds.add("Border Terrier");
        dogBreeds.add("St. Bernard");
        dogBreeds.add("Common Cur");
        dogBreeds.add("Golden Retriever");
        dogBreeds.add("Newfoundland");
        dogBreeds.add("Maltese");
    }

}
