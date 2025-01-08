package Day03;

public class Segitiga extends BangunDatar {
    public Segitiga(float panjang, int lebar) {
        setPanjang(panjang);
        setLebar(lebar);
    }

    public void keliling() {
        System.out.println("Keliling segitiga: " + (getPanjang() * 3));
    };

    public void luas() {
        System.out.println("Luas segitiga: " + (0.5 * getPanjang() * getLebar()));
    };
}
