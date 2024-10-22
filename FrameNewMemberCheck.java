package frame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FrameNewMemberCheck extends JPanel {
	JPanel framNewMemberCheckPanel;

	public FrameNewMemberCheck(JPanel homePanel, String name) {
		this.framNewMemberCheckPanel = homePanel;
		setBackground(new Color(255, 255, 255));
		setLayout(null);

		// 성공 메시지 레이블
        JLabel lblSuccessMessage = new JLabel(name + "님, 회원가입이 완료되었습니다!");
        lblSuccessMessage.setBounds(50, 200, 400, 50);
        lblSuccessMessage.setHorizontalAlignment(JLabel.CENTER);
        add(lblSuccessMessage);
		
		
		// 로그인이동 버튼
		ImageIcon lgbt = new ImageIcon("img/login_move_btn.png");
		JButton btnLogin = new JButton(lgbt);
		btnLogin.setSize(300, 70);
		btnLogin.setLocation(100, 554);

		btnLogin.setContentAreaFilled(false);
		btnLogin.setBorderPainted(false);
		btnLogin.setFocusPainted(false);

		add(btnLogin);
		setSize(500, 800);

		// 로그인버튼 누르면 로그인페이지이동
		btnLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 여기로 이동함
				FrameBase.getDispose();
				FrameBase.getInstance(new FrameLogin(homePanel));
			}
		});

		ImageIcon mainBg = new ImageIcon("img/nm_success_bg.jpg");
		JLabel lblmb = new JLabel(mainBg);
		lblmb.setSize(500, 800);
		lblmb.setLocation(0, 0);
		add(lblmb);
	}
}
