package com.ivoninsky.chess.figures;

import com.ivoninsky.chess.coordinates.Coordinate;
import com.ivoninsky.chess.interfaces.FiguresContainer;
import javafx.scene.image.ImageView;


public abstract class Figure {
    private ImageView imageView;
    private Coordinate coordinate;
    private String type;

    public abstract void moveFigure(FiguresContainer figuresContainer);
    public abstract void move(int destinationX, int destinationY);
    public abstract boolean isPossibleToMove(int destinationX, int destinationY);
    public abstract boolean isPossibleToFight(int destinationX, int destinationY);
    public abstract String getTypeOfFigure();
    public abstract ImageView getImage();
    public abstract Coordinate getCoordinate();
}
