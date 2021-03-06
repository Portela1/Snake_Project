package Game.GameStates;


import Main.Handler;
import Resources.Images;
import UI.ClickListlener;
import UI.UIImageButton;
import UI.UIManager;

import java.awt.*;

/**
 * Created by AlexVR on 7/1/2018.
 */
public class MenuState extends State {

    private UIManager uiManager;

    public MenuState(Handler handler) {
        super(handler);
        uiManager = new UIManager(handler);
        handler.getMouseManager().setUimanager(uiManager);
        
        uiManager.addObjects(new UIImageButton(handler.getWidth()/2-55, 550, 128, 64, Images.Options, () -> {
            handler.getMouseManager().setUimanager(null);
            State.setState(handler.getGame().optionStateMenu);
        }));


        uiManager.addObjects(new UIImageButton(handler.getWidth()/2-55, handler.getHeight()/2+130, 128, 64, Images.butstart, new ClickListlener() {
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
        uiManager.Render(g);
        
		g.setFont(new Font("arial", Font.BOLD, 64));
		g.setColor(Color.BLACK);
		g.drawString("PYTHON J & M" , 50, 150);

    }


}
