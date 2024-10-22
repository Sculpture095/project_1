package frame.foodcategory;

import java.awt.*;
import javax.swing.*;

public class FrameKorean extends JPanel {
    private JPanel frameKoreanPanel; // Ȩ �г�
    private JPanel listPanel; // ������ ����Ʈ�� ��� �г�
    private JScrollPane scrollPane; // ��ũ�� �г�

    public FrameKorean(JPanel homePanel) {
        this.frameKoreanPanel = homePanel;
        setBackground(new Color(255, 255, 255));
        setLayout(null);
        setSize(500, 800);

        // ���� ���̺�
        JLabel titleLabel = new JLabel("�ѽ�");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setBounds(200, 50, 100, 30); // ���� ��ġ ����
        add(titleLabel);

        // ������ ����Ʈ �г� ���� (��ũ�� ����)
        listPanel = new JPanel();
        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS)); // ���η� ������ ����

        // ��ũ�� �����ϰ� JScrollPane�� ����Ʈ �г� �߰�
        scrollPane = new JScrollPane(listPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(0, 100, 500, 600); // ��ũ�� ���� ��ġ�� ũ�� ����
        add(scrollPane);

        // ���� ������ 3�� �߰�
        addRestaurant("�ִ밨��", "img/restaurant_image.jpg", 3.0, "��ǥ�޴�: ��ġ��", 5000, "��޽ð�: 30��");
        addRestaurant("�ѽĴ�", "img/restaurant_image.jpg", 4.5, "��ǥ�޴�: �����", 3000, "��޽ð�: 20��");
        addRestaurant("��ġ������", "img/restaurant_image.jpg", 4.0, "��ǥ�޴�: ��ġ��", 4000, "��޽ð�: 25��");
    }

    // ������ ����Ʈ�� ������ �߰� �޼���
    public void addRestaurant(String name, String imagePath, double rating, String menu, int deliveryFee, String deliveryTime) {
        // ���� ������ �г�
        JPanel restaurantPanel = new JPanel();
        restaurantPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        restaurantPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // ������ �̹��� ��ư �߰�
        JButton imageButton = new JButton(new ImageIcon(new ImageIcon(imagePath).getImage().getScaledInstance(160, 120, Image.SCALE_SMOOTH)));
        imageButton.setPreferredSize(new Dimension(160, 120));
        imageButton.setContentAreaFilled(false); // ��ư ��� �����ϰ�
        imageButton.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY)); // ��ư �׵θ� �߰�

        // ������ ���� �߰�
        JLabel nameLabel = new JLabel(name);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 18)); // ������ �̸� ���� ũ�� ����

        JLabel ratingLabel = new JLabel("��� ����: ��".repeat((int) rating) + "��".repeat(5 - (int) rating));
        ratingLabel.setFont(new Font("Arial", Font.PLAIN, 16)); // ���� ���� ũ�� ����

        JLabel menuLabel = new JLabel(menu);
        menuLabel.setFont(new Font("Arial", Font.PLAIN, 16)); // �޴� ���� ũ�� ����

        JLabel deliveryFeeLabel = new JLabel("��޺�: " + deliveryFee + " ��");
        deliveryFeeLabel.setFont(new Font("Arial", Font.PLAIN, 16)); // ��޺� ���� ũ�� ����

        JLabel deliveryTimeLabel = new JLabel(deliveryTime);
        deliveryTimeLabel.setFont(new Font("Arial", Font.PLAIN, 16)); // ��޽ð� ���� ũ�� ����

        // �гο� �߰�
        restaurantPanel.add(imageButton);
        restaurantPanel.add(Box.createRigidArea(new Dimension(10, 0))); // �̹����� �ؽ�Ʈ ���� ����
        restaurantPanel.add(nameLabel);
        restaurantPanel.add(ratingLabel);
        restaurantPanel.add(menuLabel);
        restaurantPanel.add(deliveryFeeLabel);
        restaurantPanel.add(deliveryTimeLabel);

        // ������ �г��� ����Ʈ �гο� �߰�
        listPanel.add(restaurantPanel);
        listPanel.revalidate();
        listPanel.repaint();
    }
}
