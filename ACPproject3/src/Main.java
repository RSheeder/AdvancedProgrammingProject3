import javafx.scene.control.Button;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
 
public class Main extends Application {
 
    @Override
    public void start(Stage stage) {
    	BorderPane borderPane = new BorderPane();
    	
    	HBox hbox = new HBox();
    	hbox.setAlignment(Pos.CENTER);
    	hbox.setStyle("-fx-background-color: grey;");
    	
    	//Run Button create and event handler
    	Button runButton = new Button("Run");
    	runButton.setOnAction(new EventHandler<ActionEvent>() {
    		 
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Run Button was pressed");
            }
        });
    	
    	//Reset Button create and event handler
        Button resetButton = new Button("Reset");
        resetButton.setOnAction(new EventHandler<ActionEvent>() {
   		 
            @Override
            public void handle(ActionEvent event) {
                System.out.println(resetButton.getText() + " was pressed");
            }
        });
        
        //Quit Button create and event handler
        Button quitButton = new Button("Quit");
        quitButton.setOnAction(new EventHandler<ActionEvent>() {
   		 
            @Override
            public void handle(ActionEvent event) {
                System.exit(0);
            }
        });
        
    	hbox.getChildren().addAll(runButton, resetButton, quitButton);
    	
        borderPane.setTop(hbox);
        Scene scene = new Scene(borderPane, 350, 200);
 
        stage.setTitle("ACP Project 3 - Richard Sheeder");
        stage.setScene(scene);
        stage.show();
    }
 
    public static void main(String[] args) {
        Application.launch(args);
    }
 
}