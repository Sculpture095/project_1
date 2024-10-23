package frame;

import DeliveryVO.Cart;
import DeliveryVO.Review;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameReview extends JPanel {
    
    private JPanel frameCartPanel;  // 홈 패널
    private JPanel listPanel;       // 음식점 리스트가 담길 패널
    private JScrollPane scrollPane; // 스크롤 패널
    private JLabel orderAmountLabel; // 주문 금액 레이블
    private JLabel deliveryFeeLabel; // 배달비 레이블
    private JLabel totalLabel;      // 총합 레이블
    private int totalAmount = 0;    // 총합 변수
    private int deliveryFee = 3000; // 배달비
    private Image backgroundImage; // 배경 이미지를 저장할 변수
    private ImageIcon headerImage; // 상단 이미지


   
    public FrameReview(JPanel homePanel,String name) {
        this.frameCartPanel = homePanel;
        setBackground(new Color(255, 255, 255));
        setLayout(null);
        setSize(500, 800);


        // 상단 제목
        JLabel titleLabel = new JLabel(name + "에 대한 리뷰");
        titleLabel.setFont(new Font("", Font.BOLD, 24));
        titleLabel.setBounds(180, 50, 200, 30);
        add(titleLabel);

        // 리뷰를 불러오기
        Review review = new Review();
        String reviews = review.readReviews();

        // 리뷰 목록을 표시하는 JTextArea
        JTextArea reviewArea = new JTextArea(reviews);
        reviewArea.setBounds(50, 100, 400, 600);
        reviewArea.setEditable(false);
        add(reviewArea);


        // 상단 이미지 로드
        headerImage = new ImageIcon("img/cart_page.png"); // 이미지 경로 수정
        JLabel headerLabel = new JLabel(headerImage);
        headerLabel.setBounds(195, 50, 106, 28); // 이미지 위치와 크기 설정
        add(headerLabel);
     // 뒤로가기 버튼
     		ImageIcon bbt = new ImageIcon("img/back_icon.png");
     		JButton btnBack= new JButton(bbt);
     		btnBack.setSize(36, 38);
     		btnBack.setLocation(60, 48);
     		btnBack.setContentAreaFilled(false);
     		btnBack.setBorderPainted(false);
     		btnBack.setFocusPainted(false);
     		
     		add(btnBack);
     		
     	// 뒤로가기 버튼
    		btnBack.addActionListener(new ActionListener() {

    		@Override
    		public void actionPerformed(ActionEvent e) {
    		// 여기로 이동함
    		FrameBase.getDispose();
    		FrameBase.getInstance(new FrameCategory(homePanel,name,""));
    	}
    });

        
    
        
      

        // 음식점 리스트 패널 설정 (스크롤 가능)
        listPanel = new JPanel();
        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));  // 세로로 음식점 나열

        // 스크롤 가능하게 JScrollPane에 리스트 패널 추가
        scrollPane = new JScrollPane(listPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(0, 120, 520, 450);  // 스크롤 영역 위치와 크기 설정
        add(scrollPane);

        // 주문 금액 레이블 추가
        orderAmountLabel = new JLabel("주문 금액: " + totalAmount + " 원");
        orderAmountLabel.setBounds(50, 580, 200, 30);
        add(orderAmountLabel);

        // 배달비 레이블 추가
        deliveryFeeLabel = new JLabel("배달비: " + deliveryFee + " 원");
        deliveryFeeLabel.setBounds(50, 610, 200, 30);
        add(deliveryFeeLabel);

        // 총합 레이블 추가
        totalLabel = new JLabel("총합: " + (totalAmount + deliveryFee) + " 원");
        totalLabel.setBounds(50, 640, 200, 30);
        add(totalLabel);

        // 예시 음식점 3개 추가 (가격 추가)
        addRestaurant("음식점 1", "img/category_chicken.png", "맛있는 음식점 1 설명", 10000);
        addRestaurant("음식점 2", "img/category_coffee.png", "맛있는 음식점 2 설명", 15000);
        addRestaurant("음식점 3", "img/category_jajangmyeon.png", "맛있는 음식점 3 설명", 20000);

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
                JOptionPane.showMessageDialog(null, "결제 금액: " + (totalAmount + deliveryFee) + " 원");
                // 결제 로직 추가 가능
            }
        });

        // 하단의 메뉴 버튼들 (찜, 주문현황, 카테고리, 장바구니, 마이페이지)
        setupBottomMenu(homePanel);
    }

 // 음식점 리스트에 음식점 추가 메서드
    public void addRestaurant(String name, String imagePath, String description, int price) {
        // 개별 음식점 패널
        JPanel restaurantPanel = new JPanel();
        restaurantPanel.setLayout(new BorderLayout());
        restaurantPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // 음식점 이미지 추가 (ImageIcon)
        ImageIcon imageIcon = new ImageIcon(imagePath);
        Image img = imageIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);  // 이미지 크기 조정
        JLabel imageLabel = new JLabel(new ImageIcon(img));
        
        // 이미지와 정보 간격을 위한 패널 추가
        JPanel imagePanel = new JPanel();
        imagePanel.add(imageLabel);
        imagePanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10)); // 오른쪽 여백 추가

        restaurantPanel.add(imagePanel, BorderLayout.WEST);

        // 음식점 정보 패널 (이름, 설명, 가격)
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        infoPanel.setPreferredSize(new Dimension(105, 60)); // 크기 조정
        JLabel nameLabel = new JLabel(name);
        JLabel descLabel = new JLabel("<html><p style='width: 200px;'>" + description + "</p></html>");  // 설명 길이 제한
        JLabel priceLabel = new JLabel("가격: " + price + " 원");
        
        // 각 레이블 사이에 여백 추가
        nameLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0)); // 아래쪽 여백 추가
        descLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0)); // 아래쪽 여백 추가

        infoPanel.add(nameLabel);
        infoPanel.add(descLabel);
        infoPanel.add(priceLabel);
        restaurantPanel.add(infoPanel, BorderLayout.CENTER);

        // 오른쪽 버튼 패널 (수량 조정, 삭제)
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 1, 0, 0)); // 2행 1열로 설정

        // 첫 번째 행: 마이너스, 수량 레이블, 플러스 버튼
        JPanel quantityPanel = new JPanel();
        quantityPanel.setLayout(new FlowLayout()); // 수량 조정 버튼들을 가로로 배치

        JButton minusButton = new JButton("-");
        minusButton.setPreferredSize(new Dimension(60, 30)); // 버튼 크기 조정
        minusButton.setContentAreaFilled(false);
        minusButton.setBorderPainted(false);
        minusButton.setFocusPainted(false);

        JLabel quantityLabel = new JLabel("1");

        JButton plusButton = new JButton("+");
        plusButton.setPreferredSize(new Dimension(60, 30)); // 버튼 크기 조정
        plusButton.setContentAreaFilled(false);
        plusButton.setBorderPainted(false);
        plusButton.setFocusPainted(false);
        
        quantityPanel.add(minusButton);
        quantityPanel.add(quantityLabel);
        quantityPanel.add(plusButton);
      
        restaurantPanel.add(buttonPanel, BorderLayout.EAST);

        // 수량 증가
        plusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int currentQuantity = Integer.parseInt(quantityLabel.getText());
                currentQuantity++;
                quantityLabel.setText(String.valueOf(currentQuantity));
                updateTotal(price); // 가격 추가
            }
        });

        // 수량 감소
        minusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int currentQuantity = Integer.parseInt(quantityLabel.getText());
                if (currentQuantity > 1) {
                    currentQuantity--;
                    quantityLabel.setText(String.valueOf(currentQuantity));
                    updateTotal(-price); // 가격 제거
                }
            }
        });

        // 삭제 버튼
        JButton deleteButton = new JButton("삭제");
        deleteButton.setPreferredSize(new Dimension(70, 30)); // 삭제 버튼 크기 조정
        deleteButton.setContentAreaFilled(false);
        deleteButton.setBorderPainted(false);
        deleteButton.setFocusPainted(false);
        
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int currentQuantity = Integer.parseInt(quantityLabel.getText());
                updateTotal(-price * currentQuantity); // 삭제 시 총합에서 가격을 빼줌
                listPanel.remove(restaurantPanel);  // 패널에서 삭제
                listPanel.revalidate();
                listPanel.repaint();
            }
        });

        // 버튼들을 메인 패널에 추가
        buttonPanel.add(quantityPanel); // 첫 번째 행
        buttonPanel.add(deleteButton); // 두 번째 행

        restaurantPanel.add(buttonPanel, BorderLayout.EAST);

        // 음식점 패널을 리스트 패널에 추가
        listPanel.add(restaurantPanel);
        updateTotal(price); // 처음 추가되는 음식점 가격을 총합에 포함
        listPanel.revalidate();
        listPanel.repaint();
    }


    // 총합 업데이트 메서드
    private void updateTotal(int amount) {
        totalAmount += amount;
        orderAmountLabel.setText("주문 금액: " + totalAmount + " 원");
        totalLabel.setText("총합: " + (totalAmount + deliveryFee) + " 원");
    }

    // 하단 메뉴 버튼 설정 (찜, 주문현황, 카테고리, 장바구니, 마이페이지)
    private void setupBottomMenu(JPanel homePanel) {
        // 찜 버튼
        ImageIcon ggimbt = new ImageIcon("img/heart_icon.png");
        JButton btnGgim = new JButton(ggimbt);
        btnGgim.setSize(39, 38);
        btnGgim.setLocation(32, 685);
        btnGgim.setContentAreaFilled(false);
        btnGgim.setBorderPainted(false);
        btnGgim.setFocusPainted(false);
        add(btnGgim);

        // 주문현황 버튼
        ImageIcon orderbt = new ImageIcon("img/order_icon.png");
        JButton btnOrder = new JButton(orderbt);
        btnOrder.setSize(38, 38);
        btnOrder.setLocation(125, 685);
        btnOrder.setContentAreaFilled(false);
        btnOrder.setBorderPainted(false);
        btnOrder.setFocusPainted(false);
        add(btnOrder);

        // 카테고리 버튼
        ImageIcon categorybt = new ImageIcon("img/home_icon.png");
        JButton btnCategory = new JButton(categorybt);
        btnCategory.setSize(47, 39);
        btnCategory.setLocation(225, 685);
        btnCategory.setContentAreaFilled(false);
        btnCategory.setBorderPainted(false);
        btnCategory.setFocusPainted(false);
        add(btnCategory);

        // 장바구니 버튼
        ImageIcon cartbt = new ImageIcon("img/cart_icon.png");
        JButton btnCart = new JButton(cartbt);
        btnCart.setSize(44, 38);
        btnCart.setLocation(325, 685);
        btnCart.setContentAreaFilled(false);
        btnCart.setBorderPainted(false);
        btnCart.setFocusPainted(false);
        add(btnCart);

        // 마이페이지 버튼
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
