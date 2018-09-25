package Game.GameStates;


import Main.Handler;
import Resources.Images;
import UI.ClickListlener;
import UI.UIImageButton;
import UI.UIManager;

import java.awt.*;

import Game.Entities.Dynamic.Player;

/**
 * Created by AlexVR on 7/1/2018.
 */
public class OptionState extends State {

    private UIManager uiManager;

  
    public OptionState(Handler handler) {
        super(handler);
        uiManager = new UIManager(handler);
        handler.getMouseManager().setUimanager(uiManager);
        
   
        
        //Snake Color


        uiManager.addObjects(new UIImageButton(handler.getWidth()/2-10, 400, 30, 10, Images.Red, () -> {
            handler.getMouseManager().setUimanager(null);
            State.setState(handler.getGame().menuState);
            
        }));
        
        uiManager.addObjects(new UIImageButton(handler.getWidth()/2+40, 400, 30, 10, Images.Green, () -> {
            handler.getMouseManager().setUimanager(null);
            State.setState(handler.getGame().menuState);
        }));
        
        uiManager.addObjects(new UIImageButton(handler.getWidth()/2+90, 400, 30, 10, Images.Blue, () -> {
            handler.getMouseManager().setUimanager(null);
            State.setState(handler.getGame().menuState);
        }));
        
        
        //Back Color
        
     
        uiManager.addObjects(new UIImageButton(handler.getWidth()/2-10, 450, 30, 10, Images.Red, () -> {
            handler.getMouseManager().setUimanager(null);
            State.setState(handler.getGame().menuState);
        }));
        
        uiManager.addObjects(new UIImageButton(handler.getWidth()/2+40, 450, 30, 10, Images.Green, () -> {
            handler.getMouseManager().setUimanager(null);
            State.setState(handler.getGame().menuState);
        }));
        
        uiManager.addObjects(new UIImageButton(handler.getWidth()/2+90, 450, 30, 10, Images.Blue, () -> {
            handler.getMouseManager().setUimanager(null);
            State.setState(handler.getGame().menuState);
        }));
        
        
        
        //Snake Speed
        
        
        uiManager.addObjects(new UIImageButton(handler.getWidth()/2-10, 500, 10, 10, Images.One, () -> {
            handler.getMouseManager().setUimanager(null);
            Player.setSpeedSnake(9);
           
        }));
        
        uiManager.addObjects(new UIImageButton(handler.getWidth()/2+20, 500, 10, 10, Images.Two, () -> {
            handler.getMouseManager().setUimanager(null);
            Player.setSpeedSnake(8);
            
        }));
        
        uiManager.addObjects(new UIImageButton(handler.getWidth()/2+50, 500, 10, 10, Images.Three, () -> {
            handler.getMouseManager().setUimanager(null);
            Player.setSpeedSnake(7);
          
        }));
        uiManager.addObjects(new UIImageButton(handler.getWidth()/2+80, 500, 10, 10, Images.Four, () -> {
            handler.getMouseManager().setUimanager(null);
            Player.setSpeedSnake(5);
            
        }));
        
        uiManager.addObjects(new UIImageButton(handler.getWidth()/2+110, 500, 10, 10, Images.Five, () -> {
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
        g.drawImage(Images.speed , handler.getWidth()/2-90 , 490, 60 , 30 ,null);
        g.drawImage(Images.backgroundc,handler.getWidth()/2-90, 440,60,30,null); 
        g.drawImage(Images.snakec,handler.getWidth()/2-90,390,60,30,null);
        uiManager.Render(g);

    }


}
