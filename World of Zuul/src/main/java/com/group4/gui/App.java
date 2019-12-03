package com.group4.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.io.IOException;

import com.group4.gameLogic.Game;

import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {
	static Game game;
    private static Scene scene;

	public static void injectGame(Game game1){
		game = game1;
	}

	public static Game getGame(){
		return game;
	}


    @Override
    public void start(Stage stage) throws Exception {
        scene = new Scene(loadFXML("primary"), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void startFX(String[] args) {
        launch(args);
    }


}
