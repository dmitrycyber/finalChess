package com.ivoninsky.chess.coordinates;

import com.ivoninsky.chess.border.BorderSize;

public enum Move {
    UP(new Coordinate(0, -BorderSize.getRC())),
    DOWN(new Coordinate(0, BorderSize.getRC())),
    LEFT(new Coordinate(-BorderSize.getRC(), 0)),
    RIGHT(new Coordinate(BorderSize.getRC(), 0)),
    RIGHT_UP(new Coordinate(BorderSize.getRC(), -BorderSize.getRC())),
    LEFT_UP(new Coordinate(-BorderSize.getRC(), -BorderSize.getRC())),
    RIGHT_DOWN(new Coordinate(BorderSize.getRC(), BorderSize.getRC())),
    LEFT_DOWN(new Coordinate(-BorderSize.getRC(), BorderSize.getRC()));

    private Coordinate coordinate;

    Move(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public Coordinate getCoordinate() {
        coordinate.setCoordinateX(coordinate.getCoordinateX());
        coordinate.setCoordinateY(coordinate.getCoordinateY());
        return coordinate;
    }


}
