package com.example;

import clojure.lang.AFunction;
import clojure.lang.RT;
import clojure.lang.Var;

public class Main {
    public static void main(String[] args) {
        Var hashMap = RT.var("clojure.core", "hash-map");
        AFunction obj = (AFunction)hashMap.getRawRoot();
        Object result = obj.invoke("a", 1, "b", 2);

        System.out.println(result.toString());
    }
}
