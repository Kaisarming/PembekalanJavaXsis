package Day03;

public class BelahKetupat extends BangunDatar {
    public BelahKetupat(float panjang, float diagonal1, float diagonal2) {
        setPanjang(panjang);
        setDiagonal1(diagonal1);
        setDiagonal2(diagonal2);
    }

    public void keliling() {
        System.out.println("Keliling belah ketupat: " + (getPanjang() * 4));
    };

    public void luas() {
        System.out.println("Luas ketupat: " + ((getDiagonal1() * getDiagonal2()) / 2));
    };
}
