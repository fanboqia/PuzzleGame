package com.frank.ui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import com.frank.main.Main;

public class SelectGateFrame extends BasicFrame {

	private static final long serialVersionUID = 1L;
	JButton btn_menu = null;
	// 设置关卡是否可用
	public static boolean[] arrayIsGateEnable = { true, false, false, false };

	public SelectGateFrame() {
		
		//System.out.println(Arrays.toString(arrayIsGateEnable));
		
		//pnBasic = new JPanel(); 父类构造器中已经给予了一个pnBasic，子类再声明并没有加到container中，注意父子类构造器调用顺序
		pnBasic.setLayout(new GridLayout(Main.MAX_LV / 2, 2, 4, 4));
		
		String[] arrStrBtnName = { "img/lv1opn.png", "img/lv2opn.png", "img/lv3opn.png", "img/lv4opn.png" };
		String[] arrStrBtnName2 = { "img/lv1opn2.png", "img/lv2opn2.png", "img/lv3opn2.png", "img/lv4opn2.png" };
		String[] arrStrBtnName3 = { "img/lv1cls.png", "img/lv2cls.png", "img/lv3cls.png", "img/lv4cls.png" };
		for (int i = 0; i < Main.MAX_LV; i++) {
			// initialize
			btn_menu = new JButton(new ImageIcon(arrStrBtnName[i]));
			// 设置关卡
			if (!(arrayIsGateEnable[i])) {
				btn_menu.setIcon(new ImageIcon(arrStrBtnName3[i]));
			} else {
				btn_menu.setRolloverIcon(new ImageIcon(arrStrBtnName2[i]));
			}
			btn_menu.setContentAreaFilled(false);
			btn_menu.setBorderPainted(false);
			btn_menu.setRolloverEnabled(true);
			// btn_menu.setPressedIcon(...);
			pnBasic.add(btn_menu);
		}
		
//		System.out.println(pnBasic.getComponentCount());
		
		for (int i = 0; i < pnBasic.getComponentCount(); i++) {
			JButton button = (JButton) pnBasic.getComponent(i);
			if (i == 0) { // lv1
				button.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {					
						if(arrayIsGateEnable[0]){
							dispose();
							//3,3,1
							new GameFrame(3,3,1);
						}
					}
				});
			} else if (i == 1) { // lv2
				button.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						if(arrayIsGateEnable[1]){
							dispose();
							//3,3,2
							new GameFrame(3,3,2);
						}
					}
				});
			}
			else if(i == 2){ //lv3
				button.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						if(arrayIsGateEnable[2]){
							dispose();
							//5,4,3
							new GameFrame(5,4,3);
						}
					}
				});
			}
			else{	//lv4
				button.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						if(arrayIsGateEnable[3]){
							dispose();
							//2,2,4
							new GameFrame(2,2,4);
						}
					}
				});
			}
		}

		//setSize(800,500);
		setSize(165 * 2, 470 * 2);
		// setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		//setContentPane(pnBasic);
		setVisible(true);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// super.windowClosed(e);
				// System.out.println("ssss");
				// 销毁窗口
				dispose();
				// 生成主菜单
				new MainMenuFrame();
			}
		});
	}

//	 public static void main(String[] args) {
//	 new SelectGateFrame();
//	 }
}
