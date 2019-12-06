package com.group4.gui;


import com.group4.gameLogic.CommandShop;
import com.group4.gameLogic.CommandWordShop;
import com.group4.gameLogic.Text;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class ShopController {
    @FXML // fx:id="bBuyInventoryUpgrade"
    private Button bBuyInventoryUpgrade; // Value injected by FXMLLoader

    @FXML // fx:id="bBuyBreathUpgrade"
    private Button bBuyBreathUpgrade; // Value injected by FXMLLoader

    @FXML // fx:id="bNextLevel"
    private Button bNextLevel; // Value injected by FXMLLoader

    @FXML // fx:id="textFieldPirate"
    private TextArea textFieldPirate; // Value injected by FXMLLoader

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
    public void initialize() {
		textFieldPirate.setText(Text.RandomFact());
		uiUpdate();
	}

	public void uiUpdate(){
		textFieldPirate.setText(""); //FILL HERE

	}
}

