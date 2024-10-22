package DeliveryVO;

import java.util.ArrayList;
import java.util.List;

public class FoodDeliveryApp {

    private static FoodDeliveryApp instance;
    private List<Category> categories;

    private FoodDeliveryApp(){
        categories = new ArrayList<>();

    }

    static synchronized FoodDeliveryApp getInstance(){
        if(instance == null){
            instance = new FoodDeliveryApp();
        }
        return instance;
    }
    void addCategory(Category category){
        categories.add(category);
    }

    public List<Category> getCategories() {
        return categories;
    }
}
