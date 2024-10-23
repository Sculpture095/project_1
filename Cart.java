package DeliveryVO;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    // �̱��� �ν��Ͻ�
    private static Cart instance;
    // ��ٱ��� Ŭ����
    private List<CartItem> cartItems;
    private boolean paymentCompleted = false; //���� �Ϸ� ���θ� �����ϴ� �ʵ�



    public Cart() {
        this.cartItems = new ArrayList<>();
    }

    // �̱��� �ν��Ͻ� ��ȯ �޼ҵ�
    public static Cart getInstance() {
        if (instance == null) {
            instance = new Cart();
        }
        return instance;
    }

    // ��ٱ��Ͽ� �޴� �߰� (Restaurant ��ü ����)
    public void addItems(Menu menu, int quantity, Restaurant restaurant) {
        boolean itemExists = false;
        for (CartItem item : cartItems) {
            if (item.getMenu().equals(menu)) {
                item.setQuantity(item.getQuantity() + quantity); // ���� ����
                itemExists = true;
                break;
            }
        }
        if (!itemExists) {
            cartItems.add(new CartItem(menu, quantity, restaurant));  // Restaurant ��ü ����
        }
    }

    // ��ٱ����� �޴� �ջ�
    public double getTotalPrice() {
        double total = 0;
        for (CartItem item : cartItems) {
            total += item.getTotalPrice();
        }
        return total;
    }

    public void showAllCart() {
        if (cartItems.isEmpty()) {
            System.out.println("��ٱ��ϰ� ����ֽ��ϴ�.");
        } else {
            for (CartItem item : cartItems) {
                System.out.println(item);
            }
        }
    }

    // ��ٱ��� �׸� ����� ��ȯ�ϴ� �޼���
    public List<CartItem> getCartItems() {
        return cartItems;
    }

    void clearCart() {
        cartItems.clear();
    }

    // ���� �Ϸ� ó�� �޼���
    public void completePayment() {
        this.paymentCompleted = true;
        clearCart();  // ���� �� ��ٱ��� ����
    }

    // ���� �Ϸ� ���� Ȯ��
    public boolean isPaymentCompleted() {
        return this.paymentCompleted;
    }
}