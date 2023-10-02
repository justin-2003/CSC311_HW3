package com.example.csc311_hw3;

import javafx.animation.AnimationTimer;
import javafx.animation.TranslateTransition;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;

import java.net.URL;
import java.util.ResourceBundle;

public class MazeController implements Initializable {

    private BooleanProperty wPress = new SimpleBooleanProperty();
    private BooleanProperty aPress = new SimpleBooleanProperty();
    private BooleanProperty sPress = new SimpleBooleanProperty();
    private BooleanProperty dPress = new SimpleBooleanProperty();

    private BooleanBinding keyPressed = wPress.or(aPress).or(sPress).or(dPress);

    private int moveVariable = 2;

    @FXML
    private ImageView robot_id;
    @FXML
    private AnchorPane aPaneScene;

    AnimationTimer timer;

    {
        timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                if (wPress.get()) {
                    robot_id.setLayoutY(robot_id.getLayoutY() - moveVariable);
                }

                if (sPress.get()) {
                    robot_id.setLayoutY(robot_id.getLayoutY() + moveVariable);
                }

                if (aPress.get()) {
                    robot_id.setLayoutX(robot_id.getLayoutX() - moveVariable);
                }
                if (dPress.get()) {
                    robot_id.setLayoutX(robot_id.getLayoutX() + moveVariable);

                }
            }


            /*public void initialize(URL url, ResourceBundle resourceBundle) {
                robotSetup();

                keyPressed.addListener(((observableValue, aBoolean, t1) -> {
                    if (!aBoolean) {
                        timer.start();
                    } else {
                        timer.stop();
                    }
                }));
            }


            public void robotSetup() {
                aPaneScene.setOnKeyPressed(e -> {
                    if (e.getCode() == KeyCode.W) {
                        wPress.set(true);
                    }

                    if (e.getCode() == KeyCode.A) {
                        aPress.set(true);
                    }

                    if (e.getCode() == KeyCode.S) {
                        sPress.set(true);
                    }

                    if (e.getCode() == KeyCode.D) {
                        dPress.set(true);
                    }
                });

                aPaneScene.setOnKeyReleased(e -> {
                    if (e.getCode() == KeyCode.W) {
                        wPress.set(false);
                    }
                    if (e.getCode() == KeyCode.A) {
                        aPress.set(false);
                    }
                    if (e.getCode() == KeyCode.S) {
                        sPress.set(false);
                    }
                    if (e.getCode() == KeyCode.D) {
                        dPress.set(false);
                    }
                });

            }

             */


            @FXML
            protected void runMaze() {
                //PathTransition
                TranslateTransition translate = new TranslateTransition();
                translate.setNode(robot_id);
                translate.setByX(250);
                translate.play();

            }

            @FXML
            protected void carRunMaze() {

            }



        };
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        robotSetup();

        keyPressed.addListener(((observableValue, aBoolean, t1) -> {
            if (!aBoolean) {
                timer.start();
            } else {
                timer.stop();
            }
        }));
    }


    public void robotSetup() {
        aPaneScene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.W) {
                wPress.set(true);
            }

            if (e.getCode() == KeyCode.A) {
                aPress.set(true);
            }

            if (e.getCode() == KeyCode.S) {
                sPress.set(true);
            }

            if (e.getCode() == KeyCode.D) {
                dPress.set(true);
            }
        });

        aPaneScene.setOnKeyReleased(e -> {
            if (e.getCode() == KeyCode.W) {
                wPress.set(false);
            }
            if (e.getCode() == KeyCode.A) {
                aPress.set(false);
            }
            if (e.getCode() == KeyCode.S) {
                sPress.set(false);
            }
            if (e.getCode() == KeyCode.D) {
                dPress.set(false);
            }
        });

    }
}





