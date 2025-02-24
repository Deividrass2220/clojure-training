(ns com.example.interop
  (:require
    [com.example.other]
    [com.fulcrologic.fulcro.components :refer [get-ident props]]))

(defonce original-println clojure.core/println)
(defn my-println [& args]
  (apply original-println "FOO" args))

(defn g [] (println 42))

;; SYMBOL: Looks in the interns, refers, aliases, etc. of the ns.
(g)
(type {:k 2})
(type (hash-map :k 2))

(map (fn [x] (inc x)) [1 2 3])
(vector 1 2 43 )


(comment
  (def refs (ns-refers 'com.fulcrologic.fulcro.components))
  (get refs 'prewalk)
  (require '[com.fulcrologic.fulcro.components :refer [get-query]])
  (get refs 'get-query)
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
