//Name -
//Date -
//Class -
//Lab  - 

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;

public class Pong extends Canvas implements KeyListener, Runnable
{
	private Ball ball;
	private Paddle paddle;
	private boolean[] keys;
	private BufferedImage back;
	private String playerScore;
	private int Score = 0;
	private Block destroyable1;
	private Block destroyable2;
	private Block destroyable3;
	private Block destroyable4;
	private Block destroyable5;
	private Block destroyable6;
	private Block destroyable7;
	private Block destroyable8;
	private Block destroyable9;
	private Block rightWall;
	private String won = "Congrats.";


	public Pong()
	{
		ball = new Ball(300,300,20,20);
		paddle = new Paddle(350,530,100,20,Color.orange, 5);
		destroyable1 = new Block(20,20,75,50);
		destroyable2 = new Block(105,20,75,50);
		destroyable3 = new Block(190,20,75,50);
		destroyable4 = new Block(275,20,75,50);
		destroyable5 = new Block(360,20,75,50);
		destroyable6 = new Block(445,20,75,50);
		destroyable7 = new Block(530,20,75,50);
		destroyable8 = new Block(615,20,75,50);
		destroyable9 = new Block(700,20,75,50);
		rightWall = new Block(800,0,50,700);



		

		keys = new boolean[2];

    
    	setBackground(Color.WHITE);
		setVisible(true);
		
		
		new Thread(this).start();
		addKeyListener(this);		//starts the key thread to log key strokes
	}
	
   public void update(Graphics window){
	   paint(window);
   }

   public void paint(Graphics window)
   {
		//set up the double buffering to make the game animation nice and smooth
		Graphics2D twoDGraph = (Graphics2D)window;

		//take a snap shop of the current screen and same it as an image
		//that is the exact same width and height as the current screen
		if(back==null)
		   back = (BufferedImage)(createImage(getWidth(),getHeight()));

		//create a graphics reference to the back ground image
		//we will draw all changes on the background image
		Graphics graphToBack = back.createGraphics();

		playerScore = "Score = " + Score;

		
		graphToBack.drawString(playerScore, 10, 10);

		
		
		ball.moveAndDraw(graphToBack);
		destroyable1.draw(graphToBack);
		destroyable2.draw(graphToBack);
		destroyable3.draw(graphToBack);
		destroyable4.draw(graphToBack);
		destroyable5.draw(graphToBack);
		destroyable6.draw(graphToBack);
		destroyable7.draw(graphToBack);
		destroyable8.draw(graphToBack);
		destroyable9.draw(graphToBack);
		rightWall.draw(graphToBack);
		paddle.draw(graphToBack);
		graphToBack.drawString(playerScore, 234, 403);

		
		//see if the ball hits the top or bottom wall 
		if((ball.getY()<=10))
		{
			ball.setYSpeed(ball.getYSpeed()*-1);
		}
		
		if(!(ball.getX()>=10 && ball.getX()+ball.getWidth()<=800))
		{
			ball.setXSpeed(ball.getXSpeed()*-1);
		}
		if(ball.didCollideRight(rightWall))
		{
			ball.setYSpeed(ball.getYSpeed()*-1);
		}
		if(ball.didCollideTop(destroyable1))
		{
			ball.setYSpeed(ball.getYSpeed()*-1);
			destroyable1.draw(graphToBack, Color.WHITE);
			destroyable1.setPos(1000, 8);
			Score++;
			graphToBack.setColor(Color.WHITE);
			graphToBack.drawString(playerScore,234,403);
			graphToBack.setColor(Color.GREEN);
			playerScore = "Score = " + Score;
			graphToBack.drawString(playerScore, 300,350);
		}
		if(ball.didCollideTop(destroyable2))
		{
			ball.setYSpeed(ball.getYSpeed()*-1);
			destroyable2.draw(graphToBack, Color.WHITE);
			destroyable2.setPos(1000, 8);
			graphToBack.setColor(Color.WHITE);
			graphToBack.drawString(playerScore,300,350);
			graphToBack.setColor(Color.CYAN);
			Score++;
			playerScore = "Score = " + Score;
			graphToBack.drawString(playerScore, 170,200);
		}
		if(ball.didCollideTop(destroyable3))
		{
			ball.setYSpeed(ball.getYSpeed()*-1);
			destroyable3.draw(graphToBack, Color.WHITE);
			destroyable3.setPos(1000, 8);
			graphToBack.setColor(Color.WHITE);
			graphToBack.drawString(playerScore,300,350);
			graphToBack.setColor(Color.BLUE);
			Score++;
			playerScore = "Score = " + Score;
			graphToBack.drawString(playerScore, 600,300);
		}
		if(ball.didCollideTop(destroyable4))
		{
			ball.setYSpeed(ball.getYSpeed()*-1);
			destroyable4.draw(graphToBack, Color.WHITE);
			destroyable4.setPos(1000, 8);
			graphToBack.setColor(Color.WHITE);
			graphToBack.drawString(playerScore,600,300);
			graphToBack.setColor(Color.RED);
			Score++;
			playerScore = "Score = " + Score;
			graphToBack.drawString(playerScore, 345,456);
		}
		if(ball.didCollideTop(destroyable5))
		{
			ball.setYSpeed(ball.getYSpeed()*-1);
			destroyable5.draw(graphToBack, Color.WHITE);
			destroyable5.setPos(1000, 8);
			graphToBack.setColor(Color.WHITE);
			graphToBack.drawString(playerScore,345,456);
			graphToBack.setColor(Color.BLACK);
			Score++;
			playerScore = "Score = " + Score;
			graphToBack.drawString(playerScore, 50,500);
		}
		if(ball.didCollideTop(destroyable6))
		{
			ball.setYSpeed(ball.getYSpeed()*-1);
			destroyable6.draw(graphToBack, Color.WHITE);
			destroyable6.setPos(1000, 8);
			graphToBack.setColor(Color.WHITE);
			graphToBack.drawString(playerScore,50,500);
			graphToBack.setColor(Color.MAGENTA);
			Score++;
			playerScore = "Score = " + Score;
			graphToBack.drawString(playerScore, 470,456);
		}
		if(ball.didCollideTop(destroyable7))
		{
			ball.setYSpeed(ball.getYSpeed()*-1);
			destroyable7.draw(graphToBack, Color.WHITE);
			destroyable7.setPos(1000, 8);
			graphToBack.setColor(Color.WHITE);
			graphToBack.drawString(playerScore,470,456);
			graphToBack.setColor(Color.RED);
			Score++;
			playerScore = "Score = " + Score;
			graphToBack.drawString(playerScore, 509,509);
		}
		if(ball.didCollideTop(destroyable8))
		{
			ball.setYSpeed(ball.getYSpeed()*-1);
			destroyable8.draw(graphToBack, Color.WHITE);
			destroyable8.setPos(1000, 8);
			graphToBack.setColor(Color.WHITE);
			graphToBack.drawString(playerScore,509,509);
			graphToBack.setColor(Color.PINK);
			Score++;
			playerScore = "Score = " + Score;
			graphToBack.drawString(playerScore, 79,312);
		}
		if(ball.didCollideTop(destroyable9))
		{
			ball.setYSpeed(ball.getYSpeed()*-1);
			destroyable9.draw(graphToBack, Color.WHITE);
			destroyable9.setPos(1000, 8);
			graphToBack.setColor(Color.WHITE);
			graphToBack.drawString(playerScore,79,312);
			graphToBack.setColor(Color.GRAY);
			Score++;
			playerScore = "Score = " + Score;
			graphToBack.drawString(playerScore, 432,100);
			
		}
		if(Score==9)
		{
			graphToBack.fillRect(0, 0, 900, 900);
			graphToBack.setColor(Color.BLACK);
			graphToBack.drawString(won, 390, 170);
		}
		


		//see if the ball hits the paddle
		if(ball.didCollideBottom(paddle)||ball.didCollideRight(paddle)||ball.didCollideLeft(paddle)||ball.didCollideTop(paddle)||ball.getX()<=0||ball.getX()>=800-ball.getWidth())
		{
			ball.setYSpeed(ball.getYSpeed()*-1);
		}
		
		if(ball.getY()>paddle.getY()+30)
		{
			ball.draw(graphToBack);
			ball.setPos(300,300);
		}


		//see if the paddles need to be moved
		if(keys[0] == true)
		{
			paddle.moveLeftAndDraw(graphToBack);
		}
		if(keys[1] == true)
		{
			paddle.moveRightAndDraw(graphToBack);

		}
		
		
		
		twoDGraph.drawImage(back, null, 0, 0);
	}

	public void keyPressed(KeyEvent e)
	{
		switch(toUpperCase(e.getKeyChar()))
		{
			case 'A' : keys[0]=true; break;
			case 'D' : keys[1]=true; break;

		}
	}

	public void keyReleased(KeyEvent e)
	{
		switch(toUpperCase(e.getKeyChar()))
		{
			case 'A' : keys[0]=false; break;
			case 'D' : keys[1]=false; break;

		}
	}

	public void keyTyped(KeyEvent e){}
	
   public void run()
   {
   	try
   	{
   		while(true)
   		{
   		   Thread.currentThread().sleep(8);
            repaint();
         }
      }catch(Exception e)
      {
      }
  	}	
}