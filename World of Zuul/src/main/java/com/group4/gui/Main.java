package com.group4.gui;

import com.group4.gameLogic.Game;

/**
 *
 * @author kkmp
 */
public class Main {
    public static void main(String[] args) {
		App.injectGame(new Game());
        App.startFX(args);
    }
}
