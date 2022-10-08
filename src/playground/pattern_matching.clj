(ns playground.pattern-matching)

(require '[clojure.core.match :refer [match]])
(+ 3 4)

(doseq [n (range 1 101)]
  (println
   (match [(mod n 3) (mod n 5)]
     [0 0] "FizzBuzz"
     [0 _] "Fizz"
     [_ 0] "Buzz"
     :else n)))

;;---

(derive ::red ::traffic-lights)
(derive ::yellow ::traffic-lights)
(derive ::green ::traffic-lights)

;; Check parents
(parents ::red)
(descendants ::traffic-lights)

;; Variable assignment
(def currentlyOn ::green)


(match [currentlyOn]
  [::red] "it is red"
  [::yellow] "it is yellow"
  [::green] "it is green"
  :else "whoops")
