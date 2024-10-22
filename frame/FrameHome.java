package frame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import frame.FrameBase;
import frame.FrameLogin;
import frame.FrameNewMember;

public class FrameHome extends JPanel {
	
	JPanel frameLoginPanel;
	public FrameHome(JPanel homePanel) {
		this.frameLoginPanel = homePanel;
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		setSize(500, 800);
		
		
		// �α��� ��ư
				ImageIcon lgbt = new ImageIcon("img/main_login_btn.png");
				JButton btnLogin = new JButton(lgbt);
				btnLogin.setSize(300, 70);
				btnLogin.setLocation(100, 525);
				
				btnLogin.setContentAreaFilled(false);
				btnLogin.setBorderPainted(false);
				btnLogin.setFocusPainted(false);
				
	    // ȸ������ ��ư
			ImageIcon nmbt = new ImageIcon("img/main_new_member_btn.png");
			JButton btnNewMember = new JButton(nmbt);
			btnNewMember.setSize(300, 70);
			btnNewMember.setLocation(100, 612);
			btnNewMember.setContentAreaFilled(false);
			btnNewMember.setBorderPainted(false);
			btnNewMember.setFocusPainted(false);
			
			// �α��� ������
			btnLogin.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// ����� �̵���
					FrameBase.getDispose();
					FrameBase.getInstance(new FrameLogin(homePanel));
				}
			});
			
			// ȸ������ ������
			btnNewMember.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								// ����� �̵���
								FrameBase.getDispose();
								FrameBase.getInstance(new FrameNewMember(homePanel));
							}
						});

			
			
				
		add(btnLogin);
		add(btnNewMember);
		
		
		ImageIcon mainBg = new ImageIcon("img/Main_BG.jpg");
		JLabel lblmb = new JLabel(mainBg);
		lblmb.setSize(500, 800);
		lblmb.setLocation(0, 0);
		add(lblmb);
	}
	

}
