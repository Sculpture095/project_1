package frame;

import DeliveryVO.Ggim;
import DeliveryVO.Restaurant;
import java.awt.*;
import java.util.List;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameGgim extends JPanel {

    private JPanel listPanel;
    private Ggim ggimList;

    public FrameGgim(JPanel homePanel, String name, String address) {
        this.ggimList = Ggim.getInstance();
        setBackground(new Color(255, 255, 255));
        setLayout(null);
        setSize(500, 800);

        listPanel = new JPanel();
        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));  // Y������ ����
        listPanel.setPreferredSize(new Dimension(480, 1000));

        JScrollPane scrollPane = new JScrollPane(listPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(0, 120, 500, 600);  // ��ũ�� ũ�� ����
        add(scrollPane);

        // �ڷΰ��� ��ư �߰�
        ImageIcon bbt = new ImageIcon("img/back_icon.png");
        JButton btnBack = new JButton(bbt);
        btnBack.setSize(36, 38);
        btnBack.setLocation(60, 48);
        btnBack.setContentAreaFilled(false);
        btnBack.setBorderPainted(false);
        btnBack.setFocusPainted(false);
        add(btnBack);

        // �ڷΰ��� ��ư Ŭ�� �� ���� ȭ������ �̵�
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrameBase.getDispose();
                FrameBase.getInstance(new FrameCategory(homePanel, name, address));
            }
        });

        displayGgimList();  // �� ����� ȭ�鿡 ǥ��
    }

    public void displayGgimList() {
        listPanel.removeAll();  // ���� ��� �ʱ�ȭ
        List<Restaurant> ggimRestaurants = ggimList.getGgimList();

        for (Restaurant restaurant : ggimRestaurants) {
            // ������ �г��� �߰��ϴ� �޼��� ȣ�� (FrameKorean ��Ÿ�� ����)
            addRestaurant(restaurant.getName(), restaurant.getImagePath(), restaurant.getDescription());
        }

        listPanel.revalidate();
        listPanel.repaint();
    }

    public void addRestaurant(String name, String imagePath, String description) {


        // ���� ������ �г� (FrameKorean ��Ÿ�� ����)
        JPanel restaurantPanel = new JPanel();
        restaurantPanel.setLayout(null);  // null ���̾ƿ� ���
        restaurantPanel.setBounds(10, 0, 460, 140);  // �г� ũ�� �� ��ġ ����
        restaurantPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));

        // �̹��� �ε� �� �󺧿� �߰�
        ImageIcon imageIcon = new ImageIcon(imagePath);
        Image img = imageIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        JLabel imageLabel = new JLabel(new ImageIcon(img));
        imageLabel.setBounds(10, 10, 100, 100);  // �̹��� ��ġ �� ũ�� ����
        restaurantPanel.add(imageLabel);

        // ������ ���� �г�
        JLabel nameLabel = new JLabel("�̸�: " + name);
        nameLabel.setBounds(120, 10, 200, 30);  // �̸� �� ��ġ �� ũ��
        restaurantPanel.add(nameLabel);

        JLabel descriptionLabel = new JLabel("����: " + description);
        descriptionLabel.setBounds(120, 50, 300, 30);  // ���� �� ��ġ �� ũ��
        restaurantPanel.add(descriptionLabel);

        listPanel.add(restaurantPanel);  // ������ �г��� ����Ʈ �гο� �߰�
    }
}
