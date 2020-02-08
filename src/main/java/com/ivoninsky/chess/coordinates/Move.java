package com.ivoninsky.chess.coordinates;

public enum Move {
    UP (new Coordinate(0, -100)),
    DOWN (new Coordinate(0, 100)),
    LEFT (new Coordinate(-100, 0)),
    RIGHT (new Coordinate(100, 0)),
    RIGHT_UP (new Coordinate(100, -100)),
    LEFT_UP (new Coordinate(-100, -100)),
    RIGHT_DOWN (new Coordinate(100, 100)),
    LEFT_DOWN (new Coordinate(-100, 100));

    private Coordinate coordinate;

    Move(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public Coordinate getCoordinate(){
        coordinate.setCoordinateX(coordinate.getCoordinateX());
        coordinate.setCoordinateY(coordinate.getCoordinateY());
        return coordinate;
    }


}
