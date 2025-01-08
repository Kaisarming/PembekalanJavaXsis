package Day03;

public class BelahKetupat extends BangunDatar {
    public BelahKetupat(float panjang, float diagonal1, float diagonal2) {
        this.panjang = panjang;
        this.diagonal1 = diagonal1;
        this.diagonal2 = diagonal2;
    }

    public void keliling() {
        System.out.println("Keliling belah ketupat: " + (panjang * 4));
    };

    public void luas() {
        System.out.println("Luas ketupat: " + ((diagonal1 * diagonal2) / 2));
    };
}
