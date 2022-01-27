package imageviewer.Persistance;

import imageviewer.Modelo.Image;

public interface ImageLoader {
    Image load();
    Image next();
    Image prev();
}
