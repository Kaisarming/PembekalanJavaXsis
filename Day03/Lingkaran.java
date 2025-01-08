package Day03;

public class Lingkaran extends BangunDatar {

    public Lingkaran(float radius) {
        this.radius = radius;
    }

    public void keliling() {
        System.out.println("Keliling lingkaran: " + (3.14 * (radius + radius)));
    };

    public void luas() {
        System.out.println("Luas lingkaran: " + (3.14 * radius * radius));
    };
}
