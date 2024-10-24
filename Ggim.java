package DeliveryVO;

import java.util.ArrayList;
import java.util.List;

public class Ggim {

    // �̱��� �ν��Ͻ�
    private static Ggim instance = null;

    private List<Restaurant> ggimList;

    // private ������: �ܺο��� ���� ��ü�� �������� ���ϵ��� ��
    private Ggim() {
        ggimList = new ArrayList<>();
    }

    // getInstance �޼ҵ带 ���� Ggim ��ü�� ����
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
