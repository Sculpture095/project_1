package frame;

import DeliveryVO.Cart;
import DeliveryVO.CartItem;
import DeliveryVO.Restaurant;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class FrameCart extends JPanel {

    public FrameCart(JPanel homePanel) {
        // 기존 패널 초기화
        JPanel cartPanel = new JPanel();
        cartPanel.setLayout(new BoxLayout(cartPanel, BoxLayout.Y_AXIS));

        JLabel cartTitle = new JLabel("장바구니");
        cartTitle.setFont(new Font("", Font.BOLD, 20));
        cartTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        cartPanel.add(cartTitle);
        cartPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        // 장바구니 아이템을 가져옴
        List<CartItem> cartItems = Cart.getInstance().getCartItems();
        long totalPrice = 0;
        long deliveryPrice = 0;
        Restaurant restaurant = null;

        if (cartItems.isEmpty()) {
            JLabel emptyLabel = new JLabel("장바구니가 비어 있습니다.");
            emptyLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            cartPanel.add(emptyLabel);
        } else {
            // 장바구니에 아이템이 있을 때 처리
            for (CartItem item : cartItems) {
                JPanel cartItemPanel = new JPanel();
                cartItemPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
                cartItemPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

                // 메뉴 정보 및 수량
                JLabel itemNameLabel = new JLabel(item.getMenu().getMenuName() + " x " + item.getQuantity());
                cartItemPanel.add(itemNameLabel);

                // 가격 계산
                totalPrice += item.getMenu().getPrice() * item.getQuantity();
                cartPanel.add(cartItemPanel);

                // 레스토랑 정보 확인 및 배달비 설정
                if (restaurant == null) {
                    restaurant = item.getRestaurant();  // CartItem에서 Restaurant 객체 가져옴
                    if (restaurant != null) {
                        deliveryPrice = restaurant.getDeliveryPrice();
                        System.out.println("레스토랑 이름: " + restaurant.getName());  // 레스토랑 이름 출력
                        System.out.println("배달비: " + deliveryPrice);  // 배달비 확인을 위한 출력
                    } else {
                        System.out.println("레스토랑 객체가 null입니다.");
                    }
                }
            }
        }

        // 총 가격 및 배달비 표시
        long finalPrice = totalPrice + deliveryPrice;
        JLabel totalLabel = new JLabel("총 음식 가격: " + totalPrice + "원");
        JLabel deliveryLabel = new JLabel("배달비: " + deliveryPrice + "원");
        JLabel finalPriceLabel = new JLabel("최종 결제 금액: " + finalPrice + "원");

        cartPanel.add(totalLabel);
        cartPanel.add(deliveryLabel);
        cartPanel.add(finalPriceLabel);

        // 스크롤 추가
        JScrollPane scrollPane = new JScrollPane(cartPanel);
        add(scrollPane);
    }
}
