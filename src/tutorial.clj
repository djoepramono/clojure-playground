;; Primitive Data Type

2
"hello"
'(1 2 3) ;; list
[1 2 3] ;; vector
#{1 2 3} ;; set
{"name" "John" :age 12} ;; hash map

;; Variable assignment
(def myVector 
  (vector 1 2 3))
(first myVector)

(def mySet
  (set [ 1 2 3 3]))
(first mySet)

;; Immutable
(def myHashMap
  (hash-map "name" "John" 
            :age 24))
(get :age myHashMap)
(def myNewHashMap (
                   assoc myHashMap :team {:name "Roaring Tiger" :motto "rawrrr"}))                  

(get-in myNewHashMap [:team :motto])

;; Referential Transparency
(= myVector (vector 1 2 3))

;; -------------------------
;; Function
(def add-2
  (fn [x]
    (print x)
    (+ x 2)))

(add-2 3)

;; Same function different signature
(defn add-all
  ([a b]
   (+ a b))
  ([a b c]
   (+ a b c)))

(add-all 4 8 12)

;; -----------------------
;; Recursion

(defn factorial [x]
  (if (> x 1)
    (* x (factorial (dec x)))
    1))

(factorial 4)


;; -----------------------
;; Higher order function

(map inc [1 2 3 4])
(filter even? [1 2 3 4])
(reduce add-all [1 2 3 4])

(map (fn [x] (* x 2))[1 2 3 4])

;; #() denotes a lambda where % is the argument passed in
(map #(* % 2) [1 2 3 4])


;; [1 2 3 4] -> {:total 10}
(reduce
 (fn [acc curr] 
   (assoc acc :total (curr)))
 {}
 [1 2 3 4])

(type reduce)

(defn -main
  []
  (println "Hello World")
  (add-2 3))