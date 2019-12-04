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
    private static Scene scene;
	private Stage window;
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
        scene = new Scene(loadFXML("game"));
		window.setTitle("game");
		window.setOnCloseRequest(e -> closeGame());
		//window.setTitle("Hello World");
        window.setScene(scene);
        addKeyEventScene();
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

    public void addKeyEventScene() {
        scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
            if (key.getCode() == KeyCode.S) {
                System.out.println("You pressed down");
                App.game.goRoom(new Command(CommandWord.GO, "down"));
            }
            if (key.getCode() == KeyCode.W) {
                System.out.println("You pressed up");
                App.game.goRoom(new Command(CommandWord.GO, "up"));
            }
            if (key.getCode() == KeyCode.A) {
                System.out.println("You pressed left");
                App.game.goRoom(new Command(CommandWord.GO, "left"));
            }
            if (key.getCode() == KeyCode.D) {
                System.out.println("You pressed right");
                App.game.goRoom(new Command(CommandWord.GO, "right"));
            }
            if (key.getCode() == KeyCode.Q) {
                System.out.println("You presed Q");
				closeGame();
            }
            if (key.getCode() == KeyCode.T) {
                System.out.println("You presed T");
				toggleUI();
            }

        });
    }

	public void closeGame(){
		window.close();
	}

	public void toggleUI(){
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
			//TODO: handle exception
			System.out.println("Can't change root scene");
			closeGame();
		}
	}
}
