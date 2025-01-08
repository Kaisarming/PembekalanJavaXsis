package Day03;

public class PersegiPanjang extends BangunDatar {
    public void hitung(float sisi, float panjang, float lebar, float diagonal1, float diagonal2,
            float radius) {
        System.out.println("Keliling persegi panjang: " + (panjang + lebar + panjang + lebar));
        System.out.println("Luas persegi panjang: " + (panjang * lebar));
    }
}
