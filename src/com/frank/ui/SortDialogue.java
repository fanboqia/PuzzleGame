package com.frank.ui;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;


public class SortDialogue extends JDialog{
	public SortDialogue(int niX,int niY, int[] arrScore)
	{
		JPanel pnBasic = new JPanel();
		pnBasic.setBorder(new LineBorder(Color.BLACK,3));
		pnBasic.setLayout(new GridLayout(5, 2));
		
		for(int i = 0; i < arrScore.length; i++){
			JLabel lnNo = new JLabel();
			lnNo.setBorder(new LineBorder(Color.BLACK,3));
			lnNo.setText("第 "+(i+1)+" 名:");
			//lnNo.setIcon(new ImageIcon(""));
			pnBasic.add(lnNo);
			
			JLabel lbScore = new JLabel(" "+arrScore[i]+" 分",JLabel.CENTER);
			lbScore.setBorder(new LineBorder(Color.BLACK,3));
			pnBasic.add(lbScore);
		}
		
		setContentPane(pnBasic);
		setBounds(niX,niY,500,500);
		//pack();
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setUndecorated(true);
		
		setVisible(true);
	}
}
