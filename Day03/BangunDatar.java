package Day03;

public abstract class BangunDatar {
    private float panjang;
    private int lebar; // Iseng coba pakai integer. Tapi normalnya pakai float
    private float diagonal1;
    private float diagonal2;
    private float radius;

    public abstract void keliling();

    public abstract void luas();

    public float getPanjang() {
        return panjang;
    }

    public void setPanjang(float panjang) {
        this.panjang = panjang;
    }

    public float getLebar() {
        return lebar;
    }

    public void setLebar(int lebar) {
        this.lebar = lebar;
    }

    public float getDiagonal1() {
        return diagonal1;
    }

    public void setDiagonal1(float diagonal1) {
        this.diagonal1 = diagonal1;
    }

    public float getDiagonal2() {
        return diagonal2;
    }

    public void setDiagonal2(float diagonal2) {
        this.diagonal2 = diagonal2;
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }
}
