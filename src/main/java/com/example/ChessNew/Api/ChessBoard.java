package com.example.ChessNew.Api;

import java.awt.Color;
import java.awt.Graphics2D;

public class ChessBoard {
	private char [][] bord;

	public char [][] getBord() {
		return bord;
	}

	public void setBord(char [][] bord) {
		this.bord = bord;
	}
	public static void drawBoard(Graphics2D g2d,int posytionX,int posytionY,int with,
			Color first,Color second) {
		
	    int counter =0;
		for (int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				if((counter&1)==0) 
					g2d.setColor(first);
				else
					g2d.setColor(second);
			   
				g2d.fillRect(posytionX+(with*j), posytionY+(with*i), with, with);
				counter++;
			    
			}
			counter++;
		}

	}
	public Piece getPiece(int x,int y){
		char symbol=bord[x][y];
		if(symbol!='0')
		  return new Piece(symbol);
		else
			return null;
	}
	public void clearPieces(int x,int y){
		bord[x][y]='0';
	}
	public void setPiece(Piece p,int x,int y){
		bord[x][y]=p.getSymbol();
	}
	
}
