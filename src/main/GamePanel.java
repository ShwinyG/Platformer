package main;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

import javax.swing.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.nio.Buffer;
import javax.imageio.ImageIO;

public class GamePanel extends JPanel {

	private MouseInputs mouseInputs;

	private float xDelta = 100, yDelta = 100;

	private float xDir = 0.01f, yDir = 0.01f;
	private BufferedImage img;
	private BufferedImage[][] idleAni;
	private int aniTick, aniIndex, aniSpeed = 15;


	public GamePanel() {
		mouseInputs = new MouseInputs(this);

		importImg();
		loadAnimations();
		addKeyListener(new KeyboardInputs(this));
		setPanelSize();
		addMouseListener(mouseInputs);
		addMouseMotionListener(mouseInputs);
	}


	public void updateAnimationTick(){
		aniTick++;
		if(aniTick >= aniSpeed){
			aniTick = 0;
			aniIndex++;
			if(aniIndex >= idleAni.length)
				aniIndex = 0;
		}
	}

	private void loadAnimations() {
		idleAni = new BufferedImage[9][6];

		for (int i = 0; i < idleAni.length; i++) {
			idleAni[i][0] = img.getSubimage(i * 64, 0, 64, 40);
		}

	}
















	private void importImg(){
		InputStream is = getClass().getResourceAsStream("/player_sprites.png");
		try {
			img = ImageIO.read(is);
		}catch(IOException e){
			e.printStackTrace();
		}

	}

	public void changeXDelta(int value){
		this.xDelta += value;
		repaint();
	}

	public void changeYDelta(int value){
		this.yDelta += value;
		repaint();
	}

	public void setRectPos(int x, int y) {
		this.xDelta = x;
		this.yDelta = y;
		repaint();
	}

	private void setPanelSize() {
		Dimension size = new Dimension(1280, 800);
		setMinimumSize(size);
		setPreferredSize(size);
	}



	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(img.getSubimage(0,0,64,40), (int)xDelta,(int)yDelta, 120,80,null);
	}

}
