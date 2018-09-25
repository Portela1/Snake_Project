package Display;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * Created by AlexVR on 7/1/2018.
 */

public class DisplayScreen {

    private JFrame frame;
    public static Canvas canvas;
    private String title;
    private int width, height;
	

    public DisplayScreen(String title, int width, int height){
        this.title = title;
        this.width = width;
        this.height = height;
      


        createDisplay();
    }

    private void createDisplay(){
        frame = new JFrame(title);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setBackground(Color.black);

        try {
            frame.setIconImage(ImageIO.read(new File("res/Sheets/icon.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        
        
        buildCanvas(width, height,false,Color.ORANGE); // Added 
       
        
        
        
        
        frame.add(canvas);
        frame.pack();
    }

    public static Canvas getCanvas(){
        return canvas;
    }
    
    
    public static void ChangeColor(Canvas c,Color color)
    {
    	c.setBackground(color);
    }
   
    public Canvas buildCanvas(int width,int height, Boolean focus, Color c) {
    	  canvas = new Canvas();
          canvas.setPreferredSize(new Dimension(width, height));                //Added
          canvas.setMaximumSize(new Dimension(width, height));                  //Added
          canvas.setMinimumSize(new Dimension(width, height));
          canvas.setFocusable(focus);
          canvas.setBackground(c); 
    	return canvas;
    	
    }

    public JFrame getFrame(){
        return frame;
    }

}
