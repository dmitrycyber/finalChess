package com.ivoninsky.chess.figures;

import com.ivoninsky.chess.coordinates.Coordinate;
import com.ivoninsky.chess.interfaces.FiguresContainer;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class King extends Figure {
    private ImageView king;
    private Coordinate coordinate;
    private String type;

    public King(Coordinate coordinate, String type) {
        if (type.equals("b")){
            king = new ImageView(new Image("/images/bK.png"));
        }
        else {
            king = new ImageView(new Image("/images/wK.png"));
        }
        king.setX(coordinate.getCoordinateX());
        king.setY(coordinate.getCoordinateY());
        king.setFitHeight(100);
        king.setFitWidth(100);
        this.coordinate = new Coordinate(king.getX(), king.getY());
        this.type = type;
    }



    @Override
    public void moveFigure(FiguresContainer figuresContainer) {

    }

    @Override
    public boolean isPossibleToMove(int destinationX, int destinationY) {
        return false;
    }

    @Override
    public boolean isPossibleToFight(int destinationX, int destinationY) {
        return false;
    }

    @Override
    public void move(int destinationX, int destinationY) {

    }

    @Override
    public String getTypeOfFigure() {
        return type;
    }

    @Override
    public ImageView getImage() {
        return king;
    }

    @Override
    public Coordinate getCoordinate() {
        return coordinate;
    }

    @Override
    public String toString() {
        return "King{" +
                "king=" + king +
                ", coordinate=" + coordinate +
                ", type='" + type + '\'' +
                '}';
    }
}
