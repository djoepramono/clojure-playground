(ns playground.main
  (:require [playground.lib :as lib]
            [clojure.string :as str])
  (:import [java.util UUID]))

;; this main function can be executed from command line via
;; clj -M -m playground.main
;; -M means use clojure.main to execute code
;; -m means where to find `-main` function

;; alternative this can be set as an alias

(defn -main []
  (println 
   (str/join ["event-id: " (UUID/randomUUID)])
   (lib/add-all 2 5 6)))