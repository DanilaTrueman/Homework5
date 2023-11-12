package House;

import java.lang.reflect.Array;
import java.util.*;

public class House  {
    private String name;
    private int age;

    public House (String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public  int getAge() {
        return age;
    }

    public static void main(String[] args) {
        HashMap<String, Integer> houseMape = new HashMap<>();
        houseMape.put("Стив Смит", 14);
        houseMape.put("Хейли Смит", 19);
        houseMape.put("Клаус Хайсслер", 70);
        houseMape.put("Фрэнсин Смит", 40);
        houseMape.put("Стэн Смит", 47);
        houseMape.put("Роджер",1600);

        ArrayList<String> residentsAbove18 = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : houseMape.entrySet()) {
            if (entry.getValue() > 18) {
                residentsAbove18.add(entry.getKey());
            }
        }
        Collections.sort(residentsAbove18);

        for (String resident : residentsAbove18) {
            System.out.println(resident);
        }
    }
}
