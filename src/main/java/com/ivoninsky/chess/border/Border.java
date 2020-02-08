package com.ivoninsky.chess.border;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Border {
    private Canvas canvas;
    private GraphicsContext gc;

    public Border() {
        canvas = new Canvas(800, 800);
        gc = canvas.getGraphicsContext2D();
    }

    public Canvas paintBorder(){
        paintLightCells();
        paintDarkCells();
        return canvas;
    }

    private void paintLightCells(){
        gc.setFill(Color.BISQUE);
        for (int j = 0; j < 800; j+=100) {
            for (int i = 0; i < 800; i+=200) {
                if ((j / 100) % 2 != 0){
                    gc.fillRect(i + 100, j, 100, 100);
                }
                else {
                    gc.fillRect(i, j, 100, 100);
                }
            }
        }
    }

    private void paintDarkCells(){
        gc.setFill(Color.GRAY);
        for (int j = 0; j < 800; j+=100) {
            for (int i = 0; i < 800; i+=200) {
                if ((j / 100) % 2 == 0){
                    gc.fillRect(i + 100, j, 100, 100);
                }
                else {
                    gc.fillRect(i, j, 100, 100);
                }
            }
        }
    }
}
