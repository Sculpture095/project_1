package frame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class FrameLogin extends JPanel{
	JPanel frameJoinPanel;
	public FrameLogin(JPanel homePanel) {
		this.frameJoinPanel = homePanel;
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		setSize(500, 800);
		
		
		
		// 로그인 버튼
		ImageIcon lgbt = new ImageIcon("img/login_btn.png");
		JButton btnLogin= new JButton(lgbt);
		btnLogin.setSize(300, 70);
		btnLogin.setLocation(100, 554);
		
		btnLogin.setContentAreaFilled(false);
		btnLogin.setBorderPainted(false);
		btnLogin.setFocusPainted(false);
		
		// 뒤로가기 버튼
		ImageIcon bbt = new ImageIcon("img/back_icon.png");
		JButton btnBack= new JButton(bbt);
		btnBack.setSize(36, 38);
		btnBack.setLocation(60, 59);
		btnBack.setContentAreaFilled(false);
 		btnBack.setBorderPainted(false);
 		btnBack.setFocusPainted(false);
		
		add(btnLogin);
		add(btnBack);
		
		// 로그인버튼 누르면 카테고리
		btnLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FrameBase.getDispose();
				FrameBase.getInstance(new FrameCategory(homePanel));
			}
		});
		
		// 뒤로가기 버튼
		btnBack.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			FrameBase.getDispose(); // 현재 프레임 닫기
			FrameBase.getInstance(new Frame1_1()); // 새로운 프레임으로 전환
	}
});
		
		
		
		
		ImageIcon mainBg = new ImageIcon("img/login_bg.jpg");
		JLabel lblmb = new JLabel(mainBg);
		lblmb.setSize(500, 800);
		lblmb.setLocation(0, 0);
		add(lblmb);
	}

}
