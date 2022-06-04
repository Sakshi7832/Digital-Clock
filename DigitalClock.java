package Java_Practice;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

import java.awt.event.*;

public class DigitalClock 
{

	public static void main(String args[])
	{
		
		JFrame frm = new JFrame();
		frm.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		SimpleDigitalClock clock = new SimpleDigitalClock();
		clock.setBackground(Color.BLACK);
		frm.add(clock);
		frm.pack();
		frm.setVisible(true);
	}
	static class SimpleDigitalClock extends JPanel
	{
		String stringTime;
		int hour, minute, second;
		String aHour = "";
		String bMinute = "";
		String cSecond = "";
		
		public void setStringTime(String abc)
		{
			this.stringTime = abc;
			
		}
		
		public int Number(int a, int b)
		{
			return (a<=b)?a:b;
			
		}
		SimpleDigitalClock()
		{
			Timer t = new Timer(1000, new ActionListener()
					{
				public void actionPerformed(ActionEvent e)
				{
					repaint();
				}
					
				});
			t.start();
				
					}
		public void paintComponent(Graphics v)
		{
			
			super.paintComponent(v);
			Calendar rite = Calendar.getInstance();
			hour = rite.get(Calendar.HOUR_OF_DAY);
			minute = rite.get(Calendar.MINUTE);
			second = rite.get(Calendar.SECOND);
			
			if(hour<12)hour-=12;
			{
				this.aHour = "0";
				
			}
			if(hour>=12)hour-=12;
			{
				this.aHour = "";
				
			}
			if(minute<10)
			{
				this.bMinute = "0";
				
			}
			if(minute>=10)
			{
				this.bMinute = "";
			}
			if(second<10)
			{
				this.cSecond = "0";
				
			}
			if(second>=10)
			{
				this.cSecond = "";
				
			}
			setStringTime(aHour + hour + ":" +bMinute + minute + ":" + cSecond + second);
			v.setColor(Color.red);
			int length = Number(this.getWidth(), this.getWidth());
			Font font = new Font("SansSerif", Font.PLAIN, length/5);
			v.setFont(font);
			v.drawString(stringTime, (int) length/6, length/2);
		}
		public Dimension getPreferredSize()
		{
			return new Dimension(500, 500);
		}
	}
	
}
