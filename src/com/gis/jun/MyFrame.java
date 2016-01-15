package com.gis.jun;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
public class MyFrame extends JFrame{
	//JFrame frame = new JFrame("CSVRead");

	//private Panel p;
	public static void launchFrame(final JFrame f, final int width, final int height, final String title) {
		//super("CsvRead");
		//JTextArea jta = new JTextArea(3, 35);
		//jta.setLineWrap(true);
		//JScrollPane scr = new JScrollPane(jta, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
		//									   JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		//f.add(scr);
		//f.setTitle(f.getClass().getSimpleName());
		f.setTitle(title);
		f.setSize(width, height);
		//setBackground(Color.BLACK);
		
		//jta.insert("huangjun", 0);
		f.setVisible(true);
		
		f.addWindowListener(
				new WindowAdapter() {
					public void windowClosing(WindowEvent e) {
						f.setVisible(false);
						System.exit(-1);
					}
				});
	}
}