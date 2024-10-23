package frame;

import DeliveryVO.Cart;
import DeliveryVO.Review;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameReview extends JPanel {
    
    private JPanel frameCartPanel;  // Ȩ �г�
    private JPanel listPanel;       // ������ ����Ʈ�� ��� �г�
    private JScrollPane scrollPane; // ��ũ�� �г�
    private JLabel orderAmountLabel; // �ֹ� �ݾ� ���̺�
    private JLabel deliveryFeeLabel; // ��޺� ���̺�
    private JLabel totalLabel;      // ���� ���̺�
    private int totalAmount = 0;    // ���� ����
    private int deliveryFee = 3000; // ��޺�
    private Image backgroundImage; // ��� �̹����� ������ ����
    private ImageIcon headerImage; // ��� �̹���


   
    public FrameReview(JPanel homePanel,String name) {
        this.frameCartPanel = homePanel;
        setBackground(new Color(255, 255, 255));
        setLayout(null);
        setSize(500, 800);


        // ��� ����
        JLabel titleLabel = new JLabel(name + "�� ���� ����");
        titleLabel.setFont(new Font("", Font.BOLD, 24));
        titleLabel.setBounds(180, 50, 200, 30);
        add(titleLabel);

        // ���並 �ҷ�����
        Review review = new Review();
        String reviews = review.readReviews();

        // ���� ����� ǥ���ϴ� JTextArea
        JTextArea reviewArea = new JTextArea(reviews);
        reviewArea.setBounds(50, 100, 400, 600);
        reviewArea.setEditable(false);
        add(reviewArea);


        // ��� �̹��� �ε�
        headerImage = new ImageIcon("img/cart_page.png"); // �̹��� ��� ����
        JLabel headerLabel = new JLabel(headerImage);
        headerLabel.setBounds(195, 50, 106, 28); // �̹��� ��ġ�� ũ�� ����
        add(headerLabel);
     // �ڷΰ��� ��ư
     		ImageIcon bbt = new ImageIcon("img/back_icon.png");
     		JButton btnBack= new JButton(bbt);
     		btnBack.setSize(36, 38);
     		btnBack.setLocation(60, 48);
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
    		FrameBase.getInstance(new FrameCategory(homePanel,name,""));
    	}
    });

        
    
        
      

        // ������ ����Ʈ �г� ���� (��ũ�� ����)
        listPanel = new JPanel();
        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));  // ���η� ������ ����

        // ��ũ�� �����ϰ� JScrollPane�� ����Ʈ �г� �߰�
        scrollPane = new JScrollPane(listPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(0, 120, 520, 450);  // ��ũ�� ���� ��ġ�� ũ�� ����
        add(scrollPane);

        // �ֹ� �ݾ� ���̺� �߰�
        orderAmountLabel = new JLabel("�ֹ� �ݾ�: " + totalAmount + " ��");
        orderAmountLabel.setBounds(50, 580, 200, 30);
        add(orderAmountLabel);

        // ��޺� ���̺� �߰�
        deliveryFeeLabel = new JLabel("��޺�: " + deliveryFee + " ��");
        deliveryFeeLabel.setBounds(50, 610, 200, 30);
        add(deliveryFeeLabel);

        // ���� ���̺� �߰�
        totalLabel = new JLabel("����: " + (totalAmount + deliveryFee) + " ��");
        totalLabel.setBounds(50, 640, 200, 30);
        add(totalLabel);

        // ���� ������ 3�� �߰� (���� �߰�)
        addRestaurant("������ 1", "img/category_chicken.png", "���ִ� ������ 1 ����", 10000);
        addRestaurant("������ 2", "img/category_coffee.png", "���ִ� ������ 2 ����", 15000);
        addRestaurant("������ 3", "img/category_jajangmyeon.png", "���ִ� ������ 3 ����", 20000);

        // �����ϱ� ��ư
        ImageIcon paybt = new ImageIcon("img/payment_btn.png");
        JButton btnPay = new JButton(paybt);
        btnPay.setSize(300, 70);
        btnPay.setLocation(100, 680);
        btnPay.setContentAreaFilled(false);
        btnPay.setBorderPainted(false);
        btnPay.setFocusPainted(false);
        add(btnPay);

        // �����ϱ� ��ư Ŭ�� �� �հ� ���
        btnPay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cart.getInstance().completePayment();
                JOptionPane.showMessageDialog(null, "���� �ݾ�: " + (totalAmount + deliveryFee) + " ��");
                // ���� ���� �߰� ����
            }
        });

        // �ϴ��� �޴� ��ư�� (��, �ֹ���Ȳ, ī�װ�, ��ٱ���, ����������)
        setupBottomMenu(homePanel);
    }

 // ������ ����Ʈ�� ������ �߰� �޼���
    public void addRestaurant(String name, String imagePath, String description, int price) {
        // ���� ������ �г�
        JPanel restaurantPanel = new JPanel();
        restaurantPanel.setLayout(new BorderLayout());
        restaurantPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // ������ �̹��� �߰� (ImageIcon)
        ImageIcon imageIcon = new ImageIcon(imagePath);
        Image img = imageIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);  // �̹��� ũ�� ����
        JLabel imageLabel = new JLabel(new ImageIcon(img));
        
        // �̹����� ���� ������ ���� �г� �߰�
        JPanel imagePanel = new JPanel();
        imagePanel.add(imageLabel);
        imagePanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10)); // ������ ���� �߰�

        restaurantPanel.add(imagePanel, BorderLayout.WEST);

        // ������ ���� �г� (�̸�, ����, ����)
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        infoPanel.setPreferredSize(new Dimension(105, 60)); // ũ�� ����
        JLabel nameLabel = new JLabel(name);
        JLabel descLabel = new JLabel("<html><p style='width: 200px;'>" + description + "</p></html>");  // ���� ���� ����
        JLabel priceLabel = new JLabel("����: " + price + " ��");
        
        // �� ���̺� ���̿� ���� �߰�
        nameLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0)); // �Ʒ��� ���� �߰�
        descLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0)); // �Ʒ��� ���� �߰�

        infoPanel.add(nameLabel);
        infoPanel.add(descLabel);
        infoPanel.add(priceLabel);
        restaurantPanel.add(infoPanel, BorderLayout.CENTER);

        // ������ ��ư �г� (���� ����, ����)
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 1, 0, 0)); // 2�� 1���� ����

        // ù ��° ��: ���̳ʽ�, ���� ���̺�, �÷��� ��ư
        JPanel quantityPanel = new JPanel();
        quantityPanel.setLayout(new FlowLayout()); // ���� ���� ��ư���� ���η� ��ġ

        JButton minusButton = new JButton("-");
        minusButton.setPreferredSize(new Dimension(60, 30)); // ��ư ũ�� ����
        minusButton.setContentAreaFilled(false);
        minusButton.setBorderPainted(false);
        minusButton.setFocusPainted(false);

        JLabel quantityLabel = new JLabel("1");

        JButton plusButton = new JButton("+");
        plusButton.setPreferredSize(new Dimension(60, 30)); // ��ư ũ�� ����
        plusButton.setContentAreaFilled(false);
        plusButton.setBorderPainted(false);
        plusButton.setFocusPainted(false);
        
        quantityPanel.add(minusButton);
        quantityPanel.add(quantityLabel);
        quantityPanel.add(plusButton);
      
        restaurantPanel.add(buttonPanel, BorderLayout.EAST);

        // ���� ����
        plusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int currentQuantity = Integer.parseInt(quantityLabel.getText());
                currentQuantity++;
                quantityLabel.setText(String.valueOf(currentQuantity));
                updateTotal(price); // ���� �߰�
            }
        });

        // ���� ����
        minusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int currentQuantity = Integer.parseInt(quantityLabel.getText());
                if (currentQuantity > 1) {
                    currentQuantity--;
                    quantityLabel.setText(String.valueOf(currentQuantity));
                    updateTotal(-price); // ���� ����
                }
            }
        });

        // ���� ��ư
        JButton deleteButton = new JButton("����");
        deleteButton.setPreferredSize(new Dimension(70, 30)); // ���� ��ư ũ�� ����
        deleteButton.setContentAreaFilled(false);
        deleteButton.setBorderPainted(false);
        deleteButton.setFocusPainted(false);
        
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int currentQuantity = Integer.parseInt(quantityLabel.getText());
                updateTotal(-price * currentQuantity); // ���� �� ���տ��� ������ ����
                listPanel.remove(restaurantPanel);  // �гο��� ����
                listPanel.revalidate();
                listPanel.repaint();
            }
        });

        // ��ư���� ���� �гο� �߰�
        buttonPanel.add(quantityPanel); // ù ��° ��
        buttonPanel.add(deleteButton); // �� ��° ��

        restaurantPanel.add(buttonPanel, BorderLayout.EAST);

        // ������ �г��� ����Ʈ �гο� �߰�
        listPanel.add(restaurantPanel);
        updateTotal(price); // ó�� �߰��Ǵ� ������ ������ ���տ� ����
        listPanel.revalidate();
        listPanel.repaint();
    }


    // ���� ������Ʈ �޼���
    private void updateTotal(int amount) {
        totalAmount += amount;
        orderAmountLabel.setText("�ֹ� �ݾ�: " + totalAmount + " ��");
        totalLabel.setText("����: " + (totalAmount + deliveryFee) + " ��");
    }

    // �ϴ� �޴� ��ư ���� (��, �ֹ���Ȳ, ī�װ�, ��ٱ���, ����������)
    private void setupBottomMenu(JPanel homePanel) {
        // �� ��ư
        ImageIcon ggimbt = new ImageIcon("img/heart_icon.png");
        JButton btnGgim = new JButton(ggimbt);
        btnGgim.setSize(39, 38);
        btnGgim.setLocation(32, 685);
        btnGgim.setContentAreaFilled(false);
        btnGgim.setBorderPainted(false);
        btnGgim.setFocusPainted(false);
        add(btnGgim);

        // �ֹ���Ȳ ��ư
        ImageIcon orderbt = new ImageIcon("img/order_icon.png");
        JButton btnOrder = new JButton(orderbt);
        btnOrder.setSize(38, 38);
        btnOrder.setLocation(125, 685);
        btnOrder.setContentAreaFilled(false);
        btnOrder.setBorderPainted(false);
        btnOrder.setFocusPainted(false);
        add(btnOrder);

        // ī�װ� ��ư
        ImageIcon categorybt = new ImageIcon("img/home_icon.png");
        JButton btnCategory = new JButton(categorybt);
        btnCategory.setSize(47, 39);
        btnCategory.setLocation(225, 685);
        btnCategory.setContentAreaFilled(false);
        btnCategory.setBorderPainted(false);
        btnCategory.setFocusPainted(false);
        add(btnCategory);

        // ��ٱ��� ��ư
        ImageIcon cartbt = new ImageIcon("img/cart_icon.png");
        JButton btnCart = new JButton(cartbt);
        btnCart.setSize(44, 38);
        btnCart.setLocation(325, 685);
        btnCart.setContentAreaFilled(false);
        btnCart.setBorderPainted(false);
        btnCart.setFocusPainted(false);
        add(btnCart);

        // ���������� ��ư
        ImageIcon mypagebt = new ImageIcon("img/user_icon.png");
        JButton btnMypage = new JButton(mypagebt);
        btnMypage.setSize(36, 42);
        btnMypage.setLocation(425, 685);
        btnMypage.setContentAreaFilled(false);
        btnMypage.setBorderPainted(false);
        btnMypage.setFocusPainted(false);
        add(btnMypage);
    }
}
