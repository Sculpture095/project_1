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

    private static JFrame frame;  // JFrame�� ���� ������ ����
    private Ggim ggim;
    public Frame1_1(){

    }
    public static void showRestaurantMenu(Restaurant restaurant,JPanel homePanel,String name,String address) {

        frame = new JFrame("�޴� ���");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // ������ �ݱ� ����
        frame.setSize(500, 800); // ������ ũ�� ����

        // ��� �г� ����
        JPanel backgroundPanel = new JPanel();
        backgroundPanel.setLayout(null); // ���̾ƿ��� null�� ����
        // ���� ��ư
        ImageIcon lgmt = new ImageIcon("img/small_cart_icon.png");
        JButton btnmt = new JButton(lgmt);
        btnmt.setSize(31, 28);
        btnmt.setLocation(395, 300);
        btnmt.setContentAreaFilled(false);
        btnmt.setBorderPainted(false);
        btnmt.setFocusPainted(false);
        backgroundPanel.add(btnmt);
        // �ڷΰ��� ��ư
        btnmt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();  // ���� ���� �ִ� �������� ����
                FrameBase.getInstance(new FrameCategory(homePanel,name,address));  // FrameCategory�� ��ȯ
            }
        });
        // �ڷΰ��� ��ư
        ImageIcon bbt = new ImageIcon("img/back_icon.png");
        JButton btnBack= new JButton(bbt);
        btnBack.setSize(36, 38);
        btnBack.setLocation(60, 59);
        btnBack.setContentAreaFilled(false);
        btnBack.setBorderPainted(false);
        btnBack.setFocusPainted(false);

        // �ڷΰ��� ��ư
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();  // ���� ���� �ִ� �������� ����
                FrameBase.getInstance(new FrameKorean(homePanel,name,address));  // FrameCategory�� ��ȯ
            }
        });
        // ���亸�� ��ư
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
                // ���� ���� ȭ������ �̵�
                FrameBase.getDispose();
                FrameBase.getInstance(new FrameReview(homePanel, restaurant.getName(),address));
            }
        });

        // ���ƿ� ��ư �߰� (�� �ϳ��� ��ư)
        ImageIcon ggimOffIcon = new ImageIcon("img/ggim_off_icon.png");
        ImageIcon ggimOnIcon = new ImageIcon("img/ggim_on_icon.png");
        JButton likeButton = new JButton(ggimOffIcon);
        likeButton.setContentAreaFilled(false);
        likeButton.setBorderPainted(false);
        likeButton.setFocusPainted(false);
        likeButton.setBounds(386, 210, 50, 50); // ��ġ�� ���ϴ� ��� ���� ����


        // Ŭ�� �� �̹��� ��� ����
        likeButton.addActionListener(new ActionListener() {
            private boolean isLiked = false;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (isLiked) {
                    likeButton.setIcon(ggimOffIcon); // ���ƿ� ����
                } else {
                    Ggim ggim = Ggim.getInstance();
                    ggim.addGgim(restaurant);


                    JOptionPane.showMessageDialog(null, "��������� �� ��Ͽ� �߰��Ǿ����ϴ�.");
                    likeButton.setIcon(ggimOnIcon); // ���ƿ� ����
                }
                isLiked = !isLiked;
            }
        });

        backgroundPanel.add(likeButton); // ��Ʈ ��ư�� ��� �гο� �߰�

        JLabel lblImage = new JLabel();
        lblImage.setBounds(0, 0, 500, 420);
        lblImage.setIcon(new ImageIcon("img/store1_1.jpg")); // �̹��� �߰�
        backgroundPanel.add(lblImage); // ��� �гο� �̹��� �߰�

        // �޴� �г� ����
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
        menuPanel.setBounds(0, 420, 500, 380); // �޴� �г� ��ġ �� ũ�� ����

        JLabel restaurantNameLabel = new JLabel("�޴� ��� - " + restaurant.getName());
        restaurantNameLabel.setFont(new Font("", Font.BOLD, 15));
        restaurantNameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        menuPanel.add(restaurantNameLabel);
        menuPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        // ��������� �޴��� ǥ��
        for (Menu menu : restaurant.getMenuList()) {
            JPanel menuItemPanel = new JPanel();
            menuItemPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
            menuItemPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            // �޴� �̹��� �߰�
            String imagePath = "img/menu_image.png"; // �޴� �̹��� ���
            JButton menuImageButton = new JButton(new ImageIcon(new ImageIcon(imagePath).getImage().getScaledInstance(160, 120, Image.SCALE_SMOOTH)));
            menuImageButton.setPreferredSize(new Dimension(125, 95));
            menuImageButton.setContentAreaFilled(false);
            menuImageButton.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

            // �޴� ���� �г� �߰�
            JPanel infoPanel = new JPanel();
            infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));

            JLabel menuNameLabel = new JLabel(menu.getMenuName());
            menuNameLabel.setFont(new Font("", Font.BOLD, 13));

            JLabel priceLabel = new JLabel("����: " + menu.getPrice() + "��");
            priceLabel.setFont(new Font("����ü ����", Font.PLAIN, 11));

            JLabel descriptionLabel = new JLabel("����: " + menu.getDescription());
            descriptionLabel.setFont(new Font("����ü ����", Font.PLAIN, 11));

            // ���� ���� ���ǳ� �߰�
            JPanel quantityPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JLabel quantityLabel = new JLabel("����: ");
            JSpinner quantitySpinner = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1)); // �ʱⰪ 1, �ּ� 1, �ִ� 100, ���� ���� 1
            quantitySpinner.setPreferredSize(new Dimension(50, 20));
            quantityPanel.add(quantityLabel);
            quantityPanel.add(quantitySpinner);

            // ��� ��ư �߰�
            ImageIcon addToCartIcon = new ImageIcon("img/put_btn.png"); // �̹��� ���
            JButton btnAddToCart = new JButton(addToCartIcon);
            btnAddToCart.setContentAreaFilled(false); // ��ư ����� �����ϰ� ����
            btnAddToCart.setBorderPainted(false); // ��ư ��輱 ����
            btnAddToCart.addActionListener(e -> {
                int quantity = (Integer) quantitySpinner.getValue();
                Cart.getInstance().addItems(menu, quantity, restaurant);
                JOptionPane.showMessageDialog(frame, menu.getMenuName() + " " + quantity + "���� �����ϴ�!");
            });

            // ���� �гο� �߰�
            infoPanel.add(menuNameLabel);
            infoPanel.add(priceLabel);
            infoPanel.add(descriptionLabel);
            infoPanel.add(quantityPanel); // ���� ���� �г� �߰�
            infoPanel.add(btnAddToCart); // ��� ��ư �߰�

            // �޴� ������ �гο� �̹����� ���� �г� �߰�
            menuItemPanel.add(menuImageButton);
            menuItemPanel.add(Box.createRigidArea(new Dimension(10, 0)));
            menuItemPanel.add(infoPanel);

            // �޴� ������ �г��� �޴� �гο� �߰�
            menuPanel.add(menuItemPanel);
            menuPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        }

        // �޴� �г��� ��ũ�� �гη� ���α�
        JScrollPane scrollPane = new JScrollPane(menuPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(0, 420, 500, 380); // ��ũ�� �г� ��ġ �� ũ�� ����
        backgroundPanel.add(scrollPane); // ��� �гο� ��ũ�� �г� �߰�

        frame.add(backgroundPanel);
        frame.setLocationRelativeTo(null); // ȭ�� �߾ӿ� ��ġ
        frame.setVisible(true); // ������ ǥ��
    }
}
