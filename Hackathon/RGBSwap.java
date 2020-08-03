package me.vkku.string;

import java.io.*;
import java.util.*;
import java.lang.*;


public class Thoughtworks {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int N = Integer.parseInt(br.readLine().trim());
        String S = br.readLine();
        String A = br.readLine();

        String out_ = solve(N, S, A);
        System.out.println(out_);

        wr.close();
        br.close();
    }
    static String solve(int N, String S, String A){

        // Write your code here
        char[] numberCharArr = A.toCharArray();

        List<Map<Integer, Integer>> rainbowMapList = generateComputationStructures();
        populateRainbowMap(N, S, numberCharArr, rainbowMapList);
        List<Integer []> rainbowIndexList = swapRainbowPositions(rainbowMapList);
        String solutionFigure = generateSolutionFigure(S, numberCharArr, rainbowMapList, rainbowIndexList);

        return solutionFigure;


        //Hi Thoughtworker!! This is my TDD portion ;-)
        //redValues.forEach(val -> System.out.println("Red Values => " + val));
        //redColourValueMap.forEach((k, v) -> System.out.println(k + " : " + v));
        //greenColourValueMap.forEach((k, v) -> System.out.println(k + " : " + v));
        //blueColourValueMap.forEach((k, v) -> System.out.println(k + " : " + v));
    }

    private static List<Map<Integer, Integer>> generateComputationStructures() {

        Map <Integer, Integer> redColourValueMap = new HashMap();
        Map <Integer, Integer> greenColourValueMap = new HashMap();
        Map <Integer, Integer> blueColourValueMap = new HashMap();
        List<Map <Integer, Integer>> rainbowMapList = new ArrayList<>();
        rainbowMapList.add(redColourValueMap);
        rainbowMapList.add(greenColourValueMap);
        rainbowMapList.add(blueColourValueMap);

        return rainbowMapList;
    }

    private static String generateSolutionFigure(String colorCode, char[] numberCharArr, List<Map<Integer, Integer>> rainbowMapList, List<Integer[]> rainbowIndexList) {

        StringBuilder maximumFigure = new StringBuilder();
        int redCount = 0;
        int greenCount = 0;
        int blueCount = 0;
        for(int i = 0 ; i < numberCharArr.length ; i++){
            Integer val = Character.getNumericValue(numberCharArr[i]);
            if(colorCode.charAt(i) == 'R'){
                maximumFigure.append(rainbowMapList.get(0).get(rainbowIndexList.get(0)[redCount]));
                redCount++;
            }
            else if(colorCode.charAt(i) == 'G'){
                maximumFigure.append(rainbowMapList.get(1).get(rainbowIndexList.get(1)[greenCount]));
                greenCount++;
            }
            else {
                maximumFigure.append(rainbowMapList.get(2).get(rainbowIndexList.get(2)[blueCount]));
                blueCount++;
            }

        }

        return maximumFigure.toString();
    }

    private static List<Integer []> swapRainbowPositions(List<Map<Integer, Integer>> rainbowMapList) {

        List<Integer []> rainbowIndexList = new ArrayList<>();
        List<Integer> redValues = new ArrayList<Integer>(rainbowMapList.get(0).values());
        List<Integer> greenValues = new ArrayList<Integer>(rainbowMapList.get(1).values());
        List<Integer> blueValues = new ArrayList<Integer>(rainbowMapList.get(2).values());

        Collections.sort(redValues, Collections.reverseOrder());
        Collections.sort(greenValues, Collections.reverseOrder());
        Collections.sort(blueValues, Collections.reverseOrder());

        Set<Integer> redIndexes = rainbowMapList.get(0).keySet();
        Integer[] redIndexesArr = redIndexes.toArray(new Integer[0]);
        for(int i = 0 ; i < redValues.size() ; i++){
            rainbowMapList.get(0).put(redIndexesArr[i], redValues.get(i));
        }

        Set<Integer> greenIndexes = rainbowMapList.get(1).keySet();
        Integer[] greenIndexesArr = greenIndexes.toArray(new Integer[0]);
        for(int i = 0 ; i < greenValues.size() ; i++){
            rainbowMapList.get(1).put(greenIndexesArr[i], greenValues.get(i));
        }

        Set<Integer> blueIndexes = rainbowMapList.get(2).keySet();
        Integer[] blueIndexesArr = blueIndexes.toArray(new Integer[0]);
        for(int i = 0 ; i < blueValues.size() ; i++){
            rainbowMapList.get(2).put(blueIndexesArr[i], blueValues.get(i));
        }

        rainbowIndexList.add(redIndexesArr);
        rainbowIndexList.add(greenIndexesArr);
        rainbowIndexList.add(blueIndexesArr);

        return rainbowIndexList;

    }

    private static void populateRainbowMap(int numDigits, String colorCode, char[] numberCharArr, List<Map<Integer, Integer>> rainbowMapList) {

        for(int i = 0 ; i < numDigits ; i++){
            Integer val = Character.getNumericValue(numberCharArr[i]);
            if(colorCode.charAt(i) == 'R'){
                rainbowMapList.get(0).put(i, val);
            }
            else if(colorCode.charAt(i) == 'G'){
                rainbowMapList.get(1).put(i, val);
            }
            else {
                rainbowMapList.get(2).put(i, val);
            }
        }
    }

}