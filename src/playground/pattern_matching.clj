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

;; -----------------------
;; Sum type pattern matching e.g. traffic light

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

;; -----------------------
;; Product type pattern matching

(defrecord Student [name grade])
(def jack (Student. "Jack" "A"))
(:name jack)
(type jack)

(defrecord Teacher [name subject])
(def jill (Teacher. "Jill" "Math"))
(:name jill)
(class jill)

;; It's based on the structure
(match [jill]
  [{:name %}] (str "the name is " %)
  [{:grade %}] (str "the grade is " %)
  :else "no name")

;; For some reason this doesn't work
;; (match [(type jack)]
;;   [Teacher] "teacher"
;;   :else "no match")

;; Or you can try to match the type
(let [teacher Teacher]
  (match [(type jack)]
    [teacher] "teacher"
    :else "not teacher"))

