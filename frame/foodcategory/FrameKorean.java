package frame.foodcategory;

import java.awt.*;
import javax.swing.*;

public class FrameKorean extends JPanel {
    private JPanel frameKoreanPanel; // 홈 패널
    private JPanel listPanel; // 음식점 리스트가 담길 패널
    private JScrollPane scrollPane; // 스크롤 패널

    public FrameKorean(JPanel homePanel) {
        this.frameKoreanPanel = homePanel;
        setBackground(new Color(255, 255, 255));
        setLayout(null);
        setSize(500, 800);

        // 제목 레이블
        JLabel titleLabel = new JLabel("한식");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setBounds(200, 50, 100, 30); // 제목 위치 설정
        add(titleLabel);

        // 음식점 리스트 패널 설정 (스크롤 가능)
        listPanel = new JPanel();
        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS)); // 세로로 음식점 나열

        // 스크롤 가능하게 JScrollPane에 리스트 패널 추가
        scrollPane = new JScrollPane(listPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(0, 100, 500, 600); // 스크롤 영역 위치와 크기 설정
        add(scrollPane);

        // 예시 음식점 3개 추가
        addRestaurant("최대감네", "img/restaurant_image.jpg", 3.0, "대표메뉴: 김치찜", 5000, "배달시간: 30분");
        addRestaurant("한식당", "img/restaurant_image.jpg", 4.5, "대표메뉴: 비빔밥", 3000, "배달시간: 20분");
        addRestaurant("김치전문점", "img/restaurant_image.jpg", 4.0, "대표메뉴: 김치전", 4000, "배달시간: 25분");
    }

    // 음식점 리스트에 음식점 추가 메서드
    public void addRestaurant(String name, String imagePath, double rating, String menu, int deliveryFee, String deliveryTime) {
        // 개별 음식점 패널
        JPanel restaurantPanel = new JPanel();
        restaurantPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        restaurantPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // 음식점 이미지 버튼 추가
        JButton imageButton = new JButton(new ImageIcon(new ImageIcon(imagePath).getImage().getScaledInstance(160, 120, Image.SCALE_SMOOTH)));
        imageButton.setPreferredSize(new Dimension(160, 120));
        imageButton.setContentAreaFilled(false); // 버튼 배경 투명하게
        imageButton.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY)); // 버튼 테두리 추가

        // 음식점 정보 추가
        JLabel nameLabel = new JLabel(name);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 18)); // 음식점 이름 글자 크기 조정

        JLabel ratingLabel = new JLabel("평균 별점: ★".repeat((int) rating) + "☆".repeat(5 - (int) rating));
        ratingLabel.setFont(new Font("Arial", Font.PLAIN, 16)); // 별점 글자 크기 조정

        JLabel menuLabel = new JLabel(menu);
        menuLabel.setFont(new Font("Arial", Font.PLAIN, 16)); // 메뉴 글자 크기 조정

        JLabel deliveryFeeLabel = new JLabel("배달비: " + deliveryFee + " 원");
        deliveryFeeLabel.setFont(new Font("Arial", Font.PLAIN, 16)); // 배달비 글자 크기 조정

        JLabel deliveryTimeLabel = new JLabel(deliveryTime);
        deliveryTimeLabel.setFont(new Font("Arial", Font.PLAIN, 16)); // 배달시간 글자 크기 조정

        // 패널에 추가
        restaurantPanel.add(imageButton);
        restaurantPanel.add(Box.createRigidArea(new Dimension(10, 0))); // 이미지와 텍스트 간의 간격
        restaurantPanel.add(nameLabel);
        restaurantPanel.add(ratingLabel);
        restaurantPanel.add(menuLabel);
        restaurantPanel.add(deliveryFeeLabel);
        restaurantPanel.add(deliveryTimeLabel);

        // 음식점 패널을 리스트 패널에 추가
        listPanel.add(restaurantPanel);
        listPanel.revalidate();
        listPanel.repaint();
    }
}
