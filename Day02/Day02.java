package Day02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Day02 {
    public static void main(String[] args) {
        /*
         * // Array
         * int[] arr = new int[5];
         * arr[0] = 1;
         * arr[1] = 2;
         * 
         * for (int i = 0; i < arr.length; i++) {
         * System.out.println(arr[i]);
         * }
         * 
         * // Array List
         * ArrayList<String> motorBike = new ArrayList<>();
         * motorBike.add("Honda Beat");
         * motorBike.add("Kawasaki Ninja");
         * 
         * motorBike.set(0, "Motor Beat Bekas");
         * 
         * for (int i = 0; i < motorBike.size(); i++) {
         * System.out.println(motorBike.get((i)));
         * }
         * 
         * for (String s : motorBike) {
         * System.out.println(s);
         * }
         * 
         * // Escape Character
         * String n = "Pembekalan\nJava";
         * String t = "Pembekalan\tJava";
         * String escapeCharacter = "\"Pembekalan Java\"";
         * String r = "Jim - onii chan \rMamat";
         * 
         * System.out.println(n);
         * System.out.println(t);
         * System.out.println(escapeCharacter);
         * System.out.println(r);
         * 
         * String hello = "Hello world";
         * 
         * System.out.println(hello.getClass());
         * 
         * System.out.println("Hello Matthew".substring(1, 3));
         * System.out.println("   Hello Matthew    ".trim());
         * System.out.println("Hello Matthew".replace("e", "i"));
         * System.out.println("Hello Matthew".replace("el", "i"));
         * 
         * String xsis = "PT. Xsis Mitra Utama 12345678 !@##$%^&";
         * System.out.println(xsis.replaceAll("[A-Za-z]+", "Matthew"));
         * 
         * // Map (Dictionary di bahasa lain)
         * Map<String, String> responseMap = new HashMap<>();
         * responseMap.put("Makanan", "Indomie Goreng");
         * responseMap.put("Minuman", "Milo");
         * 
         * System.out.println(responseMap);
         * System.out.println(String.valueOf(responseMap));
         */

        Day02Class o = new Day02Class();
        o.accelerate("Mazda", 50);

        // Polymorhism
        Day02Inheritance i1 = new Day02Inheritance();
        Day02Inheritance2 i2 = new Day02Inheritance2();
        i1.suaraBinatang();
        i2.suaraBinatang();

    }
}
