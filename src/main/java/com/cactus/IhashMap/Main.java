package com.cactus.IhashMap;

public class Main {
    public static void main(String[] args) {
        IHashMap<String, String> map = new IHashMap<>();
        int count = 10;
        for (int i = 0; i < count; i++) {
            map.put(String.valueOf(i), String.valueOf(i));
        }
        System.out.println(map.size());

        map.remove("8");
        System.out.println(map.get("8"));
    }
}
