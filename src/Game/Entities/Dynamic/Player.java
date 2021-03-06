package Game.Entities.Dynamic;

import Main.Handler;
import Resources.Images;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.util.Random;

import Game.GameStates.State;

/**
 * Created by AlexVR on 7/2/2018.
 */
public class Player {

	public int lenght;
	public boolean justAte;
	private Handler handler;

	public int xCoord;
	public int yCoord;
	public int moveCounter;

	public static int speedSnake = 5;
	public int snakeScore = 0;
	
	public static void setSpeedSnake(int speed) {
		speedSnake = speed;
	}

	public static String direction;// is your first name one?

	public Player(Handler handler) {
		this.handler = handler;
		xCoord = 0;
		yCoord = 0;
		moveCounter = 0;
		direction = "Right";
		justAte = false;
		lenght = 1;

	}

	public void tick() {

		int x = xCoord;
		int y = yCoord;

		if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_N)) { // add tail
			handler.getWorld().body.add(new Tail(x, y, handler));
			lenght++;
		}
		if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_EQUALS)) { // increase snake speed
			speedSnake--;
		}
		if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_MINUS)) { // decrease snake speed
			speedSnake++;
		}
		if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_I)) { // pause snake
			speedSnake = 1000;
		}
		if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_O)) { // return to default speed snake
			speedSnake = 5;
		}

		moveCounter++;

		if (moveCounter >= speedSnake) {
			checkCollisionAndMove();
			moveCounter = 2; // Change snake Speed
		}
		if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_UP)) {
			if (direction != "Down") { //Prevent Backtracking
				direction = "Up";
			}

		}
		if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_DOWN)) {
			if (direction != "Up") { //Prevent Backtracking
				direction = "Down";
			}

		}
		if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_RIGHT)) {
			if (direction != "Left") { //Prevent Backtracking
				direction = "Right";
			}

		}
		if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_LEFT)) {
			if (direction != "Right") { //Prevent Backtracking
				direction = "Left";
			}
		}
	}


    public void checkCollisionAndMove(){
        handler.getWorld().playerLocation[xCoord][yCoord]=false;
        int x = xCoord;
        int y = yCoord;
        

        
        switch (direction){
            case "Left":
                if(xCoord==0){
                    kill();
                }else{
                    xCoord--;
                }
                break;
            case "Right":
                if(xCoord==handler.getWorld().GridWidthHeightPixelCount-1){
                    kill();
                }else{
                    xCoord++;
                }
                break;
            case "Up":
                if(yCoord==0){
                    kill();
                }else{
                    yCoord--;
                }
                break;
            case "Down":
                if(yCoord==handler.getWorld().GridWidthHeightPixelCount-1){
                    kill();
                }else{
                    yCoord++;
                }
                break;
		}
        
        for(int i = 0; i < handler.getWorld().body.size(); i++)
        {
        	if(handler.getWorld().body.get(i).x == xCoord && handler.getWorld().body.get(i).y == yCoord)
        	{
        		kill();
        	}
        }
        
		handler.getWorld().playerLocation[xCoord][yCoord] = true;
        
        if(handler.getWorld().appleLocation[xCoord][yCoord]){
            Eat();
        }
       
        if(!handler.getWorld().body.isEmpty()) {
            handler.getWorld().playerLocation[handler.getWorld().body.getLast().x][handler.getWorld().body.getLast().y] = false;
            handler.getWorld().body.removeLast();
            handler.getWorld().body.addFirst(new Tail(x, y,handler));
        }
        	
    }


	public void render(Graphics g, Boolean[][] playeLocation) {
		Random r = new Random();

		// Implement RandomColor;
		int blue = r.nextInt(256);
		int green = r.nextInt(256);
		int red = r.nextInt(256);

		for (int i = 0; i < handler.getWorld().GridWidthHeightPixelCount; i++) {
			for (int j = 0; j < handler.getWorld().GridWidthHeightPixelCount; j++) {
				Color color = new Color(red, blue, green); // random color

				g.setColor(color); // Change snake color

				if (playeLocation[i][j]) {
					g.fillRect((i * handler.getWorld().GridPixelsize), (j * handler.getWorld().GridPixelsize),
							handler.getWorld().GridPixelsize, handler.getWorld().GridPixelsize);

					g.setFont(new Font("arial", Font.BOLD, 11));
					g.setColor(Color.WHITE);
					g.drawString("SCORE: " + snakeScore, 500, 20);

				}
				if (handler.getWorld().appleLocation[i][j]) {
					g.setColor(Color.cyan);
					g.fillRect((i * handler.getWorld().GridPixelsize), (j * handler.getWorld().GridPixelsize),
							handler.getWorld().GridPixelsize, handler.getWorld().GridPixelsize);

				}

			}

		}
	}

    public void Eat(){
        lenght++;
        snakeScore++;
        Tail tail= null;
        handler.getWorld().appleLocation[xCoord][yCoord]=false;
        handler.getWorld().appleOnBoard=false;
        switch (direction){
            case "Left":
                if( handler.getWorld().body.isEmpty()){
                    if(this.xCoord!=handler.getWorld().GridWidthHeightPixelCount-1){
                        tail = new Tail(this.xCoord+1,this.yCoord,handler);
                    }else{
                        if(this.yCoord!=0){
                            tail = new Tail(this.xCoord,this.yCoord-1,handler);
                        }else{
                            tail =new Tail(this.xCoord,this.yCoord+1,handler);
                        }
                    }
                }else{
                    if(handler.getWorld().body.getLast().x!=handler.getWorld().GridWidthHeightPixelCount-1){
                        tail=new Tail(handler.getWorld().body.getLast().x+1,this.yCoord,handler);
                    }else{
                        if(handler.getWorld().body.getLast().y!=0){
                            tail=new Tail(handler.getWorld().body.getLast().x,this.yCoord-1,handler);
                        }else{
                            tail=new Tail(handler.getWorld().body.getLast().x,this.yCoord+1,handler);

                        }
                    }

                }
                break;
            case "Right":
                if( handler.getWorld().body.isEmpty()){
                    if(this.xCoord!=0){
                        tail=new Tail(this.xCoord-1,this.yCoord,handler);
                    }else{
                        if(this.yCoord!=0){
                            tail=new Tail(this.xCoord,this.yCoord-1,handler);
                        }else{
                            tail=new Tail(this.xCoord,this.yCoord+1,handler);
                        }
                    }
                }else{
                    if(handler.getWorld().body.getLast().x!=0){
                        tail=(new Tail(handler.getWorld().body.getLast().x-1,this.yCoord,handler));
                    }else{
                        if(handler.getWorld().body.getLast().y!=0){
                            tail=(new Tail(handler.getWorld().body.getLast().x,this.yCoord-1,handler));
                        }else{
                            tail=(new Tail(handler.getWorld().body.getLast().x,this.yCoord+1,handler));
                        }
                    }

                }
                break;
            case "Up":
                if( handler.getWorld().body.isEmpty()){
                    if(this.yCoord!=handler.getWorld().GridWidthHeightPixelCount-1){
                        tail=(new Tail(this.xCoord,this.yCoord+1,handler));
                    }else{
                        if(this.xCoord!=0){
                            tail=(new Tail(this.xCoord-1,this.yCoord,handler));
                        }else{
                            tail=(new Tail(this.xCoord+1,this.yCoord,handler));
                        }
                    }
                }else{
                    if(handler.getWorld().body.getLast().y!=handler.getWorld().GridWidthHeightPixelCount-1){
                        tail=(new Tail(handler.getWorld().body.getLast().x,this.yCoord+1,handler));
                    }else{
                        if(handler.getWorld().body.getLast().x!=0){
                            tail=(new Tail(handler.getWorld().body.getLast().x-1,this.yCoord,handler));
                        }else{
                            tail=(new Tail(handler.getWorld().body.getLast().x+1,this.yCoord,handler));
                        }
                    }

                }
                break;
            case "Down":
                if( handler.getWorld().body.isEmpty()){
                    if(this.yCoord!=0){
                        tail=(new Tail(this.xCoord,this.yCoord-1,handler));
                    }else{
                        if(this.xCoord!=0){
                            tail=(new Tail(this.xCoord-1,this.yCoord,handler));
                        }else{
                            tail=(new Tail(this.xCoord+1,this.yCoord,handler));
                        } System.out.println("Tu biscochito");
                    }
                }else{
                    if(handler.getWorld().body.getLast().y!=0){
                        tail=(new Tail(handler.getWorld().body.getLast().x,this.yCoord-1,handler));
                    }else{
                        if(handler.getWorld().body.getLast().x!=0){
                            tail=(new Tail(handler.getWorld().body.getLast().x-1,this.yCoord,handler));
                        }else{
                            tail=(new Tail(handler.getWorld().body.getLast().x+1,this.yCoord,handler));
                        }
                    }

                }
                break;
        }
        

        handler.getWorld().body.addLast(tail);
        handler.getWorld().playerLocation[tail.x][tail.y] = false;
    }

    public void kill(){
        lenght = 0;
        for (int i = 0; i < handler.getWorld().GridWidthHeightPixelCount; i++) {
            for (int j = 0; j < handler.getWorld().GridWidthHeightPixelCount; j++) {

                handler.getWorld().playerLocation[i][j]=true;
                State.setState(handler.getGame().gameOverState);
                speedSnake = 5;
                
      


            }
        }
    }

    public boolean isJustAte() {
        return justAte;
    }

    public void setJustAte(boolean justAte) {
        this.justAte = justAte;
    }
    
    
}
