package com.ivoninsky.chess.figures;

import com.ivoninsky.chess.border.BorderSize;
import com.ivoninsky.chess.coordinates.Coordinate;
import com.ivoninsky.chess.containers.CoordinatesContainer;
import com.ivoninsky.chess.containers.FiguresContainer;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Knight extends Figure {
    private ImageView knight;
    private Coordinate coordinate;
    private String type;

    public Knight(Coordinate coordinate, String type) {
        if (type.equals("b")) {
            knight = new ImageView(new Image("/images/bN.png"));
        } else {
            knight = new ImageView(new Image("/images/wN.png"));
        }
        knight.setX(coordinate.getCoordinateX());
        knight.setY(coordinate.getCoordinateY());
        knight.setFitHeight(BorderSize.getRC());
        knight.setFitWidth(BorderSize.getRC());
        this.coordinate = new Coordinate(knight.getX(), knight.getY());
        this.type = type;
    }


    @Override
    public void moveFigure() {
        setMoveAnimation(knight);
        knight.setOnMouseReleased(event ->
        {
            knight.setEffect(null);
            double sceneX = event.getSceneX();
            double sceneY = event.getSceneY();
            if (sceneX > BorderSize.getRC() * 8 || sceneY > BorderSize.getRC() * 8 || sceneX < 0 || sceneY < 0) {
                System.out.println("It's impossible to move here!");
                knight.setX(coordinate.getCoordinateX());
                knight.setY(coordinate.getCoordinateY());
                return;
            }
            int destinationX = (int) (sceneX - (sceneX % BorderSize.getRC()));
            int destinationY = (int) (sceneY - (sceneY % BorderSize.getRC()));
            if (isPossibleToFight(destinationX, destinationY)) {
                FiguresContainer.removeFigure(new Coordinate(destinationX, destinationY));
                move(destinationX, destinationY, knight, coordinate, type);
            } else if (isPossibleToMove(destinationX, destinationY)) {
                move(destinationX, destinationY, knight, coordinate, type);

            } else {
                knight.setX(coordinate.getCoordinateX());
                knight.setY(coordinate.getCoordinateY());
                System.out.println("It's impossible to move here!");
            }
        });
    }

    @Override
    public boolean isPossibleToMove(int destinationX, int destinationY) {
        int currentX = (int) this.coordinate.getCoordinateX();
        int currentY = (int) this.coordinate.getCoordinateY();
        if (!CoordinatesContainer.getInstance().getCoordinateStringMap().get(new Coordinate(destinationX, destinationY)).equals("n")) {
            return false;
        }
        if (Math.abs(destinationY - currentY) == BorderSize.getRC() * 2 && Math.abs(destinationX - currentX) == BorderSize.getRC()) {
            return true;
        } else if (Math.abs(destinationY - currentY) == BorderSize.getRC() && Math.abs(destinationX - currentX) == BorderSize.getRC() * 2) {
            return true;
        }
        return false;
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
        return knight;
    }

    @Override
    public Coordinate getCoordinate() {
        return coordinate;
    }
}
