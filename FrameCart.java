package frame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import DeliveryVO.Cart;
import DeliveryVO.CartItem;
import DeliveryVO.Restaurant;

public class FrameCart extends JPanel {

    private JPanel frameCartPanel;  // 홈 패널
    private JPanel listPanel;       // 음식점 리스트가 담길 패널
    private JScrollPane scrollPane; // 스크롤 패널
    private JLabel orderAmountLabel; // 주문 금액 레이블
    private JLabel deliveryFeeLabel; // 배달비 레이블
    private JLabel totalLabel;      // 총합 레이블
    private long totalAmount = 0;    // 총합 변수
    private long deliveryPrice = 0;  // 배달비 변수
    private Restaurant restaurant;   // 레스토랑 객체
    private ImageIcon headerImage;  // 상단 이미지

    public FrameCart(JPanel homePanel, String name, String address) {
        this.frameCartPanel = homePanel;
        setBackground(new Color(255, 255, 255));
        setLayout(null);
        setSize(500, 800);

        // 상단 이미지 로드
        headerImage = new ImageIcon("img/cart_page.png"); // 이미지 경로 수정
        JLabel headerLabel = new JLabel(headerImage);
        headerLabel.setBounds(195, 50, 106, 28); // 이미지 위치와 크기 설정
        add(headerLabel);

        // 뒤로가기 버튼
        ImageIcon bbt = new ImageIcon("img/back_icon.png");
        JButton btnBack = new JButton(bbt);
        btnBack.setSize(36, 38);
        btnBack.setLocation(60, 48);
        btnBack.setContentAreaFilled(false);
        btnBack.setBorderPainted(false);
        btnBack.setFocusPainted(false);
        add(btnBack);

        // 뒤로가기 버튼 액션
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrameBase.getDispose();
                FrameBase.getInstance(new FrameCategory(homePanel, name, address));
            }
        });

        // 음식점 리스트 패널 설정 (스크롤 가능)
        listPanel = new JPanel();
        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));  // 세로로 음식점 나열

        // 스크롤 가능하게 JScrollPane에 리스트 패널 추가
        scrollPane = new JScrollPane(listPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(0, 120, 500, 450);  // 스크롤 영역 위치와 크기 설정
        add(scrollPane);

        // 장바구니 아이템 로드
        loadCartItems();

        // 주문 금액 레이블 추가
        orderAmountLabel = new JLabel("주문 금액: " + totalAmount + " 원");
        orderAmountLabel.setBounds(50, 580, 200, 30);
        add(orderAmountLabel);

        // 배달비 레이블 추가
        deliveryFeeLabel = new JLabel("배달비: " + deliveryPrice + " 원");
        deliveryFeeLabel.setBounds(50, 610, 200, 30);
        add(deliveryFeeLabel);

        // 총합 레이블 추가
        totalLabel = new JLabel("총합: " + (totalAmount + deliveryPrice) + " 원");
        totalLabel.setBounds(50, 640, 200, 30);
        add(totalLabel);

        // 결제하기 버튼
        ImageIcon paybt = new ImageIcon("img/payment_btn.png");
        JButton btnPay = new JButton(paybt);
        btnPay.setSize(300, 70);
        btnPay.setLocation(100, 680);
        btnPay.setContentAreaFilled(false);
        btnPay.setBorderPainted(false);
        btnPay.setFocusPainted(false);
        add(btnPay);

        // 결제하기 버튼 클릭 시 합계 출력
        btnPay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cart.getInstance().completePayment();
                JOptionPane.showMessageDialog(null, "결제 금액: " + (totalAmount + deliveryPrice) + " 원");
                FrameBase.getDispose();
                FrameBase.getInstance(new FrameCategory(homePanel,name,address));
                // 결제 로직 추가 가능
            }
        });
    }

    // 장바구니 아이템을 로드하고 리스트에 추가하는 메소드
    private void loadCartItems() {
        java.util.List<CartItem> cartItems = Cart.getInstance().getCartItems();

        if (cartItems.isEmpty()) {
            JLabel emptyLabel = new JLabel("장바구니가 비어 있습니다.");
            emptyLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            listPanel.add(emptyLabel);
        } else {
            // 첫 번째 아이템에서 레스토랑 정보를 가져와 배달비 설정
            for (CartItem item : cartItems) {
                if (restaurant == null) {
                    restaurant = item.getRestaurant();  // CartItem에서 Restaurant 객체 가져옴
                    if (restaurant != null) {
                        deliveryPrice = restaurant.getDeliveryPrice();  // Restaurant에서 배달비 가져오기
                        System.out.println("레스토랑 이름: " + restaurant.getName());  // 확인용 출력
                        System.out.println("배달비: " + deliveryPrice);  // 배달비 확인용 출력
                    }
                }
                addRestaurant(item);  // 아이템을 리스트에 추가
            }
        }
        listPanel.revalidate();
        listPanel.repaint();
    }

    // 음식점 리스트에 아이템 추가 메서드
    public void addRestaurant(CartItem item) {
        String itemName = item.getMenu().getMenuName();
        int[] quantity = {item.getQuantity()}; // 수량을 배열로 감싸서 변경 가능하도록

        long price = item.getMenu().getPrice();

        JPanel cartItemPanel = new JPanel();
        cartItemPanel.setLayout(null);  // 레이아웃을 null로 설정하여 수동 위치 지정
        cartItemPanel.setPreferredSize(new Dimension(500, 130)); // 패널의 크기를 설정

        // 음식 이미지 추가
        ImageIcon foodImage = new ImageIcon("img/f_1_1_1.png"); // 음식 이미지 경로 수정
        JLabel foodImageLabel = new JLabel(new ImageIcon(foodImage.getImage().getScaledInstance(125, 95, Image.SCALE_SMOOTH)));
        foodImageLabel.setBounds(20, 10, 125, 95);  // 이미지 위치와 크기 설정
        cartItemPanel.add(foodImageLabel);

        // 메뉴 정보 및 가격 레이블
        JLabel itemNameLabel = new JLabel(itemName);
        itemNameLabel.setBounds(190, 10, 200, 30);  // 음식 이름 위치 설정
        cartItemPanel.add(itemNameLabel);

        JLabel priceLabel = new JLabel("가격: " + (price * quantity[0]) + " 원");
        priceLabel.setBounds(220, 40, 200, 30);  // 가격 레이블 위치 설정
        cartItemPanel.add(priceLabel);

        // 수량 조정 버튼 및 레이블
        JButton minusButton = new JButton("-");
        minusButton.setBounds(350, 70, 45, 30);  // 수량 감소 버튼 위치 설정
        cartItemPanel.add(minusButton);

        JLabel quantityLabel = new JLabel(String.valueOf(quantity[0]));
        quantityLabel.setBounds(330, 70, 30, 30);  // 수량 레이블 위치 설정
        cartItemPanel.add(quantityLabel);

        JButton plusButton = new JButton("+");
        plusButton.setBounds(280, 70, 45, 30);  // 수량 증가 버튼 위치 설정
        cartItemPanel.add(plusButton);

        // 삭제 버튼
        JButton deleteButton = new JButton("삭제");
        deleteButton.setBounds(335, 50, 60, 30);  // 삭제 버튼 위치 설정
        cartItemPanel.add(deleteButton);

        // 수량 증가 버튼 액션
        plusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                quantity[0]++;
                quantityLabel.setText(String.valueOf(quantity[0]));
                totalAmount += price; // 총합 증가
                updateTotalLabels();
            }
        });

        // 수량 감소 버튼 액션
        minusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (quantity[0] > 1) {
                    quantity[0]--;
                    quantityLabel.setText(String.valueOf(quantity[0]));
                    totalAmount -= price; // 총합 감소
                    updateTotalLabels();
                }
            }
        });

        // 삭제 버튼 액션
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listPanel.remove(cartItemPanel); // 패널에서 제거
                totalAmount -= price * quantity[0]; // 총합 감소
                updateTotalLabels();
                listPanel.revalidate();
                listPanel.repaint();
            }
        });

        // 패널에 추가
        listPanel.add(cartItemPanel);
        totalAmount += price * quantity[0]; // 총합 계산
    }

    // 총합 레이블 업데이트 메서드
    public void updateTotalLabels() {
        orderAmountLabel.setText("주문 금액: " + totalAmount + " 원");
        totalLabel.setText("총합: " + (totalAmount + deliveryPrice) + " 원");
    }
}
