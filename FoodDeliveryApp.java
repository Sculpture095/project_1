package DeliveryVO;

import java.util.ArrayList;
import java.util.List;

public class FoodDeliveryApp {

    private static FoodDeliveryApp instance; //�̱��� �ν��Ͻ�
    private List<Category> categories; //ī�װ� ����Ʈ

    //
    private FoodDeliveryApp(){
        categories = new ArrayList<>();
        RestaurantDAO.init(this); //RestaurantDAO���� ������ �ʱ�ȭ

    }

    public static FoodDeliveryApp getInstance(){
        if(instance == null){
            instance = new FoodDeliveryApp();
        }
        return instance;
    }
    //ī�װ��� �߰��ϴ� �޼ҵ�
    void addCategory(Category category){
        categories.add(category);
    }
    //ī�װ� ����� ��ȯ�ϴ� �޼ҵ�
    public List<Category> getCategories() {
        return categories;
    }
}
