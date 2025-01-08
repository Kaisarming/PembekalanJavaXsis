package Day03;

public class Segitiga extends BangunDatar {
    public Segitiga(float panjang, float lebar) {
        this.panjang = panjang;
        this.lebar = lebar;
    }

    public void keliling() {
        System.out.println("Keliling segitiga: " + (panjang * 3));
    };

    public void luas() {
        System.out.println("Luas segitiga: " + (0.5 * panjang * lebar));
    };
}
