package me.vkku.sneakAttack.game.controller;

import me.vkku.sneakAttack.pojo.Player;

import java.util.ArrayList;
import java.util.List;

public class ControllerParams {

    List<Player> playerList = new ArrayList<Player>();
    List<Integer> killedList = new ArrayList<Integer>();
    List<Integer> maxFrequency = new ArrayList<>();
    Integer suspectArr[];
    int randomKillerPos;
    int healerPos;
    int round;
    int toBeHealed;
    int sherlockSuspect;
    int sherlockPos;

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }

    public List<Integer> getKilledList() {
        return killedList;
    }

    public void setKilledList(List<Integer> killedList) {
        this.killedList = killedList;
    }

    public int getRandomKillerPos() {
        return randomKillerPos;
    }

    public void setRandomKillerPos(int randomKillerPos) {
        this.randomKillerPos = randomKillerPos;
    }

    public int getHealerPos() {
        return healerPos;
    }

    public void setHealerPos(int healerPos) {
        this.healerPos = healerPos;
    }

    public List<Integer> getMaxFrequency() {
        return maxFrequency;
    }

    public void setMaxFrequency(List<Integer> maxFrequency) {
        this.maxFrequency = maxFrequency;
    }

    public Integer[] getSuspectArr() {
        return suspectArr;
    }

    public void setSuspectArr(Integer[] suspectArr) {
        this.suspectArr = suspectArr;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public int getToBeHealed() {
        return toBeHealed;
    }

    public void setToBeHealed(int toBeHealed) {
        this.toBeHealed = toBeHealed;
    }

    public int getSherlockSuspect() {
        return sherlockSuspect;
    }

    public void setSherlockSuspect(int sherlockSuspect) {
        this.sherlockSuspect = sherlockSuspect;
    }

    public int getSherlockPos() {
        return sherlockPos;
    }

    public void setSherlockPos(int sherlockPos) {
        this.sherlockPos = sherlockPos;
    }
}
