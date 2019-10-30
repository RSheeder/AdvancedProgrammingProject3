import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Timer;

import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.animation.TranslateTransition;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
 
public class Main extends Application {
	
	double horseSpeed1;
	double horseSpeed2;
	double horseSpeed3;
	double horseSpeed4;
	
	TranslateTransition transition1;
	TranslateTransition transition2;
	TranslateTransition transition3;
	TranslateTransition transition4;
	double borderPaneWidth;
	Timeline timeline;
	
	BorderPane borderPane;
	
	FileInputStream horseFile1;
	FileInputStream horseFile2;
	FileInputStream horseFile3;
	FileInputStream horseFile4;
	
	ImageView imageView1;
	ImageView imageView2;
	ImageView imageView3;
	ImageView imageView4;
	
	
	@Override
    public void start(Stage stage)  {
    	borderPane = new BorderPane();
    	borderPaneWidth = borderPane.getMaxWidth();
    	
    	HBox hbox = new HBox(3);
    	hbox.setAlignment(Pos.CENTER);
    	hbox.setStyle("-fx-background-color: grey;");
    	
    	VBox vbox = new VBox(35);
    	vbox.setAlignment(Pos.BASELINE_LEFT);
    	
    	try {
    	horseFile1 = new FileInputStream("./src/horse1.jpg");
    	horseFile2 = new FileInputStream("./src/horse2.jpg");
    	horseFile3 = new FileInputStream("./src/horse3.jpg");
    	horseFile4 = new FileInputStream("./src/horse4.jpg");
    	} catch (Exception e) {
    		
    	}
    	
    	Image horse1 = new Image(horseFile1);
    	imageView1 = new ImageView();
    	imageView1.setImage(horse1);
    	imageView1.setFitHeight(150);
    	imageView1.setFitWidth(200);
    	
    	
    	Image horse2 = new Image(horseFile2);
    	imageView2 = new ImageView();
    	imageView2.setImage(horse2);
    	imageView2.setFitHeight(150);
    	imageView2.setFitWidth(200);
    	
    	Image horse3 = new Image(horseFile3);
    	imageView3 = new ImageView();
    	imageView3.setImage(horse3);
    	imageView3.setFitHeight(150);
    	imageView3.setFitWidth(200);
    
    	Image horse4 = new Image(horseFile4);
    	imageView4 = new ImageView();
    	imageView4.setImage(horse4);
    	imageView4.setFitHeight(150);
    	imageView4.setFitWidth(200);

    	
    	
    	//Run Button create and event handler
    	Button runButton = new Button("Run");
    	runButton.setOnAction(new EventHandler<ActionEvent>() {
    		 
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Run Button was pressed");
                runButton.setDisable(true);
                
                Run run = new Run();
               // h1.run();
                
                horseSpeed1 = (double) ((Math.random() * ( 4 - 1 ) + 1));
                horseSpeed2 = (double) ((Math.random() * ( 4 - 1 ) + 1));
                horseSpeed3 = (double) ((Math.random() * ( 4 - 1 ) + 1));
                horseSpeed4 = (double) ((Math.random() * ( 4 - 1 ) + 1));
                
                run.run();
               /* horseSpeed1 = (double) ((Math.random() * ( 4 - 1 ) + 1));
                transition1 = new TranslateTransition(Duration.seconds(horseSpeed1), imageView1);
                transition1.setFromX(0);
                transition1.setToX((borderPane.getWidth() - 200));
                transition1.play();
                
                horseSpeed2 = (double) ((Math.random() * ( 4 - 1 ) + 1));
                transition2 = new TranslateTransition(Duration.seconds(horseSpeed2), imageView2);
                transition2.setFromX(0);
                transition2.setToX((borderPane.getWidth() - 200));
                transition2.play(); 
                
                horseSpeed3 = (double) ((Math.random() * ( 4 - 1 ) + 1));
                transition3 = new TranslateTransition(Duration.seconds(horseSpeed3), imageView3);
                transition3.setFromX(0);
                transition3.setToX((borderPane.getWidth() - 200));
                transition3.play(); 
                
                horseSpeed4 = (double) ((Math.random() * ( 4 - 1 ) + 1));
                transition4 = new TranslateTransition(Duration.seconds(horseSpeed4), imageView4);
                transition4.setFromX(0);
                transition4.setToX((borderPane.getWidth() - 200));
                transition4.play(); */
                
                double[] nums = {horseSpeed1, horseSpeed2, horseSpeed3, horseSpeed4};
                double[] sortedNums = {horseSpeed1, horseSpeed2, horseSpeed3, horseSpeed4};
                Arrays.sort(sortedNums);
                System.out.println("Slowest Horse Time: " + sortedNums[sortedNums.length-1]);
                System.out.println("Fastest Horse Time: " + nums[1]);
                
                
               
                
                /*
                KeyValue startKeyValue = new KeyValue(imageView1.translateXProperty(), borderPaneWidth);
                KeyFrame startKeyFrame = new KeyFrame(startDuration, startKeyValue);
                KeyValue endKeyValue = new KeyValue(imageView1.translateXProperty(), -1.0 * borderPaneWidth);
                KeyFrame endKeyFrame = new KeyFrame(endDuration, endKeyValue);
                
                Timeline timeline = new Timeline(startKeyFrame, endKeyFrame);
                //timeline.setCycleCount(Timeline.INDEFINITE);
                timeline.setDelay(Duration.seconds(1));//(nums[nums.length-1]));
                System.out.println("Duration " + Duration.seconds(nums[nums.length-1]));
                timeline.play();
                */
                
                timeline = new Timeline(
                	    new KeyFrame(Duration.seconds(sortedNums[sortedNums.length-1]), e -> {
                	    	double min = nums[0];
                	    	int index = 0;
                	    	for(int i=0; i < nums.length; i++) {
                	    		//String number = nums[i].toString();
                	    		if(min > nums[i]) {
                	    			min = nums[i];
                	    			index = i;	
                	    		}
                	    	}
                	    	JOptionPane.showMessageDialog(null, "Horse " + (index+1) + " is the winner" + "\n" + "Horse " + (index+1) + " completed the race in " + (sortedNums[sortedNums.length-1]) + "seconds.";
                	    	
                	    	transition1.stop();
                	    	transition2.stop();
                	    	transition3.stop();
                	    	transition4.stop();
                	    })
                	);
                	timeline.play();  	 
            }
        });
    	
    	//Reset Button create and event handler
        Button resetButton = new Button("Reset");
        resetButton.setOnAction(new EventHandler<ActionEvent>() {
   		 
            @Override
            public void handle(ActionEvent event) {
                System.out.println(resetButton.getText() + " was pressed");
                runButton.setDisable(false);
                
                Reset reset = new Reset();
                reset.reset();
                
               // imageView1.setX(value);
                /*timeline.stop();
                
                transition1.stop();
                TranslateTransition reset1 = new TranslateTransition(Duration.seconds(0.001), imageView1);
                reset1.setFromX((borderPane.getWidth() - 200));
                reset1.setToX(0);
                reset1.play();

                transition2.stop();
                TranslateTransition reset2 = new TranslateTransition(Duration.seconds(0.001), imageView2);
                reset2.setFromX((borderPane.getWidth() - 200));
                reset2.setToX(0);
                reset2.play();
                
                transition3.stop();
                TranslateTransition reset3 = new TranslateTransition(Duration.seconds(0.001), imageView3);
                reset3.setFromX((borderPane.getWidth() - 200));
                reset3.setToX(0);
                reset3.play();
                
                transition4.stop();
                TranslateTransition reset4 = new TranslateTransition(Duration.seconds(0.001), imageView4);
                reset4.setFromX((borderPane.getWidth() - 200));
                reset4.setToX(0);
                reset4.play();*/
               
                
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
    	vbox.getChildren().addAll(imageView1, imageView2, imageView3, imageView4);
    	
        borderPane.setTop(hbox);
        borderPane.setCenter(vbox);
        Scene scene = new Scene(borderPane, 1000, 750);
 
        stage.setTitle("ACP Project 3 - Richard Sheeder");
        stage.setScene(scene);
        stage.show();
    }
	
	class Run extends Thread{
		public void run() {
			//horseSpeed1 = (double) ((Math.random() * ( 4 - 1 ) + 1));
            transition1 = new TranslateTransition(Duration.seconds(horseSpeed1), imageView1);
            transition1.setFromX(0);
            transition1.setToX((borderPane.getWidth() - 200));
            transition1.play();
            
            //horseSpeed2 = (double) ((Math.random() * ( 4 - 1 ) + 1));
            transition2 = new TranslateTransition(Duration.seconds(horseSpeed2), imageView2);
            transition2.setFromX(0);
            transition2.setToX((borderPane.getWidth() - 200));
            transition2.play(); 
            
            //horseSpeed3 = (double) ((Math.random() * ( 4 - 1 ) + 1));
            transition3 = new TranslateTransition(Duration.seconds(horseSpeed3), imageView3);
            transition3.setFromX(0);
            transition3.setToX((borderPane.getWidth() - 200));
            transition3.play(); 
            
            //horseSpeed4 = (double) ((Math.random() * ( 4 - 1 ) + 1));
            transition4 = new TranslateTransition(Duration.seconds(horseSpeed4), imageView4);
            transition4.setFromX(0);
            transition4.setToX((borderPane.getWidth() - 200));
            transition4.play(); 
            
            double[] nums = {horseSpeed1, horseSpeed2, horseSpeed3, horseSpeed4};
            double[] sortedNums = {horseSpeed1, horseSpeed2, horseSpeed3, horseSpeed4};
            Arrays.sort(sortedNums);
            System.out.println("Max Time in seconds: " + sortedNums[sortedNums.length-1]);
            System.out.println("Nums: " + nums[1]);
		}
	}
	
	class Reset extends Thread {
		public void reset() {
		timeline.stop();
        
        transition1.stop();
        TranslateTransition reset1 = new TranslateTransition(Duration.seconds(0.0001), imageView1);
        reset1.setFromX((borderPane.getWidth() - 200));
        reset1.setToX(0);
        reset1.play();

        transition2.stop();
        TranslateTransition reset2 = new TranslateTransition(Duration.seconds(0.0001), imageView2);
        reset2.setFromX((borderPane.getWidth() - 200));
        reset2.setToX(0);
        reset2.play();
        
        transition3.stop();
        TranslateTransition reset3 = new TranslateTransition(Duration.seconds(0.0001), imageView3);
        reset3.setFromX((borderPane.getWidth() - 200));
        reset3.setToX(0);
        reset3.play();
        
        transition4.stop();
        TranslateTransition reset4 = new TranslateTransition(Duration.seconds(0.0001), imageView4);
        reset4.setFromX((borderPane.getWidth() - 200));
        reset4.setToX(0);
        reset4.play();
		}
	}
 
    public static void main(String[] args) {
        Application.launch(args);
    }
}