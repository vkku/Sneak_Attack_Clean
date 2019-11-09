package me.vkku.sneakAttack.game;

import me.vkku.sneakAttack.game.controller.GameController;

public class SneakAttackGame {

    public static void main(String[] args) {

        GameController gameController = new GameController(6);
        gameController.playGame();

    }

}
