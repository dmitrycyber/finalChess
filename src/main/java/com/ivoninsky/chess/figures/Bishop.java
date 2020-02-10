package com.ivoninsky.chess.figures;

import com.ivoninsky.chess.coordinates.Coordinate;
import com.ivoninsky.chess.coordinates.CoordinatesContainer;
import com.ivoninsky.chess.interfaces.FiguresContainer;
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
        bishop.setFitHeight(100);
        bishop.setFitWidth(100);
        this.coordinate = new Coordinate(bishop.getX(), bishop.getY());
        this.type = type;
    }

    @Override
    public void moveFigure() {
        bishop.setOnMouseReleased(event ->
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
                move(destinationX, destinationY, bishop, coordinate, type);
            }
            else if (isPossibleToFight(destinationX, destinationY)) {
                FiguresContainer.removeFigure(new Coordinate(destinationX, destinationY));
                System.out.println(FiguresContainer.getFigureList());
                move(destinationX, destinationY, bishop, coordinate, type);
            }
            else {
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
                for (int i = 100; i < multiply; i += 100) {
                    if (!CoordinatesContainer.getInstance().getCoordinateStringMap().get(new Coordinate(currentX + i, currentY + i)).equals("n")) {
                        return false;
                    }
                }
            }
            else  if (currentX > destinationX && currentY > destinationY){
                for (int i = 100; i < multiply; i += 100) {
                    if (!CoordinatesContainer.getInstance().getCoordinateStringMap().get(new Coordinate(currentX - i, currentY - i)).equals("n")) {
                        return false;
                    }
                }
            }
            else  if (currentX < destinationX && currentY > destinationY){
                for (int i = 100; i < multiply; i += 100) {
                    if (!CoordinatesContainer.getInstance().getCoordinateStringMap().get(new Coordinate(currentX + i, currentY - i)).equals("n")) {
                        return false;
                    }
                }
            }
            else  if (currentX > destinationX && currentY < destinationY){
                for (int i = 100; i < multiply; i += 100) {
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
