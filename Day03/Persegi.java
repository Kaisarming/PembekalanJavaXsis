package Day03;

public class Persegi extends BangunDatar {

    public Persegi(float sisi) {
        panjang = sisi;
    }

    public void keliling() {
        System.out.println("Keliling persegi: " + (panjang * 4));
    };

    public void luas() {
        System.out.println("Luas persegi: " + (panjang * panjang));
    };
}
