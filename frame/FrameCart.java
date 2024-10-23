package frame;

import DeliveryVO.Cart;
import DeliveryVO.CartItem;
import DeliveryVO.Restaurant;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class FrameCart extends JPanel {

    public FrameCart(JPanel homePanel) {
        // ���� �г� �ʱ�ȭ
        JPanel cartPanel = new JPanel();
        cartPanel.setLayout(new BoxLayout(cartPanel, BoxLayout.Y_AXIS));

        JLabel cartTitle = new JLabel("��ٱ���");
        cartTitle.setFont(new Font("", Font.BOLD, 20));
        cartTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        cartPanel.add(cartTitle);
        cartPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        // ��ٱ��� �������� ������
        List<CartItem> cartItems = Cart.getInstance().getCartItems();
        long totalPrice = 0;
        long deliveryPrice = 0;
        Restaurant restaurant = null;

        if (cartItems.isEmpty()) {
            JLabel emptyLabel = new JLabel("��ٱ��ϰ� ��� �ֽ��ϴ�.");
            emptyLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            cartPanel.add(emptyLabel);
        } else {
            // ��ٱ��Ͽ� �������� ���� �� ó��
            for (CartItem item : cartItems) {
                JPanel cartItemPanel = new JPanel();
                cartItemPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
                cartItemPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

                // �޴� ���� �� ����
                JLabel itemNameLabel = new JLabel(item.getMenu().getMenuName() + " x " + item.getQuantity());
                cartItemPanel.add(itemNameLabel);

                // ���� ���
                totalPrice += item.getMenu().getPrice() * item.getQuantity();
                cartPanel.add(cartItemPanel);

                // ������� ���� Ȯ�� �� ��޺� ����
                if (restaurant == null) {
                    restaurant = item.getRestaurant();  // CartItem���� Restaurant ��ü ������
                    if (restaurant != null) {
                        deliveryPrice = restaurant.getDeliveryPrice();
                        System.out.println("������� �̸�: " + restaurant.getName());  // ������� �̸� ���
                        System.out.println("��޺�: " + deliveryPrice);  // ��޺� Ȯ���� ���� ���
                    } else {
                        System.out.println("������� ��ü�� null�Դϴ�.");
                    }
                }
            }
        }

        // �� ���� �� ��޺� ǥ��
        long finalPrice = totalPrice + deliveryPrice;
        JLabel totalLabel = new JLabel("�� ���� ����: " + totalPrice + "��");
        JLabel deliveryLabel = new JLabel("��޺�: " + deliveryPrice + "��");
        JLabel finalPriceLabel = new JLabel("���� ���� �ݾ�: " + finalPrice + "��");

        cartPanel.add(totalLabel);
        cartPanel.add(deliveryLabel);
        cartPanel.add(finalPriceLabel);

        // ��ũ�� �߰�
        JScrollPane scrollPane = new JScrollPane(cartPanel);
        add(scrollPane);
    }
}
