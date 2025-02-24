(ns com.example.interop)

(def a 1)

(comment
  (println (System/getProperty "java.class.path"))
  (binding [*compile-path* "target/classes"]
    (compile 'com.example.interop))

  )
