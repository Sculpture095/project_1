package frame;

import DeliveryVO.Menu;
import DeliveryVO.Restaurant;
import javax.swing.*;
import java.awt.*;

public class Frame1_1 extends JPanel {
    
    public static void showRestaurantMenu(Restaurant restaurant) {
        // 메뉴 패널 생성
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));

        JLabel restaurantNameLabel = new JLabel("메뉴 목록 - " + restaurant.getName());
        restaurantNameLabel.setFont(new Font("", Font.BOLD, 15));
        restaurantNameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        menuPanel.add(restaurantNameLabel);
        menuPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        // 레스토랑의 메뉴를 표시
        for (Menu menu : restaurant.getMenuList()) {
            JPanel menuItemPanel = new JPanel();
            menuItemPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
            menuItemPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            // 메뉴 이미지 추가
            String imagePath = "img/menu_image.png"; // 메뉴 이미지 경로
            JButton menuImageButton = new JButton(new ImageIcon(new ImageIcon(imagePath).getImage().getScaledInstance(160, 120, Image.SCALE_SMOOTH)));
            menuImageButton.setPreferredSize(new Dimension(125, 95));
            menuImageButton.setContentAreaFilled(false);
            menuImageButton.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

            // 메뉴 정보 패널 추가
            JPanel infoPanel = new JPanel();
            infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));

            JLabel menuNameLabel = new JLabel(menu.getMenuName());
            menuNameLabel.setFont(new Font("", Font.BOLD, 13));

            JLabel priceLabel = new JLabel("가격: " + menu.getPrice() + "원");
            priceLabel.setFont(new Font("굴림체 보통", Font.PLAIN, 11));

            JLabel descriptionLabel = new JLabel("설명: " + menu.getDescription());
            descriptionLabel.setFont(new Font("굴림체 보통", Font.PLAIN, 11));

            // 정보 패널에 추가
            infoPanel.add(menuNameLabel);
            infoPanel.add(priceLabel);
            infoPanel.add(descriptionLabel);

            // 메뉴 아이템 패널에 이미지와 정보 패널 추가
            menuItemPanel.add(menuImageButton);
            menuItemPanel.add(Box.createRigidArea(new Dimension(10, 0)));
            menuItemPanel.add(infoPanel);

            // 메뉴 아이템 패널을 메뉴 패널에 추가
            menuPanel.add(menuItemPanel);
            menuPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        }

        // 메뉴 패널을 스크롤 패널로 감싸기
        JScrollPane scrollPane = new JScrollPane(menuPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(520, 450)); // 스크롤 영역 크기 설정

        // 새로운 JFrame 생성
        JFrame frame = new JFrame("메뉴 목록");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // 프레임 닫기 설정
        frame.add(scrollPane);
        frame.pack(); // 적절한 크기로 조정
        frame.setLocationRelativeTo(null); // 화면 중앙에 위치
        frame.setVisible(true); // 프레임 표시
    }
}
