;; This tutorial assumed that you have installed Calva
;; alt+enter -> evaluate from within a form
;; ctrl+enter -> evaluate the previous form, left side of the cursor
;;               you can also highlight and execute with ctrl+enter

;; -------------------------
;; Primitive Data Type
2
"hello"
'(1 2 3) ;; list, '(single quote) is also used to delay the evaluation
[1 2 3] ;; vector
#{1 2 3} ;; set
{"name" "John" :age 12} ;; hash map


;; -------------------------
;; Loading description into REPL
(require '[clojure.repl :refer :all])
(doc first) ;; read the function document
(find-doc "first") ;; read further more
(apropos "fir") ;; search that function


;; -------------------------
;; Variable assignment
(def x 1)
x

;; Note that you can redefine once assigned x so yes Clojure allows mutability
;; Redefining unbound variable would yield in a different memory address however

;; Let, would allow you to scope the variable assignment
;; and it prevents mutability*
;; * redefining x actually doesn't do anything inside the form, 
;;   but it will mutates x outside the form
(let [x 4]
  (println (+ x 3))
  (println (+ x 4))
  (def x 7) 
  x)
x

;; Take this with a grain of salt, because some would argue that the data itself is immutable
;; Calling def x twice only mutates the binding


;; -------------------------
;; Referential Transparency
(def myVector
  (vector 1 2 3))
(= myVector (vector 1 2 3))

;; You can do point free programming here


;; -------------------------
;; Immutable data
(def myHashMap
  (hash-map "name" "John" 
            :age 24))
(eval myHashMap)
(get myHashMap :age)
(:age myHashMap)

;; adding additional key value pair is actually creating another copy of the data
(def myNewHashMap (
                   assoc myHashMap :team {:name "Roaring Tiger" :motto "rawrrr"}))

(get-in myNewHashMap [:team :motto])


;; -------------------------
;; Function
(def add-2
  (fn [x]
    (print x)
    (+ x 2)))

(add-2 3)
(apply add-2 [3])

;; Same function different signature
(defn add-all
  ([a b]
   (+ a b))
  ([a b c]
   (+ a b c)))


;; You can create different arity function
(add-all 2 3)
(add-all 4 8 12)


;; -----------------------
;; Recursion

(defn factorial [x]
  (if (> x 1)
    (* x (factorial (dec x)))
    1))

(factorial 4)
(= (factorial 4) (* 4 3 2 1))


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
   (+ acc curr)) 
 2
 [1 2 3 4])

(some even? [1289 20 54])

