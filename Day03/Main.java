package Day03;

public class Main {
    public static void main(String[] args) {
        Persegi persegi = new Persegi(5);
        persegi.keliling();
        persegi.luas();

        PersegiPanjang persegiPanjang = new PersegiPanjang(3, 5);
        persegiPanjang.keliling();
        persegiPanjang.luas();

        Segitiga segitiga = new Segitiga(7, 8);
        segitiga.keliling();
        segitiga.luas();

        BelahKetupat belahKetupat = new BelahKetupat(3, 4, 5);
        belahKetupat.keliling();
        belahKetupat.luas();

        Lingkaran lingkaran = new Lingkaran(7);
        lingkaran.keliling();
        lingkaran.luas();
    }
}
