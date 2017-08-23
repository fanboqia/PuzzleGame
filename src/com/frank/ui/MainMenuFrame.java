package com.frank.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.frank.main.Main;

public class MainMenuFrame extends BasicFrame {
	private static final long serialVersionUID = 1L;
	
	private boolean switchBtn = false;
	
	private int clickCounter = 0;
	
	SortDialogue sortDialogue = null;
	
	public MainMenuFrame() {
		pnBasic.setLayout(new BorderLayout());

		JLabel lbMenu = new JLabel();
		lbMenu.setIcon(new ImageIcon("img/splash.png"));
		pnBasic.add(lbMenu, BorderLayout.CENTER);

		JPanel pnOperation = new JPanel();
		pnOperation.setBackground(Color.BLACK);
		pnBasic.add(pnOperation, BorderLayout.SOUTH);
		pnOperation.setLayout(new GridLayout(1, 3));

		String[] arrStrBtnName = { "img/sort.gif", "img/start.gif", "img/exit.gif" };
		for (int i = 0; i < 3; i++) {
			JButton btn_menu = new JButton(new ImageIcon(arrStrBtnName[i]));
			btn_menu.setContentAreaFilled(false);
			btn_menu.setBorderPainted(false);
			// btn_menu.setRolloverEnabled(true);
			// btn_menu.setRolloverIcon(...);
			// btn_menu.setPressedIcon(...);
			pnOperation.add(btn_menu);
		}

		// 获取三个按钮
		for (int i = 0; i < pnOperation.getComponentCount(); i++) {
			JButton button = (JButton) pnOperation.getComponent(i);
			if (i == 0) { // sort	
				button.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						//Main.arrNIScore;
						clickCounter++;	//click 
						int[] arrScore = {3920,2700,500,100,0};
						if(clickCounter%2 == 1)	//click open
							sortDialogue  = new SortDialogue(getX(), getY(), arrScore);
						else 	//click close
							sortDialogue.dispose();
					}
				});
	
			} else if (i == 1) { // start
				button.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						dispose();
						new SelectGateFrame();
					}
				});
			} else if (i == 2) { // exit
				button.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						//存储数据
						
						try {
							Main.save();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						
						dispose();
						System.exit(0);
					}
				});
			}
		}

		setSize(800, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setUndecorated(true);
		setVisible(true);
	}
}
