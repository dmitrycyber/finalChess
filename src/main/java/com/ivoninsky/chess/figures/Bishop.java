package com.ivoninsky.chess.figures;

import com.ivoninsky.chess.coordinates.Coordinate;
import com.ivoninsky.chess.interfaces.FiguresContainer;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Bishop extends Figure {
    private ImageView bishop;
    private Coordinate coordinate;
    private String type;

    public Bishop(Coordinate coordinate, String type) {
        if (type.equals("b")){
            bishop = new ImageView(new Image("/images/bB.png"));
        }
        else {
            bishop = new ImageView(new Image("/images/wB.png"));
        }
        bishop.setX(coordinate.getCoordinateX());
        bishop.setY(coordinate.getCoordinateY());
        bishop.setFitHeight(100);
        bishop.setFitWidth(100);
        this.coordinate = new Coordinate(bishop.getX(), bishop.getY());
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
        return bishop;
    }

    @Override
    public Coordinate getCoordinate() {
        return coordinate;
    }
}
