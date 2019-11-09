package me.vkku.sneakAttack.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Util {

    public static int randomInRange(int range){
        Random random = new Random();
        return random.nextInt(range);
    }

    public static int randomInRange(int range, int except){
        Random random = new Random();
        int randomInt = random.nextInt(range);
        while(randomInt == except){
            randomInt = random.nextInt(range);
        }
        return randomInt;
    }

    public static int randomInRange(int range, List<Integer> exceptionList){
        Random random = new Random();
        int randomInt = random.nextInt(range);
        while(exceptionList.contains(randomInt)){
            randomInt = random.nextInt(range);

        }
        return randomInt;
    }

    public static List<Integer> maxTwoFrequency(Integer arr[], int size){
        List<Integer> maxFrequencies = new ArrayList<>();
        int countMax = 0;
        int lastCount = 0;
        int maxIndex = 0;
        int lastSaveIndex = 0;
        boolean update = true;
        for(int i = 0 ; i < size ; i++){
            if(arr[i] >= countMax){
                if(arr[i] == countMax){
                    update = false;
                }
                countMax = arr[i];
                maxIndex = i;
                if(update) {
                    lastSaveIndex = i;
                }
            }
        }
            maxFrequencies.addAll(Arrays.asList(maxIndex));

        return maxFrequencies;
    }
}
