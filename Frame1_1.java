package frame;

import DeliveryVO.Menu;
import DeliveryVO.Restaurant;
import javax.swing.*;
import java.awt.*;

public class Frame1_1 extends JPanel {

    public static void showRestaurantMenu(Restaurant restaurant) {
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));

        JLabel restaurantNameLabel = new JLabel("메뉴 목록 - " + restaurant.getName());
        restaurantNameLabel.setFont(new Font("", Font.BOLD, 20));
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
            menuImageButton.setPreferredSize(new Dimension(160, 120));
            menuImageButton.setContentAreaFilled(false);
            menuImageButton.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

            // 메뉴 정보 패널 추가
            JPanel infoPanel = new JPanel();
            infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));

            JLabel menuNameLabel = new JLabel(menu.getMenuName());
            menuNameLabel.setFont(new Font("", Font.BOLD, 18));

            JLabel priceLabel = new JLabel("가격: " + menu.getPrice() + "원");
            priceLabel.setFont(new Font("굴림체 보통", Font.PLAIN, 16));

            JLabel descriptionLabel = new JLabel("설명: " + menu.getDescription());
            descriptionLabel.setFont(new Font("굴림체 보통", Font.PLAIN, 16));

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

        // 메뉴 패널을 새로운 프레임으로 표시
        FrameBase.getDispose();  // 현재 프레임 닫기
        FrameBase.getInstance(menuPanel);  // 메뉴를 표시하는 패널로 전환
    }
}
