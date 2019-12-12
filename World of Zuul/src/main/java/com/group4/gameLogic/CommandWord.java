package com.group4.gameLogic;

// blueprint for the commandWords the player can use in the game..
public enum CommandWord {
    GO("go"), QUIT("quit"), HELP("help"), UNKNOWN("?"), CHEAT("cheat"), SAVE("save"), LOAD("load"), RESET("reset");

    private String commandString;

    CommandWord(String commandString) {
        this.commandString = commandString;
    }

    @Override
    public String toString() {
        return commandString;
    }
}
