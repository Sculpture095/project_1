package DeliveryVO;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {

    private String name;  //������ �̸�
    private List<Menu> menuList; //�޴�

    private double restaurantScore; // ������ ����
    private double distance; //������ �Ÿ�
    private long deliveryPrice; //�⺻��޺�, ������޺�� �⺻��޺�+�Ÿ��� ���� ���
    private String imagePath;
    private String description;

    public Restaurant(String name,
                      double restaurantScore, double distance, long deliveryPrice,String description) {
        this.name = name;
        this.menuList = new ArrayList<>();
        this.restaurantScore = restaurantScore;
        this.distance = distance;
        this.deliveryPrice = deliveryPrice;
        this.description = description;
    }

    public Restaurant(String name,
                      double restaurantScore, double distance, long deliveryPrice) {
        this.name = name;
        this.menuList = new ArrayList<>();
        this.restaurantScore = restaurantScore;
        this.distance = distance;
        this.deliveryPrice = deliveryPrice;
    }

    //�޴��� �߰��ϴ� �޼ҵ�
    public void addMenu(Menu menu){
        menuList.add(menu);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Menu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<Menu> menuList) {
        this.menuList = menuList;
    }

    public double getRestaurantScore() {
        return restaurantScore;
    }

    public void setRestaurantScore(double restaurantScore) {
        this.restaurantScore = restaurantScore;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public long getDeliveryPrice() {
        return deliveryPrice;
    }

    public void setDeliveryPrice(long deliveryPrice) {
        this.deliveryPrice = deliveryPrice;
    }

    public String getDescription() {
        return description;
    }

    public String getImagePath() {
        return imagePath;
    }
}