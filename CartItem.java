package DeliveryVO;

public class CartItem {
    //��ٱ��� �׸� Ŭ����
    private Menu menu; //��ٱ��Ͽ� �� �޴�
    private int quantity; //����
    private Restaurant restaurant;

    public CartItem(Menu menu, int quantity) {
        this.menu = menu;
        this.quantity = quantity;

    }

    public CartItem(Menu menu, int quantity, Restaurant restaurant) {
        this.menu = menu;
        this.quantity = quantity;
        this.restaurant = restaurant;
    }

    public Menu getMenu() {
        return menu;
    }

    public int getQuantity() {
        return quantity;
    }
    double getTotalPrice(){
       return menu.getPrice()*quantity;
    }

 public Restaurant getRestaurant(){
        return this.restaurant;
 }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return
                "�޴�: " + menu +"\n"+
                "����: " + quantity;

    }
}