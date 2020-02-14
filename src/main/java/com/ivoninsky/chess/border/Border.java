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

    public Canvas paintBorder() {
        for (int j = 0; j < 8; j++) {
            for (int i = 0; i < 8; i++) {
                if (i % 2 == 0 && j % 2 == 0) {
                    gc.setFill(Color.BISQUE);
                    gc.fillRect(i * BorderSize.getRC(), j * BorderSize.getRC(), BorderSize.getRC(), BorderSize.getRC());
                } else if (i % 2 != 0 && j % 2 != 0) {
                    gc.setFill(Color.BISQUE);
                    gc.fillRect(i * BorderSize.getRC(), j * BorderSize.getRC(), BorderSize.getRC(), BorderSize.getRC());
                } else if (i % 2 != 0) {
                    gc.setFill(Color.GRAY);
                    gc.fillRect(i * BorderSize.getRC(), j * BorderSize.getRC(), BorderSize.getRC(), BorderSize.getRC());
                } else {
                    gc.setFill(Color.GRAY);
                    gc.fillRect(i * BorderSize.getRC(), j * BorderSize.getRC(), BorderSize.getRC(), BorderSize.getRC());
                }
            }
        }
        return canvas;
    }
}
