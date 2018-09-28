package Game.GameStates;


import Main.Handler;
import Resources.Images;
import UI.ClickListlener;
import UI.UIImageButton;
import UI.UIManager;

import java.awt.*;

import Display.DisplayScreen;
import Game.Entities.Dynamic.Player;

/**
 * Created by AlexVR on 7/1/2018.
 */
public class OptionStateMenu extends State {

    private UIManager uiManager;
    public OptionStateMenu(Handler handler) {
        super(handler);
        uiManager = new UIManager(handler);
        handler.getMouseManager().setUimanager(uiManager);
        
   
        
        
        
     
        
        
        
    
        
          
        //Back Color
    
        
        uiManager.addObjects(new UIImageButton(160, 350, 60, 60, Images.Red, () -> {
            handler.getMouseManager().setUimanager(null);
            DisplayScreen.ChangeColor(DisplayScreen.getCanvas(),Color.RED);
        }));
        
        uiManager.addObjects(new UIImageButton(235, 350, 60, 60, Images.Green, () -> {
            handler.getMouseManager().setUimanager(null);
            DisplayScreen.ChangeColor(DisplayScreen.getCanvas(),Color.GREEN);
        }));
        
        uiManager.addObjects(new UIImageButton(310, 350, 60, 60, Images.Blue, () -> {
            handler.getMouseManager().setUimanager(null);
            DisplayScreen.ChangeColor(DisplayScreen.getCanvas(),Color.BLUE);
        }));
 
        uiManager.addObjects(new UIImageButton(385, 350, 60, 60, Images.Yellow, () -> {
           handler.getMouseManager().setUimanager(null);
           DisplayScreen.ChangeColor(DisplayScreen.getCanvas(),Color.YELLOW);
        }));
        
        
        
        
        //Snake Speed
        
        uiManager.addObjects(new UIImageButton(130, 500, 60, 60, Images.One, () -> {
            handler.getMouseManager().setUimanager(null);
            Player.setSpeedSnake(7);
        })); 
        uiManager.addObjects(new UIImageButton(205, 500, 60, 60, Images.Two, () -> {
            handler.getMouseManager().setUimanager(null);
            Player.setSpeedSnake(6); 
        }));
        uiManager.addObjects(new UIImageButton(280, 500, 60, 60, Images.Three, () -> {
            handler.getMouseManager().setUimanager(null);
            Player.setSpeedSnake(5);
        }));
        uiManager.addObjects(new UIImageButton(355, 500, 60, 60, Images.Four, () -> {
            handler.getMouseManager().setUimanager(null);
            Player.setSpeedSnake(4);  
        }));
        uiManager.addObjects(new UIImageButton(430, 500, 60, 60, Images.Five, () -> {
            handler.getMouseManager().setUimanager(null);
            Player.setSpeedSnake(3);
        }));
        
        
        uiManager.addObjects(new UIImageButton(55, 32, 128, 64, Images.butstart, new ClickListlener() {
            @Override
            public void onClick() {
                handler.getMouseManager().setUimanager(null);
                handler.getGame().reStart();
                State.setState(handler.getGame().gameState);
            }
        }));
    }

    @Override
    public void tick() {
        handler.getMouseManager().setUimanager(uiManager);
        uiManager.tick();

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.darkGray);
        g.fillRect(0,0,handler.getWidth(),handler.getHeight());
        g.drawImage(Images.gtitle,0,0,handler.getWidth(),handler.getHeight(),null);
        g.drawImage(Images.speed , 10 , 500, 100 , 60 ,null);
        g.drawImage(Images.backcolor, 10, 350, 130 , 60,null); 
        
        uiManager.Render(g);

    }


}