(ns playground.recursion)

;; factorial function
;; given 4, the results should be 4 * 3 * 2 * 1 = 24
(defn factorial [x]
  (if (>= x 1)
    (* x (factorial (dec x))) 
    1))

(factorial 4)

;; unfortunately the solution above is prone to stack overflow
(factorial 999999)

;; ----
;; now let's redo the function to use tail recursion
;; with tail recursion, more often that not you would want a recursive function that has accumulator
;; so what happen if the original function doesn't have a accumulator? we would need to define an inner function

;; additional hints
;; recur syntax tell the compiler not to consume a stack
;; recur needs to happen at tail position i.e. last expression. Note that in Clojure everything is an expression
;; arithmetic functions with ' will convert results to BigInt to avoid overflow

(defn another-factorial [x]
  (defn inner-factorial [y acc]
    (if (<= y 1)
      acc
      (recur (dec y) (*' acc y))))
  (inner-factorial x 1))

(another-factorial 999)

;; now let's do another factor and turn the original function to use multi arity
;; basically turn the inner function is the same function with different arity
(defn tail-rec-factorial
  ([x] (tail-rec-factorial x 1))
  ([x acc] (
            if (<= x 1) 
            acc
            (recur (dec x) (*' acc x)))))

(tail-rec-factorial 999)


