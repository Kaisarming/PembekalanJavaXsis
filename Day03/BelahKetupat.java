package Day03;

public class BelahKetupat extends BangunDatar {
    public void hitung(float sisi, float panjang, float lebar, float diagonal1, float diagonal2,
            float radius) {
        System.out.println("Keliling belah ketupat: " + (sisi + sisi + sisi + sisi));
        System.out.println("Luas ketupat: " + ((diagonal1 * diagonal2) / 2));
    }
}
