(ns playground.main
  (:require [playground.lib :as lib]
            [clojure.string :as str])
  (:import [java.util UUID]))

(defn -main []
  (println
   (UUID/randomUUID)
   (str/join ["hi" "mate"])
   (lib/add-all 2 5 6)))