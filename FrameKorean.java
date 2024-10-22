package frame.foodcategory;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import DeliveryVO.Restaurant;
import DeliveryVO.RestaurantDAO;
import frame.Frame1_1;
import frame.FrameBase;
import frame.FrameCategory;

public class FrameKorean extends JPanel {
    private JPanel frameKoreanPanel; // 홈 패널
    private JPanel listPanel; // 음식점 리스트가 담길 패널
    private JScrollPane scrollPane; // 스크롤 패널

    public FrameKorean(JPanel homePanel) {
        this.frameKoreanPanel = homePanel;
        setBackground(new Color(255, 255, 255));
        setLayout(null);
        setSize(500, 800);

        // 뒤로가기 버튼
        ImageIcon bbt = new ImageIcon("img/back_icon.png");
        JButton btnBack = new JButton(bbt);
        btnBack.setSize(36, 38);
        btnBack.setLocation(60, 50);
        btnBack.setContentAreaFilled(false);
        btnBack.setBorderPainted(false);
        btnBack.setFocusPainted(false);
        add(btnBack);

        // 뒤로가기 버튼 액션
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrameBase.getDispose();
                FrameBase.getInstance(new FrameCategory(homePanel));
            }
        });

        // 제목 레이블
        JLabel titleLabel = new JLabel("한식");
        titleLabel.setFont(new Font("", Font.BOLD, 24));
        titleLabel.setBounds(230, 50, 100, 30);
        add(titleLabel);

        // 음식점 리스트 패널 설정 (스크롤 가능)
        listPanel = new JPanel();
        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));

        // 스크롤 가능하게 JScrollPane에 리스트 패널 추가
        scrollPane = new JScrollPane(listPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(0, 100, 500, 600);
        add(scrollPane);

        // 음식점 목록을 초기화하고 추가하는 메소드 호출
        loadKoreanRestaurants();
    }

    // 음식점 리스트에 음식점 추가 메서드
    public void addRestaurant(Restaurant restaurant, String imagePath) {
        JPanel restaurantPanel = new JPanel();
        restaurantPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        restaurantPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // 음식점 이미지 버튼 추가
        JButton imageButton = new JButton(new ImageIcon(new ImageIcon(imagePath).getImage().getScaledInstance(160, 120, Image.SCALE_SMOOTH)));
        imageButton.setPreferredSize(new Dimension(160, 120));
        imageButton.setContentAreaFilled(false);
        imageButton.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

        // 이미지 버튼 클릭 시 액션 리스너 추가
        imageButton.addActionListener(e -> {
            Frame1_1.showRestaurantMenu(restaurant);
        });

        // 음식점 정보 추가
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));

        JLabel nameLabel = new JLabel(restaurant.getName());
        nameLabel.setFont(new Font("", Font.BOLD, 18));

        JLabel ratingLabel = new JLabel("평균 별점: " + restaurant.getRestaurantScore());
        ratingLabel.setFont(new Font("굴림체 보통", Font.PLAIN, 16));

        JLabel deliveryFeeLabel = new JLabel("배달비: " + restaurant.getDeliveryPrice() + " 원");
        deliveryFeeLabel.setFont(new Font("굴림체 보통", Font.PLAIN, 16));

        // 정보 패널에 추가
        infoPanel.add(nameLabel);
        infoPanel.add(ratingLabel);
        infoPanel.add(deliveryFeeLabel);

        // 패널에 추가
        restaurantPanel.add(imageButton);
        restaurantPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        restaurantPanel.add(infoPanel);

        // 음식점 패널을 리스트 패널에 추가
        listPanel.add(restaurantPanel);
        listPanel.revalidate();
        listPanel.repaint();
    }

    // 한식 음식점을 로드하고 리스트에 추가하는 메소드
    public void loadKoreanRestaurants() {
        for (Restaurant restaurant : RestaurantDAO.getKoreanRestaurants()) {
            addRestaurant(restaurant, "img/restaurant_image.png");  // 각 음식점에 이미지 경로를 전달
        }
    }
}
