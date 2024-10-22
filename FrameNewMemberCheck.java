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

		// ���� �޽��� ���̺�
        JLabel lblSuccessMessage = new JLabel(name + "��, ȸ�������� �Ϸ�Ǿ����ϴ�!");
        lblSuccessMessage.setBounds(50, 200, 400, 50);
        lblSuccessMessage.setHorizontalAlignment(JLabel.CENTER);
        add(lblSuccessMessage);
		
		
		// �α����̵� ��ư
		ImageIcon lgbt = new ImageIcon("img/login_move_btn.png");
		JButton btnLogin = new JButton(lgbt);
		btnLogin.setSize(300, 70);
		btnLogin.setLocation(100, 554);

		btnLogin.setContentAreaFilled(false);
		btnLogin.setBorderPainted(false);
		btnLogin.setFocusPainted(false);

		add(btnLogin);
		setSize(500, 800);

		// �α��ι�ư ������ �α����������̵�
		btnLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// ����� �̵���
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
