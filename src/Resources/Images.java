package Resources;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by AlexVR on 7/1/2018.
 */
public class Images {


    public static BufferedImage[] butstart;
    public static BufferedImage title;
    public static BufferedImage Pause;
    public static BufferedImage GameOver;
    public static BufferedImage[] Resume;
    public static BufferedImage[] BTitle;
    public static BufferedImage[] BMenu;
    public static BufferedImage[] Options;
//    public static BufferedImage[] BMainMenu;
    public static ImageIcon icon;
   // public static BufferedImage Red[]; //Added
   // public static BufferedImage[] Blue; //Added
   // public static BufferedImage[] Green; //Added
    
    
    public Images() {

        butstart = new BufferedImage[3];
        Resume = new BufferedImage[2];
        BTitle = new BufferedImage[3];
        BMenu = new BufferedImage[2];
        Options = new BufferedImage[2];
       // Red = new BufferedImage[0];//Added
       // Blue = new BufferedImage[1]; //Added
       // Green = new BufferedImage[1]; //Added
        
        try {
        	
        	
        	//Red[0] = ImageIO.read(getClass().getResourceAsStream("/Buttons/color_word_red.png"));
        	//Blue[1] = ImageIO.read(getClass().getResourceAsStream("/Buttons/color_word_blue.png"));
        	//Green[1] = ImageIO.read(getClass().getResourceAsStream("/Buttons/green.png"));
        	
        	
        	
            title = ImageIO.read(getClass().getResourceAsStream("/Sheets/Title.png"));
            Pause = ImageIO.read(getClass().getResourceAsStream("/Buttons/Pause.png"));
            GameOver = ImageIO.read(getClass().getResourceAsStream("/Buttons/GameOver.png")); //Game Over Image
            Resume[0] = ImageIO.read(getClass().getResourceAsStream("/Buttons/Resume.png"));
            Resume[1] = ImageIO.read(getClass().getResourceAsStream("/Buttons/ResumeP.png"));
            BTitle[0] = ImageIO.read(getClass().getResourceAsStream("/Buttons/BTitle.png"));
            BTitle[1] = ImageIO.read(getClass().getResourceAsStream("/Buttons/BTitleP.png"));
            BMenu[0] = ImageIO.read(getClass().getResourceAsStream("/Buttons/BMenu.png")); //Main menu button
            BMenu[1] = ImageIO.read(getClass().getResourceAsStream("/Buttons/BMenu.png")); //Main menu button
            Options[0] = ImageIO.read(getClass().getResourceAsStream("/Buttons/Options.png"));
            Options[1] = ImageIO.read(getClass().getResourceAsStream("/Buttons/OptionsP.png"));
            butstart[0]= ImageIO.read(getClass().getResourceAsStream("/Buttons/NormBut.png"));//normbut
            butstart[1]= ImageIO.read(getClass().getResourceAsStream("/Buttons/HoverBut.png"));//hoverbut
            butstart[2]= ImageIO.read(getClass().getResourceAsStream("/Buttons/ClickedBut.png"));//clickbut

            icon =  new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/Sheets/icon.png")));


        }catch (IOException e) {
        e.printStackTrace();
    }


    }

    public static BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(Images.class.getResourceAsStream(path));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }

}
