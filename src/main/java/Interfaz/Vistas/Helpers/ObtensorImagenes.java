package Interfaz.Vistas.Helpers;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class ObtensorImagenes {

    public static void SettearImagenFondo(Pane espacio) {
        try{
            String path = "ImagenesGUI/fondo.jpg";
            InputStream stream = new FileInputStream(path);
            Image imagen = new Image(stream);
            espacio.setBackground(
                    new javafx.scene.layout.Background(
                            new javafx.scene.layout.BackgroundImage(
                                    imagen,
                                    javafx.scene.layout.BackgroundRepeat.NO_REPEAT,
                                    javafx.scene.layout.BackgroundRepeat.NO_REPEAT,
                                    javafx.scene.layout.BackgroundPosition.DEFAULT,
                                    new javafx.scene.layout.BackgroundSize(
                                            javafx.scene.layout.BackgroundSize.AUTO,
                                            javafx.scene.layout.BackgroundSize.AUTO,
                                            false,
                                            false,
                                            true,
                                            false
                                    )
                            )
                    )
            );
            //imageView.setFitWidth(73);
            //imageView.setFitHeight(90);
            //Rectangle clip = new Rectangle(imageView.getFitWidth(), imageView.getFitHeight());
            //clip.setArcWidth(20);
            //clip.setArcHeight(20);
            //imageView.setClip(clip);
            //imageView.setStyle("-fx-border-color: black; -fx-border-width: 1;");
            //return imageView;
        } catch (FileNotFoundException ex) {
            System.err.println("Error al intentar obtener la imágen de fondo");
            //return new ImageView();
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
