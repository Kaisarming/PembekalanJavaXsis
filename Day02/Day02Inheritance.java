package Day02;

public class Day02Inheritance extends Day02Class { // Pakai extends untuk inheritance
    public Day02Inheritance() {

    }

    public Day02Inheritance(int s) {
        super(); // Untuk inherit semua yang ada di parent class
    }

    public void suaraBinatang() { // Polymorhism (Inhertance 2 child class dari 1 parent yang bernama Day02Class)
        System.out.println("Guk guk");
    }
}
