package Day03;

public class BangunDatar {
    public void hitungPersegi(float sisi) {
        System.out.println("Keliling persegi: " + (sisi * 4));
        System.out.println("Luas persegi: " + (sisi * sisi));
    };

    public void hitungPersegiPanjang(float panjang, float lebar) {
        System.out.println("Keliling persegi panjang: " + ((panjang * 2) + (lebar * 2)));
        System.out.println("Luas persegi panjang: " + (panjang * lebar));
    };

    public void hitungSegitiga(float alas, float tinggi) {
        System.out.println("Keliling segitiga: " + (alas * 3));
        System.out.println("Luas segitiga: " + (0.5 * alas * tinggi));
    };

    public void hitungBelahKetupat(float sisi, float diagonal1, float diagonal2) {
        System.out.println("Keliling belah ketupat: " + (sisi + sisi + sisi + sisi));
        System.out.println("Luas ketupat: " + ((diagonal1 * diagonal2) / 2));
    };

    public void hitungLingkaran(float radius) {
        System.out.println("Keliling lingkaran: " + (3.14 * (radius + radius)));
        System.out.println("Luas lingkaran: " + (3.14 * radius * radius));
    };
}
