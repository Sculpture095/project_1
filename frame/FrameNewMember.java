package frame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class FrameNewMember extends JPanel{
	JPanel framNewMemberPanel;
	public FrameNewMember(JPanel homePanel) {
		this.framNewMemberPanel = homePanel;
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		setSize(500, 800);
		// 회원가입 버튼
				ImageIcon lgbt = new ImageIcon("img/signup_btn.png");
				JButton btnSignUp= new JButton(lgbt);
				btnSignUp.setSize(300, 70);
				btnSignUp.setLocation(108, 663);
				
				btnSignUp.setContentAreaFilled(false);
				btnSignUp.setBorderPainted(false);
				btnSignUp.setFocusPainted(false);
				
		// 중복확인 버튼
				ImageIcon chbt = new ImageIcon("img/id_check_btn.png");
				JButton btnCheck= new JButton(chbt);
				btnCheck.setSize(92, 45);
				btnCheck.setLocation(341, 146);
				
				btnCheck.setContentAreaFilled(false);
				btnCheck.setBorderPainted(false);
				btnCheck.setFocusPainted(false);
				// 뒤로가기 버튼
				ImageIcon bbt = new ImageIcon("img/back_icon.png");
				JButton btnBack= new JButton(bbt);
				btnBack.setSize(36, 38);
				btnBack.setLocation(60, 59);
				
				btnBack.setContentAreaFilled(false);
				btnBack.setBorderPainted(false);
				btnBack.setFocusPainted(false);
				add(btnBack);
				add(btnSignUp);
				add(btnCheck);
				
				
		// 회원가입 누르면
				btnSignUp.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					FrameBase.getDispose(); // 현재 프레임 닫기
					FrameBase.getInstance(new FrameNewMemberCheck(homePanel)); // 새로운 프레임으로 전환
			}
		});
				
				// 뒤로가기 버튼
				btnBack.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					FrameBase.getDispose(); // 현재 프레임 닫기
					FrameBase.getInstance(homePanel); // 이전 화면으로 전환
			}
		});

		
		
		ImageIcon mainBg = new ImageIcon("img/newmember_bg.jpg");
		JLabel lblmb = new JLabel(mainBg);
		lblmb.setSize(500, 800);
		lblmb.setLocation(0, 0);
		add(lblmb);
		
	}
}

