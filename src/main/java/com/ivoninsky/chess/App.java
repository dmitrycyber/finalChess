package com.ivoninsky.chess;

import com.ivoninsky.chess.border.Border;
import com.ivoninsky.chess.border.BorderSize;
import com.ivoninsky.chess.figures.Figure;
import com.ivoninsky.chess.containers.FiguresContainer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;

import java.util.List;

public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();
        Canvas canvas = new Border().paintBorder();
        Scene scene = new Scene(root, BorderSize.getAC(), BorderSize.getAC());
        root.getChildren().add(canvas);
        primaryStage.setTitle("Chess");
        primaryStage.setScene(scene);

        FiguresContainer figuresContainer = new FiguresContainer(root);
        List<Figure> figureList = FiguresContainer.getFigureList();

        for (Figure figure : figureList){
            root.getChildren().add(figure.getImage());
            figure.moveFigure();
        }
        primaryStage.show();

    }
}
