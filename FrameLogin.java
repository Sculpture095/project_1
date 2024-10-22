package frame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FrameLogin extends JPanel {
	JPanel frameJoinPanel;

	public FrameLogin(JPanel homePanel) {
		this.frameJoinPanel = homePanel;
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		setSize(500, 800);

		// ���̵�� ��й�ȣ �Է�â
		JTextField tfID = new JTextField(10);
		JPasswordField tfPW = new JPasswordField(10);

		// ���̵� �Է�
		tfID.setBounds(180, 340, 250, 40);
		tfID.setOpaque(false); // �����ϰ� ����
        tfID.setBackground(new Color(0, 0, 0, 0)); // ���� ���� ���
		tfID.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		add(tfID);

		// ��й�ȣ �Է�
		tfPW.setBounds(180, 420, 250, 40);
		tfPW.setOpaque(false); // �����ϰ� ����
		tfPW.setBackground(new Color(0, 0, 0, 0)); // ���� ���� ���
		tfPW.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		add(tfPW);

		// �α��� ��ư
		ImageIcon lgbt = new ImageIcon("img/login_btn.png");
		JButton btnLogin = new JButton(lgbt);
		btnLogin.setSize(300, 70);
		btnLogin.setLocation(100, 554);

		btnLogin.setContentAreaFilled(false);
		btnLogin.setBorderPainted(false);
		btnLogin.setFocusPainted(false);

		// �ڷΰ��� ��ư
		ImageIcon bbt = new ImageIcon("img/back_icon.png");
		JButton btnBack = new JButton(bbt);
		btnBack.setSize(36, 38);
		btnBack.setLocation(60, 59);
		btnBack.setContentAreaFilled(false);
		btnBack.setBorderPainted(false);
		btnBack.setFocusPainted(false);

		add(btnLogin);
		add(btnBack);

		// �α��ι�ư ������ ī�װ�
		btnLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String id = tfID.getText();
				String password = new String(tfPW.getPassword());

				if (validateLogin(id, password)) {
					// �α��� ���� & �̸� ��������
					String name = getNameById(id);
					if (name != null) {
						JOptionPane.showMessageDialog(null, name + "��, ȯ���մϴ�!", "�α��� ����", JOptionPane.INFORMATION_MESSAGE);
					}
					// ����� �̵���
					FrameBase.getDispose();
					FrameBase.getInstance(new FrameCategory(homePanel));
				} else {
					// �α��� ����
					JOptionPane.showMessageDialog(null, "���̵� �Ǵ� ��й�ȣ�� �߸��Ǿ����ϴ�.", "�α��� ����", JOptionPane.WARNING_MESSAGE);
				}

				
			}
		});

		// �ڷΰ��� ��ư
		btnBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// ����� �̵���
				FrameBase.getDispose();
				FrameBase.getInstance(new FrameHome(homePanel));
			}
		});

		ImageIcon mainBg = new ImageIcon("img/login_bg.jpg");
		JLabel lblmb = new JLabel(mainBg);
		lblmb.setSize(500, 800);
		lblmb.setLocation(0, 0);
		add(lblmb);
	}

	private boolean validateLogin(String id, String password) {
		try (BufferedReader br = new BufferedReader(new FileReader("member.txt"))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] parts = line.split(" ");
				if (parts.length >= 2 && parts[0].equals(id) && parts[1].equals(password)) {
					return true; // �α��� ����
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false; // �α��� ����
	}

	private String getNameById(String id) {
		try (BufferedReader br = new BufferedReader(new FileReader("member.txt"))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] parts = line.split(" ");
				if (parts.length > 2 && parts[0].equals(id)) {
					return parts[2]; // ID�� �ش��ϴ� �̸� ��ȯ
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null; // �̸��� ã�� ���� ���
	}
	
}
