package me.vkku.sneakAttack.game.controller;

import me.vkku.sneakAttack.enums.Role;
import me.vkku.sneakAttack.enums.State;
import me.vkku.sneakAttack.pojo.Player;
import me.vkku.sneakAttack.util.Util;

import java.util.*;

public class GameController {

    private int numPlayers;
    private ControllerParams controllerParams;

    public GameController(int numPlayers){
        this.numPlayers = numPlayers;
        this.controllerParams = new ControllerParams();
    }

    public void playGame(){

        assignRoles(numPlayers);

        //Uncomment for Version - 2 Output
        /*for(int i = 0 ; i < 5 ; i++){
            System.out.println("Round " + (i+1));
            killInitialPlayer();
        }*/
        controllerParams.round = 0;
        while(!controllerParams.getKilledList().contains(controllerParams.randomKillerPos) && (controllerParams.killedList.size() < numPlayers)){
            System.out.println("** Round Starts **");
            chooseToBeHealed();
            killInitialPlayer();
            voteSuspect();
            killSuspects();
            System.out.println("** Round Ends **");
        }
    }

    private void assignRoles(int numPlayers) {
        controllerParams.randomKillerPos = Util.randomInRange(numPlayers);
        controllerParams.healerPos = Util.randomInRange(numPlayers, controllerParams.randomKillerPos);

        for(int i = 0 ; i < numPlayers ; i++){
            if(i == controllerParams.randomKillerPos){
                controllerParams.getPlayerList().add(new Player(Role.KILLER));
            }
            else if(i == controllerParams.healerPos){
                controllerParams.getPlayerList().add(new Player(Role.HEALER));
            }
            else {
                controllerParams.getPlayerList().add(new Player(Role.INNOCENT));
            }
            controllerParams.getPlayerList().get(i).setState(State.ALIVE);

            System.out.println("P" + i + ": " + controllerParams.getPlayerList().get(i).getRole());

        }

    }

    public void killInitialPlayer(){

        int killIndex = 0;
        List<Integer> killingExceptionList = new ArrayList<Integer>();
        killingExceptionList.add(controllerParams.randomKillerPos);
        killingExceptionList.addAll(controllerParams.getKilledList());
        if(killingExceptionList.size() < numPlayers)
            killIndex = Util.randomInRange(numPlayers, killingExceptionList);
        controllerParams.getKilledList().add(killIndex);
        controllerParams.getPlayerList().get(killIndex).setState(State.DEAD);
        System.out.println("P" + controllerParams.randomKillerPos + " killed P" + killIndex);

    }

    public void voteSuspect(){

        int randomSuspect = 0;
        List<Integer> suspectExceptionList = new ArrayList<Integer>();
        controllerParams.suspectArr = new Integer[numPlayers];
        Arrays.fill(controllerParams.suspectArr, 0);
        for(int i = 0 ; i < numPlayers ; i++){
            suspectExceptionList.clear();
            Player currentPlayer = controllerParams.getPlayerList().get(i);
            if( (currentPlayer.getState() == State.ALIVE) && (currentPlayer.getRole() == Role.INNOCENT || currentPlayer.getRole() == Role.HEALER) ){
                healerValidation(currentPlayer, suspectExceptionList);
                suspectExceptionList.add(i);
                suspectExceptionList.addAll(controllerParams.getKilledList());
                if(suspectExceptionList.size() < numPlayers)
                randomSuspect = Util.randomInRange(numPlayers, suspectExceptionList);
                controllerParams.getPlayerList().get(i).setSuspects(randomSuspect);
                controllerParams.suspectArr[randomSuspect] += 1;
                System.out.println("P" + i + " suspects : " + randomSuspect);
            }
        }

        controllerParams.maxFrequency = Util.maxTwoFrequency(controllerParams.suspectArr, numPlayers);
    }

    private void healerValidation(Player currentPlayer, List<Integer> suspectExceptionList) {
        if(currentPlayer.getRole() == Role.HEALER){
            suspectExceptionList.add(controllerParams.toBeHealed);
        }
    }

    public void killSuspects(){
        for (int i = 0 ; i < numPlayers ; i++){
            if(controllerParams.suspectArr[i] != 0){
                System.out.println("P" + i + " has been suspected " + controllerParams.suspectArr[i] + " times");
            }
        }

        System.out.println("The maximum suspect count is : " + controllerParams.maxFrequency.get(0));

        int maxFreq;
            maxFreq = controllerParams.maxFrequency.get(0);
            if (controllerParams.toBeHealed != maxFreq) {
                controllerParams.getKilledList().add(maxFreq);
                controllerParams.getPlayerList().get(maxFreq).setState(State.DEAD);
                controllerParams.round++;
                if (controllerParams.randomKillerPos == maxFreq) {
                    System.out.println("The killer P" + maxFreq + " has been suspected and killed in round " + controllerParams.round);
                } else {
                    System.out.println("The player P" + maxFreq + " has been suspected and killed in round " + controllerParams.round);
                }
            }
            else if(maxFreq == controllerParams.toBeHealed){
                if(controllerParams.getKilledList().contains(controllerParams.toBeHealed)){
                    controllerParams.getKilledList().remove(controllerParams.toBeHealed);
                    controllerParams.getPlayerList().get(controllerParams.toBeHealed).setState(State.ALIVE);
                }
                System.out.println("Player P" + controllerParams.toBeHealed + " is healed by healer");
            }
    }

    public void chooseToBeHealed(){
        List<Integer> healingExceptionList = new ArrayList<>();
        healingExceptionList.add(controllerParams.randomKillerPos);
        healingExceptionList.addAll(controllerParams.getKilledList());
        controllerParams.toBeHealed = Util.randomInRange(numPlayers, healingExceptionList);
        System.out.println("Healer selects P" + controllerParams.toBeHealed);
    }


}