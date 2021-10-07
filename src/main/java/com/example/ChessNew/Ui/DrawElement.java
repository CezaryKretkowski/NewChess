package com.example.ChessNew.Ui;

import java.awt.*;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import com.example.ChessNew.Api.ChessBoard;
import com.example.ChessNew.Api.Fen;
import com.example.ChessNew.Api.Piece;



public class DrawElement extends JPanel {

	/**
	 * 
	 */
	private int hightOfWindow;
	private int widthOfWindow;
	protected double chessBoardWidth;
	protected double chessFildWidth;
	protected double leftPanel;
	protected Graphics2D g2d;
	protected RunGame mouseListener;
	protected Point boardPosX;
	protected Point boardPosy;
	private boolean ANTIALIAS;
	protected RenderingHints hints;

	public DrawElement() {
         this.ANTIALIAS=true;
		 this.boardPosX=new Point();
		 this.boardPosy=new Point();
	     this.setBackground(Color.DARK_GRAY);
	     this.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		 mouseListener=new RunGame(this);
		 this.addMouseListener(mouseListener);
		 this.addMouseMotionListener(mouseListener);
	     this.addComponentListener(new ComponentAdapter() {
	    	    public void componentResized(ComponentEvent componentEvent) {
	    	    	repaint();
	    	    }

	     });
		this.setAntiAliasing();
	}
	public void setAntiAliasing() {
		hints = new RenderingHints(RenderingHints.KEY_RENDERING,
				 RenderingHints.VALUE_RENDER_QUALITY);
		if(ANTIALIAS)
			hints.put(RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_ON);
		else
			hints.put(RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_OFF);

		
	}
	protected void calculateSize() {
		
		Rectangle  r=super.getBounds();
		setHightOfWindow(r.height); 
		setWidthOfWindow(r.width);
		double w=(double)widthOfWindow/ (double)100;
		this.chessBoardWidth= w*50.75;
		this.chessFildWidth=chessBoardWidth / 8.0;
		if(chessFildWidth<50.0)
			chessFildWidth=50.0;
		if(chessFildWidth>120.0)
			chessFildWidth=120.0;
		this.leftPanel=w*12.65;
		this.boardPosX.x=(int)leftPanel;
		this.boardPosX.y=(int)leftPanel+((int)chessFildWidth*8);
		this.boardPosy.x=30;
		this.boardPosy.y=30+((int)chessFildWidth*8);

	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g2d=(Graphics2D) g;	
		calculateSize();
		ChessBoard.drawBoard(g2d,(int)leftPanel,30,(int)chessFildWidth, Color.BLACK,Color.WHITE );
		if(ANTIALIAS)
			g2d.setRenderingHints(hints);
		paintPosytion(mouseListener.getFen(),g2d);
        if(null!=mouseListener.getSeletedPiece()){
			Piece.drawPieces(mouseListener.getSeletedPiece(),g2d,(int)chessFildWidth);
		}
		g2d.drawString(String.valueOf(mouseListener.getMousePosX())+"/"+String.valueOf(mouseListener.getMousePosY()),20,20);
		g2d.drawString(String.valueOf(mouseListener.getBoardPosX())+"/"+String.valueOf(mouseListener.getBoardPosY()),20,40);
	}
	public int getHightOfWindow() {
		return hightOfWindow;
	}
	public void setHightOfWindow(int hightOfWindow) {
		this.hightOfWindow = hightOfWindow;
	}
	public int getWidthOfWindow() {
		return widthOfWindow;
	}
	public void setWidthOfWindow(int widthOfWindow) {
		this.widthOfWindow = widthOfWindow;
	}


	public void paintPosytion(Fen fen,Graphics2D g2d){
		char tab[][]=fen.fenToTab();
		for(int i=0;i<tab.length;i++){
			for(int j=0;j<tab.length;j++){
				if(tab[i][j]!='0')
					Piece.drawPieces(new Piece(tab[i][j],(int) leftPanel+(j*(int)chessFildWidth)+7,30+(i*(int)chessFildWidth)+7), g2d,(int)chessFildWidth);
			}
		}

	}

	
}
