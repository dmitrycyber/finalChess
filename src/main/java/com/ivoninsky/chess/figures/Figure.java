package com.ivoninsky.chess.figures;

import com.ivoninsky.chess.border.BorderSize;
import com.ivoninsky.chess.coordinates.Coordinate;
import com.ivoninsky.chess.containers.CoordinatesContainer;
import com.ivoninsky.chess.containers.FiguresContainer;
import javafx.scene.effect.Shadow;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

import java.util.List;
import java.util.Random;


public abstract class Figure {

    public abstract void moveFigure();

    public void move(int destinationX, int destinationY, ImageView imageView, Coordinate coordinate, String type) {
        CoordinatesContainer.getInstance().getCoordinateStringMap().put(coordinate, "n");
        imageView.setX(destinationX);
        imageView.setY(destinationY);
        imageView.toFront();
        coordinate.setCoordinateX(destinationX);
        coordinate.setCoordinateY(destinationY);
        CoordinatesContainer.getInstance().getCoordinateStringMap().put(coordinate, getTypeOfFigure());
        CoordinatesContainer.getInstance().printField();
        Random rand = new Random();
        float rW = (float) (rand.nextFloat() / 2f + 0.5);
        float gW = (float) (rand.nextFloat() / 2f + 0.5);
        float bW = (float) (rand.nextFloat() / 2f + 0.5);
        Color randomColorWhite = Color.color(rW, gW, bW);

        float rB = (float) (rand.nextFloat() / 2f + 0.1);
        float gB = (float) (rand.nextFloat() / 2f + 0.1);
        float bB = (float) (rand.nextFloat() / 2f + 0.1);
        Color randomColorBlack = Color.color(rB, gB, bB);



        Shadow shadowWhite = new Shadow(1, randomColorWhite);
        Shadow shadowBlack = new Shadow(1, randomColorBlack);
        if (type.equals("w")) {
            System.out.println("Black need to run now!");
            for (Figure figure : FiguresContainer.getFiguresFromType("w")) {

                figure.getImage().setEffect(shadowWhite);
                figure.getImage().setDisable(true);
            }
            for (Figure figure : FiguresContainer.getFiguresFromType("b")) {
                figure.getImage().setDisable(false);
            }
        }
        else {
            System.out.println("White need to run now!");
            for (Figure figure : FiguresContainer.getFiguresFromType("w")) {
                figure.getImage().setDisable(false);
            }
            for (Figure figure : FiguresContainer.getFiguresFromType("b")) {
                figure.getImage().setDisable(true);
                figure.getImage().setEffect(shadowBlack);
            }
        }
    }

    public void setMoveAnimation(ImageView imageView) {
        Shadow shadow = new Shadow(1, Color.RED);
        imageView.setOnMouseDragged(event ->
        {
            imageView.setX(event.getSceneX() - BorderSize.getRC() / 2);
            imageView.setY(event.getSceneY() - BorderSize.getRC() / 2);
            imageView.setEffect(shadow);
        });
    }

    public abstract boolean isPossibleToMove(int destinationX, int destinationY);

    public abstract boolean isPossibleToFight(int destinationX, int destinationY);

    public abstract String getTypeOfFigure();

    public abstract ImageView getImage();

    public abstract Coordinate getCoordinate();
}
