package com.group4.gameLogic;

public class Shopping {

    private Character player;
    private ParserShop parser = new ParserShop();

    public Shopping(Character player) {
        this.player = player;
    }

    public void goToShop(Character player1) {
        //player1.setRewards(player1.getRewards() + 2);                 //gives rewards to character for upgrades
        System.out.println("Welcome to the Shop. We are happy you are here. Let's get you upgraded.");
        System.out.println("You have " + player1.getRewards() + " rewards to spent");
        parser.showShopCommands();

        boolean finished = false;
        while (!finished) {
            CommandShop command = parser.getCommand();
            finished = processShopCommand(command);
        }

    }

    public boolean processShopCommand(CommandShop command) {
        boolean wantToNextLevel = false;

        CommandWordShop commandWord = command.getCommandWord();

        if (commandWord == CommandWordShop.UNKNOWN) {
            System.out.println("I don't know what you mean...");  //Whenever the commandWord is set to .UNKNOWN prints this message, used to communicate to the player that the input wasn't understood.
            return false;
        }

        if (commandWord == CommandWordShop.HELP) { //If CommandWord is set to help, printHelp (See below)
            printShopHelp();
        } else if (commandWord == CommandWordShop.BREATH) {
            if (player.getRewards() > 0) {
                player.upgradeBreath();
                System.out.println("Your breath has been upgraded to " + player.getBreath());
                player.setRewards(player.getRewards() - 1);
                System.out.println("You now have " + player.getRewards() + " rewards left");
            } else if (player.getRewards() == 0) {
                System.out.println("You have spent all of your rewards");
                System.out.println("You better nextlevel it");
            }
        } else if (commandWord == CommandWordShop.INVENTORY) {
            if (player.getRewards() > 0) {
                player.setCarryCapacity(player.getCarryCapacity() + 1);
                System.out.println("Your inventory capacity has been upgraded to " + player.getCarryCapacity());
                player.setRewards(player.getRewards() - 1);
                System.out.println("You now have " + player.getRewards() + " rewards left");
            } else if (player.getRewards() == 0) {
                System.out.println("You have spent all of your rewards");
                System.out.println("You better nextlevel it");
            }
        } else if (commandWord == CommandWordShop.NEXTLEVEL) {
            wantToNextLevel = true;
        }
        return wantToNextLevel;
    }

    private void printShopHelp() {
        System.out.println("Your command words are: ");
        parser.showShopCommands();
    }

}
