package com.ivoninsky.chess;

import com.ivoninsky.chess.border.AdaptiveSize;
import com.ivoninsky.chess.border.Border;
import com.ivoninsky.chess.border.BorderSize;
import com.ivoninsky.chess.figures.Figure;
import com.ivoninsky.chess.containers.FiguresContainer;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();
        Canvas canvas = new Border().paintBorder();
        Scene scene = new Scene(root, BorderSize.getAC(), BorderSize.getAC());
        root.getChildren().add(canvas);
        primaryStage.setTitle("ShitChess");
        primaryStage.setScene(scene);
        List<Figure> figureList = new FiguresContainer(root).getFigureList();
        for (Figure figure : figureList) {
            root.getChildren().add(figure.getImage());
            figure.moveFigure();
        }
        primaryStage.show();


        primaryStage.widthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                double max = Math.min(primaryStage.getWidth(), primaryStage.getHeight());
                BorderSize.setAC(max);
                BorderSize.setRC(max/8);
                Group root1 = new Group();
                Canvas canvas1 = new Border().paintBorder();
                Scene scene1 = new Scene(root1, BorderSize.getAC(), BorderSize.getAC());
                root1.getChildren().add(canvas1);
                primaryStage.setScene(scene1);
                primaryStage.show();

            }
        });





//canvas.setOnMouseDragReleased(event -> System.out.printf("hi"));
//scene.setOnMouseDragReleased(event -> System.out.printf("1233"));
//        root.setOnMouseDragReleased(    event ->
//        {
//            System.out.println("Event done");
//            double max = Math.max(primaryStage.getWidth(), primaryStage.getHeight()) - 39;
//            BorderSize.setAC(max);
//            BorderSize.setRC(max/8);
//            Group root1 = new Group();
//            Canvas canvas1 = new Border().paintBorder();
//            Scene scene1 = new Scene(root1, BorderSize.getAC(), BorderSize.getAC());
//            root1.getChildren().add(canvas1);
//            primaryStage.setScene(scene1);
//            primaryStage.show();
//        });

//        ExecutorService executorService = Executors.newSingleThreadExecutor();
//        executorService.submit(new AdaptiveSize(scene, primaryStage, root));
    }


}
