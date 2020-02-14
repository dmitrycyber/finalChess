package com.ivoninsky.chess.figures;

import com.ivoninsky.chess.border.BorderSize;
import com.ivoninsky.chess.coordinates.Coordinate;
import com.ivoninsky.chess.containers.CoordinatesContainer;
import com.ivoninsky.chess.containers.FiguresContainer;
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
        rook.setFitHeight(BorderSize.getRC());
        rook.setFitWidth(BorderSize.getRC());
        this.coordinate = new Coordinate(rook.getX(), rook.getY());
        this.type = type;
    }

    @Override
    public void moveFigure() {
        setMoveAnimation(rook);
        rook.setOnMouseReleased(event ->
        {
            rook.setEffect(null);
            double sceneX = event.getSceneX();
            double sceneY = event.getSceneY();
            if (sceneX > BorderSize.getRC() * 8 || sceneY > BorderSize.getRC() * 8 || sceneX < 0 || sceneY < 0) {
                System.out.println("It's impossible to move here!");
                rook.setX(coordinate.getCoordinateX());
                rook.setY(coordinate.getCoordinateY());
                return;
            }
            int destinationX = (int) (sceneX - (sceneX % BorderSize.getRC()));
            int destinationY = (int) (sceneY - (sceneY % BorderSize.getRC()));

            if (isPossibleToMove(destinationX, destinationY)) {
                move(destinationX, destinationY, rook, coordinate, type);
            } else if (isPossibleToFight(destinationX, destinationY)) {
                FiguresContainer.removeFigure(new Coordinate(destinationX, destinationY));
                move(destinationX, destinationY, rook, coordinate, type);
            } else {
                rook.setX(coordinate.getCoordinateX());
                rook.setY(coordinate.getCoordinateY());
                System.out.println("It's impossible to move here!");
            }
        });
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
                for (double i = currentY + BorderSize.getRC(); i <= destinationY; i += BorderSize.getRC()) {
                    if (!CoordinatesContainer.getInstance().getCoordinateStringMap().get(new Coordinate(currentX, i)).equals("n")) {
                        return false;
                    }
                }
            } else {
                for (double i = currentY - BorderSize.getRC(); i >= destinationY; i -= BorderSize.getRC()) {
                    if (!CoordinatesContainer.getInstance().getCoordinateStringMap().get(new Coordinate(currentX, i)).equals("n")) {
                        return false;
                    }
                }
            }
        } else if (destinationY == currentY) {
            if (destinationX > currentX) {
                for (double i = currentX + BorderSize.getRC(); i <= destinationX; i += BorderSize.getRC()) {
                    if (!CoordinatesContainer.getInstance().getCoordinateStringMap().get(new Coordinate(i, currentY)).equals("n")) {
                        return false;
                    }
                }
            } else {
                for (double i = currentX - BorderSize.getRC(); i >= destinationX; i -= BorderSize.getRC()) {
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
