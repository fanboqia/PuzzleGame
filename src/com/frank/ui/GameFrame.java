package com.frank.ui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import com.frank.main.Main;
import com.sun.org.apache.bcel.internal.generic.Select;

import javafx.scene.layout.Border;

public class GameFrame extends BasicFrame {

	private static final long serialVersionUID = 1L;

	// 计时器
	Timer timer = null;

	// 面板
	JPanel pnPinTu = null;

	// 标题
	JLabel lbTitle = null;

	// 进度条
	JProgressBar progressBar = null;

	// 之前被按下的按钮
	private JButton btnOld = null;

	// level selection
	boolean success = true;

	int value = 0;

	public static int lv = 0;

	// set the game timeo
	public int getTime() {
		return 30;
	}

	public GameFrame(int row, int col, int level) {

		// level selection
		lv = level;

		// System.out.println(lv);

		ButtonMonitor btnMonitor = new ButtonMonitor();

		setSize(533 * 2, 340);
		pnBasic.setLayout(new BorderLayout());

		progressBar = new JProgressBar();
		progressBar.setMaximum(getTime());
		progressBar.setMinimum(0);
		progressBar.setValue(0);
		progressBar.setBorderPainted(true);
		progressBar.setBackground(Color.pink);
		progressBar.setStringPainted(true);

		timer = new Timer();
		if (value <= getTime()) {
			timer.schedule(new TimerTask() {
				@Override
				public void run() {

					// System.out.println("hhh");
					// System.out.println(value);

					// 时间设置
					if (value < getTime())
						progressBar.setValue(value++);
					else if(value >= getTime()){
						timer.cancel();
						timer = null;
						JOptionPane.showMessageDialog(GameFrame.this, "失败！请继续挑战！");
						dispose();
						new MainMenuFrame();
						//value = 0;
						//progressBar.setValue(0);
						 //System.out.println(value);
					}
				}
			}, 0, 1000);
		}

		JPanel pnBasicCenter = new JPanel();
		pnBasicCenter.setLayout(new GridLayout(1, 2));
		JLabel lbPuzzleOk = new JLabel(new ImageIcon("img/bgp" + level + ".png"));

		pnPinTu = new JPanel();
		pnPinTu.setLayout(new GridLayout(row, col, 1, 1));

		// random index generated
		int[] arr = new int[row * col];
		for (int i = 0; i < arr.length; i++)
			arr[i] = i;
		// random range index
		Main.flushRandomArray(arr);

		switch (level) {
		// level 1 --> 3x3
		case 1:

			lbTitle = new JLabel("第一关  城墙之内", JLabel.CENTER);
			lbTitle.setFont(new Font("黑体", Font.BOLD, 16));

			String[] arraStrBtnPuzzle = { "img/lv3/thumb-1920-656728 [www.imagesplitter.net]-0-0.png",
					"img/lv3/thumb-1920-656728 [www.imagesplitter.net]-0-1.png",
					"img/lv3/thumb-1920-656728 [www.imagesplitter.net]-0-2.png",
					"img/lv3/thumb-1920-656728 [www.imagesplitter.net]-1-0.png",
					"img/lv3/thumb-1920-656728 [www.imagesplitter.net]-1-1.png",
					"img/lv3/thumb-1920-656728 [www.imagesplitter.net]-1-2.png",
					"img/lv3/thumb-1920-656728 [www.imagesplitter.net]-2-0.png",
					"img/lv3/thumb-1920-656728 [www.imagesplitter.net]-2-1.png",
					"img/lv3/thumb-1920-656728 [www.imagesplitter.net]-2-2.png",
					"img/lv3/thumb-1920-656728 [www.imagesplitter.net]-3-0.png",
					"img/lv3/thumb-1920-656728 [www.imagesplitter.net]-3-1.png",
					"img/lv3/thumb-1920-656728 [www.imagesplitter.net]-3-2.png" };

			for (int i = 0; i < row * col; i++) {
				JButton btnPinTu = new JButton(new ImageIcon(arraStrBtnPuzzle[arr[i]]));
				btnPinTu.setName("" + arr[i]);
				btnPinTu.addActionListener(btnMonitor);
				pnPinTu.add(btnPinTu);
			}

			break;

		// level 2 --> 3x3
		case 2:

			lbTitle = new JLabel("第二关   勇闯夺命岛", JLabel.CENTER);
			lbTitle.setFont(new Font("黑体", Font.BOLD, 16));

			String[] arraStrBtnPuzzle1 = { "img/lv1/bgp1 [www.imagesplitter.net]-0-0.png",
					"img/lv1/bgp1 [www.imagesplitter.net]-0-1.png", "img/lv1/bgp1 [www.imagesplitter.net]-0-2.png",
					"img/lv1/bgp1 [www.imagesplitter.net]-1-0.png", "img/lv1/bgp1 [www.imagesplitter.net]-1-1.png",
					"img/lv1/bgp1 [www.imagesplitter.net]-1-2.png", "img/lv1/bgp1 [www.imagesplitter.net]-2-0.png",
					"img/lv1/bgp1 [www.imagesplitter.net]-2-1.png", "img/lv1/bgp1 [www.imagesplitter.net]-2-2.png",
					"img/lv1/bgp1 [www.imagesplitter.net]-3-0.png", "img/lv1/bgp1 [www.imagesplitter.net]-3-1.png",
					"img/lv1/bgp1 [www.imagesplitter.net]-3-2.png" };

			for (int i = 0; i < row * col; i++) {
				JButton btnPinTu = new JButton(new ImageIcon(arraStrBtnPuzzle1[arr[i]]));
				btnPinTu.setName("" + arr[i]);
				btnPinTu.addActionListener(btnMonitor);
				pnPinTu.add(btnPinTu);
			}

			break;
		// level 3 --> 5x4
		case 3:
			lbTitle = new JLabel("第三关   勇闯巨人岛", JLabel.CENTER);
			lbTitle.setFont(new Font("黑体", Font.BOLD, 16));

			String[] arraStrBtnPuzzle2 = { "img/lv2/thumb-1920-451609 [www.imagesplitter.net]-0-0.png",
					"img/lv2/thumb-1920-451609 [www.imagesplitter.net]-0-1.png",
					"img/lv2/thumb-1920-451609 [www.imagesplitter.net]-0-2.png",
					"img/lv2/thumb-1920-451609 [www.imagesplitter.net]-0-3.png",
					"img/lv2/thumb-1920-451609 [www.imagesplitter.net]-1-0.png",
					"img/lv2/thumb-1920-451609 [www.imagesplitter.net]-1-1.png",
					"img/lv2/thumb-1920-451609 [www.imagesplitter.net]-1-2.png",
					"img/lv2/thumb-1920-451609 [www.imagesplitter.net]-1-3.png",
					"img/lv2/thumb-1920-451609 [www.imagesplitter.net]-2-0.png",
					"img/lv2/thumb-1920-451609 [www.imagesplitter.net]-2-1.png",
					"img/lv2/thumb-1920-451609 [www.imagesplitter.net]-2-2.png",
					"img/lv2/thumb-1920-451609 [www.imagesplitter.net]-2-3.png",
					"img/lv2/thumb-1920-451609 [www.imagesplitter.net]-3-0.png",
					"img/lv2/thumb-1920-451609 [www.imagesplitter.net]-3-1.png",
					"img/lv2/thumb-1920-451609 [www.imagesplitter.net]-3-2.png",
					"img/lv2/thumb-1920-451609 [www.imagesplitter.net]-3-3.png",
					"img/lv2/thumb-1920-451609 [www.imagesplitter.net]-4-0.png",
					"img/lv2/thumb-1920-451609 [www.imagesplitter.net]-4-1.png",
					"img/lv2/thumb-1920-451609 [www.imagesplitter.net]-4-2.png",
					"img/lv2/thumb-1920-451609 [www.imagesplitter.net]-4-3.png" };

			for (int i = 0; i < row * col; i++) {
				JButton btnPinTu = new JButton(new ImageIcon(arraStrBtnPuzzle2[arr[i]]));
				btnPinTu.setName("" + arr[i]);
				btnPinTu.addActionListener(btnMonitor);
				pnPinTu.add(btnPinTu);
			}
			break;
		// level 4 --> 2x2
		case 4:

			lbTitle = new JLabel("第四关 大陆的尽头", JLabel.CENTER);
			lbTitle.setFont(new Font("黑体", Font.BOLD, 16));

			String[] arraStrBtnPuzzle3 = { "img/lv4/bgp4 [www.imagesplitter.net]-0-0.png",
					"img/lv4/bgp4 [www.imagesplitter.net]-0-1.png", "img/lv4/bgp4 [www.imagesplitter.net]-1-0.png",
					"img/lv4/bgp4 [www.imagesplitter.net]-1-1.png" };

			for (int i = 0; i < row * col; i++) {
				JButton btnPinTu = new JButton(new ImageIcon(arraStrBtnPuzzle3[arr[i]]));
				btnPinTu.setName("" + arr[i]);
				btnPinTu.addActionListener(btnMonitor);
				pnPinTu.add(btnPinTu);
			}

			break;
		default:
			break;
		}

		pnBasicCenter.add(pnPinTu);
		pnBasicCenter.add(lbPuzzleOk);

		pnBasic.add(pnBasicCenter, BorderLayout.CENTER);
		pnBasic.add(progressBar, BorderLayout.SOUTH); /// ************
		pnBasic.add(lbTitle, BorderLayout.NORTH);

		setVisible(true);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// 询问型窗口(父窗口对象,"显示信息"，"窗口标题",窗口类型)
				int result = JOptionPane.showConfirmDialog(GameFrame.this, "你确定要离开吗？", "警告", JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE);
				// System.out.println(result);
				if (result == 0) // 是
				{
					dispose();
					timer.cancel();	//关闭timer
					new MainMenuFrame();
				}
			}
		});

	}

	private class ButtonMonitor implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// 第一次
			if (btnOld == null) {
				// 当前按钮
				JButton btnCur = (JButton) e.getSource();
				btnOld = btnCur;
			}
			// 多次以后
			else {
				JButton btnCur = (JButton) e.getSource();
				// swap icon
				Icon btnIconCurr = btnCur.getIcon();
				Icon btnIconOld = btnOld.getIcon();
				// swap name
				String btnNameOld = btnOld.getName();
				String btnNameCurr = btnCur.getName();

				btnCur.setName(btnNameOld);
				btnOld.setName(btnNameCurr);
				btnOld.setIcon(btnIconCurr);
				btnCur.setIcon(btnIconOld);
				btnOld = null;

				// test if success
				for (int i = 0, j = 0; i < pnPinTu.getComponentCount(); i++, j++) {
					JButton button = (JButton) pnPinTu.getComponent(i);
					int btnNameNum = Integer.parseInt(button.getName());
					// System.out.println(button.getName() + ",");
					// System.out.println("");
					// System.out.println(btnNameNum);
					if (j != btnNameNum) {
						// System.out.println("no");
						success = false;
						break;
					}
					// 最后一个拼图没问题判断为正确
					// 判断对的情况：注意：格子为变量-1
					if (btnNameNum == pnPinTu.getComponentCount() - 1) {
						success = true;
					}
				}
				if (success) {
					
					/**分数结算**/
					int niScore = 500 + (getTime()-progressBar.getValue());
					System.out.println(niScore);
					Main.appendScore(niScore);
					System.out.println(Arrays.toString(Main.arrNIScore));
					
					dispose();
					timer.cancel();
					new MainMenuFrame();
					// 通关解锁
					// System.out.println("lv: "+lv);
					// 解锁后一关
					// 最后一关不解锁
					if (lv != 4)
						SelectGateFrame.arrayIsGateEnable[lv] = true;
					int counter = 0;
					for (int i = 0; i < 4; i++) {
						if (SelectGateFrame.arrayIsGateEnable[i])
							counter++;
					}
					// 通关
					if (counter == 4) {
						JOptionPane.showMessageDialog(GameFrame.this, "恭喜你通关成功！");
						// System.out.println("你已经通关！");
					} else {
						JOptionPane.showMessageDialog(GameFrame.this, "恭喜你进入下一关！");
					}
				}
			}
		}
	}

	// public static void main(String[] args) {
	// new GameFrame();
	// }
}
