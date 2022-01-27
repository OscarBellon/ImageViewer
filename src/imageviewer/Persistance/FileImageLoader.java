package imageviewer.Persistance;

import imageviewer.Modelo.Image;
import imageviewer.Modelo.ProxyImage;
import imageviewer.Modelo.RealImage;
import java.io.*;

public class FileImageLoader implements ImageLoader {
    
    private final File[] files;
    private int current;
    
    public FileImageLoader(File folder) {
        this.current=0;
        this.files = folder.listFiles(imageTypes());
    }
    
    private FileFilter imageTypes(){
        return (File pathname) -> pathname.getName().endsWith(".jpg");
    }
    @Override
    public Image load() {
        return new ProxyImage(this.files[this.current]);
    }

    private Image imageAt(int i) {
        return new RealImage( files[i].getName(),getStream(files[i]) );
        
    }
    private InputStream getStream(File file) {
        try{
            return new BufferedInputStream(new FileInputStream(file));
        }catch(FileNotFoundException e){
                return null;
        }
    }
    @Override
    public Image next() {
        if(this.current == this.files.length -1){
            this.current=0;
        }else{
            this.current++;
        }
        return this.load();
    }

    @Override
    public Image prev() {
        if(this.current==0){
            this.current = this.files.length -1;
        }else{
            this.current--;

        }
        return this.load();
    }
    
}
