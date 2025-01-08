package Day03;

public class PersegiPanjang extends BangunDatar {

    public PersegiPanjang(float panjang, float lebar) {
        this.panjang = panjang;
        this.lebar = lebar;
    }

    public void keliling() {
        System.out.println("Keliling persegi panjang: " + ((panjang * 2) + (lebar * 2)));
    };

    public void luas() {
        System.out.println("Luas persegi panjang: " + (panjang * lebar));
    };
}
