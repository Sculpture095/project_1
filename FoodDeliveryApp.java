package DeliveryVO;

import java.util.ArrayList;
import java.util.List;

public class FoodDeliveryApp {

    private static FoodDeliveryApp instance; //싱글톤 인스턴스
    private List<Category> categories; //카테고리 리스트

    //
    private FoodDeliveryApp(){
        categories = new ArrayList<>();
        RestaurantDAO.init(this); //RestaurantDAO에서 데이터 초기화

    }

    public static FoodDeliveryApp getInstance(){
        if(instance == null){
            instance = new FoodDeliveryApp();
        }
        return instance;
    }
    //카테고리를 추가하는 메소드
    void addCategory(Category category){
        categories.add(category);
    }
    //카테고리 목록을 반환하는 메소드
    public List<Category> getCategories() {
        return categories;
    }
}
