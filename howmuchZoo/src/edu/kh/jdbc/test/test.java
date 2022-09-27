package edu.kh.jdbc.test;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class test {

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame("도움말");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setPreferredSize(new Dimension(800, 600));
				JLabel label = new JLabel("<HTML><center>안녕하세요.<br>얼마쥬의 도움말입니다.<br>"
						+ "이 게임은 5일동안 5번의 행동 횟수로<br>"
						+ "선택한 동물을 키워서 높은 점수로<br>"
						+ "판매하는 게임입니다.<br>그럼 충분히 즐겨주세요.</center></HTML>", SwingConstants.CENTER);
				label.setFont(new Font("돋움", Font.PLAIN, 20));
				frame.getContentPane().add(label);
				Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
				frame.setLocation(dim.width/2-400, dim.height/2-300/2);
				
				frame.pack();
				frame.setVisible(true);
			}
		});
	}
}
