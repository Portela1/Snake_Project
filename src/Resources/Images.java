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
    public static BufferedImage optionbackw;
    public static BufferedImage Pause;
    public static BufferedImage GameOver;
    public static BufferedImage[] Resume;
    public static BufferedImage[] BTitle;
    public static BufferedImage[] BMenu;
    public static BufferedImage[] Options;
    public static BufferedImage[] BMainMenu;
    public static ImageIcon icon;
    
    
    public static BufferedImage[] Red; //Added
    public static BufferedImage[] Blue; //Added
    public static BufferedImage[] Green; //Added
    public static BufferedImage[] Yellow; //Added
    public static BufferedImage[] One; //Added
    public static BufferedImage[] Two; //Added
    public static BufferedImage[] Three; //Added
    public static BufferedImage[] Four; //Added
    public static BufferedImage[] Five; //Added
   
    
    
    public static BufferedImage backgroundc; //Added
    public static BufferedImage speed; //Added
   
    
    
    
    public Images() {

        butstart = new BufferedImage[3];
        Resume = new BufferedImage[3];
        BTitle = new BufferedImage[3];
        BMenu = new BufferedImage[2];
        Options = new BufferedImage[2];
        
        Red = new BufferedImage[3];//Added
        Blue = new BufferedImage[3]; //Added
        Green = new BufferedImage[3]; //Added
        Yellow = new BufferedImage[3]; //Added
        
        
        One = new BufferedImage[3];//Added
        Two = new BufferedImage[3]; //Added
        Three = new BufferedImage[3]; //Added
        Four = new BufferedImage[3];//Added
        Five = new BufferedImage[3]; //Added
        
        
        try {
        	
        	
        	Red[0] = ImageIO.read(getClass().getResourceAsStream("/Buttons/Redu.png"));
        	Red[1] = ImageIO.read(getClass().getResourceAsStream("/Buttons/Redp.png"));
        	Red[2] = ImageIO.read(getClass().getResourceAsStream("/Buttons/Redu.png"));
        	
        	
        	Blue[0] = ImageIO.read(getClass().getResourceAsStream("/Buttons/Blueu.png"));
        	Blue[1] = ImageIO.read(getClass().getResourceAsStream("/Buttons/Bluep.png"));
        	Blue[2] = ImageIO.read(getClass().getResourceAsStream("/Buttons/Blueu.png"));
        	
        
        	Green[0] = ImageIO.read(getClass().getResourceAsStream("/Buttons/Greenu.png"));
        	Green[1] = ImageIO.read(getClass().getResourceAsStream("/Buttons/Greenp.png"));
        	Green[2] = ImageIO.read(getClass().getResourceAsStream("/Buttons/Greenu.png"));
        	
        	Yellow[0] = ImageIO.read(getClass().getResourceAsStream("/Buttons/Yellu.png"));
        	Yellow[1] = ImageIO.read(getClass().getResourceAsStream("/Buttons/Yellp.png"));
        	Yellow[2] = ImageIO.read(getClass().getResourceAsStream("/Buttons/Yellu.png"));
       
        	
        	One[0] = ImageIO.read(getClass().getResourceAsStream("/Buttons/1u.png"));
        	One[1] = ImageIO.read(getClass().getResourceAsStream("/Buttons/1p.png"));
        	One[2] = ImageIO.read(getClass().getResourceAsStream("/Buttons/1u.png"));
        	
        	
        	Two[0] = ImageIO.read(getClass().getResourceAsStream("/Buttons/2u.png"));
        	Two[1] = ImageIO.read(getClass().getResourceAsStream("/Buttons/2p.png"));
        	Two[2] = ImageIO.read(getClass().getResourceAsStream("/Buttons/2u.png"));

        	Three[0] = ImageIO.read(getClass().getResourceAsStream("/Buttons/3u.png"));
        	Three[1] = ImageIO.read(getClass().getResourceAsStream("/Buttons/3p.png"));
        	Three[2] = ImageIO.read(getClass().getResourceAsStream("/Buttons/3u.png"));

        	Four[0] = ImageIO.read(getClass().getResourceAsStream("/Buttons/4u.png"));
        	Four[1] = ImageIO.read(getClass().getResourceAsStream("/Buttons/4p.png"));
        	Four[2] = ImageIO.read(getClass().getResourceAsStream("/Buttons/4u.png"));

        	Five[0] = ImageIO.read(getClass().getResourceAsStream("/Buttons/5u.png"));
        	Five[1] = ImageIO.read(getClass().getResourceAsStream("/Buttons/5p.png"));
        	Five[2] = ImageIO.read(getClass().getResourceAsStream("/Buttons/5u.png"));
        	
        	
        	
        	speed = ImageIO.read(getClass().getResourceAsStream("/Sheets/Speed.png"));
        	backgroundc = ImageIO.read(getClass().getResourceAsStream("/Sheets/Backgorund.png"));
        	
        	
            title = ImageIO.read(getClass().getResourceAsStream("/Sheets/Title.png"));
            optionbackw = ImageIO.read(getClass().getResourceAsStream("/Sheets/optionbackw.png"));
            Pause = ImageIO.read(getClass().getResourceAsStream("/Buttons/Pause.png"));
            GameOver = ImageIO.read(getClass().getResourceAsStream("/Buttons/GameOver.png")); //Game Over Image
            Resume[0] = ImageIO.read(getClass().getResourceAsStream("/Buttons/Resume.png"));
            Resume[1] = ImageIO.read(getClass().getResourceAsStream("/Buttons/ResumeP.png"));
            Resume[2] = ImageIO.read(getClass().getResourceAsStream("/Buttons/Resume.png"));
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
