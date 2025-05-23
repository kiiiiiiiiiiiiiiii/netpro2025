package _05;
import java.io.Serializable;

public class RestaurantMenu implements Serializable {
    private int menuId = -1;
    private int money;
    private String message;
    private boolean isError = false;

    RestaurantMenu(int menuId){
        this.menuId = Math.abs(menuId);
    }

    private static String[] MENU_NAMES = { "カレー", "ラーメン", "オムライス", "寿司", "すき焼き", "餃子", "ハンバーグ", "ステーキ", "からあげ", "うどん", "そば",
            "お好み焼き", "たこ焼き" };

    private static int[] COSTS = {500, 600, 800, 900, 900, 1200, 500, 700, 1000, 600, 300, 300, 400, 400};

    public int getMenuId() {
        return menuId;
    }

    public int getMoney() {
        return money;
    }

    public String getMessage() {
        return message;
    }

    public boolean getIsError() {
        return isError;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void setMessage(String message) {
        this.message = message;
        this.isError = false;
    }

    public void setMessage(String message, boolean isError) {
        this.message = message;
        this.isError = isError;
    }

    public void addMoney(int add) {
        this.money += add;
    }

    public String getMenuName() {
        if (menuId < 0) return "";
        return MENU_NAMES[menuId % MENU_NAMES.length];
    }

    public int getCost() {
        return COSTS[menuId % COSTS.length];
    }

    public int getOtsuri() {
        return money - getCost();
    }
}
