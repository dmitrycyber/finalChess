package com.ivoninsky.chess.border;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Border {
    private Canvas canvas;
    private GraphicsContext gc;

    public Border() {
        canvas = new Canvas(BorderSize.getAC(), BorderSize.getAC());
        gc = canvas.getGraphicsContext2D();
    }

    public Canvas paintBorder(){
        paintLightCells();
        paintDarkCells();
        return canvas;
    }

    private void paintLightCells(){
        gc.setFill(Color.BISQUE);
        for (int j = 0; j < BorderSize.getAC(); j+=BorderSize.getRC()) {
            for (int i = 0; i < BorderSize.getAC(); i+=BorderSize.getRC()*2) {
                if ((j / BorderSize.getRC()) % 2 != 0){
                    gc.fillRect(i + BorderSize.getRC(), j, BorderSize.getRC(), BorderSize.getRC());
                }
                else {
                    gc.fillRect(i, j, BorderSize.getRC(), BorderSize.getRC());
                }
            }
        }
    }

    private void paintDarkCells(){
        gc.setFill(Color.GRAY);
        for (int j = 0; j < BorderSize.getAC(); j+=BorderSize.getRC()) {
            for (int i = 0; i < BorderSize.getAC(); i+=BorderSize.getRC()*2) {
                if ((j / BorderSize.getRC()) % 2 == 0){
                    gc.fillRect(i + BorderSize.getRC(), j, BorderSize.getRC(), BorderSize.getRC());
                }
                else {
                    gc.fillRect(i, j, BorderSize.getRC(), BorderSize.getRC());
                }
            }
        }
    }
}
