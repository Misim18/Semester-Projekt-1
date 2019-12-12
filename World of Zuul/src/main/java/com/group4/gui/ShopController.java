package com.group4.gui;

import com.group4.gameLogic.CommandShop;
import com.group4.gameLogic.CommandWordShop;
import com.group4.gameLogic.GameText;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class ShopController {


    @FXML
    private Text tUpgradesLeft;
    @FXML
    private HBox hboxShop;
    @FXML
    private TextArea tBuyBreathUpgrade;
    @FXML
    private Button bBuyBreathUpgrade;
    @FXML
    private TextArea tBuyInventoryUpgrade;
    @FXML
    private Button bBuyInventoryUpgrade;
    @FXML
    private Button bNextLevel;
    @FXML
    private TextArea textbubble;

    @FXML
    void handleBuyBreathUpgradeButtonAction(ActionEvent event) {
        App.game.shop.processShopCommand(new CommandShop(CommandWordShop.BREATH, null));
        uiUpdate();
    }

    @FXML
    void handleInventoryUpgradeButtonAction(ActionEvent event) {
        App.game.shop.processShopCommand(new CommandShop(CommandWordShop.INVENTORY, null));
        uiUpdate();
    }

    @FXML
    void handleNextLevelButtonAction(ActionEvent event) {
        App.game.shop.processShopCommand(new CommandShop(CommandWordShop.NEXTLEVEL, null));
        App.toggleUI();
    }

    @FXML
    public void initialize() throws Exception {
        textbubble.setText("Pirates says: \n" + GameText.getRandLine());

        uiUpdate();

    }

    public void uiUpdate() {
		tUpgradesLeft.setText(""+App.game.player1.getRewards());

		// Breath
		tBuyBreathUpgrade.setText("Breath \n\n" +
				"You can hold your breath for " + App.game.player1.getBreath() + " times.\n" +
				"Breath Description: \n" +
				"This is the amount you can hold your breath.\n" +
				"Every time you walk 1 block you lose on breath.\n"+
				"Breath gets refilled then you are at the surface.\n"+
				"If you don't upgrade breath, you can't get the next items."+
				"Then you press buy your breath goes up by 6");
		// Inventory
		tBuyInventoryUpgrade.setText("Inventory \n\n" +
				"You can carry " + App.game.player1.getCarryCapacity() + " items at once \n" +
				"Inventory Description: \n" +
				"With a bigger inventory you can carry more items.\n" +
				"If you have a Bigger inventory, then you don't need to up and down so many times\n"+
				"Then you press buy your inventory space goes up by one.\n");
	}
}
