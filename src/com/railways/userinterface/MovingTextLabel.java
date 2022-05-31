package com.railways.userinterface;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.Timer;

public class MovingTextLabel extends UserInterfaceView implements ActionListener
{
	public MovingTextLabel() 
    {
        setScrollingMessage(new JLabel("                                                                        Welcome to Ultramain Express                                                         "));
        getScrollingMessage().setFont(new Font(getScrollingMessage().getFont().getFontName(), Font.BOLD, 18));
        getScrollingMessage().setBounds(0, 45, 780, 100); // bug
        getToolbarPanel().add(getScrollingMessage());
        Timer t = new Timer(100, this); // set a timer
        t.start();
     }
	
	@Override
    public void actionPerformed(ActionEvent e) 
	{
        String oldText = getScrollingMessage().getText();
        String newText= oldText.substring(1)+ oldText.substring(0,1);
        getScrollingMessage().setText(newText);
     }
}

