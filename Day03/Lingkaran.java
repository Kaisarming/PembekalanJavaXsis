package Day03;

public class Lingkaran extends BangunDatar {

    public Lingkaran(float radius) {
        setRadius(radius);
    }

    public void keliling() {
        System.out.println("Keliling lingkaran: " + (3.14 * (getRadius() + getRadius())));
    };

    public void luas() {
        System.out.println("Luas lingkaran: " + (3.14 * getRadius() * getRadius()));
    };
}
