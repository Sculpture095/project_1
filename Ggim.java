package DeliveryVO;

import java.util.ArrayList;
import java.util.List;

public class Ggim {

    // 싱글톤 인스턴스
    private static Ggim instance = null;

    private List<Restaurant> ggimList;

    // private 생성자: 외부에서 직접 객체를 생성하지 못하도록 함
    private Ggim() {
        ggimList = new ArrayList<>();
    }

    // getInstance 메소드를 통해 Ggim 객체에 접근
    public static Ggim getInstance() {
        if (instance == null) {
            instance = new Ggim();
        }
        return instance;
    }

    public void addGgim(Restaurant restaurant) {
        ggimList.add(restaurant);
    }

    public void removeGgim(Restaurant restaurant) {
        ggimList.remove(restaurant);
    }

    public List<Restaurant> getGgimList() {
        return ggimList;
    }
}
