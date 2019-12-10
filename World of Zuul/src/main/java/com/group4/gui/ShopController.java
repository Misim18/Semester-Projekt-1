package com.group4.gui;

import com.group4.gameLogic.CommandShop;
import com.group4.gameLogic.CommandWordShop;
import com.group4.gameLogic.Text;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javax.imageio.ImageIO;

public class ShopController {

    @FXML
    private Button bBuyInventoryUpgrade;

    @FXML
    private Button bBuyBreathUpgrade;

    @FXML
    private Button bNextLevel;

    @FXML
    private ImageView bubble;
    
    
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
        textbubble.setText(Text.getRandLine());

        uiUpdate();

    }

    public void uiUpdate() {

    }
}
