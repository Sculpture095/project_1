package frame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

@SuppressWarnings("serial")
public class FrameNewMember extends JPanel {
	JPanel framNewMemberPanel;
	private boolean isIdAvailable = false; // �ߺ� Ȯ�� ����� ������ ����

	public FrameNewMember(JPanel homePanel) {
		this.framNewMemberPanel = homePanel;
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		setSize(500, 800);

		// ���̵� �Է�
		JTextField tfID = new JTextField(10);
		tfID.setBounds(75, 195, 240, 40);
		tfID.setOpaque(false); // �����ϰ� ����
        tfID.setBackground(new Color(0, 0, 0, 0)); // ���� ���� ���
		tfID.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		add(tfID);

		// ��й�ȣ �Է�
		JPasswordField tfPW = new JPasswordField(10);
		tfPW.setBounds(75, 288, 345, 40);
		tfPW.setOpaque(false); // �����ϰ� ����
		tfPW.setBackground(new Color(0, 0, 0, 0)); // ���� ���� ���
		tfPW.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		add(tfPW);

		// ��й�ȣ Ȯ�� �Է�
		JPasswordField tfPWConfirm = new JPasswordField(10);
		tfPWConfirm.setBounds(75, 382, 345, 40);
		tfPWConfirm.setOpaque(false); // �����ϰ� ����
		tfPWConfirm.setBackground(new Color(0, 0, 0, 0)); // ���� ���� ���
		tfPWConfirm.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		add(tfPWConfirm);

		// �̸� �Է�
		JTextField tfName = new JTextField(10);
		tfName.setBounds(75, 479, 345, 40);
		tfName.setOpaque(false); // �����ϰ� ����
		tfName.setBackground(new Color(0, 0, 0, 0)); // ���� ���� ���
		tfName.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		add(tfName);

		// �ּ� �Է�
		JTextField tfAddress = new JTextField(10);
		tfAddress.setBounds(75, 575, 345, 40);
		tfAddress.setOpaque(false); // �����ϰ� ����
		tfAddress.setBackground(new Color(0, 0, 0, 0)); // ���� ���� ���
		tfAddress.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		add(tfAddress);

		// ȸ������ ��ư
		ImageIcon lgbt = new ImageIcon("img/signup_btn.png");
		JButton btnSignUp = new JButton(lgbt);
		btnSignUp.setSize(300, 70);
		btnSignUp.setLocation(108, 663);

		btnSignUp.setContentAreaFilled(false);
		btnSignUp.setBorderPainted(false);
		btnSignUp.setFocusPainted(false);

		// �ߺ�Ȯ�� ��ư
		ImageIcon chbt = new ImageIcon("img/id_check_btn.png");
		JButton btnCheck = new JButton(chbt);
		btnCheck.setSize(92, 45);
		btnCheck.setLocation(341, 192);

		btnCheck.setContentAreaFilled(false);
		btnCheck.setBorderPainted(false);
		btnCheck.setFocusPainted(false);
		// �ڷΰ��� ��ư
		ImageIcon bbt = new ImageIcon("img/back_icon.png");
		JButton btnBack = new JButton(bbt);
		btnBack.setSize(36, 38);
		btnBack.setLocation(60, 59);

		btnBack.setContentAreaFilled(false);
		btnBack.setBorderPainted(false);
		btnBack.setFocusPainted(false);
		add(btnBack);
		add(btnSignUp);
		add(btnCheck);

		// �ߺ�Ȯ�� ��ư Ŭ�� ��
		btnCheck.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = tfID.getText();
				if (id.isEmpty()) {
					JOptionPane.showMessageDialog(null, "���̵� �Է��� �ּ���.", "�Է� ����", JOptionPane.WARNING_MESSAGE);
					isIdAvailable = false; // �ʱ�ȭ
					return;
				}

				if (isIdDuplicate(id)) {
					JOptionPane.showMessageDialog(null, "�̹� ��� ���� ���̵��Դϴ�.", "�ߺ� Ȯ��", JOptionPane.WARNING_MESSAGE);
					isIdAvailable = false; // �ߺ� ���̵� Ȯ��
				} else {
					JOptionPane.showMessageDialog(null, "��� ������ ���̵��Դϴ�.", "�ߺ� Ȯ��", JOptionPane.INFORMATION_MESSAGE);
					isIdAvailable = true; // ��� ������ ���̵�
				}
			}
		});

		// ȸ������ ������
		btnSignUp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String id = tfID.getText();
                String pw = new String(tfPW.getPassword());
                String pwConfirm = new String(tfPWConfirm.getPassword());
                String name = tfName.getText();
                String address = tfAddress.getText();

                // �Է� ����
                if (id.isEmpty() || pw.isEmpty() || pwConfirm.isEmpty() || name.isEmpty() || address.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "��� �ʵ带 �Է��� �ּ���.", "�Է� ����", JOptionPane.WARNING_MESSAGE);
                } else if (!pw.equals(pwConfirm)) {
                    JOptionPane.showMessageDialog(null, "��й�ȣ�� ��ġ���� �ʽ��ϴ�.", "��й�ȣ ����", JOptionPane.WARNING_MESSAGE);
                } else if (!isIdAvailable) {
                    JOptionPane.showMessageDialog(null, "���̵� �ߺ� Ȯ���� ���ּ���.", "�ߺ� Ȯ�� �ʿ�", JOptionPane.WARNING_MESSAGE);
                } else {
                    // ȸ�� ���� ����
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter("member.txt", true))) {
                        writer.write(id + " " + pw + " " + name + " " + address);
                        writer.newLine();
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, "ȸ������ �� ������ �߻��߽��ϴ�.", "����", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    // ȸ������ ����
                    FrameBase.getDispose();
                    FrameBase.getInstance(new FrameNewMemberCheck(homePanel, name));
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

		ImageIcon mainBg = new ImageIcon("img/newmember_bg.jpg");
		JLabel lblmb = new JLabel(mainBg);
		lblmb.setSize(500, 800);
		lblmb.setLocation(0, 0);
		add(lblmb);

	}
	// ���̵� �ߺ� Ȯ�� �޼���
    private boolean isIdDuplicate(String id) {
        try (BufferedReader br = new BufferedReader(new FileReader("member.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length > 0 && parts[0].equals(id)) {
                    return true; // �ߺ� ���̵� �߰�
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false; // �ߺ� ���̵� ����
    }
}
