public class CarTest {
    public static void main(String[] args) {
        Car myCar = new Car();
        myCar.drive(20);
        System.out.printf("current speed is %s\n", myCar.speedUp(5));
        System.out.printf("curret speed is %s \n", myCar.speedDown(5));
        myCar.stop(12);
    }
}
