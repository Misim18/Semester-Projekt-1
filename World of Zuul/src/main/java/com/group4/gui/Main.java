package com.group4.gui;

import com.group4.gameLogic.Game;

public class Main {

    public static void main(String[] args) {
        // new Game(2 = gui)
        App.injectGame(new Game(2));
        App.startFX(args);
    }
}
