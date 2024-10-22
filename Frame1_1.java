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
    private JPanel frameKoreanPanel; // Ȩ �г�
    private JPanel listPanel; // ������ ����Ʈ�� ��� �г�
    private JScrollPane scrollPane; // ��ũ�� �г�
    

    public Frame1_1(JPanel homePanel) {
        this.frameKoreanPanel = homePanel;
        setBackground(new Color(255, 255, 255));
        setLayout(null);
        setSize(500, 800);
        
      
        // �ڷΰ��� ��ư
     		ImageIcon bbt = new ImageIcon("img/back_icon.png");
     		JButton btnBack= new JButton(bbt);
     		btnBack.setSize(36, 38);
     		btnBack.setLocation(60, 50);
     		btnBack.setContentAreaFilled(false);
      		btnBack.setBorderPainted(false);
      		btnBack.setFocusPainted(false);
      		
      		add(btnBack);
      		
      	// �ڷΰ��� ��ư
    		btnBack.addActionListener(new ActionListener() {

    		@Override
    		public void actionPerformed(ActionEvent e) {
    		// ����� �̵���
    		FrameBase.getDispose();
    		FrameBase.getInstance(new FrameCategory(homePanel));
    	}
    });
    		// ���亸�� ��ư
    		ImageIcon lgbt = new ImageIcon("img/store_review_btn.png");
    		JButton btnLogin = new JButton(lgbt);
    		btnLogin.setSize(117, 35);
    		btnLogin.setLocation(200, 280);

    		btnLogin.setContentAreaFilled(false);
    		btnLogin.setBorderPainted(false);
    		btnLogin.setFocusPainted(false);

    		add(btnLogin);

    		// ���亸�� ��ư ������ ������������ �̵�
    		btnLogin.addActionListener(new ActionListener() {

    			@Override
    			public void actionPerformed(ActionEvent e) {
    				// ����� �̵���
    				FrameBase.getDispose();
    				
    			}
    				});

        // ���� ���̺�
        JLabel titleLabel = new JLabel("�ִ밨��");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setBounds(230, 50, 100, 30); // ���� ��ġ ����
        add(titleLabel);

        // ������ ����Ʈ �г� ���� (��ũ�� ����)
        listPanel = new JPanel();
        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS)); // ���η� ������ ����

        // ��ũ�� �����ϰ� JScrollPane�� ����Ʈ �г� �߰�
        scrollPane = new JScrollPane(listPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(0, 400, 500, 380); // ��ũ�� ���� ��ġ�� ũ�� ����
        add(scrollPane);
        
        // ���� ������ 3�� �߰�
        
        addRestaurant("�ִ밨��", "img/restaurant_image.jpg", 3.0, "���ְ� �پ��� �ѽ� �޴��� �����մϴ�.", 5000, "��޽ð�: 30��", new FrameCategory(homePanel));
        addRestaurant("�ѽĴ�", "img/restaurant_image.jpg", 4.5, "�ż��� ���� �������� ���� �丮", 3000, "��޽ð�: 20��", new FrameCategory(homePanel));
        addRestaurant("��ġ������", "img/restaurant_image.jpg", 4.0, "���� ��ġ �丮�� �����մϴ�.", 4000, "��޽ð�: 25��", new FrameCategory(homePanel));
    }

    // ������ ����Ʈ�� ������ �߰� �޼���
    public void addRestaurant(String name, String imagePath, double rating, String description, int deliveryFee, String deliveryTime, JPanel nextFrame) {
        // ���� ������ �г�
        JPanel restaurantPanel = new JPanel();
        restaurantPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        restaurantPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // ������ �̹��� ��ư �߰�
        JButton imageButton = new JButton(new ImageIcon(new ImageIcon(imagePath).getImage().getScaledInstance(160, 120, Image.SCALE_SMOOTH)));
        imageButton.setPreferredSize(new Dimension(160, 120));
        imageButton.setContentAreaFilled(false); // ��ư ��� �����ϰ�
        imageButton.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY)); // ��ư �׵θ� �߰�

        // �̹��� ��ư Ŭ�� �� �׼� ������ �߰�
        imageButton.addActionListener(e -> {
            FrameBase.getDispose(); // ���� ������ �ݱ�
            FrameBase.getInstance(nextFrame); // ���ο� ���������� ��ȯ
        });

        // ������ ���� �߰�
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS)); // ���η� ����

        JLabel nameLabel = new JLabel(name);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 18)); // ������ �̸� ���� ũ�� ����

        // ��� ���� ǥ��
        StringBuilder stars = new StringBuilder("��� ����: ");
        for (int i = 0; i < (int) rating; i++) {
            stars.append("��");
        }
        for (int i = 0; i < 5 - (int) rating; i++) {
            stars.append("��");
        }
        JLabel ratingLabel = new JLabel(stars.toString());
        ratingLabel.setFont(new Font("Arial", Font.PLAIN, 16)); // ���� ���� ũ�� ����

        JLabel descriptionLabel = new JLabel("<html>" + description + "</html>");
        descriptionLabel.setFont(new Font("Arial", Font.PLAIN, 16)); // ���� ���� ũ�� ����

        JLabel deliveryFeeLabel = new JLabel("��޺�: " + deliveryFee + " ��");
        deliveryFeeLabel.setFont(new Font("Arial", Font.PLAIN, 16)); // ��޺� ���� ũ�� ����

        JLabel deliveryTimeLabel = new JLabel(deliveryTime);
        deliveryTimeLabel.setFont(new Font("Arial", Font.PLAIN, 16)); // ��޽ð� ���� ũ�� ����

        // ���� �гο� �߰�
        infoPanel.add(nameLabel);
        infoPanel.add(ratingLabel);
        infoPanel.add(descriptionLabel);
        infoPanel.add(deliveryFeeLabel);
        infoPanel.add(deliveryTimeLabel);

        // �гο� �߰�
        restaurantPanel.add(imageButton);
        restaurantPanel.add(Box.createRigidArea(new Dimension(10, 0))); // �̹����� �ؽ�Ʈ ���� ����
        restaurantPanel.add(infoPanel); // ���� �г� �߰�

        // ������ �г��� ����Ʈ �гο� �߰�
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
