package com.ivoninsky.chess.figures;

import com.ivoninsky.chess.border.BorderSize;
import com.ivoninsky.chess.coordinates.Coordinate;
import com.ivoninsky.chess.containers.CoordinatesContainer;
import com.ivoninsky.chess.containers.FiguresContainer;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Queen extends Figure {
    private ImageView queen;
    private Coordinate coordinate;
    private String type;

    public Queen(Coordinate coordinate, String type) {
        if (type.equals("b")) {
            queen = new ImageView(new Image("/images/bQ.png"));
        } else {
            queen = new ImageView(new Image("/images/wQ.png"));
        }
        queen.setX(coordinate.getCoordinateX());
        queen.setY(coordinate.getCoordinateY());
        queen.setFitHeight(BorderSize.getRC());
        queen.setFitWidth(BorderSize.getRC());
        this.coordinate = new Coordinate(queen.getX(), queen.getY());
        this.type = type;
    }


    @Override
    public void moveFigure() {
        setMoveAnimation(queen);
        queen.setOnMouseReleased(event ->
        {
            queen.setEffect(null);
            double sceneX = event.getSceneX();
            double sceneY = event.getSceneY();
            if (sceneX > BorderSize.getRC() * 8 || sceneY > BorderSize.getRC() * 8 || sceneX < 0 || sceneY < 0) {
                System.out.println("It's impossible to move here!");
                queen.setX(coordinate.getCoordinateX());
                queen.setY(coordinate.getCoordinateY());
                return;
            }
            int destinationX = (int) (sceneX - (sceneX % BorderSize.getRC()));
            int destinationY = (int) (sceneY - (sceneY % BorderSize.getRC()));
            if (isPossibleToMove(destinationX, destinationY)) {
                move(destinationX, destinationY, queen, coordinate, type);
            } else if (isPossibleToFight(destinationX, destinationY)) {
                FiguresContainer.removeFigure(new Coordinate(destinationX, destinationY));
                System.out.println(FiguresContainer.getFigureList());
                move(destinationX, destinationY, queen, coordinate, type);
            } else {
                queen.setX(coordinate.getCoordinateX());
                queen.setY(coordinate.getCoordinateY());
                System.out.println("It's impossible to move here!");
            }
        });
    }

    @Override
    public boolean isPossibleToMove(int destinationX, int destinationY) {
        int currentX = (int) this.coordinate.getCoordinateX();
        int currentY = (int) this.coordinate.getCoordinateY();
        int multiply = Math.abs(currentY - destinationY);
        if (Math.abs(destinationY - currentY) == Math.abs(destinationX - currentX) || currentX == destinationX || currentY == destinationY) {
            // BISHOP
            if (Math.abs(destinationY - currentY) == Math.abs(destinationX - currentX)) {
                System.out.println("multiply= " + multiply);
                if (currentX < destinationX && currentY < destinationY) {
                    for (int i = (int) BorderSize.getRC(); i <= multiply; i += BorderSize.getRC()) {
                        if (!CoordinatesContainer.getInstance().getCoordinateStringMap().get(new Coordinate(currentX + i, currentY + i)).equals("n")) {
                            return false;
                        }
                    }
                } else if (currentX > destinationX && currentY > destinationY) {
                    for (int i = (int) BorderSize.getRC(); i <= multiply; i += BorderSize.getRC()) {
                        if (!CoordinatesContainer.getInstance().getCoordinateStringMap().get(new Coordinate(currentX - i, currentY - i)).equals("n")) {
                            return false;
                        }
                    }
                } else if (currentX < destinationX && currentY > destinationY) {
                    for (int i = (int) BorderSize.getRC(); i <= multiply; i += BorderSize.getRC()) {
                        if (!CoordinatesContainer.getInstance().getCoordinateStringMap().get(new Coordinate(currentX + i, currentY - i)).equals("n")) {
                            return false;
                        }
                    }
                } else if (currentX > destinationX && currentY < destinationY) {
                    for (int i = (int) BorderSize.getRC(); i <= multiply; i += BorderSize.getRC()) {
                        if (!CoordinatesContainer.getInstance().getCoordinateStringMap().get(new Coordinate(currentX - i, currentY + i)).equals("n")) {
                            return false;
                        }
                    }
                }
                return true;
            }
            //ROOK
            else if (currentX == destinationX || currentY == destinationY) {
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
        return queen;
    }

    @Override
    public Coordinate getCoordinate() {
        return coordinate;
    }
}
