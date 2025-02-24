(ns com.example.interop)

(defonce original-println clojure.core/println)
(defn my-println [& args]
  (apply original-println "FOO" args))

(defn g [] (println 42))

(g)


(comment
  (alter-var-root (var clojure.core/println) (constantly my-println))
  ;; WHEN symbols are used in a clojure file, the compiler tries to resolve their
  ;; MEANING.
  ;; 1. If it is a symbol that is IN the ns, and that contains a var, it gets
  ;;    the BINDING of the var
  ;; 2. #' asks for the VAR itself (instead of looking for it's value)
  (type a)
  (type #'a)
  (meta #'a)
  (println (System/getProperty "java.class.path"))
  (binding [*compile-path* "target/classes"]
    (compile 'com.example.interop))

  )
