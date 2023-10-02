package com.example.csc311_hw3;

import javafx.animation.AnimationTimer;
import javafx.animation.PathTransition;
import javafx.animation.TranslateTransition;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Polyline;
import javafx.util.Duration;

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
    @FXML
    private Button startBtn;

    AnimationTimer timer;

    //Method for robot to run through the maze
    @FXML
    public void runMaze(ActionEvent actionEvent) {
        //PathTransition
        Polyline polyline  = new Polyline();
        //Sets the coordinates
        polyline.getPoints().addAll(new Double[]{
                11.0,12.0,
                50.0, 12.0,
                50.0,-85.0,
                249.0,-85.0,
                249.0, -135.0,
                295.0, -135.0,
                295.0, 65.0,
                347.0, 65.0,
                347.0, -33.0,
                450.0,-33.0,
                450.0, -130.0,
                500.0, -130.0,
                500.0, 00.0,
                530.0, 00.0
        });
        PathTransition transition = new PathTransition();
        //Sets the node
        transition.setNode(robot_id);
        transition.setPath(polyline);
        //Sets the duration of the robot to make to the end.
        transition.setDuration(Duration.seconds(8));
        transition.play();
    }

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

            @FXML
            private void carRunMaze(){
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