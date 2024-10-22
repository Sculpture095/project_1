package frame;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FrameMypage extends JPanel{
	JPanel frameMypagePanel;
    JLabel profile;  // ������ �̹��� ��
    String profileImagePath;  // ������ �̹��� ��� ����

    public FrameMypage(JPanel homePanel) {
        this.frameMypagePanel = homePanel;
        setBackground(new Color(255, 255, 255));
        setLayout(null);
        setSize(500, 800);

        // ���Ͽ��� ����� ������ ��� �о����
        profileImagePath = loadProfileImagePath();

        // �����ʼ��� ��ư
        ImageIcon profilebt = new ImageIcon("img/profile_modify_icon.png");
        JButton btnProfile = new JButton(profilebt);
        btnProfile.setSize(40, 40);
        btnProfile.setLocation(279, 247);
        btnProfile.setContentAreaFilled(false);
        btnProfile.setBorderPainted(false);
        btnProfile.setFocusPainted(false);
        add(btnProfile);

        // ������ ���� (������ ������ �󺧿� ǥ��)
        profile = new JLabel();
        profile.setSize(160, 160);
        profile.setLocation(166, 128);
        updateProfileImage();  // ������ �̹��� ������Ʈ
        add(profile);

        // ������ ���� ��ư�� Ŭ������ ��, ������ ������ �����ϴ� ��� �߰�
        btnProfile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter("Image files", "jpg", "jpeg", "png", "gif");
                fileChooser.setFileFilter(filter);
                int returnVal = fileChooser.showOpenDialog(null);

                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    // ������ ���� ��� ����
                    profileImagePath = fileChooser.getSelectedFile().getPath();
                    updateProfileImage();  // ������ ���� ������Ʈ

                    // ��θ� ���Ͽ� ����
                    saveProfileImagePath(profileImagePath);
                }
            }
        });

		// �α׾ƿ� ��ư
				ImageIcon lglo = new ImageIcon("img/logout_btn.png");
				JButton btnLogout= new JButton(lglo);
				btnLogout.setSize(300, 70);
				btnLogout.setLocation(101, 551);
				
				btnLogout.setContentAreaFilled(false);
				btnLogout.setBorderPainted(false);
				btnLogout.setFocusPainted(false);
				
				add(btnLogout);
				
				// �α׾ƿ���ư ������ ī�װ�
				btnLogout.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// ����� �̵���
						FrameBase.getDispose();
						FrameBase.getInstance(new FrameCategory(homePanel));
					}
				});
				
				// ���ּҺ��� ��ư
				ImageIcon adbt = new ImageIcon("img/address_btn.png");
				JButton btnAdress= new JButton(adbt);
				btnAdress.setSize(415, 52);
				btnAdress.setLocation(45, 376);
				
				btnAdress.setContentAreaFilled(false);
				btnAdress.setBorderPainted(false);
				btnAdress.setFocusPainted(false);
				
				add(btnAdress);
				
				// ���ּҺ��� ��ư ������ ī�װ�
				btnAdress.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// ����� �̵���
						FrameBase.getDispose();
						FrameBase.getInstance(new FrameCategory(homePanel));
					}
				});
				// ���������亸�� ��ư
				ImageIcon rvbt = new ImageIcon("img/my_review_btn.png");
				JButton btnReview= new JButton(rvbt);
				btnReview.setSize(415, 52);
				btnReview.setLocation(45, 438);
				
				btnReview.setContentAreaFilled(false);
				btnReview.setBorderPainted(false);
				btnReview.setFocusPainted(false);
				
				add(btnReview);
				
				// ���������亸�� ��ư ������ ī�װ�
				btnReview.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// ����� �̵���
						FrameBase.getDispose();
						FrameBase.getInstance(new FrameCategory(homePanel));
					}
				});
		
		// �� ��ư
				ImageIcon ggimbt = new ImageIcon("img/heart_icon.png");
				JButton btnGgim = new JButton(ggimbt);
				btnGgim.setSize(39, 38);
				btnGgim.setLocation(32, 685);

				btnGgim.setContentAreaFilled(false);
				btnGgim.setBorderPainted(false);
				btnGgim.setFocusPainted(false);
				// �ֹ���Ȳ ��ư
				ImageIcon orderbt = new ImageIcon("img/order_icon.png");
				JButton btnOrder = new JButton(orderbt);
				btnOrder.setSize(38, 38);
				btnOrder.setLocation(125, 685);

				btnOrder.setContentAreaFilled(false);
				btnOrder.setBorderPainted(false);
				btnOrder.setFocusPainted(false);
				// ī�װ� ��ư
				ImageIcon categorybt = new ImageIcon("img/home_icon.png");
				JButton btnCategory = new JButton(categorybt);
				btnCategory.setSize(47, 39);
				btnCategory.setLocation(225, 685);

				btnCategory.setContentAreaFilled(false);
				btnCategory.setBorderPainted(false);
				btnCategory.setFocusPainted(false);
				// ��ٱ��� ��ư
				ImageIcon cartbt = new ImageIcon("img/cart_icon.png");
				JButton btnCart = new JButton(cartbt);
				btnCart.setSize(44, 38);
				btnCart.setLocation(325, 685);

				btnCart.setContentAreaFilled(false);
				btnCart.setBorderPainted(false);
				btnCart.setFocusPainted(false);
				// ���������� ��ư
				ImageIcon mypagebt = new ImageIcon("img/user_icon.png");
				JButton btnMypage = new JButton(mypagebt);
				btnMypage.setSize(36, 42);
				btnMypage.setLocation(425, 685);

				btnMypage.setContentAreaFilled(false);
				btnMypage.setBorderPainted(false);
				btnMypage.setFocusPainted(false);

				add(btnGgim);
				add(btnOrder);
				add(btnCategory);
				add(btnCart);
				add(btnMypage);

				// ���ư ������
				btnGgim.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// ����� �̵���
						FrameBase.getDispose();
						
						FrameBase.getInstance(new FrameGgim(homePanel));
						
					}
				});
				// �ֹ���Ȳ��ư ������
				btnOrder.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// ����� �̵���
						FrameBase.getDispose();
						FrameBase.getInstance(new FrameOrder(homePanel));
					}
				});
				// ī�װ���ư ������
				btnCategory.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// ����� �̵���
						FrameBase.getDispose();
						FrameBase.getInstance(new FrameCategory(homePanel));
					}
				});
				// ��ٱ��Ϲ�ư ������
				btnCart.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// ����� �̵���
						FrameBase.getDispose();
						FrameBase.getInstance(new FrameCart(homePanel));
					}
				});
				// ���������� ������
				btnMypage.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// ����� �̵���
						FrameBase.getDispose();
						FrameBase.getInstance(new FrameMypage(homePanel));
					}
				});
				 // ��� �̹��� �߰�
		        ImageIcon mainBg = new ImageIcon("img/mypage_bg.jpg");
		        JLabel lblmb = new JLabel(mainBg);
		        lblmb.setSize(500, 800);
		        lblmb.setLocation(0, -20);
		        add(lblmb);
		    }

		    // ������ �̹����� ������Ʈ�ϴ� �޼���
		    private void updateProfileImage() {
		        ImageIcon profileIcon;
		        if (profileImagePath == null || profileImagePath.isEmpty()) {
		            // ��ΰ� ������ �⺻ �̹����� ���
		            profileIcon = new ImageIcon("img/profile_icon.png");
		        } else {
		            profileIcon = new ImageIcon(profileImagePath);
		        }

		        // �̹��� ũ�� ����
		        Image img = profileIcon.getImage();
		        Image scaledImg = img.getScaledInstance(160, 160, Image.SCALE_SMOOTH);
		        profileIcon = new ImageIcon(scaledImg);
		        profile.setIcon(profileIcon);
		    }

		    // ������ �̹��� ��θ� ���Ͽ� �����ϴ� �޼���
		    private void saveProfileImagePath(String path) {
		        try (BufferedWriter writer = new BufferedWriter(new FileWriter("profile_path.txt"))) {
		            writer.write(path);
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		    }

		    // ���Ͽ��� ������ �̹��� ��θ� �ҷ����� �޼���
		    private String loadProfileImagePath() {
		        File file = new File("profile_path.txt");
		        if (file.exists()) {
		            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
		                return reader.readLine();
		            } catch (IOException e) {
		                e.printStackTrace();
		            }
		        }
		        // ������ ������ �⺻ ��� ���
		        return "img/profile_icon.png";
		    }
		}