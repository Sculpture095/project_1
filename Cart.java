package DeliveryVO;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    // 싱글톤 인스턴스
    private static Cart instance;
    // 장바구니 클래스
    private List<CartItem> cartItems;
    private boolean paymentCompleted = false; //결제 완료 여부를 저장하는 필드



    public Cart() {
        this.cartItems = new ArrayList<>();
    }

    // 싱글톤 인스턴스 반환 메소드
    public static Cart getInstance() {
        if (instance == null) {
            instance = new Cart();
        }
        return instance;
    }

    // 장바구니에 메뉴 추가 (Restaurant 객체 포함)
    public void addItems(Menu menu, int quantity, Restaurant restaurant) {
        boolean itemExists = false;
        for (CartItem item : cartItems) {
            if (item.getMenu().equals(menu)) {
                item.setQuantity(item.getQuantity() + quantity); // 수량 증가
                itemExists = true;
                break;
            }
        }
        if (!itemExists) {
            cartItems.add(new CartItem(menu, quantity, restaurant));  // Restaurant 객체 전달
        }
    }

    // 장바구니의 메뉴 합산
    public double getTotalPrice() {
        double total = 0;
        for (CartItem item : cartItems) {
            total += item.getTotalPrice();
        }
        return total;
    }

    public void showAllCart() {
        if (cartItems.isEmpty()) {
            System.out.println("장바구니가 비어있습니다.");
        } else {
            for (CartItem item : cartItems) {
                System.out.println(item);
            }
        }
    }

    // 장바구니 항목 목록을 반환하는 메서드
    public List<CartItem> getCartItems() {
        return cartItems;
    }

    void clearCart() {
        cartItems.clear();
    }

    // 결제 완료 처리 메서드
    public void completePayment() {
        this.paymentCompleted = true;
        clearCart();  // 결제 후 장바구니 비우기
    }

    // 결제 완료 여부 확인
    public boolean isPaymentCompleted() {
        return this.paymentCompleted;
    }
}