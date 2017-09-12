package ow.skiddev.mactxt;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.*;
import java.util.Scanner;

/**
 * Created by skiddev on 03.09.17.
 */
public class Main extends Application{

    private double xOffset = 0;
    private double yOffset = 0;

    public static FileChooser fileChooser = new FileChooser();

    public static long sysALong;

    @Override
    public void start(Stage primaryStage) throws Exception{
        fileChooser.setTitle("Save File");
        Pane pane = new Pane();
        Rectangle rectangle = new Rectangle(800, 30);
        rectangle.setFill(Color.GRAY);

        Rectangle rectangle2 = new Rectangle(26, 26);
        rectangle2.setFill(Color.DARKGRAY);

        rectangle2.setLayoutX(772);
        rectangle2.setLayoutY(2);

        Rectangle rectangle3 = new Rectangle(26, 26);
        rectangle3.setFill(Color.DARKGRAY);

        rectangle3.setLayoutX(742);
        rectangle3.setLayoutY(2);

        Rectangle rectangle4 = new Rectangle(26, 26);
        rectangle4.setFill(Color.DARKGRAY);

        rectangle4.setLayoutX(712);
        rectangle4.setLayoutY(2);

        pane.getChildren().add(rectangle);
        pane.getChildren().add(rectangle2);

        rectangle2.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                ShutDownClient();
            }
        });

        Label label = new Label("BetterEdit - SkidDev");
        Label label1 = new Label("X");

        label.setLayoutX(4);
        label.setLayoutY(0);
        label.setFont(Font.font("IMPACT", 26));

        label1.setLayoutX(779);
        label1.setLayoutY(-2);
        label1.setFont(Font.font("IMPACT", 26));

        TextArea textArea = new TextArea();
        textArea.setLayoutX(0);
        textArea.setLayoutY(30);
        textArea.setMinWidth(800);
        textArea.setMinHeight(570);
        pane.getChildren().add(textArea);

        Label label5 = new Label("SAVE");
        label5.setFont(Font.font("IMPACT", 26));
        label5.setLayoutX(700);
        label5.setLayoutY(0);

        Label label6 = new Label("OPEN");
        label6.setFont(Font.font("IMPACT", 26));
        label6.setLayoutX(630);
        label6.setLayoutY(0);

        Label label7 = new Label("CREDITS");
        label7.setFont(Font.font("IMPACT", 26));
        label7.setLayoutX(525);
        label7.setLayoutY(0);

        
        label5.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try{
                    FileChooser fileChooser = new FileChooser();
                    File result = fileChooser.showSaveDialog(null);
                    if(result != null){
                        String s = result.getAbsolutePath();
                        FileWriter fw = new FileWriter(s + ".txt");
                        BufferedWriter bw = new BufferedWriter(fw);
                        Scanner sc = new Scanner(textArea.getText());
                        while (sc.hasNextLine()){
                            bw.write(sc.nextLine());
                            bw.newLine();
                        }
                        bw.newLine();
                        bw.write("Created with BetterEdit by SkidDev. YT : https://www.youtube.com/channel/UCInkBdJzG9ABBxM-u-yG21A");
                        bw.close();
                    }
                }catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        label6.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try{
                    FileChooser fileChooser = new FileChooser();
                    File toopen = fileChooser.showOpenDialog(null);
                    if(toopen != null){
                        Scanner sc = new Scanner(toopen.getAbsoluteFile());
                        textArea.setText("");
                        while(sc.hasNextLine()){
                            textArea.setText(textArea.getText() + sc.nextLine() + "\n");
                        }
                    }
                }catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });

        label7.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Pane pane1 = new Pane();
                Label label8 = new Label("Application Icon by : https://www.flaticon.com/authors/chanut-is-industries");
                pane1.getChildren().add(label8);
                Button button = new Button("OK");
                button.setLayoutY(70);
                button.setLayoutX(430);
                pane1.getChildren().add(button);
                Stage stage = new Stage();
                Scene scene = new Scene(pane1, 470,100);
                stage.setScene(scene);
                stage.sizeToScene();
                stage.setTitle("Credits");
                stage.show();
                button.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        stage.close();
                    }
                });
            }
        });

        pane.getChildren().add(label);
        pane.getChildren().add(label1);
        pane.getChildren().add(label5);
        pane.getChildren().add(label6);
        pane.getChildren().add(label7);



        label1.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                ShutDownClient();
            }
        });


        rectangle4.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
            }
        });

        label.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });

        label.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                primaryStage.setX(event.getScreenX() - xOffset);
                primaryStage.setY(event.getScreenY() - yOffset);
            }
        });

        rectangle.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });

        rectangle.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                primaryStage.setX(event.getScreenX() - xOffset);
                primaryStage.setY(event.getScreenY() - yOffset);
            }
        });

        rectangle3.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                ShutDownClient();
            }
        });

        Scene scene = new Scene(pane, 800, 600);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static void ShutDownClient(){
        System.out.print("Skid is shutting down!");
        System.exit(0);
    }

}
