package DeliveryVO;

public class Menu {

    private String menuName; //메뉴의 이름
    private long price; //메뉴의 가격
    private String description; //메뉴의 설명



    public Menu(String menuName, long price, String description) {
        this.menuName = menuName;
        this.price = price;
        this.description = description;
    }

    public String getMenuName() {
        return menuName;
    }


    public long getPrice() {
        return price;
    }


    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "메뉴 이름: "+menuName+"\n" +
                "가격: "+price+"\n"+
                "설명: "+description;
    }
}
