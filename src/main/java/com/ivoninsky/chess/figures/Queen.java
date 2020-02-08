package com.ivoninsky.chess.figures;

import com.ivoninsky.chess.coordinates.Coordinate;
import com.ivoninsky.chess.interfaces.FiguresContainer;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Queen extends Figure {
    private ImageView queen;
    private Coordinate coordinate;
    private String type;

    public Queen(Coordinate coordinate, String type) {
        if (type.equals("b")){
            queen = new ImageView(new Image("/images/bQ.png"));
        }
        else {
            queen = new ImageView(new Image("/images/wQ.png"));
        }
        queen.setX(coordinate.getCoordinateX());
        queen.setY(coordinate.getCoordinateY());
        queen.setFitHeight(100);
        queen.setFitWidth(100);
        this.coordinate = new Coordinate(queen.getX(), queen.getY());
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
        return queen;
    }

    @Override
    public Coordinate getCoordinate() {
        return coordinate;
    }
}
