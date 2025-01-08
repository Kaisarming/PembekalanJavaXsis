package Day03;

public class Persegi extends BangunDatar {

    public Persegi(float sisi) {
        setPanjang(sisi);
    }

    public void keliling() {
        System.out.println("Keliling persegi: " + (getPanjang() * 4));
    };

    public void luas() {
        System.out.println("Luas persegi: " + (getPanjang() * getPanjang()));
    };
}
