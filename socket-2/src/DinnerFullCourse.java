public class DinnerFullCourse {
    private Dish[] list = new Dish[5];

    DinnerFullCourse() {
        String[] names = {"寿司", "ラーメン", "餃子", "ステーキ", "プリン"};
        int[] costs = {100, 200, 300, 400, 500};
        for (int i = 0; i < list.length; i++){
            Dish d = new Dish();
            d.setName(names[i]);
            d.setValune(costs[i]);
            list[i] = d;
        }
    }

    public void eatAll() {
        for (Dish d : list) {
            System.err.printf("%s: %s円\n", d.getName(), d.getValune());
        }
    }

    public static void main(String[] args) {
        DinnerFullCourse fullcourse = new DinnerFullCourse();
        fullcourse.eatAll();
    }
}
