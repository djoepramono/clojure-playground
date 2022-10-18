(ns playground.lib 
  (:require [clojure.string :as str]))

;; this function can be run from the command line via
;; clj -X playground.lib/greetings :name "Bob"
(defn greetings [x]
  (println
   (str/join ["Greetings " (:name x)] )))

;; this next function, however, cannot be run via -X
;; because -X expects the argument to be a hash map
(defn add-all
  ([a b]
   (+ a b))
  ([a b c]
   (+ a b c)))