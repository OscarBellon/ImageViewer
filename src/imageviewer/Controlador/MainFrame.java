package imageviewer.Controlador;

import imageviewer.Persistance.ImageLoader;
import imageviewer.UI.ImageDisplay;
import imageviewer.UI.SwingImageDisplay;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class MainFrame extends JFrame {
    ImageDisplay imageDisplay;
    final ImageLoader imageLoader;

    public MainFrame(ImageLoader imageLoader) {
        this.imageLoader = imageLoader;
        
        this.setTitle("Image Viewer");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(800,600);
        this.setLocationRelativeTo(null);
        this.getContentPane().add(imageDisplay());
        this.getContentPane().add(toolBar(),BorderLayout.SOUTH);
        this.setVisible(true);
    }

    private JPanel imageDisplay() {
        SwingImageDisplay sid = new SwingImageDisplay();
        this.imageDisplay = sid;
        return sid;
    }
    public ImageDisplay getImageDisplay(){
        return imageDisplay;
    }
        
   
    
    JPanel toolBar(){
        JPanel panel = new JPanel();
        panel.add(prevButton());
        panel.add(nextButton());
        return panel;
    }
    
    JButton nextButton(){
        JButton button = new JButton(">");
        button.addActionListener(nextImage());
        return button;
    }
    
    ActionListener nextImage(){
        return (ActionEvent e) -> {
            imageDisplay.show(imageLoader.next());
        };
    }
    
    JButton prevButton(){
        JButton button = new JButton("<");
        button.addActionListener(prevImage());
        return button;
    }
    
    ActionListener prevImage(){
        return (ActionEvent e) -> {
            imageDisplay.show(imageLoader.prev());
        };
    }
    
}
