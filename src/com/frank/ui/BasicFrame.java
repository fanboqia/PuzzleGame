package com.frank.ui;

import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public abstract class BasicFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	protected JPanel pnBasic = null;

	public BasicFrame() {

		pnBasic = new JPanel();
		setContentPane(pnBasic);
		setTitle("愤 怒 的 小 鸟");
		setCursor(Toolkit.getDefaultToolkit().createCustomCursor(Toolkit.getDefaultToolkit().getImage("img/arrow.png"),
				new Point(), "self"));
		// 设置窗口图标
		// setIconImage(new ImageIcon("img/bird1.png").getImage());
		setLocationRelativeTo(null);
		// setResizable(false);
	}
}
