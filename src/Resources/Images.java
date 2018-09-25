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
    
    
    public static BufferedImage[] Red; //Added
    public static BufferedImage[] Blue; //Added
    public static BufferedImage[] Green; //Added
    public static BufferedImage[] One; //Added
    public static BufferedImage[] Two; //Added
    public static BufferedImage[] Three; //Added
    public static BufferedImage[] Four; //Added
    public static BufferedImage[] Five; //Added
   
    
    
    public static BufferedImage backgroundc; //Added
    public static BufferedImage speed; //Added
    public static BufferedImage snakec; //Added
    
    
    
    public Images() {

        butstart = new BufferedImage[3];
        Resume = new BufferedImage[2];
        BTitle = new BufferedImage[3];
        BMenu = new BufferedImage[2];
        Options = new BufferedImage[2];
        Red = new BufferedImage[2];//Added
        Blue = new BufferedImage[2]; //Added
        Green = new BufferedImage[2]; //Added
        
        One = new BufferedImage[2];//Added
        Two = new BufferedImage[2]; //Added
        Three = new BufferedImage[2]; //Added
        Four = new BufferedImage[2];//Added
        Five = new BufferedImage[2]; //Added
        
        
        try {
        	
        	
        	Red[0] = ImageIO.read(getClass().getResourceAsStream("/Buttons/color_word_red.png.png"));
        	Red[1] = ImageIO.read(getClass().getResourceAsStream("/Buttons/color_word_red.png.png"));
        	
        	Blue[0] = ImageIO.read(getClass().getResourceAsStream("/Buttons/color_word_blue.png"));
        	Blue[1] = ImageIO.read(getClass().getResourceAsStream("/Buttons/color_word_blue.png"));
        	
        	Green[0] = ImageIO.read(getClass().getResourceAsStream("/Buttons/green.png"));
        	Green[1] = ImageIO.read(getClass().getResourceAsStream("/Buttons/green.png"));
        	
        	One[0] = ImageIO.read(getClass().getResourceAsStream("/Buttons/1.png"));
        	One[1] = ImageIO.read(getClass().getResourceAsStream("/Buttons/1.png"));
        	
        	Two[0] = ImageIO.read(getClass().getResourceAsStream("/Buttons/2.png"));
        	Two[1] = ImageIO.read(getClass().getResourceAsStream("/Buttons/2.png"));
        	
        	Three[0] = ImageIO.read(getClass().getResourceAsStream("/Buttons/3.png"));
        	Three[1] = ImageIO.read(getClass().getResourceAsStream("/Buttons/3.png"));
        	
        	Four[0] = ImageIO.read(getClass().getResourceAsStream("/Buttons/4.png"));
        	Four[1] = ImageIO.read(getClass().getResourceAsStream("/Buttons/4.png"));
        	
        	Five[0] = ImageIO.read(getClass().getResourceAsStream("/Buttons/5.png"));
        	Five[1] = ImageIO.read(getClass().getResourceAsStream("/Buttons/5.png"));
        	
        	
        	
        	
        	speed = ImageIO.read(getClass().getResourceAsStream("/Sheets/Speed.png"));
        	backgroundc = ImageIO.read(getClass().getResourceAsStream("/Sheets/Backgorund.png"));
        	snakec = ImageIO.read(getClass().getResourceAsStream("/Sheets/Snake Color.png"));
        	
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
