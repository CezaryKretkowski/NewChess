package com.example.ChessNew.Api;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Piece {
	private char symbol;
	private Point kords;
	private boolean  color;
    public Piece(char symbol,int x,int y) {
    	this.kords=new Point(x,y);
    	this.symbol=symbol;
    	if(symbol>'Z')
    		setColor(false);
    	else 
    		setColor(true);
    }
	public Piece(char symbol) {

		this.symbol=symbol;
		if(symbol>'Z')
			setColor(false);
		else
			setColor(true);
	}
	public char getSymbol() {
		return symbol;
	}

	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}

	public Point getKords() {
		return kords;
	}

	public void setKords(Point kords) {
		this.kords = kords;
	} 
	public void setKords(int x,int y) {
		this.kords = new Point(x,y);
	} 
	public static void drawPieces(Piece p,Graphics2D g2d,int fildHight) {
		String path="src/main/java/com/example/ChessNew/resources/basic/"+p.getSymbol();
		if(p.isColor())
			path=path+"W.png";
		else
			path=path+"B.png";	
		BufferedImage image=null;
		try {
			image=ImageIO.read(new File(path));
		}catch(IOException e) {
			e.printStackTrace();
		}
		g2d.drawImage(image,p.getKords().x,p.getKords().y,fildHight-15,fildHight-15,null,null);
	}
	public boolean isColor() {
		return color;
	}
	public void setColor(boolean color) {
		this.color = color;
	}
}
