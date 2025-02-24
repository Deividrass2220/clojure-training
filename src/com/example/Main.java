package com.example;

import clojure.lang.AFunction;
import clojure.lang.IPersistentMap;
import clojure.lang.RT;
import clojure.lang.Var;

public class Main {
    public static void main(String[] args) {
        Var vvar = RT.var("clojure.core", "vector");
        AFunction obj = (AFunction)vvar.getRawRoot();
        Object result = obj.invoke(1, 2, 3);

        Var mapvar = RT.var("clojure.core", "map");
        AFunction mapfn = (AFunction)mapvar.getRawRoot();

        //Object result2 = mapfn.invoke(???, result);
        //System.out.println(result2.toString());
    }
}
