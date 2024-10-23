package frame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import DeliveryVO.Cart;
import DeliveryVO.CartItem;
import DeliveryVO.Restaurant;

public class FrameCart extends JPanel {

    private JPanel frameCartPanel;  // Ȩ �г�
    private JPanel listPanel;       // ������ ����Ʈ�� ��� �г�
    private JScrollPane scrollPane; // ��ũ�� �г�
    private JLabel orderAmountLabel; // �ֹ� �ݾ� ���̺�
    private JLabel deliveryFeeLabel; // ��޺� ���̺�
    private JLabel totalLabel;      // ���� ���̺�
    private long totalAmount = 0;    // ���� ����
    private long deliveryPrice = 0;  // ��޺� ����
    private Restaurant restaurant;   // ������� ��ü
    private ImageIcon headerImage;  // ��� �̹���

    public FrameCart(JPanel homePanel, String name, String address) {
        this.frameCartPanel = homePanel;
        setBackground(new Color(255, 255, 255));
        setLayout(null);
        setSize(500, 800);

        // ��� �̹��� �ε�
        headerImage = new ImageIcon("img/cart_page.png"); // �̹��� ��� ����
        JLabel headerLabel = new JLabel(headerImage);
        headerLabel.setBounds(195, 50, 106, 28); // �̹��� ��ġ�� ũ�� ����
        add(headerLabel);

        // �ڷΰ��� ��ư
        ImageIcon bbt = new ImageIcon("img/back_icon.png");
        JButton btnBack = new JButton(bbt);
        btnBack.setSize(36, 38);
        btnBack.setLocation(60, 48);
        btnBack.setContentAreaFilled(false);
        btnBack.setBorderPainted(false);
        btnBack.setFocusPainted(false);
        add(btnBack);

        // �ڷΰ��� ��ư �׼�
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrameBase.getDispose();
                FrameBase.getInstance(new FrameCategory(homePanel, name, address));
            }
        });

        // ������ ����Ʈ �г� ���� (��ũ�� ����)
        listPanel = new JPanel();
        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));  // ���η� ������ ����

        // ��ũ�� �����ϰ� JScrollPane�� ����Ʈ �г� �߰�
        scrollPane = new JScrollPane(listPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(0, 120, 500, 450);  // ��ũ�� ���� ��ġ�� ũ�� ����
        add(scrollPane);

        // ��ٱ��� ������ �ε�
        loadCartItems();

        // �ֹ� �ݾ� ���̺� �߰�
        orderAmountLabel = new JLabel("�ֹ� �ݾ�: " + totalAmount + " ��");
        orderAmountLabel.setBounds(50, 580, 200, 30);
        add(orderAmountLabel);

        // ��޺� ���̺� �߰�
        deliveryFeeLabel = new JLabel("��޺�: " + deliveryPrice + " ��");
        deliveryFeeLabel.setBounds(50, 610, 200, 30);
        add(deliveryFeeLabel);

        // ���� ���̺� �߰�
        totalLabel = new JLabel("����: " + (totalAmount + deliveryPrice) + " ��");
        totalLabel.setBounds(50, 640, 200, 30);
        add(totalLabel);

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
                JOptionPane.showMessageDialog(null, "���� �ݾ�: " + (totalAmount + deliveryPrice) + " ��");
                FrameBase.getDispose();
                FrameBase.getInstance(new FrameCategory(homePanel,name,address));
                // ���� ���� �߰� ����
            }
        });
    }

    // ��ٱ��� �������� �ε��ϰ� ����Ʈ�� �߰��ϴ� �޼ҵ�
    private void loadCartItems() {
        java.util.List<CartItem> cartItems = Cart.getInstance().getCartItems();

        if (cartItems.isEmpty()) {
            JLabel emptyLabel = new JLabel("��ٱ��ϰ� ��� �ֽ��ϴ�.");
            emptyLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            listPanel.add(emptyLabel);
        } else {
            // ù ��° �����ۿ��� ������� ������ ������ ��޺� ����
            for (CartItem item : cartItems) {
                if (restaurant == null) {
                    restaurant = item.getRestaurant();  // CartItem���� Restaurant ��ü ������
                    if (restaurant != null) {
                        deliveryPrice = restaurant.getDeliveryPrice();  // Restaurant���� ��޺� ��������
                        System.out.println("������� �̸�: " + restaurant.getName());  // Ȯ�ο� ���
                        System.out.println("��޺�: " + deliveryPrice);  // ��޺� Ȯ�ο� ���
                    }
                }
                addRestaurant(item);  // �������� ����Ʈ�� �߰�
            }
        }
        listPanel.revalidate();
        listPanel.repaint();
    }

    // ������ ����Ʈ�� ������ �߰� �޼���
    public void addRestaurant(CartItem item) {
        String itemName = item.getMenu().getMenuName();
        int[] quantity = {item.getQuantity()}; // ������ �迭�� ���μ� ���� �����ϵ���

        long price = item.getMenu().getPrice();

        JPanel cartItemPanel = new JPanel();
        cartItemPanel.setLayout(null);  // ���̾ƿ��� null�� �����Ͽ� ���� ��ġ ����
        cartItemPanel.setPreferredSize(new Dimension(500, 130)); // �г��� ũ�⸦ ����

        // ���� �̹��� �߰�
        ImageIcon foodImage = new ImageIcon("img/f_1_1_1.png"); // ���� �̹��� ��� ����
        JLabel foodImageLabel = new JLabel(new ImageIcon(foodImage.getImage().getScaledInstance(125, 95, Image.SCALE_SMOOTH)));
        foodImageLabel.setBounds(20, 10, 125, 95);  // �̹��� ��ġ�� ũ�� ����
        cartItemPanel.add(foodImageLabel);

        // �޴� ���� �� ���� ���̺�
        JLabel itemNameLabel = new JLabel(itemName);
        itemNameLabel.setBounds(190, 10, 200, 30);  // ���� �̸� ��ġ ����
        cartItemPanel.add(itemNameLabel);

        JLabel priceLabel = new JLabel("����: " + (price * quantity[0]) + " ��");
        priceLabel.setBounds(220, 40, 200, 30);  // ���� ���̺� ��ġ ����
        cartItemPanel.add(priceLabel);

        // ���� ���� ��ư �� ���̺�
        JButton minusButton = new JButton("-");
        minusButton.setBounds(350, 70, 45, 30);  // ���� ���� ��ư ��ġ ����
        cartItemPanel.add(minusButton);

        JLabel quantityLabel = new JLabel(String.valueOf(quantity[0]));
        quantityLabel.setBounds(330, 70, 30, 30);  // ���� ���̺� ��ġ ����
        cartItemPanel.add(quantityLabel);

        JButton plusButton = new JButton("+");
        plusButton.setBounds(280, 70, 45, 30);  // ���� ���� ��ư ��ġ ����
        cartItemPanel.add(plusButton);

        // ���� ��ư
        JButton deleteButton = new JButton("����");
        deleteButton.setBounds(335, 50, 60, 30);  // ���� ��ư ��ġ ����
        cartItemPanel.add(deleteButton);

        // ���� ���� ��ư �׼�
        plusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                quantity[0]++;
                quantityLabel.setText(String.valueOf(quantity[0]));
                totalAmount += price; // ���� ����
                updateTotalLabels();
            }
        });

        // ���� ���� ��ư �׼�
        minusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (quantity[0] > 1) {
                    quantity[0]--;
                    quantityLabel.setText(String.valueOf(quantity[0]));
                    totalAmount -= price; // ���� ����
                    updateTotalLabels();
                }
            }
        });

        // ���� ��ư �׼�
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listPanel.remove(cartItemPanel); // �гο��� ����
                totalAmount -= price * quantity[0]; // ���� ����
                updateTotalLabels();
                listPanel.revalidate();
                listPanel.repaint();
            }
        });

        // �гο� �߰�
        listPanel.add(cartItemPanel);
        totalAmount += price * quantity[0]; // ���� ���
    }

    // ���� ���̺� ������Ʈ �޼���
    public void updateTotalLabels() {
        orderAmountLabel.setText("�ֹ� �ݾ�: " + totalAmount + " ��");
        totalLabel.setText("����: " + (totalAmount + deliveryPrice) + " ��");
    }
}
