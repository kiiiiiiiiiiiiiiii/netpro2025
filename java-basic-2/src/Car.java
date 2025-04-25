public class Car implements Drivable {
    private int speed;

    @Override
    public void drive(int speed) {
        this.speed = speed;
        System.out.println("Driving at " + speed + " kilometers per hour.");
    }

    @Override
    public void stop(int withintime) {
        System.out.println("stopping with in "+withintime);
        try {
            Thread.sleep(withintime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.speed=0;
        System.out.println("stopped");
    }

    @Override
    public int speedUp(int upSpeed) {
        this.speed += upSpeed;
        return this.speed;
    }

    @Override
    public int speedDown(int downSpeed) {
        this.speed -= downSpeed;
        return this.speed;
    }
}
