package Day03;

public class Lingkaran extends BangunDatar {
    public void hitung(float sisi, float panjang, float lebar, float diagonal1, float diagonal2,
            float radius) {
        System.out.println("Keliling lingkaran: " + (3.14 * (radius + radius)));
        System.out.println("Luas lingkaran: " + (3.14 * radius * radius));
    }
}
