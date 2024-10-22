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
	private boolean isIdAvailable = false; // 중복 확인 결과를 저장할 변수

	public FrameNewMember(JPanel homePanel) {
		this.framNewMemberPanel = homePanel;
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		setSize(500, 800);

		// 아이디 입력
		JTextField tfID = new JTextField(10);
		tfID.setBounds(75, 195, 240, 40);
		tfID.setOpaque(false); // 투명하게 설정
        tfID.setBackground(new Color(0, 0, 0, 0)); // 완전 투명 배경
		tfID.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		add(tfID);

		// 비밀번호 입력
		JPasswordField tfPW = new JPasswordField(10);
		tfPW.setBounds(75, 288, 345, 40);
		tfPW.setOpaque(false); // 투명하게 설정
		tfPW.setBackground(new Color(0, 0, 0, 0)); // 완전 투명 배경
		tfPW.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		add(tfPW);

		// 비밀번호 확인 입력
		JPasswordField tfPWConfirm = new JPasswordField(10);
		tfPWConfirm.setBounds(75, 382, 345, 40);
		tfPWConfirm.setOpaque(false); // 투명하게 설정
		tfPWConfirm.setBackground(new Color(0, 0, 0, 0)); // 완전 투명 배경
		tfPWConfirm.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		add(tfPWConfirm);

		// 이름 입력
		JTextField tfName = new JTextField(10);
		tfName.setBounds(75, 479, 345, 40);
		tfName.setOpaque(false); // 투명하게 설정
		tfName.setBackground(new Color(0, 0, 0, 0)); // 완전 투명 배경
		tfName.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		add(tfName);

		// 주소 입력
		JTextField tfAddress = new JTextField(10);
		tfAddress.setBounds(75, 575, 345, 40);
		tfAddress.setOpaque(false); // 투명하게 설정
		tfAddress.setBackground(new Color(0, 0, 0, 0)); // 완전 투명 배경
		tfAddress.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		add(tfAddress);

		// 회원가입 버튼
		ImageIcon lgbt = new ImageIcon("img/signup_btn.png");
		JButton btnSignUp = new JButton(lgbt);
		btnSignUp.setSize(300, 70);
		btnSignUp.setLocation(108, 663);

		btnSignUp.setContentAreaFilled(false);
		btnSignUp.setBorderPainted(false);
		btnSignUp.setFocusPainted(false);

		// 중복확인 버튼
		ImageIcon chbt = new ImageIcon("img/id_check_btn.png");
		JButton btnCheck = new JButton(chbt);
		btnCheck.setSize(92, 45);
		btnCheck.setLocation(341, 192);

		btnCheck.setContentAreaFilled(false);
		btnCheck.setBorderPainted(false);
		btnCheck.setFocusPainted(false);
		// 뒤로가기 버튼
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

		// 중복확인 버튼 클릭 시
		btnCheck.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = tfID.getText();
				if (id.isEmpty()) {
					JOptionPane.showMessageDialog(null, "아이디를 입력해 주세요.", "입력 오류", JOptionPane.WARNING_MESSAGE);
					isIdAvailable = false; // 초기화
					return;
				}

				if (isIdDuplicate(id)) {
					JOptionPane.showMessageDialog(null, "이미 사용 중인 아이디입니다.", "중복 확인", JOptionPane.WARNING_MESSAGE);
					isIdAvailable = false; // 중복 아이디 확인
				} else {
					JOptionPane.showMessageDialog(null, "사용 가능한 아이디입니다.", "중복 확인", JOptionPane.INFORMATION_MESSAGE);
					isIdAvailable = true; // 사용 가능한 아이디
				}
			}
		});

		// 회원가입 누르면
		btnSignUp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String id = tfID.getText();
                String pw = new String(tfPW.getPassword());
                String pwConfirm = new String(tfPWConfirm.getPassword());
                String name = tfName.getText();
                String address = tfAddress.getText();

                // 입력 검증
                if (id.isEmpty() || pw.isEmpty() || pwConfirm.isEmpty() || name.isEmpty() || address.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "모든 필드를 입력해 주세요.", "입력 오류", JOptionPane.WARNING_MESSAGE);
                } else if (!pw.equals(pwConfirm)) {
                    JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다.", "비밀번호 오류", JOptionPane.WARNING_MESSAGE);
                } else if (!isIdAvailable) {
                    JOptionPane.showMessageDialog(null, "아이디 중복 확인을 해주세요.", "중복 확인 필요", JOptionPane.WARNING_MESSAGE);
                } else {
                    // 회원 정보 저장
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter("member.txt", true))) {
                        writer.write(id + " " + pw + " " + name + " " + address);
                        writer.newLine();
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, "회원가입 중 오류가 발생했습니다.", "오류", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    // 회원가입 성공
                    FrameBase.getDispose();
                    FrameBase.getInstance(new FrameNewMemberCheck(homePanel, name));
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

		ImageIcon mainBg = new ImageIcon("img/newmember_bg.jpg");
		JLabel lblmb = new JLabel(mainBg);
		lblmb.setSize(500, 800);
		lblmb.setLocation(0, 0);
		add(lblmb);

	}
	// 아이디 중복 확인 메서드
    private boolean isIdDuplicate(String id) {
        try (BufferedReader br = new BufferedReader(new FileReader("member.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length > 0 && parts[0].equals(id)) {
                    return true; // 중복 아이디 발견
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false; // 중복 아이디 없음
    }
}
