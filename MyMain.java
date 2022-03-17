package com.internshala.javafxapp;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

public class MyMain extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void init() throws Exception {
		System.out.println("init");
		super.init();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		System.out.println("start");

		FXMLLoader loader = new FXMLLoader(getClass().getResource("app_layout.fxml"));
		VBox rootNode = loader.load();

		MenuBar menuBar = createMenu();
		rootNode.getChildren().add(0, menuBar);

		Scene scene = new Scene(rootNode);

		primaryStage.setScene(scene);
		primaryStage.setTitle("Temperature Converter Tool");
		primaryStage.show();
	}
	private MenuBar createMenu(){
		Menu fileMenu = new Menu("File");
		MenuItem newMenuItem = new MenuItem("New");
		newMenuItem.setOnAction(event -> System.out.println("New menu  item clicked"));

		SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();
		MenuItem qiuitMenuItem = new MenuItem("Quit");
		qiuitMenuItem.setOnAction(event -> {
			Platform.exit();
			System.exit(0);
		});

		fileMenu.getItems().addAll(newMenuItem,separatorMenuItem, qiuitMenuItem);

		Menu helpMenu = new Menu("Help");
		MenuItem aboutApp = new MenuItem("About");
		aboutApp.setOnAction(event -> aboutApp());

		helpMenu.getItems().addAll(aboutApp);

		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(fileMenu, helpMenu);
		return menuBar;

	}

	private void aboutApp() {
		Alert alerttDialog = new Alert(Alert.AlertType.INFORMATION);
		alerttDialog.setTitle("My First Desktop App");
		alerttDialog.setHeaderText("Learning JavaFX");
		alerttDialog.setContentText("I am a bot now but soon i will be a pro and fuck all the rebels");

		ButtonType yes = new ButtonType("Yes");
		ButtonType no = new ButtonType("No");
		alerttDialog.getButtonTypes().setAll(yes, no);

		Optional<ButtonType> clickedButton = alerttDialog.showAndWait();

		if (clickedButton.isPresent() && clickedButton.get() == yes){
			System.out.println("Yes button clicked");
		} else {
			System.out.println("No button clicked ");
		}

	}

	@Override
	public void stop() throws Exception {
		System.out.println("stop");
		super.stop();
	}
}
