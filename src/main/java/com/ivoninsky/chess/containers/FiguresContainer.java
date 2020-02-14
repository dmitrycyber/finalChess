package com.ivoninsky.chess.containers;

import com.ivoninsky.chess.coordinates.Coordinate;
import com.ivoninsky.chess.figures.*;
import javafx.scene.Group;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FiguresContainer {
    private static List<Figure> figureList = new ArrayList<>();

    private Pawn whitePawn1;
    private Pawn whitePawn2;
    private Pawn whitePawn3;
    private Pawn whitePawn4;
    private Pawn whitePawn5;
    private Pawn whitePawn6;
    private Pawn whitePawn7;
    private Pawn whitePawn8;
    private Rook whiteRook1;
    private Rook whiteRook2;
    private Knight whiteKnight1;
    private Knight whiteKnight2;
    private Bishop whiteBishop1;
    private Bishop whiteBishop2;
    private Queen whiteQueen;
    private King whiteKing;

    private Pawn blackPawn1;
    private Pawn blackPawn2;
    private Pawn blackPawn3;
    private Pawn blackPawn4;
    private Pawn blackPawn5;
    private Pawn blackPawn6;
    private Pawn blackPawn7;
    private Pawn blackPawn8;
    private Rook blackRook1;
    private Rook blackRook2;
    private Knight blackKnight1;
    private Knight blackKnight2;
    private Bishop blackBishop1;
    private Bishop blackBishop2;
    private Queen blackQueen;
    private King blackKing;

    private static Group root;

    public FiguresContainer(Group root) {

        this.root = root;
        whitePawn1 = new Pawn(CoordinatesContainer.getInstance().getA2(), "w");
        whitePawn2 = new Pawn(CoordinatesContainer.getInstance().getB2(), "w");
        whitePawn3 = new Pawn(CoordinatesContainer.getInstance().getC2(), "w");
        whitePawn4 = new Pawn(CoordinatesContainer.getInstance().getD2(), "w");
        whitePawn5 = new Pawn(CoordinatesContainer.getInstance().getE2(), "w");
        whitePawn6 = new Pawn(CoordinatesContainer.getInstance().getF2(), "w");
        whitePawn7 = new Pawn(CoordinatesContainer.getInstance().getG2(), "w");
        whitePawn8 = new Pawn(CoordinatesContainer.getInstance().getH2(), "w");
        whiteRook1 = new Rook(CoordinatesContainer.getInstance().getA1(), "w");
        whiteRook2 = new Rook(CoordinatesContainer.getInstance().getH1(), "w");
        whiteKnight1 = new Knight(CoordinatesContainer.getInstance().getB1(), "w");
        whiteKnight2 = new Knight(CoordinatesContainer.getInstance().getG1(), "w");
        whiteBishop1 = new Bishop(CoordinatesContainer.getInstance().getC1(), "w");
        whiteBishop2 = new Bishop(CoordinatesContainer.getInstance().getF1(), "w");
        whiteQueen = new Queen(CoordinatesContainer.getInstance().getD1(), "w");
        whiteKing = new King(CoordinatesContainer.getInstance().getE1(), "w");

        blackPawn1 = new Pawn(CoordinatesContainer.getInstance().getA7(), "b");
        blackPawn2 = new Pawn(CoordinatesContainer.getInstance().getB7(), "b");
        blackPawn3 = new Pawn(CoordinatesContainer.getInstance().getC7(), "b");
        blackPawn4 = new Pawn(CoordinatesContainer.getInstance().getD7(), "b");
        blackPawn5 = new Pawn(CoordinatesContainer.getInstance().getE7(), "b");
        blackPawn6 = new Pawn(CoordinatesContainer.getInstance().getF7(), "b");
        blackPawn7 = new Pawn(CoordinatesContainer.getInstance().getG7(), "b");
        blackPawn8 = new Pawn(CoordinatesContainer.getInstance().getH7(), "b");
        blackRook1 = new Rook(CoordinatesContainer.getInstance().getA8(), "b");
        blackRook2 = new Rook(CoordinatesContainer.getInstance().getH8(), "b");
        blackKnight1 = new Knight(CoordinatesContainer.getInstance().getB8(), "b");
        blackKnight2 = new Knight(CoordinatesContainer.getInstance().getG8(), "b");
        blackBishop1 = new Bishop(CoordinatesContainer.getInstance().getC8(), "b");
        blackBishop2 = new Bishop(CoordinatesContainer.getInstance().getF8(), "b");
        blackQueen = new Queen(CoordinatesContainer.getInstance().getD8(), "b");
        blackKing = new King(CoordinatesContainer.getInstance().getE8(), "b");

        addFigureToList(whitePawn1, whitePawn2, whitePawn3, whitePawn4, whitePawn5, whitePawn6, whitePawn7, whitePawn8, blackPawn1, blackPawn2, blackPawn3, blackPawn4, blackPawn5, blackPawn6, blackPawn7, blackPawn8, whiteRook1, whiteRook2, blackRook1, blackRook2, whiteBishop1, whiteBishop2, blackBishop1, blackBishop2, whiteKnight1, whiteKnight2, blackKnight1, blackKnight2, whiteKing, blackKing, whiteQueen, blackQueen);
        addFigureToCoordinateMap(whitePawn1, whitePawn2, whitePawn3, whitePawn4, whitePawn5, whitePawn6, whitePawn7, whitePawn8, blackPawn1, blackPawn2, blackPawn3, blackPawn4, blackPawn5, blackPawn6, blackPawn7, blackPawn8, whiteRook1, whiteRook2, blackRook1, blackRook2, whiteBishop1, whiteBishop2, blackBishop1, blackBishop2, whiteKnight1, whiteKnight2, blackKnight1, blackKnight2, whiteKing, blackKing, whiteQueen, blackQueen);
    }

    private void addFigureToCoordinateMap(Figure... figures) {
        for (Figure figure : figures) {
            CoordinatesContainer.getInstance().getCoordinateStringMap().put(figure.getCoordinate(), figure.getTypeOfFigure());
        }
    }

    private void addFigureToList(Figure... figures) {
        figureList.addAll(Arrays.asList(figures));

    }

    public static List<Figure> getFigureList() {
        return figureList;
    }

    public static void removeFigure(Coordinate coordinate) {

        Figure figure = null;
        for (int i = 0; i < figureList.size(); i++) {
            if (figureList.get(i).getCoordinate().equals(coordinate)) {
                figure = figureList.get(i);
            }
        }
        if (figure instanceof King) {
            if (figure.getTypeOfFigure().equals("w")) {
                System.out.println("BLACK WINNER!!!");
                System.exit(1);
            }
            System.out.println("WHITE WINNER!!!");
            System.exit(1);
        }
        CoordinatesContainer.getInstance().getCoordinateStringMap().remove(figure);
        figureList.remove(figure);
        root.getChildren().removeAll(figure.getImage());
    }

    public static List<Figure> getFiguresFromType(String type) {
        return figureList
                .stream()
                .filter(figure -> figure.getTypeOfFigure().equals(type))
                .collect(Collectors.toList());
    }
}
