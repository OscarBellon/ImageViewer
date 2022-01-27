package imageviewer.UI;

import imageviewer.Modelo.Image;

public interface ImageDisplay  {
    Image current();
    void show(Image image);
}
