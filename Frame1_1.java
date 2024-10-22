package frame;

import DeliveryVO.Menu;
import DeliveryVO.Restaurant;
import javax.swing.*;
import java.awt.*;

public class Frame1_1 extends JPanel {
    
    public static void showRestaurantMenu(Restaurant restaurant) {
        // �޴� �г� ����
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));

        JLabel restaurantNameLabel = new JLabel("�޴� ��� - " + restaurant.getName());
        restaurantNameLabel.setFont(new Font("", Font.BOLD, 15));
        restaurantNameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        menuPanel.add(restaurantNameLabel);
        menuPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        // ��������� �޴��� ǥ��
        for (Menu menu : restaurant.getMenuList()) {
            JPanel menuItemPanel = new JPanel();
            menuItemPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
            menuItemPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            // �޴� �̹��� �߰�
            String imagePath = "img/menu_image.png"; // �޴� �̹��� ���
            JButton menuImageButton = new JButton(new ImageIcon(new ImageIcon(imagePath).getImage().getScaledInstance(160, 120, Image.SCALE_SMOOTH)));
            menuImageButton.setPreferredSize(new Dimension(125, 95));
            menuImageButton.setContentAreaFilled(false);
            menuImageButton.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

            // �޴� ���� �г� �߰�
            JPanel infoPanel = new JPanel();
            infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));

            JLabel menuNameLabel = new JLabel(menu.getMenuName());
            menuNameLabel.setFont(new Font("", Font.BOLD, 13));

            JLabel priceLabel = new JLabel("����: " + menu.getPrice() + "��");
            priceLabel.setFont(new Font("����ü ����", Font.PLAIN, 11));

            JLabel descriptionLabel = new JLabel("����: " + menu.getDescription());
            descriptionLabel.setFont(new Font("����ü ����", Font.PLAIN, 11));

            // ���� �гο� �߰�
            infoPanel.add(menuNameLabel);
            infoPanel.add(priceLabel);
            infoPanel.add(descriptionLabel);

            // �޴� ������ �гο� �̹����� ���� �г� �߰�
            menuItemPanel.add(menuImageButton);
            menuItemPanel.add(Box.createRigidArea(new Dimension(10, 0)));
            menuItemPanel.add(infoPanel);

            // �޴� ������ �г��� �޴� �гο� �߰�
            menuPanel.add(menuItemPanel);
            menuPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        }

        // �޴� �г��� ��ũ�� �гη� ���α�
        JScrollPane scrollPane = new JScrollPane(menuPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(520, 450)); // ��ũ�� ���� ũ�� ����

        // ���ο� JFrame ����
        JFrame frame = new JFrame("�޴� ���");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // ������ �ݱ� ����
        frame.add(scrollPane);
        frame.pack(); // ������ ũ��� ����
        frame.setLocationRelativeTo(null); // ȭ�� �߾ӿ� ��ġ
        frame.setVisible(true); // ������ ǥ��
    }
}
