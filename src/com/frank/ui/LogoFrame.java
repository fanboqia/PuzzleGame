package com.frank.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LogoFrame extends BasicFrame {
	private static final long serialVersionUID = 1L;
	private int bgIndex = 1;
	private JLabel lbLogo = null;
	JLabel lbWelcome = null;
	JButton btnNext = null;

	// logo 线程
	private Timer timerLogo;

	public LogoFrame() {
		// super();
		pnBasic.setLayout(new BorderLayout());
		lbLogo = new JLabel();
		ImageIcon img_bg = new ImageIcon("img/bg.png");
		lbLogo.setIcon(img_bg);

		pnBasic.add(lbLogo, BorderLayout.CENTER);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setUndecorated(true); // 去除对话
		pack();
		// AWTUtilities.setWindowOpaque(this, false);
		setLocationRelativeTo(null);
		setVisible(true);
		startThread();

	}

	private void startThread() {
		if (timerLogo == null) {
			timerLogo = new Timer();

			// TimerTask
			TimerTask task = new TimerTask() {
				@Override
				public void run() {
					// System.out.println("GOGO!");
					if (bgIndex < 7) {
						lbLogo.setIcon(new ImageIcon("img/bg" + bgIndex + ".png"));
					}

					// last scene
					if (bgIndex == 7) {
						JPanel pn_useless = new JPanel(new GridLayout(1, 3));
						pnBasic.add(pn_useless, BorderLayout.NORTH);
						// lbWelcome1.setBounds(300,5,30,5);
						pn_useless.add(new JLabel());

						lbWelcome = new JLabel("欢 迎 ！");
						lbWelcome.setFont(new Font("宋体", Font.BOLD, 30));
						lbWelcome.setForeground(Color.BLUE);
						lbWelcome.setBounds(300, 5, 30, 5);
						pn_useless.add(lbWelcome, BorderLayout.NORTH);
						// btnNext.setText("进入游戏");
						stopThread();
						// 三秒后关闭
						try {
							Thread.sleep(1500);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						// 销毁窗口
						dispose();
						// 退出
						// System.exit(0);
						new MainMenuFrame();
					}
					bgIndex++;
				}
			};
			timerLogo.schedule(task, 1000, 200);
		}
	}

	// 关闭线程
	private void stopThread() {
		if (timerLogo != null) {
			timerLogo.cancel();
			timerLogo = null;
			// System.out.println("asdas");
		}
	}
}
