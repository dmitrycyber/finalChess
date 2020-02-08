package com.ivoninsky.chess.figures;

import com.ivoninsky.chess.coordinates.Coordinate;
import com.ivoninsky.chess.coordinates.CoordinatesContainer;
import com.ivoninsky.chess.coordinates.Move;
import com.ivoninsky.chess.interfaces.FiguresContainer;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Pawn extends Figure {
    private ImageView pawn;
    private Coordinate coordinate;
    private String type;

    public Pawn(Coordinate coordinate, String type) {
        if (type.equals("b")){
            pawn = new ImageView(new Image("/images/bP.png"));
        }
        else {
            pawn = new ImageView(new Image("/images/wP.png"));
        }
        pawn.setX(coordinate.getCoordinateX());
        pawn.setY(coordinate.getCoordinateY());
        pawn.setFitHeight(100);
        pawn.setFitWidth(100);
        this.coordinate = new Coordinate(pawn.getX(), pawn.getY());
        this.type = type;
    }

    @Override
    public void moveFigure(FiguresContainer figuresContainer) {
        pawn.setOnMouseReleased(event ->
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

    public void move(int destinationX, int destinationY) {
        CoordinatesContainer.getInstance().getCoordinateStringMap().put(coordinate, "n");
        pawn.setX(destinationX);
        pawn.setY(destinationY);
        pawn.toFront();
        coordinate.setCoordinateX(destinationX);
        coordinate.setCoordinateY(destinationY);
        CoordinatesContainer.getInstance().getCoordinateStringMap().put(coordinate, getTypeOfFigure());
        CoordinatesContainer.getInstance().printField();
    }

    @Override
    public boolean isPossibleToMove(int destinationX, int destinationY) {
        int currentX = (int) this.coordinate.getCoordinateX();
        int currentY = (int) this.coordinate.getCoordinateY();

        int additionalXBlack = (int) Move.DOWN.getCoordinate().getCoordinateX();
        int additionalYBlack = (int) Move.DOWN.getCoordinate().getCoordinateY();
        int additionalXWhite = (int) Move.UP.getCoordinate().getCoordinateX();
        int additionalYWhite = (int) Move.UP.getCoordinate().getCoordinateY();

        if (type.equals("b")){
            if (destinationX == currentX + additionalXBlack && destinationY == currentY + additionalYBlack && CoordinatesContainer.getInstance().getCoordinateStringMap().get(new Coordinate(destinationX, destinationY)).equals("n")){
                return true;
            }
        }
        else if (type.equals("w")){
            if (destinationX == currentX + additionalXWhite && destinationY == currentY + additionalYWhite && CoordinatesContainer.getInstance().getCoordinateStringMap().get(new Coordinate(destinationX, destinationY)).equals("n")){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isPossibleToFight(int destinationX, int destinationY) {
        int currentX = (int) this.coordinate.getCoordinateX();
        int currentY = (int) this.coordinate.getCoordinateY();

        int additionalX1Black = (int) Move.RIGHT_DOWN.getCoordinate().getCoordinateX();
        int additionalY1Black = (int) Move.RIGHT_DOWN.getCoordinate().getCoordinateY();
        int additionalX2Black = (int) Move.LEFT_DOWN.getCoordinate().getCoordinateX();
        int additionalY2Black = (int) Move.LEFT_DOWN.getCoordinate().getCoordinateY();

        int additionalX1White = (int) Move.RIGHT_UP.getCoordinate().getCoordinateX();
        int additionalY1White = (int) Move.RIGHT_UP.getCoordinate().getCoordinateY();
        int additionalX2White = (int) Move.LEFT_UP.getCoordinate().getCoordinateX();
        int additionalY2White = (int) Move.LEFT_UP.getCoordinate().getCoordinateY();

        int checkX1Black = currentX + additionalX1Black;
        int checkY1Black = currentY + additionalY1Black;
        int checkX2Black = currentX + additionalX2Black;
        int checkY2Black = currentY + additionalY2Black;

        int checkX1White = currentX + additionalX1White;
        int checkY1White = currentY + additionalY1White;
        int checkX2White = currentX + additionalX2White;
        int checkY2White = currentY + additionalY2White;
        if (type.equals("b")){
            if ((checkX1Black == destinationX && checkY1Black == destinationY) || (checkX2Black == destinationX && checkY2Black == destinationY)){
                if (CoordinatesContainer.getInstance().getCoordinateStringMap().get(new Coordinate(destinationX, destinationY)).equals("w")){
                    return true;
                }
            }

        }
        else {
            if ((checkX1White == destinationX && checkY1White == destinationY) || (checkX2White == destinationX && checkY2White == destinationY)){
                if (CoordinatesContainer.getInstance().getCoordinateStringMap().get(new Coordinate(destinationX, destinationY)).equals("b")){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String getTypeOfFigure() {
        return type;
    }

    @Override
    public ImageView getImage() {
        return pawn;
    }

    @Override
    public Coordinate getCoordinate() {
        return coordinate;
    }

    @Override
    public String toString() {
        return "Pawn{" +
                "pawn=" + pawn +
                ", coordinate=" + coordinate +
                ", type='" + type + '\'' +
                '}';
    }
}
