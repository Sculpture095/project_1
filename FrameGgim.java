package frame;

import DeliveryVO.Ggim;
import DeliveryVO.Restaurant;
import java.awt.*;
import java.util.List;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameGgim extends JPanel {

    private JPanel listPanel;
    private Ggim ggimList;

    public FrameGgim(JPanel homePanel, String name, String address) {
        this.ggimList = Ggim.getInstance();
        setBackground(new Color(255, 255, 255));
        setLayout(null);
        setSize(500, 800);

        listPanel = new JPanel();
        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));  // Y축으로 나열
        listPanel.setPreferredSize(new Dimension(480, 1000));

        JScrollPane scrollPane = new JScrollPane(listPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(0, 120, 500, 600);  // 스크롤 크기 조정
        add(scrollPane);

        // 뒤로가기 버튼 추가
        ImageIcon bbt = new ImageIcon("img/back_icon.png");
        JButton btnBack = new JButton(bbt);
        btnBack.setSize(36, 38);
        btnBack.setLocation(60, 48);
        btnBack.setContentAreaFilled(false);
        btnBack.setBorderPainted(false);
        btnBack.setFocusPainted(false);
        add(btnBack);

        // 뒤로가기 버튼 클릭 시 이전 화면으로 이동
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrameBase.getDispose();
                FrameBase.getInstance(new FrameCategory(homePanel, name, address));
            }
        });

        displayGgimList();  // 찜 목록을 화면에 표시
    }

    public void displayGgimList() {
        listPanel.removeAll();  // 기존 목록 초기화
        List<Restaurant> ggimRestaurants = ggimList.getGgimList();

        for (Restaurant restaurant : ggimRestaurants) {
            // 음식점 패널을 추가하는 메서드 호출 (FrameKorean 스타일 적용)
            addRestaurant(restaurant.getName(), restaurant.getImagePath(), restaurant.getDescription());
        }

        listPanel.revalidate();
        listPanel.repaint();
    }

    public void addRestaurant(String name, String imagePath, String description) {


        // 개별 음식점 패널 (FrameKorean 스타일 적용)
        JPanel restaurantPanel = new JPanel();
        restaurantPanel.setLayout(null);  // null 레이아웃 사용
        restaurantPanel.setBounds(10, 0, 460, 140);  // 패널 크기 및 위치 설정
        restaurantPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));

        // 이미지 로드 및 라벨에 추가
        ImageIcon imageIcon = new ImageIcon(imagePath);
        Image img = imageIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        JLabel imageLabel = new JLabel(new ImageIcon(img));
        imageLabel.setBounds(10, 10, 100, 100);  // 이미지 위치 및 크기 설정
        restaurantPanel.add(imageLabel);

        // 음식점 정보 패널
        JLabel nameLabel = new JLabel("이름: " + name);
        nameLabel.setBounds(120, 10, 200, 30);  // 이름 라벨 위치 및 크기
        restaurantPanel.add(nameLabel);

        JLabel descriptionLabel = new JLabel("설명: " + description);
        descriptionLabel.setBounds(120, 50, 300, 30);  // 설명 라벨 위치 및 크기
        restaurantPanel.add(descriptionLabel);

        listPanel.add(restaurantPanel);  // 음식점 패널을 리스트 패널에 추가
    }
}
