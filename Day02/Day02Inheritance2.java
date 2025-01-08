package Day02;

public class Day02Inheritance2 extends Day02Class { // Pakai extends untuk inheritance
    public Day02Inheritance2() {

    }

    public Day02Inheritance2(int s) {
        super(); // Untuk inherit semua yang ada di parent class
    }

    public void suaraBinatang() { // Polymorhism (Inhertance 2 child class dari 1 parent yang bernama Day02Class)
        System.out.println("Meow Meow Meow");
    }
}
