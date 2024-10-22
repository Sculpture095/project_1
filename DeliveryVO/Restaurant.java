package DeliveryVO;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {

    private String name;  //음식점 이름
    private List<Menu> menuList; //메뉴

    private double restaurantScore; // 음식점 평점
    private double distance; //가게의 거리
    private long deliveryPrice; //기본배달비, 최종배달비는 기본배달비+거리에 따른 비용

    public Restaurant(String name,
                      double restaurantScore, double distance, long deliveryPrice) {
        this.name = name;
        this.menuList = new ArrayList<>();
        this.restaurantScore = restaurantScore;
        this.distance = distance;
        this.deliveryPrice = deliveryPrice;
    }

    //메뉴를 추가하는 메소드
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
}
