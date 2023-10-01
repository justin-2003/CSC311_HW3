package com.example.csc311_hw3;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import java.net.URL;

import java.net.URL;
import java.util.ResourceBundle;

public class MazeController implements Initializable {

    private ImageView robot_id;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    @FXML
    protected void runMaze() {
        //PathTransition
        TranslateTransition translate = new TranslateTransition();
        translate.setNode(robot_id);
        translate.setByX(250);
        translate.play();

    }

    @FXML
    protected void carRunMaze(){

    }
}