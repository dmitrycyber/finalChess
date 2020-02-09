package com.ivoninsky.chess.figures;

import com.ivoninsky.chess.coordinates.Coordinate;
import com.ivoninsky.chess.coordinates.CoordinatesContainer;
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
        king.setOnMouseReleased(event ->
        {
            double sceneX = event.getSceneX();
            double sceneY = event.getSceneY();
            if (sceneX > 800 || sceneY > 800 || sceneX < 0 || sceneY < 0){
                System.out.println("It's impossible to move here!");
                return;
            }
            int destinationX = (int) (sceneX - (sceneX % 100));
            int destinationY = (int) (sceneY - (sceneY % 100));
            if (isPossibleToFight(destinationX, destinationY)){
                FiguresContainer.removeFigure(new Coordinate(destinationX, destinationY));
                move(destinationX, destinationY);
            }
            else if (isPossibleToMove(destinationX, destinationY)){
                move(destinationX, destinationY);

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
        if (Math.abs(currentX - destinationX) <= 100 && Math.abs(currentY - destinationY) <= 100){
            System.out.println("HERE");
            return true;
        }
        return false;
    }

    @Override
    public boolean isPossibleToFight(int destinationX, int destinationY) {
        if (type.equals("b")){
            return CoordinatesContainer.getInstance().getCoordinateStringMap().get(new Coordinate(destinationX, destinationY)).equals("w");
        }
        return CoordinatesContainer.getInstance().getCoordinateStringMap().get(new Coordinate(destinationX, destinationY)).equals("b");
    }

    @Override
    public void move(int destinationX, int destinationY) {
        CoordinatesContainer.getInstance().getCoordinateStringMap().put(coordinate, "n");
        king.setX(destinationX);
        king.setY(destinationY);
        king.toFront();
        coordinate.setCoordinateX(destinationX);
        coordinate.setCoordinateY(destinationY);
        CoordinatesContainer.getInstance().getCoordinateStringMap().put(coordinate, getTypeOfFigure());
        CoordinatesContainer.getInstance().printField();
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
