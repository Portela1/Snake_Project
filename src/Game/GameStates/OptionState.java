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
public class OptionState extends State {

    private UIManager uiManager;
    private Canvas canvas;
  
    public OptionState(Handler handler) {
        super(handler);
        uiManager = new UIManager(handler);
        handler.getMouseManager().setUimanager(uiManager);
        
   
        
        
        
        //Resume
        
        
        uiManager.addObjects(new UIImageButton(handler.getWidth()/2-50, 550, 128, 64, Images.Resume, () -> {
            handler.getMouseManager().setUimanager(null);
            State.setState(handler.getGame().gameState);
        }));
        
        
        
    
        
          
        //Back Color
    
        
        uiManager.addObjects(new UIImageButton(handler.getWidth()/2-13, 450, 25, 25, Images.Red, () -> {
            handler.getMouseManager().setUimanager(null);
            DisplayScreen.ChangeColor(DisplayScreen.getCanvas(),Color.RED);
        }));
        
        uiManager.addObjects(new UIImageButton(handler.getWidth()/2+22, 450, 25, 25, Images.Green, () -> {
            handler.getMouseManager().setUimanager(null);
            DisplayScreen.ChangeColor(DisplayScreen.getCanvas(),Color.GREEN);
        }));
        
        uiManager.addObjects(new UIImageButton(handler.getWidth()/2+57, 450, 25, 25, Images.Blue, () -> {
            handler.getMouseManager().setUimanager(null);
            DisplayScreen.ChangeColor(DisplayScreen.getCanvas(),Color.BLUE);
        }));
 
        uiManager.addObjects(new UIImageButton(handler.getWidth()/2+92, 450, 25, 25, Images.Yellow, () -> {
           handler.getMouseManager().setUimanager(null);
           DisplayScreen.ChangeColor(DisplayScreen.getCanvas(),Color.YELLOW);
        }));
        
        
        
        
        //Snake Speed
        
        uiManager.addObjects(new UIImageButton(handler.getWidth()/2-17, 500, 20, 20, Images.One, () -> {
            handler.getMouseManager().setUimanager(null);
            Player.setSpeedSnake(7);
        })); 
        uiManager.addObjects(new UIImageButton(handler.getWidth()/2+13, 500, 20, 20, Images.Two, () -> {
            handler.getMouseManager().setUimanager(null);
            Player.setSpeedSnake(6); 
        }));
        uiManager.addObjects(new UIImageButton(handler.getWidth()/2+43, 500, 20, 20, Images.Three, () -> {
            handler.getMouseManager().setUimanager(null);
            Player.setSpeedSnake(5);
        }));
        uiManager.addObjects(new UIImageButton(handler.getWidth()/2+73, 500, 20, 20, Images.Four, () -> {
            handler.getMouseManager().setUimanager(null);
            Player.setSpeedSnake(4);  
        }));
        uiManager.addObjects(new UIImageButton(handler.getWidth()/2+103, 500, 20, 20, Images.Five, () -> {
            handler.getMouseManager().setUimanager(null);
            Player.setSpeedSnake(3);
        }));
        
        
        uiManager.addObjects(new UIImageButton(handler.getWidth()/2-55, handler.getHeight()/2-32, 128, 64, Images.butstart, new ClickListlener() {
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
        g.drawImage(Images.title,0,0,handler.getWidth(),handler.getHeight(),null);
        g.drawImage(Images.speed , handler.getWidth()/2-90 , 495, 60 , 30 ,null);
        g.drawImage(Images.backgroundc,handler.getWidth()/2-90, 440,60,30,null); 
        
        uiManager.Render(g);

    }


}
