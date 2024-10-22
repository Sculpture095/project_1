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
    private JPanel frameKoreanPanel; // Ȩ �г�
    private JPanel listPanel; // ������ ����Ʈ�� ��� �г�
    private JScrollPane scrollPane; // ��ũ�� �г�

    public FrameKorean(JPanel homePanel) {
        this.frameKoreanPanel = homePanel;
        setBackground(new Color(255, 255, 255));
        setLayout(null);
        setSize(500, 800);

        // �ڷΰ��� ��ư
        ImageIcon bbt = new ImageIcon("img/back_icon.png");
        JButton btnBack = new JButton(bbt);
        btnBack.setSize(36, 38);
        btnBack.setLocation(60, 50);
        btnBack.setContentAreaFilled(false);
        btnBack.setBorderPainted(false);
        btnBack.setFocusPainted(false);
        add(btnBack);

        // �ڷΰ��� ��ư �׼�
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrameBase.getDispose();
                FrameBase.getInstance(new FrameCategory(homePanel));
            }
        });

        // ���� ���̺�
        JLabel titleLabel = new JLabel("�ѽ�");
        titleLabel.setFont(new Font("", Font.BOLD, 24));
        titleLabel.setBounds(230, 50, 100, 30);
        add(titleLabel);

        // ������ ����Ʈ �г� ���� (��ũ�� ����)
        listPanel = new JPanel();
        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));

        // ��ũ�� �����ϰ� JScrollPane�� ����Ʈ �г� �߰�
        scrollPane = new JScrollPane(listPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(0, 100, 500, 600);
        add(scrollPane);

        // ������ ����� �ʱ�ȭ�ϰ� �߰��ϴ� �޼ҵ� ȣ��
        loadKoreanRestaurants();
    }

    // ������ ����Ʈ�� ������ �߰� �޼���
    public void addRestaurant(Restaurant restaurant, String imagePath) {
        JPanel restaurantPanel = new JPanel();
        restaurantPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        restaurantPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // ������ �̹��� ��ư �߰�
        JButton imageButton = new JButton(new ImageIcon(new ImageIcon(imagePath).getImage().getScaledInstance(160, 120, Image.SCALE_SMOOTH)));
        imageButton.setPreferredSize(new Dimension(160, 120));
        imageButton.setContentAreaFilled(false);
        imageButton.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

        // �̹��� ��ư Ŭ�� �� �׼� ������ �߰�
        imageButton.addActionListener(e -> {
            Frame1_1.showRestaurantMenu(restaurant);
        });

        // ������ ���� �߰�
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));

        JLabel nameLabel = new JLabel(restaurant.getName());
        nameLabel.setFont(new Font("", Font.BOLD, 18));

        JLabel ratingLabel = new JLabel("��� ����: " + restaurant.getRestaurantScore());
        ratingLabel.setFont(new Font("����ü ����", Font.PLAIN, 16));

        JLabel deliveryFeeLabel = new JLabel("��޺�: " + restaurant.getDeliveryPrice() + " ��");
        deliveryFeeLabel.setFont(new Font("����ü ����", Font.PLAIN, 16));

        // ���� �гο� �߰�
        infoPanel.add(nameLabel);
        infoPanel.add(ratingLabel);
        infoPanel.add(deliveryFeeLabel);

        // �гο� �߰�
        restaurantPanel.add(imageButton);
        restaurantPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        restaurantPanel.add(infoPanel);

        // ������ �г��� ����Ʈ �гο� �߰�
        listPanel.add(restaurantPanel);
        listPanel.revalidate();
        listPanel.repaint();
    }

    // �ѽ� �������� �ε��ϰ� ����Ʈ�� �߰��ϴ� �޼ҵ�
    public void loadKoreanRestaurants() {
        for (Restaurant restaurant : RestaurantDAO.getKoreanRestaurants()) {
            addRestaurant(restaurant, "img/restaurant_image.png");  // �� �������� �̹��� ��θ� ����
        }
    }
}
