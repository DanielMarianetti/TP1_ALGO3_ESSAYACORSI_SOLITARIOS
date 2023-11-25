package Interfaz.Vistas.Helpers;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.shape.Rectangle;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class ObtensorImagenes {

    public static void SettearImagenFondo(Pane espacio) {
        try {
            String path = "ImagenesGUI/fondoResized.jpg";
            InputStream stream = new FileInputStream(path);
            Image imagen = new Image(stream);

            BackgroundSize backgroundSize = new BackgroundSize(
                    espacio.getWidth(),
                    espacio.getHeight(),
                    false,
                    false,
                    true,
                    false
            );

            espacio.setBackground(
                    new Background(
                            new BackgroundImage(
                                    imagen,
                                    BackgroundRepeat.NO_REPEAT,
                                    BackgroundRepeat.NO_REPEAT,
                                    BackgroundPosition.CENTER,
                                    backgroundSize
                            )
                    )
            );
        } catch (FileNotFoundException ex) {
            System.err.println("Error al intentar obtener la imagen de fondo");
        }
    }

    public static ImageView ObtenerImagenCarta(String identificador) throws FileNotFoundException {
        String path = "ImagenesGUI/"+ identificador + ".png";
        InputStream stream = new FileInputStream(path);
        ImageView imageView = new ImageView(new Image(stream));
        imageView.setFitWidth(73);
        imageView.setFitHeight(90);
        Rectangle clip = new Rectangle(imageView.getFitWidth(), imageView.getFitHeight());
        clip.setArcWidth(20);
        clip.setArcHeight(20);
        imageView.setClip(clip);
        //imageView.setStyle("-fx-border-color: black; -fx-border-width: 1;");
        return imageView;
    }
}
