package Interfaz.Handlers;

import Interfaz.Vistas.VistaInicial;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class InicializadorSpider extends Button {

    private Pane lienzo;
    private VistaInicial observer;

    public InicializadorSpider(Pane lienzo, VistaInicial observer){
        this.lienzo = lienzo;
        this.observer = observer;
        setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                handleButtonClick();
            }
        });
    }

    public void handleButtonClick() {
        //BorderPane root = new BorderPane();

        var canvas = new Canvas();
        resizeCanvas(canvas, lienzo.getWidth(), lienzo.getHeight());

        // Add a listener to handle lienzo resizing
        lienzo.widthProperty().addListener((obs, oldVal, newVal) ->
                resizeCanvas(canvas, newVal.doubleValue(), lienzo.getHeight()));

        lienzo.heightProperty().addListener((obs, oldVal, newVal) ->
                resizeCanvas(canvas, lienzo.getWidth(), newVal.doubleValue()));

        lienzo.getChildren().add(canvas);
        //root.setCenter(canvas);

        // Scene scene = new Scene(root);

        // lienzo.setScene(scene);
    }

    private void resizeCanvas(Canvas canvas, double width, double height) {
        canvas.setWidth(width);
        canvas.setHeight(height);

        Color backgroundColor = Color.rgb(28, 170, 23, 0.8);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, width, height);
        gc.setFill(backgroundColor);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

        double rectangleWidth = 50;
        double rectangleHeight = 150;
        double spacing = 20;

        double firstRectangleX = spacing;
        double secondRectangleX = width - spacing - rectangleWidth;

        // Draw the first rectangle
        gc.setFill(Color.RED);
        gc.fillRect(firstRectangleX, (height - rectangleHeight) / 2, rectangleWidth, rectangleHeight);

        // Draw the second rectangle
        gc.setFill(Color.GREEN);
        gc.fillRect(secondRectangleX, (height - rectangleHeight) / 2, rectangleWidth, rectangleHeight);

        // Add numbers inside the rectangles
        gc.setFill(Color.WHITE);
        gc.fillText("3", firstRectangleX + rectangleWidth / 2 - 5, height / 2 + 5);
        gc.fillText("4", secondRectangleX + rectangleWidth / 2 - 5, height / 2 + 5);
    }
}
