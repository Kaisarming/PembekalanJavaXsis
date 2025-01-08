package Day03;

public class PersegiPanjang extends BangunDatar {

    public PersegiPanjang(float panjang, int lebar) {
        setPanjang(panjang);
        setLebar(lebar);
    }

    public void keliling() {
        System.out.println("Keliling persegi panjang: " + ((getPanjang() * 2) + (getLebar() * 2)));
    };

    public void luas() {
        System.out.println("Luas persegi panjang: " + (getPanjang() * getLebar()));
    };
}
