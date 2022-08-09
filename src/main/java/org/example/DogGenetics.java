package org.example;

import java.util.ArrayList;
import java.util.Random;

public class DogGenetics implements Game{

    private Random rand = new Random();

    public ArrayList<String> dogBreeds = new ArrayList<>();


    /**
     *
     */
    @Override
    public void play() {
        populateDogBreeds();

        System.out.println("************");
        System.out.println("Dog Genetics");

        System.out.print("Dog name :: ");
        String dogName = myScanner.nextLine();


        //get 5 breeds & percents
        ArrayList<String> dogBreedComposition;
        ArrayList<Integer> dogBreedPrcnt;

        dogBreedPrcnt = getRandomPercents();
        dogBreedComposition = getRandomComposition();

        //print results
        System.out.printf("\n%s is:\n", dogName);

        for (int i=0; i<5; i++){
            System.out.printf("%d%%\t %s\n", dogBreedPrcnt.get(i), dogBreedComposition.get(i));
        }

    }

    /**
     *
     */
    private void populateDogBreeds() {
        dogBreeds.add("Chihuahua");
        dogBreeds.add("Australian Shepherd");
        dogBreeds.add("Border Terrier");
        dogBreeds.add("St. Bernard");
        dogBreeds.add("Common Cur");
        dogBreeds.add("Golden Retriever");
        dogBreeds.add("Newfoundland");
        dogBreeds.add("Maltese");
    }

    /**
     * get 5 random breeds
     * @return
     */
    private ArrayList<String> getRandomComposition() {
        ArrayList<String> dogBreedComposition = new ArrayList<>();

        for (int i=0; i<5; i++) {
            String tmpBreed = dogBreeds.get(rand.nextInt(dogBreeds.size()));
            dogBreedComposition.add(tmpBreed);
            dogBreeds.remove(tmpBreed);
        }

        return dogBreedComposition;
    }

    /**
     * get 5 random percents
     * @return
     */
    private ArrayList<Integer> getRandomPercents() {
        ArrayList<Integer> dogBreedPrcnt = new ArrayList<>();
        int sum = 0;

        dogBreedPrcnt.add(0);
        for (int i=0; i<4; i++) {
            sum += dogBreedPrcnt.get(i);
            dogBreedPrcnt.add(rand.nextInt(0, 100 - sum));
        }
        sum += dogBreedPrcnt.get(dogBreedPrcnt.size()-1);//sum of prcnt so far
        dogBreedPrcnt.add(100-sum);//add value to make values sum to 100
        dogBreedPrcnt.remove(0);

        return dogBreedPrcnt;
    }

}
