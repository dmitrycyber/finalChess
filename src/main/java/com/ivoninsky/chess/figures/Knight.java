package com.ivoninsky.chess.figures;

import com.ivoninsky.chess.coordinates.Coordinate;
import com.ivoninsky.chess.coordinates.CoordinatesContainer;
import com.ivoninsky.chess.interfaces.FiguresContainer;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Knight extends Figure {
    private ImageView knight;
    private Coordinate coordinate;
    private String type;

    public Knight(Coordinate coordinate, String type) {
        if (type.equals("b")){
            knight = new ImageView(new Image("/images/bN.png"));
        }
        else {
            knight = new ImageView(new Image("/images/wN.png"));
        }
        knight.setX(coordinate.getCoordinateX());
        knight.setY(coordinate.getCoordinateY());
        knight.setFitHeight(100);
        knight.setFitWidth(100);
        this.coordinate = new Coordinate(knight.getX(), knight.getY());
        this.type = type;
    }


    @Override
    public void moveFigure() {
        knight.setOnMouseReleased(event ->
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
                move(destinationX, destinationY, knight, coordinate, type);
            }
            else if (isPossibleToMove(destinationX, destinationY)){
                move(destinationX, destinationY, knight, coordinate, type);

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
        if (!CoordinatesContainer.getInstance().getCoordinateStringMap().get(new Coordinate(destinationX, destinationY)).equals("n")){
            return false;
        }
        if (Math.abs(destinationY - currentY)  == 200 && Math.abs(destinationX - currentX) == 100){
            return true;
        }
        else if (Math.abs(destinationY - currentY)  == 100 && Math.abs(destinationX - currentX) == 200){
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
