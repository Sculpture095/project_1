package restaurant;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import firstpro.main.FoodDeliveryApp;
import firstpro.main.RestaurantDAO;
import frame.FrameBase;
import frame.FrameCategory;
import frame.FrameHome;

public class Frame1_1 extends JPanel {
    private JPanel frameKoreanPanel; // 홈 패널
    private JPanel listPanel; // 음식점 리스트가 담길 패널
    private JScrollPane scrollPane; // 스크롤 패널
    

    public Frame1_1(JPanel homePanel) {
        this.frameKoreanPanel = homePanel;
        setBackground(new Color(255, 255, 255));
        setLayout(null);
        setSize(500, 800);
        
      
        // 뒤로가기 버튼
     		ImageIcon bbt = new ImageIcon("img/back_icon.png");
     		JButton btnBack= new JButton(bbt);
     		btnBack.setSize(36, 38);
     		btnBack.setLocation(60, 50);
     		btnBack.setContentAreaFilled(false);
      		btnBack.setBorderPainted(false);
      		btnBack.setFocusPainted(false);
      		
      		add(btnBack);
      		
      	// 뒤로가기 버튼
    		btnBack.addActionListener(new ActionListener() {

    		@Override
    		public void actionPerformed(ActionEvent e) {
    		// 여기로 이동함
    		FrameBase.getDispose();
    		FrameBase.getInstance(new FrameCategory(homePanel));
    	}
    });
    		// 리뷰보기 버튼
    		ImageIcon lgbt = new ImageIcon("img/store_review_btn.png");
    		JButton btnLogin = new JButton(lgbt);
    		btnLogin.setSize(117, 35);
    		btnLogin.setLocation(200, 280);

    		btnLogin.setContentAreaFilled(false);
    		btnLogin.setBorderPainted(false);
    		btnLogin.setFocusPainted(false);

    		add(btnLogin);

    		// 리뷰보기 버튼 누르면 리뷰페이지로 이동
    		btnLogin.addActionListener(new ActionListener() {

    			@Override
    			public void actionPerformed(ActionEvent e) {
    				// 여기로 이동함
    				FrameBase.getDispose();
    				
    			}
    				});

        // 제목 레이블
        JLabel titleLabel = new JLabel("최대감네");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setBounds(230, 50, 100, 30); // 제목 위치 설정
        add(titleLabel);

        // 음식점 리스트 패널 설정 (스크롤 가능)
        listPanel = new JPanel();
        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS)); // 세로로 음식점 나열

        // 스크롤 가능하게 JScrollPane에 리스트 패널 추가
        scrollPane = new JScrollPane(listPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(0, 400, 500, 380); // 스크롤 영역 위치와 크기 설정
        add(scrollPane);
        
        // 예시 음식점 3개 추가
        
        addRestaurant("최대감네", "img/restaurant_image.jpg", 3.0, "맛있고 다양한 한식 메뉴를 제공합니다.", 5000, "배달시간: 30분", new FrameCategory(homePanel));
        addRestaurant("한식당", "img/restaurant_image.jpg", 4.5, "신선한 재료와 정성으로 만든 요리", 3000, "배달시간: 20분", new FrameCategory(homePanel));
        addRestaurant("김치전문점", "img/restaurant_image.jpg", 4.0, "정통 김치 요리를 제공합니다.", 4000, "배달시간: 25분", new FrameCategory(homePanel));
    }

    // 음식점 리스트에 음식점 추가 메서드
    public void addRestaurant(String name, String imagePath, double rating, String description, int deliveryFee, String deliveryTime, JPanel nextFrame) {
        // 개별 음식점 패널
        JPanel restaurantPanel = new JPanel();
        restaurantPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        restaurantPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // 음식점 이미지 버튼 추가
        JButton imageButton = new JButton(new ImageIcon(new ImageIcon(imagePath).getImage().getScaledInstance(160, 120, Image.SCALE_SMOOTH)));
        imageButton.setPreferredSize(new Dimension(160, 120));
        imageButton.setContentAreaFilled(false); // 버튼 배경 투명하게
        imageButton.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY)); // 버튼 테두리 추가

        // 이미지 버튼 클릭 시 액션 리스너 추가
        imageButton.addActionListener(e -> {
            FrameBase.getDispose(); // 현재 프레임 닫기
            FrameBase.getInstance(nextFrame); // 새로운 프레임으로 전환
        });

        // 음식점 정보 추가
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS)); // 세로로 정렬

        JLabel nameLabel = new JLabel(name);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 18)); // 음식점 이름 글자 크기 조정

        // 평균 별점 표시
        StringBuilder stars = new StringBuilder("평균 별점: ");
        for (int i = 0; i < (int) rating; i++) {
            stars.append("★");
        }
        for (int i = 0; i < 5 - (int) rating; i++) {
            stars.append("☆");
        }
        JLabel ratingLabel = new JLabel(stars.toString());
        ratingLabel.setFont(new Font("Arial", Font.PLAIN, 16)); // 별점 글자 크기 조정

        JLabel descriptionLabel = new JLabel("<html>" + description + "</html>");
        descriptionLabel.setFont(new Font("Arial", Font.PLAIN, 16)); // 설명 글자 크기 조정

        JLabel deliveryFeeLabel = new JLabel("배달비: " + deliveryFee + " 원");
        deliveryFeeLabel.setFont(new Font("Arial", Font.PLAIN, 16)); // 배달비 글자 크기 조정

        JLabel deliveryTimeLabel = new JLabel(deliveryTime);
        deliveryTimeLabel.setFont(new Font("Arial", Font.PLAIN, 16)); // 배달시간 글자 크기 조정

        // 정보 패널에 추가
        infoPanel.add(nameLabel);
        infoPanel.add(ratingLabel);
        infoPanel.add(descriptionLabel);
        infoPanel.add(deliveryFeeLabel);
        infoPanel.add(deliveryTimeLabel);

        // 패널에 추가
        restaurantPanel.add(imageButton);
        restaurantPanel.add(Box.createRigidArea(new Dimension(10, 0))); // 이미지와 텍스트 간의 간격
        restaurantPanel.add(infoPanel); // 정보 패널 추가

        // 음식점 패널을 리스트 패널에 추가
        listPanel.add(restaurantPanel);
        listPanel.revalidate();
        listPanel.repaint();
        ImageIcon mainBg = new ImageIcon("img/store1_1.jpg");
      		JLabel lblmb = new JLabel(mainBg);
      		lblmb.setSize(500, 420);
      		lblmb.setOpaque(true);
      		lblmb.setLocation(0, 0);
      		add(lblmb);
    }
}
