/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group4.gameLogic;

import java.util.Scanner;

/**
 *
 * @author mikai
 */
public class Shopping {

    private ParserShop parser = new ParserShop();

    public void goToShop(Character player1) {
        System.out.println("Welcome to the Shop. We are happy you are here. Let's get you upgraded.");
        System.out.println("You have " + player1.getRewards() + " rewards to spent");
        parser.showShopCommands();

        boolean finished = false;
        while (!finished) {
            CommandShop command = parser.getCommand();
            finished = processShopCommand(player1, command);
        }

    }

    private boolean processShopCommand(Character player1, CommandShop command) {
        boolean wantToNextLevel = false;

        CommandWordShop commandWord = command.getCommandWord();

        if (commandWord == CommandWordShop.UNKNOWN) {
            System.out.println("I don't know what you mean...");  //Whenever the commandWord is set to .UNKNOWN prints this message, used to communicate to the player that the input wasn't understood.
            return false;
        }

        if (commandWord == CommandWordShop.HELP) { //If CommandWord is set to help, printHelp (See below)
            printShopHelp();
        } else if (commandWord == CommandWordShop.BREATH) {
            if (player1.getRewards() > 0) {
                player1.upgradeBreath();
                System.out.println("Your breath has been upgraded to " + player1.getBreath());
                player1.setRewards(player1.getRewards() - 1);
                System.out.println("You now have " + player1.getRewards() + " rewards left");
            } else if (player1.getRewards() == 0) {
                System.out.println("You have spent all of your rewards");
                System.out.println("You better nextlevel it");
            }
        } else if (commandWord == CommandWordShop.INVENTORY) {
            if (player1.getRewards() > 0) {
                player1.setCarryCapacity(player1.getCarryCapacity() + 1);
                System.out.println("Your inventory capacity has been upgraded to " + player1.getCarryCapacity());
                player1.setRewards(player1.getRewards() - 1);
                System.out.println("You now have " + player1.getRewards() + " rewards left");
            } else if (player1.getRewards() == 0) {
                System.out.println("You have spent all of your rewards");
                System.out.println("You better nextlevel it");
            }
        } else if (commandWord == CommandWordShop.NEXTLEVEL) {
            wantToNextLevel = true;
        }
        return wantToNextLevel;
    }

    private void printShopHelp() {
        System.out.println("Your command words are:");
        parser.showShopCommands();
    }

}
