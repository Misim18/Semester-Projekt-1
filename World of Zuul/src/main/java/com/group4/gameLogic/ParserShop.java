package com.group4.gameLogic;

import java.util.Scanner;

public class ParserShop {

    private CommandWordsShop commandsShop;
    private Scanner readerShop;

    public ParserShop() {
        commandsShop = new CommandWordsShop();
        readerShop = new Scanner(System.in);
    }

    public CommandShop getCommand() {
        String inputLine;
        String word1 = null;
        String word2 = null;

        System.out.print("> ");

        inputLine = readerShop.nextLine();

        Scanner tokenizer = new Scanner(inputLine);
        if (tokenizer.hasNext()) {
            word1 = tokenizer.next();
            if (tokenizer.hasNext()) {
                word2 = tokenizer.next();
            }
        }

        return new CommandShop(commandsShop.getCommandWordShop(word1), word2);
    }

    public void showShopCommands() {
        commandsShop.showAll();
    }
}
