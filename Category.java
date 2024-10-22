package DeliveryVO;

import java.util.ArrayList;
import java.util.List;

public class Category {
    private  String name; //카테고리 이름
    private  List<Restaurant> restaurantList; //음식점 리스트

    public  Category(String name) {
        this.name = name;
        this.restaurantList = new ArrayList<>();

    }
     void addRestaurant(Restaurant restaurant){
        restaurantList.add(restaurant);
    }

    public String getName() {
        return name;
    }


    public List<Restaurant> getRestaurantList() {
        return restaurantList;
    }

    public void setRestaurantList(List<Restaurant> restaurantList) {
        this.restaurantList = restaurantList;
    }
}
