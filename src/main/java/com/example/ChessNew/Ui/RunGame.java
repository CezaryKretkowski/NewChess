package com.example.ChessNew.Ui;

import com.example.ChessNew.Api.ChessBoard;
import com.example.ChessNew.Api.Fen;
import com.example.ChessNew.Api.Piece;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class RunGame implements MouseListener, MouseMotionListener {
    protected DrawElement p;
    private int mousePosX;
    private int mousePosY;
    private int boardPosX;
    private int boardPosY;
    protected ChessBoard board;
    private Piece seletedPiece;
    private Fen fen;
    void bordPosClaculate(int x,int y){
        if(x>p.boardPosX.x&&x<p.boardPosX.y)
            setBoardPosX((x-p.boardPosX.x)/(int)p.chessFildWidth);
        if(y>p.boardPosy.x&&y<p.boardPosy.y)
            setBoardPosY((y-p.boardPosy.x)/(int)p.chessFildWidth);
    }
    public RunGame(DrawElement p){
        fen=new Fen("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR");
        board=new ChessBoard();
        board.setBord(fen.fenToTab());
        this.p=p;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if(null!=board.getPiece(boardPosX,boardPosY)) {
            seletedPiece = board.getPiece(boardPosX, boardPosY);
            seletedPiece.setKords(mousePosX, mousePosY);
            //board.clearPieces(boardPosY,boardPosX);
            //fen.setFenString(fen.tabToFen(board.getBord()));
        }
        p.repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        bordPosClaculate(e.getX(),e.getY());
        Fen oldFen=fen;
        if(null==board.getPiece(boardPosX,boardPosY)){

            board.setPiece(seletedPiece,boardPosY,boardPosX);
            fen.tabToFen(board.getBord());
            fen.setFenString(fen.tabToFen(board.getBord()));
            //if(fen.equals(oldFen))
        }
        p.repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        mousePosX=e.getX();
        mousePosY=e.getY();
        if(null!=board.getPiece(boardPosY,boardPosX)) {
            seletedPiece = board.getPiece(boardPosY, boardPosX);

            board.clearPieces(boardPosY, boardPosX);
            fen.setFenString(fen.tabToFen(board.getBord()));
        }
        if(seletedPiece!=null)
            seletedPiece.setKords(mousePosX, mousePosY);


        p.repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mousePosX=e.getX();
        mousePosY=e.getY();
        bordPosClaculate(e.getX(),e.getY());
    }

    public int getMousePosX() {
        return mousePosX;
    }

    public void setMousePosX(int mousePosX) {
        this.mousePosX = mousePosX;
    }

    public int getMousePosY() {
        return mousePosY;
    }

    public void setMousePosY(int mousePosY) {
        this.mousePosY = mousePosY;
    }

    public Fen getFen() {
        return fen;
    }

    public void setFen(Fen fen) {
        this.fen = fen;
    }

    public Piece getSeletedPiece() {
            return seletedPiece;

    }

    public void setSeletedPiece(Piece seletedPiece) {
        this.seletedPiece = seletedPiece;
    }

    public void setBoardPosX(int boardPosX) {
        this.boardPosX = boardPosX;
    }

    public int getBoardPosX() {
        return boardPosX;
    }

    public void setBoardPosY(int boardPosY) {
        this.boardPosY = boardPosY;
    }

    public int getBoardPosY() {
        return boardPosY;
    }
}
