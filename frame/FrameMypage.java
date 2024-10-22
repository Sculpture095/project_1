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
    JLabel profile;  // 프로필 이미지 라벨
    String profileImagePath;  // 프로필 이미지 경로 저장

    public FrameMypage(JPanel homePanel) {
        this.frameMypagePanel = homePanel;
        setBackground(new Color(255, 255, 255));
        setLayout(null);
        setSize(500, 800);

        // 파일에서 저장된 프로필 경로 읽어오기
        profileImagePath = loadProfileImagePath();

        // 프로필설정 버튼
        ImageIcon profilebt = new ImageIcon("img/profile_modify_icon.png");
        JButton btnProfile = new JButton(profilebt);
        btnProfile.setSize(40, 40);
        btnProfile.setLocation(279, 247);
        btnProfile.setContentAreaFilled(false);
        btnProfile.setBorderPainted(false);
        btnProfile.setFocusPainted(false);
        add(btnProfile);

        // 프로필 사진 (프로필 사진을 라벨에 표시)
        profile = new JLabel();
        profile.setSize(160, 160);
        profile.setLocation(166, 128);
        updateProfileImage();  // 프로필 이미지 업데이트
        add(profile);

        // 프로필 설정 버튼을 클릭했을 때, 프로필 사진을 변경하는 기능 추가
        btnProfile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter("Image files", "jpg", "jpeg", "png", "gif");
                fileChooser.setFileFilter(filter);
                int returnVal = fileChooser.showOpenDialog(null);

                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    // 선택한 파일 경로 저장
                    profileImagePath = fileChooser.getSelectedFile().getPath();
                    updateProfileImage();  // 프로필 사진 업데이트

                    // 경로를 파일에 저장
                    saveProfileImagePath(profileImagePath);
                }
            }
        });

		// 로그아웃 버튼
				ImageIcon lglo = new ImageIcon("img/logout_btn.png");
				JButton btnLogout= new JButton(lglo);
				btnLogout.setSize(300, 70);
				btnLogout.setLocation(101, 551);
				
				btnLogout.setContentAreaFilled(false);
				btnLogout.setBorderPainted(false);
				btnLogout.setFocusPainted(false);
				
				add(btnLogout);
				
				// 로그아웃버튼 누르면 카테고리
				btnLogout.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// 여기로 이동함
						FrameBase.getDispose();
						FrameBase.getInstance(new FrameCategory(homePanel));
					}
				});
				
				// 상세주소변경 버튼
				ImageIcon adbt = new ImageIcon("img/address_btn.png");
				JButton btnAdress= new JButton(adbt);
				btnAdress.setSize(415, 52);
				btnAdress.setLocation(45, 376);
				
				btnAdress.setContentAreaFilled(false);
				btnAdress.setBorderPainted(false);
				btnAdress.setFocusPainted(false);
				
				add(btnAdress);
				
				// 상세주소변경 버튼 누르면 카테고리
				btnAdress.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// 여기로 이동함
						FrameBase.getDispose();
						FrameBase.getInstance(new FrameCategory(homePanel));
					}
				});
				// 내가쓴리뷰보기 버튼
				ImageIcon rvbt = new ImageIcon("img/my_review_btn.png");
				JButton btnReview= new JButton(rvbt);
				btnReview.setSize(415, 52);
				btnReview.setLocation(45, 438);
				
				btnReview.setContentAreaFilled(false);
				btnReview.setBorderPainted(false);
				btnReview.setFocusPainted(false);
				
				add(btnReview);
				
				// 내가쓴리뷰보기 버튼 누르면 카테고리
				btnReview.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// 여기로 이동함
						FrameBase.getDispose();
						FrameBase.getInstance(new FrameCategory(homePanel));
					}
				});
		
		// 찜 버튼
				ImageIcon ggimbt = new ImageIcon("img/heart_icon.png");
				JButton btnGgim = new JButton(ggimbt);
				btnGgim.setSize(39, 38);
				btnGgim.setLocation(32, 685);

				btnGgim.setContentAreaFilled(false);
				btnGgim.setBorderPainted(false);
				btnGgim.setFocusPainted(false);
				// 주문현황 버튼
				ImageIcon orderbt = new ImageIcon("img/order_icon.png");
				JButton btnOrder = new JButton(orderbt);
				btnOrder.setSize(38, 38);
				btnOrder.setLocation(125, 685);

				btnOrder.setContentAreaFilled(false);
				btnOrder.setBorderPainted(false);
				btnOrder.setFocusPainted(false);
				// 카테고리 버튼
				ImageIcon categorybt = new ImageIcon("img/home_icon.png");
				JButton btnCategory = new JButton(categorybt);
				btnCategory.setSize(47, 39);
				btnCategory.setLocation(225, 685);

				btnCategory.setContentAreaFilled(false);
				btnCategory.setBorderPainted(false);
				btnCategory.setFocusPainted(false);
				// 장바구니 버튼
				ImageIcon cartbt = new ImageIcon("img/cart_icon.png");
				JButton btnCart = new JButton(cartbt);
				btnCart.setSize(44, 38);
				btnCart.setLocation(325, 685);

				btnCart.setContentAreaFilled(false);
				btnCart.setBorderPainted(false);
				btnCart.setFocusPainted(false);
				// 마이페이지 버튼
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

				// 찜버튼 누르면
				btnGgim.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// 여기로 이동함
						FrameBase.getDispose();
						
						FrameBase.getInstance(new FrameGgim(homePanel));
						
					}
				});
				// 주문현황버튼 누르면
				btnOrder.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// 여기로 이동함
						FrameBase.getDispose();
						FrameBase.getInstance(new FrameOrder(homePanel));
					}
				});
				// 카테고리버튼 누르면
				btnCategory.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// 여기로 이동함
						FrameBase.getDispose();
						FrameBase.getInstance(new FrameCategory(homePanel));
					}
				});
				// 장바구니버튼 누르면
				btnCart.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// 여기로 이동함
						FrameBase.getDispose();
						FrameBase.getInstance(new FrameCart(homePanel));
					}
				});
				// 마이페이지 누르면
				btnMypage.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// 여기로 이동함
						FrameBase.getDispose();
						FrameBase.getInstance(new FrameMypage(homePanel));
					}
				});
				 // 배경 이미지 추가
		        ImageIcon mainBg = new ImageIcon("img/mypage_bg.jpg");
		        JLabel lblmb = new JLabel(mainBg);
		        lblmb.setSize(500, 800);
		        lblmb.setLocation(0, -20);
		        add(lblmb);
		    }

		    // 프로필 이미지를 업데이트하는 메서드
		    private void updateProfileImage() {
		        ImageIcon profileIcon;
		        if (profileImagePath == null || profileImagePath.isEmpty()) {
		            // 경로가 없으면 기본 이미지를 사용
		            profileIcon = new ImageIcon("img/profile_icon.png");
		        } else {
		            profileIcon = new ImageIcon(profileImagePath);
		        }

		        // 이미지 크기 조정
		        Image img = profileIcon.getImage();
		        Image scaledImg = img.getScaledInstance(160, 160, Image.SCALE_SMOOTH);
		        profileIcon = new ImageIcon(scaledImg);
		        profile.setIcon(profileIcon);
		    }

		    // 프로필 이미지 경로를 파일에 저장하는 메서드
		    private void saveProfileImagePath(String path) {
		        try (BufferedWriter writer = new BufferedWriter(new FileWriter("profile_path.txt"))) {
		            writer.write(path);
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		    }

		    // 파일에서 프로필 이미지 경로를 불러오는 메서드
		    private String loadProfileImagePath() {
		        File file = new File("profile_path.txt");
		        if (file.exists()) {
		            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
		                return reader.readLine();
		            } catch (IOException e) {
		                e.printStackTrace();
		            }
		        }
		        // 파일이 없으면 기본 경로 사용
		        return "img/profile_icon.png";
		    }
		}