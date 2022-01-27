package imageviewer.Controlador;

import imageviewer.Modelo.Image;
import imageviewer.Persistance.FileImageLoader;
import java.io.File;

public class Main {
    public static void main(String[] args){
        File file = new File("C:\\Users\\osbeg\\Desktop\\Universidad 2Curso\\casas");
        FileImageLoader imageLoader = new FileImageLoader(file);
        Image image = imageLoader.load();
        MainFrame mainFrame = new MainFrame(imageLoader);
        mainFrame.getImageDisplay().show(image);
    }
}
