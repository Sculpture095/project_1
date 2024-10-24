package frame;

import DeliveryVO.Cart;
import DeliveryVO.Ggim;
import DeliveryVO.Menu;
import DeliveryVO.Restaurant;
import frame.foodcategory.FrameKorean;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Frame1_1 extends JPanel {

    private static JFrame frame;  // JFrame을 전역 변수로 저장
    private Ggim ggim;
    public Frame1_1(){

    }
    public static void showRestaurantMenu(Restaurant restaurant,JPanel homePanel,String name,String address) {

        frame = new JFrame("메뉴 목록");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // 프레임 닫기 설정
        frame.setSize(500, 800); // 프레임 크기 설정

        // 배경 패널 생성
        JPanel backgroundPanel = new JPanel();
        backgroundPanel.setLayout(null); // 레이아웃을 null로 설정
        // 마켓 버튼
        ImageIcon lgmt = new ImageIcon("img/small_cart_icon.png");
        JButton btnmt = new JButton(lgmt);
        btnmt.setSize(31, 28);
        btnmt.setLocation(395, 300);
        btnmt.setContentAreaFilled(false);
        btnmt.setBorderPainted(false);
        btnmt.setFocusPainted(false);
        backgroundPanel.add(btnmt);
        // 뒤로가기 버튼
        btnmt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();  // 현재 열려 있는 프레임을 닫음
                FrameBase.getInstance(new FrameCategory(homePanel,name,address));  // FrameCategory로 전환
            }
        });
        // 뒤로가기 버튼
        ImageIcon bbt = new ImageIcon("img/back_icon.png");
        JButton btnBack= new JButton(bbt);
        btnBack.setSize(36, 38);
        btnBack.setLocation(60, 59);
        btnBack.setContentAreaFilled(false);
        btnBack.setBorderPainted(false);
        btnBack.setFocusPainted(false);

        // 뒤로가기 버튼
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();  // 현재 열려 있는 프레임을 닫음
                FrameBase.getInstance(new FrameKorean(homePanel,name,address));  // FrameCategory로 전환
            }
        });
        // 리뷰보기 버튼
        ImageIcon lgbt = new ImageIcon("img/store_review_btn.png");
        JButton btnLogin = new JButton(lgbt);
        btnLogin.setSize(117, 35);
        btnLogin.setLocation(200, 280);

        btnLogin.setContentAreaFilled(false);
        btnLogin.setBorderPainted(false);
        btnLogin.setFocusPainted(false);

        backgroundPanel.add(btnLogin);
        backgroundPanel.add(btnBack);

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 리뷰 보기 화면으로 이동
                FrameBase.getDispose();
                FrameBase.getInstance(new FrameReview(homePanel, restaurant.getName(),address));
            }
        });

        // 좋아요 버튼 추가 (단 하나의 버튼)
        ImageIcon ggimOffIcon = new ImageIcon("img/ggim_off_icon.png");
        ImageIcon ggimOnIcon = new ImageIcon("img/ggim_on_icon.png");
        JButton likeButton = new JButton(ggimOffIcon);
        likeButton.setContentAreaFilled(false);
        likeButton.setBorderPainted(false);
        likeButton.setFocusPainted(false);
        likeButton.setBounds(386, 210, 50, 50); // 위치를 원하는 대로 조정 가능


        // 클릭 시 이미지 토글 구현
        likeButton.addActionListener(new ActionListener() {
            private boolean isLiked = false;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (isLiked) {
                    likeButton.setIcon(ggimOffIcon); // 좋아요 해제
                } else {
                    Ggim ggim = Ggim.getInstance();
                    ggim.addGgim(restaurant);


                    JOptionPane.showMessageDialog(null, "레스토랑이 찜 목록에 추가되었습니다.");
                    likeButton.setIcon(ggimOnIcon); // 좋아요 선택
                }
                isLiked = !isLiked;
            }
        });

        backgroundPanel.add(likeButton); // 하트 버튼을 배경 패널에 추가

        JLabel lblImage = new JLabel();
        lblImage.setBounds(0, 0, 500, 420);
        lblImage.setIcon(new ImageIcon("img/store1_1.jpg")); // 이미지 추가
        backgroundPanel.add(lblImage); // 배경 패널에 이미지 추가

        // 메뉴 패널 생성
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
        menuPanel.setBounds(0, 420, 500, 380); // 메뉴 패널 위치 및 크기 설정

        JLabel restaurantNameLabel = new JLabel("메뉴 목록 - " + restaurant.getName());
        restaurantNameLabel.setFont(new Font("", Font.BOLD, 15));
        restaurantNameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        menuPanel.add(restaurantNameLabel);
        menuPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        // 레스토랑의 메뉴를 표시
        for (Menu menu : restaurant.getMenuList()) {
            JPanel menuItemPanel = new JPanel();
            menuItemPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
            menuItemPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            // 메뉴 이미지 추가
            String imagePath = "img/menu_image.png"; // 메뉴 이미지 경로
            JButton menuImageButton = new JButton(new ImageIcon(new ImageIcon(imagePath).getImage().getScaledInstance(160, 120, Image.SCALE_SMOOTH)));
            menuImageButton.setPreferredSize(new Dimension(125, 95));
            menuImageButton.setContentAreaFilled(false);
            menuImageButton.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

            // 메뉴 정보 패널 추가
            JPanel infoPanel = new JPanel();
            infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));

            JLabel menuNameLabel = new JLabel(menu.getMenuName());
            menuNameLabel.setFont(new Font("", Font.BOLD, 13));

            JLabel priceLabel = new JLabel("가격: " + menu.getPrice() + "원");
            priceLabel.setFont(new Font("굴림체 보통", Font.PLAIN, 11));

            JLabel descriptionLabel = new JLabel("설명: " + menu.getDescription());
            descriptionLabel.setFont(new Font("굴림체 보통", Font.PLAIN, 11));

            // 수량 조절 스피너 추가
            JPanel quantityPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JLabel quantityLabel = new JLabel("수량: ");
            JSpinner quantitySpinner = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1)); // 초기값 1, 최소 1, 최대 100, 증가 단위 1
            quantitySpinner.setPreferredSize(new Dimension(50, 20));
            quantityPanel.add(quantityLabel);
            quantityPanel.add(quantitySpinner);

            // 담기 버튼 추가
            ImageIcon addToCartIcon = new ImageIcon("img/put_btn.png"); // 이미지 경로
            JButton btnAddToCart = new JButton(addToCartIcon);
            btnAddToCart.setContentAreaFilled(false); // 버튼 배경을 투명하게 설정
            btnAddToCart.setBorderPainted(false); // 버튼 경계선 제거
            btnAddToCart.addActionListener(e -> {
                int quantity = (Integer) quantitySpinner.getValue();
                Cart.getInstance().addItems(menu, quantity, restaurant);
                JOptionPane.showMessageDialog(frame, menu.getMenuName() + " " + quantity + "개가 담겼습니다!");
            });

            // 정보 패널에 추가
            infoPanel.add(menuNameLabel);
            infoPanel.add(priceLabel);
            infoPanel.add(descriptionLabel);
            infoPanel.add(quantityPanel); // 수량 조절 패널 추가
            infoPanel.add(btnAddToCart); // 담기 버튼 추가

            // 메뉴 아이템 패널에 이미지와 정보 패널 추가
            menuItemPanel.add(menuImageButton);
            menuItemPanel.add(Box.createRigidArea(new Dimension(10, 0)));
            menuItemPanel.add(infoPanel);

            // 메뉴 아이템 패널을 메뉴 패널에 추가
            menuPanel.add(menuItemPanel);
            menuPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        }

        // 메뉴 패널을 스크롤 패널로 감싸기
        JScrollPane scrollPane = new JScrollPane(menuPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(0, 420, 500, 380); // 스크롤 패널 위치 및 크기 설정
        backgroundPanel.add(scrollPane); // 배경 패널에 스크롤 패널 추가

        frame.add(backgroundPanel);
        frame.setLocationRelativeTo(null); // 화면 중앙에 위치
        frame.setVisible(true); // 프레임 표시
    }
}
