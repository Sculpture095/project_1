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

		// 아이디와 비밀번호 입력창
		JTextField tfID = new JTextField(10);
		JPasswordField tfPW = new JPasswordField(10);

		// 아이디 입력
		tfID.setBounds(180, 340, 250, 40);
		tfID.setOpaque(false); // 투명하게 설정
        tfID.setBackground(new Color(0, 0, 0, 0)); // 완전 투명 배경
		tfID.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		add(tfID);

		// 비밀번호 입력
		tfPW.setBounds(180, 420, 250, 40);
		tfPW.setOpaque(false); // 투명하게 설정
		tfPW.setBackground(new Color(0, 0, 0, 0)); // 완전 투명 배경
		tfPW.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		add(tfPW);

		// 로그인 버튼
		ImageIcon lgbt = new ImageIcon("img/login_btn.png");
		JButton btnLogin = new JButton(lgbt);
		btnLogin.setSize(300, 70);
		btnLogin.setLocation(100, 554);

		btnLogin.setContentAreaFilled(false);
		btnLogin.setBorderPainted(false);
		btnLogin.setFocusPainted(false);

		// 뒤로가기 버튼
		ImageIcon bbt = new ImageIcon("img/back_icon.png");
		JButton btnBack = new JButton(bbt);
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

				String id = tfID.getText();
				String password = new String(tfPW.getPassword());

				if (validateLogin(id, password)) {
					// 로그인 성공 & 이름 가져오기
					String name = getNameById(id);
					if (name != null) {
						JOptionPane.showMessageDialog(null, name + "님, 환영합니다!", "로그인 성공", JOptionPane.INFORMATION_MESSAGE);
					}
					// 여기로 이동함
					FrameBase.getDispose();
					FrameBase.getInstance(new FrameCategory(homePanel));
				} else {
					// 로그인 실패
					JOptionPane.showMessageDialog(null, "아이디 또는 비밀번호가 잘못되었습니다.", "로그인 오류", JOptionPane.WARNING_MESSAGE);
				}

				
			}
		});

		// 뒤로가기 버튼
		btnBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 여기로 이동함
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
					return true; // 로그인 성공
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false; // 로그인 실패
	}

	private String getNameById(String id) {
		try (BufferedReader br = new BufferedReader(new FileReader("member.txt"))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] parts = line.split(" ");
				if (parts.length > 2 && parts[0].equals(id)) {
					return parts[2]; // ID에 해당하는 이름 반환
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null; // 이름을 찾지 못한 경우
	}
	
}
