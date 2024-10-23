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
		// ȸ������ ��ư
				ImageIcon lgbt = new ImageIcon("img/signup_btn.png");
				JButton btnSignUp= new JButton(lgbt);
				btnSignUp.setSize(300, 70);
				btnSignUp.setLocation(108, 663);
				
				btnSignUp.setContentAreaFilled(false);
				btnSignUp.setBorderPainted(false);
				btnSignUp.setFocusPainted(false);
				
		// �ߺ�Ȯ�� ��ư
				ImageIcon chbt = new ImageIcon("img/id_check_btn.png");
				JButton btnCheck= new JButton(chbt);
				btnCheck.setSize(92, 45);
				btnCheck.setLocation(341, 146);
				
				btnCheck.setContentAreaFilled(false);
				btnCheck.setBorderPainted(false);
				btnCheck.setFocusPainted(false);
				// �ڷΰ��� ��ư
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
				
				
		// ȸ������ ������
				btnSignUp.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					FrameBase.getDispose(); // ���� ������ �ݱ�
					FrameBase.getInstance(new FrameNewMemberCheck(homePanel)); // ���ο� ���������� ��ȯ
			}
		});
				
				// �ڷΰ��� ��ư
				btnBack.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					FrameBase.getDispose(); // ���� ������ �ݱ�
					FrameBase.getInstance(homePanel); // ���� ȭ������ ��ȯ
			}
		});

		
		
		ImageIcon mainBg = new ImageIcon("img/newmember_bg.jpg");
		JLabel lblmb = new JLabel(mainBg);
		lblmb.setSize(500, 800);
		lblmb.setLocation(0, 0);
		add(lblmb);
		
	}
}

