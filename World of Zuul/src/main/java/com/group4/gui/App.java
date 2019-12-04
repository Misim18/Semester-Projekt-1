package com.group4.gui;

import com.group4.gameLogic.Command;
import com.group4.gameLogic.CommandWord;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import java.io.IOException;
import com.group4.gameLogic.Game;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {
	private static Stage window;
    static Scene scene;
    static Game game;

    public static void injectGame(Game game1) {
        game = game1;
    }

    public static Game getGame() {
        return game;
    }

    @Override
    public void start(Stage stage) throws Exception {
		window = stage;
        scene = new Scene(loadFXML("start"));
		window.setTitle("start");
		window.setOnCloseRequest(e -> closeGame());
		//window.setTitle("Hello World");
        window.setScene(scene);
        window.show();
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


	public static void closeGame(){
		window.close();
	}

	public static void toggleUI(){
		try {
			System.out.println("Window title" + window.getTitle());
			if(window.getTitle() == "game"){
				scene.setRoot(loadFXML("shop"));
				window.setTitle("shop");
			} else {
				scene.setRoot(loadFXML("game"));
				window.setTitle("game");
			}

		} catch (Exception e) {
			System.out.println("Can't change root scene");
			closeGame();
		}
	}
}
