package Interfaz.Vistas.Helpers;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class ObtensorImagenes {

    public static ImageView ObtenerImagen(String identificador) throws FileNotFoundException {
        String path = "ImagenesGUI/"+ identificador + ".png";
        InputStream stream = new FileInputStream(path);
        System.out.println(path);
        ImageView imageView = new ImageView(new Image(stream));
        imageView.setFitWidth(73);
        imageView.setFitHeight(90);
        Rectangle clip = new Rectangle(imageView.getFitWidth(), imageView.getFitHeight());
        clip.setArcWidth(20);
        clip.setArcHeight(20);
        imageView.setClip(clip);
        imageView.setStyle("-fx-border-color: black; -fx-border-width: 1;");
        //TODO aca si queremos podemos settear el tamaño comun para todas
        return imageView;
    }
}
