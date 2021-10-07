package com.example.ChessNew.Ui;

import java.awt.Color;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

/**		
 * Hello world!		
 *
 */
public class App extends JFrame
{
    /**
	 * 
	 */
    protected JPanel loginView;
    protected JPanel gameView;
	public static void main( String[] args )
    {
        try {
        App window = new App();
        window.setVisible(true);

        }
        catch(Exception e) {
        	e.getStackTrace();
        }
    }
	public App() {
		intialize();
	}
	public void intialize() {
	     setBounds(100, 100, 800, 600);
	     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     gameView=new DrawElement();
	     loginView=new LoginPanel(gameView,this);
	     this.setContentPane(gameView);//Parca przy logice
	     
	}

	
}
