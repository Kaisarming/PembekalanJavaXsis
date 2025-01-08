package Day03;

public class LayangLayang extends BangunDatar {
    public void hitung(float sisi, float panjang, float lebar, float diagonal1, float diagonal2,
            float radius) {
        System.out.println("Keliling layang-layang: " + (sisi + sisi + sisi + sisi));
        System.out.println("Luas layang-layang: " + ((diagonal1 * diagonal2) / 2));
    }
}
