;; This tutorial assumed that you have installed Calva
;; alt+enter -> evaluate from within a form
;; ctrl+enter -> evaluate the previous form, left side of the cursor
;;               you can also highlight and execute with ctrl+enter

;; -------------------------
;; 1. Primitive Data Type

;; number
2

;; string
"hello"

;; vector
[1 2 3]

;; set, contains unique member
#{1 2 3} 

;; hash map
{"name" "John" :age 12} ;; 


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
;; A piece of code can be replaced with the output
(def myVector
  (vector 1 2 3))
(= myVector (vector 1 2 3))

;; You can do point free programming here


;; -------------------------
;; Immutable hash map
;; declare a hash map
(def myHashMap
  (hash-map "name" "John" 
            :age 24))

;; evaluate or get its properties
(eval myHashMap)
(get myHashMap :age)
(:age myHashMap)

;; add additional key value pair by creating another copy of the data
(def myNewHashMap (
                   assoc myHashMap :team {:name "Roaring Tiger" :motto "rawrrr"}))

;; try use get-in to get deeper properties of an object
(get-in myNewHashMap [:team :motto])


;; -------------------------
;; Function

;; create using def
;; can also call a function using apply
(def add-2
  (fn [x]
    (print x)
    (+ x 2)))

(add-2 3)
(apply add-2 [3])

;; create using defn
;; but this time use different arity
(defn add-all
  ([a b]
   (+ a b))
  ([a b c]
   (+ a b c)))

(add-all 2 3)
(add-all 4 8 12)

;; function that accepts any number of arguments
(defn smooch-all-strings
  ([& args]
   (reduce str args)))
(smooch-all-strings "jack" "jill" "bob")

;; -> compose x with functions where x comes as the first args
;; also called as thread first
;; function can take any arguments
(defn times-eight-then-plus-one
  ([number] 
   (-> number
       (* 8)
       (+ 1))))
(times-eight-then-plus-one 2)

(= (times-eight-then-plus-one 2) (+ (* 2 8) 1))

;; ->> another compose x with functions but x comes as the last args
;; called as thread last
;; that means the functions need to take at least 2 arguments
(defn times-eight-then-plus-one-v2
  ([number]
   (->> number
        (* 8)
        (+ 1))))
(times-eight-then-plus-one-v2 2)

(= (times-eight-then-plus-one-v2 2) (+ 1(* 8 2)))
(= (times-eight-then-plus-one 2) (times-eight-then-plus-one-v2 2))

;; -----------------------
;; Higher order function

;; map
(map inc [1 2 3 4])
(map (fn [x] (* x 2)) [1 2 3 4])

;; filter
(filter even? [1 2 3 4])

;; reduce
(reduce add-all [1 2 3 4])

;; #() denotes a lambda where % is the argument passed in
(map #(* % 2) [1 2 3 4])

;; [1 2 3 4] -> {:total 10}
(reduce
 (fn [acc curr] 
   (+ acc curr)) 
 0
 [1 2 3 4])

;; there are other higher order function as well
;; some, who will check if some of the vector meets a criteria
(some even? [1289 20 54])
