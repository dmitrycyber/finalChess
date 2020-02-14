package com.ivoninsky.chess.figures;

import com.ivoninsky.chess.border.BorderSize;
import com.ivoninsky.chess.coordinates.Coordinate;
import com.ivoninsky.chess.containers.CoordinatesContainer;
import com.ivoninsky.chess.containers.FiguresContainer;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Bishop extends Figure {
    private ImageView bishop;
    private Coordinate coordinate;
    private String type;

    public Bishop(Coordinate coordinate, String type) {
        if (type.equals("b")) {
            bishop = new ImageView(new Image("/images/bB.png"));
        } else {
            bishop = new ImageView(new Image("/images/wB.png"));
        }
        bishop.setX(coordinate.getCoordinateX());
        bishop.setY(coordinate.getCoordinateY());
        bishop.setFitHeight(BorderSize.getRC());
        bishop.setFitWidth(BorderSize.getRC());
        this.coordinate = new Coordinate(bishop.getX(), bishop.getY());
        this.type = type;
    }

    @Override
    public void moveFigure() {
        setMoveAnimation(bishop);
        bishop.setOnMouseReleased(event ->
        {
            bishop.setEffect(null);
            double sceneX = event.getSceneX();
            double sceneY = event.getSceneY();
            if (sceneX > BorderSize.getRC() * 8 || sceneY > BorderSize.getRC() * 8 || sceneX < 0 || sceneY < 0) {
                bishop.setX(coordinate.getCoordinateX());
                bishop.setY(coordinate.getCoordinateY());
                System.out.println("It's impossible to move here!");
                return;
            }
            int destinationX = (int) (sceneX - (sceneX % BorderSize.getRC()));
            int destinationY = (int) (sceneY - (sceneY % BorderSize.getRC()));
            if (isPossibleToMove(destinationX, destinationY)) {
                move(destinationX, destinationY, bishop, coordinate, type);
            } else if (isPossibleToFight(destinationX, destinationY)) {
                FiguresContainer.removeFigure(new Coordinate(destinationX, destinationY));
                System.out.println(FiguresContainer.getFigureList());
                move(destinationX, destinationY, bishop, coordinate, type);
            } else {
                bishop.setX(coordinate.getCoordinateX());
                bishop.setY(coordinate.getCoordinateY());
                System.out.println("It's impossible to move here!");
            }
        });
    }

    @Override
    public boolean isPossibleToMove(int destinationX, int destinationY) {
        int currentX = (int) this.coordinate.getCoordinateX();
        int currentY = (int) this.coordinate.getCoordinateY();
        int multiply = Math.abs(currentY - destinationY);
        if (!CoordinatesContainer.getInstance().getCoordinateStringMap().get(new Coordinate(destinationX, destinationY)).equals("n")) {
            return false;
        }
        if (Math.abs(destinationY - currentY) == Math.abs(destinationX - currentX)) {
            System.out.println("multiply= " + multiply);
            if (currentX < destinationX && currentY < destinationY) {
                for (int i = (int) BorderSize.getRC(); i < multiply; i += BorderSize.getRC()) {
                    if (!CoordinatesContainer.getInstance().getCoordinateStringMap().get(new Coordinate(currentX + i, currentY + i)).equals("n")) {
                        return false;
                    }
                }
            } else if (currentX > destinationX && currentY > destinationY) {
                for (int i = (int) BorderSize.getRC(); i < multiply; i += BorderSize.getRC()) {
                    if (!CoordinatesContainer.getInstance().getCoordinateStringMap().get(new Coordinate(currentX - i, currentY - i)).equals("n")) {
                        return false;
                    }
                }
            } else if (currentX < destinationX && currentY > destinationY) {
                for (int i = (int) BorderSize.getRC(); i < multiply; i += BorderSize.getRC()) {
                    if (!CoordinatesContainer.getInstance().getCoordinateStringMap().get(new Coordinate(currentX + i, currentY - i)).equals("n")) {
                        return false;
                    }
                }
            } else if (currentX > destinationX && currentY < destinationY) {
                for (int i = (int) BorderSize.getRC(); i < multiply; i += BorderSize.getRC()) {
                    if (!CoordinatesContainer.getInstance().getCoordinateStringMap().get(new Coordinate(currentX - i, currentY + i)).equals("n")) {
                        return false;
                    }
                }
            }
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
        return bishop;
    }

    @Override
    public Coordinate getCoordinate() {
        return coordinate;
    }
}
