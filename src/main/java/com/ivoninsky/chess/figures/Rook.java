package com.ivoninsky.chess.figures;

import com.ivoninsky.chess.coordinates.Coordinate;
import com.ivoninsky.chess.coordinates.CoordinatesContainer;
import com.ivoninsky.chess.interfaces.FiguresContainer;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Rook extends Figure {
    private ImageView rook;
    private Coordinate coordinate;
    private String type;

    public Rook(Coordinate coordinate, String type) {
        if (type.equals("b")) {
            rook = new ImageView(new Image("/images/bR.png"));
        } else {
            rook = new ImageView(new Image("/images/wR.png"));
        }
        rook.setX(coordinate.getCoordinateX());
        rook.setY(coordinate.getCoordinateY());
        rook.setFitHeight(100);
        rook.setFitWidth(100);
        this.coordinate = new Coordinate(rook.getX(), rook.getY());
        this.type = type;
    }

    @Override
    public void moveFigure(FiguresContainer figuresContainer) {
        rook.setOnMouseReleased(event ->
        {
            double sceneX = event.getSceneX();
            double sceneY = event.getSceneY();
            if (sceneX > 800 || sceneY > 800 || sceneX < 0 || sceneY < 0) {
                System.out.println("It's impossible to move here!");
                return;
            }
            int destinationX = (int) (sceneX - (sceneX % 100));
            int destinationY = (int) (sceneY - (sceneY % 100));

            if (isPossibleToMove(destinationX, destinationY)) {
                move(destinationX, destinationY);
            }
            else if (isPossibleToFight(destinationX, destinationY)) {
                FiguresContainer.removeFigure(new Coordinate(destinationX, destinationY));
                move(destinationX, destinationY);
            }
            else {
                System.out.println("It's impossible to move here!");
            }
        });
    }

    @Override
    public void move(int destinationX, int destinationY) {
        CoordinatesContainer.getInstance().getCoordinateStringMap().put(coordinate, "n");
        rook.setX(destinationX);
        rook.setY(destinationY);
        rook.toFront();
        coordinate.setCoordinateX(destinationX);
        coordinate.setCoordinateY(destinationY);
        CoordinatesContainer.getInstance().getCoordinateStringMap().put(coordinate, getTypeOfFigure());
        CoordinatesContainer.getInstance().printField();
    }

    @Override
    public boolean isPossibleToMove(int destinationX, int destinationY) {
        int currentX = (int) this.coordinate.getCoordinateX();
        int currentY = (int) this.coordinate.getCoordinateY();
        if (destinationX != currentX & destinationY != currentY) {
            return false;
        }
        if (destinationX == currentX) {
            if (destinationY > currentY) {
                for (double i = currentY + 100; i <= destinationY; i += 100) {
                    if (!CoordinatesContainer.getInstance().getCoordinateStringMap().get(new Coordinate(currentX, i)).equals("n")) {
                        return false;
                    }
                }
            } else {
                for (double i = currentY - 100; i >= destinationY; i -= 100) {
                    if (!CoordinatesContainer.getInstance().getCoordinateStringMap().get(new Coordinate(currentX, i)).equals("n")) {
                        return false;
                    }
                }
            }
        } else if (destinationY == currentY) {
            if (destinationX > currentX) {
                for (double i = currentX + 100; i <= destinationX; i += 100) {
                    if (!CoordinatesContainer.getInstance().getCoordinateStringMap().get(new Coordinate(i, currentY)).equals("n")) {
                        return false;
                    }
                }
            } else {
                for (double i = currentX - 100; i >= destinationX; i -= 100) {
                    if (!CoordinatesContainer.getInstance().getCoordinateStringMap().get(new Coordinate(i, currentY)).equals("n")) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    @Override
    public boolean isPossibleToFight(int destinationX, int destinationY) {
        if (type.equals("b")) {
            return CoordinatesContainer.getInstance().getCoordinateStringMap().get(new Coordinate(destinationX, destinationY)).equals("w");
        }
        return CoordinatesContainer.getInstance().getCoordinateStringMap().get(new Coordinate(destinationX, destinationY)).equals("b");
    }

    @Override
    public String getTypeOfFigure() {
        return type;
    }

    @Override
    public ImageView getImage() {
        return rook;
    }

    @Override
    public Coordinate getCoordinate() {
        return coordinate;
    }
}
