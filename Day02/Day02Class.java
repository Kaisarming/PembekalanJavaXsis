package Day02;

public class Day02Class {
    public int speed;
    public String brand;

    public void accelerate(String brand, int speed) {
        this.brand = brand;
        this.speed = speed;

        System.out.println(this.brand + " drive at " + this.speed + "km/h.");
    }

}
