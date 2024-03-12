package com.example.dobozok;

import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class HelloController {
    @FXML private Pane pnJatek;
    @FXML private ImageView ivNyil;

    private Label[][] lt = new Label[10][15];
    private String[][] t = new String[10][15];

    private AnimationTimer timer = null;
    int f = 0;
    int k = 0;
    Image nulll =new Image(getClass().getResourceAsStream("null.png"));
    Image box =new Image(getClass().getResourceAsStream("box.png"));
    Image boxopen =new Image(getClass().getResourceAsStream("boxopen.png"));
    public void initialize(){

        for(int s = 0;s<10;s++){
            for(int o = 0;o<15;o++){
                int ss = s, oo = o;
                t[s][o] = "null";
                lt[s][o] = new Label("");
                lt[s][o].setGraphic(new ImageView(nulll));
                random();
                lt[s][o].setLayoutX(10+o*64);
                lt[s][o].setLayoutY(10+s*64);
                lt[s][o].setOnMouseEntered(e -> lt[ss][oo].setStyle("-fx-background-color: lightgreen"));
                lt[s][o].setOnMouseExited(e -> lt[ss][oo].setStyle("-fx-background-color: white"));
                pnJatek.getChildren().add(lt[s][o]);
            }
        }
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                f++;
                forgat();
            }
        };
        timer.start();
    }


    private void forgat(){
        ivNyil.setRotate(f);
    }

    private int[] rt = new int[15];

    @FXML private void onRandomClick(){
        int rand = 0;
        for(int s = 0;s<10;s++){
            for(int o = 0;o<15;o++){
                lt[s][o].setGraphic(new ImageView(nulll));
            }
        }

        for(int i = 0; i<15;i++) rt[i] = (int)(Math.random()*10);
        for(int o = 0;o<15;o++){
            lt[9-rt[o]][o].setGraphic(new ImageView(box));
            t[9-rt[o]][o] = "box";
        }
        for(int s = 0;s<10;s++){
            for(int o = 0;o<15;o++){
                if(t[s][o].equals("box")) { lt[s+1][o].setGraphic(new ImageView(box)); t[s+1][o] = "box"; }
            }
        }
    }

    public void random(){
       
    }

}