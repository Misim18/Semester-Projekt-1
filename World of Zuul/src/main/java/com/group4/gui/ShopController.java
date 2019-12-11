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
    private TextArea yBuyInventoryUpgrade;
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
        textbubble.setText(GameText.getRandLine());

        uiUpdate();

    }

    public void uiUpdate() {
		tUpgradesLeft.setText(""+App.game.player1.getRewards());

    }
}
