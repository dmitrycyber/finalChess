package com.ivoninsky.chess.figures;

import com.ivoninsky.chess.coordinates.Coordinate;
import com.ivoninsky.chess.containers.CoordinatesContainer;
import com.ivoninsky.chess.containers.FiguresContainer;
import javafx.scene.effect.Shadow;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;


public abstract class Figure {

    public abstract void moveFigure();
    public void move(int destinationX, int destinationY, ImageView imageView, Coordinate coordinate, String type){
        CoordinatesContainer.getInstance().getCoordinateStringMap().put(coordinate, "n");
        imageView.setX(destinationX);
        imageView.setY(destinationY);
        imageView.toFront();
        coordinate.setCoordinateX(destinationX);
        coordinate.setCoordinateY(destinationY);
        CoordinatesContainer.getInstance().getCoordinateStringMap().put(coordinate, getTypeOfFigure());
        CoordinatesContainer.getInstance().printField();
        if (type.equals("w")){
            System.out.println("Black need to run now!");
            for (Figure figure : FiguresContainer.getFiguresFromType("w")){
                figure.getImage().setDisable(true);
            }
            for (Figure figure : FiguresContainer.getFiguresFromType("b")){
                figure.getImage().setDisable(false);
            }
        }
        else {
            System.out.println("White need to run now!");
            for (Figure figure : FiguresContainer.getFiguresFromType("w")){
                figure.getImage().setDisable(false);
            }
            for (Figure figure : FiguresContainer.getFiguresFromType("b")){
                figure.getImage().setDisable(true);
            }
        }
    }
    public void setMoveAnimation(ImageView imageView){
        Shadow shadow = new Shadow(1, Color.RED);
        imageView.setOnMouseDragged(event ->
        {
            imageView.setX(event.getSceneX()-50);
            imageView.setY(event.getSceneY()-50);
            imageView.setEffect(shadow);
        });
    }

    public abstract boolean isPossibleToMove(int destinationX, int destinationY);
    public abstract boolean isPossibleToFight(int destinationX, int destinationY);
    public abstract String getTypeOfFigure();
    public abstract ImageView getImage();
    public abstract Coordinate getCoordinate();
}
