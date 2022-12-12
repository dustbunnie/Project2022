package application;
	
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.io.Serializable;
import com.gluonhq.charm.glisten.*;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;



public class Main<G> extends Application implements Serializable{
	boolean login=false;
	boolean createPost = false;
	Stage primaryStage = new Stage();

	@Override
	
	
	public void start(Stage primaryStage) {
		try {
			
			//ScrollPane root = (ScrollPane)FXMLLoader.load(getClass().getResource("TwittlrPage.fxml"));
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("Sample.fxml"));
			Scene scene1 = new Scene(root, 1910, 1010);
			scene1.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			this.primaryStage.setScene(scene1);
			this.primaryStage.show();

			


				
	
			
		} catch(Exception e) {
			e.printStackTrace();
		}

	}
	


		



	
	public static void main(String[] args) {
		launch(args);
	}
	

}
