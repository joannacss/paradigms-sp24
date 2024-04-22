(def temperatures [69 73 69 68 70 71 68 72 67 71 71 64 65 71 66 71 70 76 73 67 66 71 72 71 63 71 71 75 71 72])
;; TODO: print min
(println (apply min temperatures))
;; TODO: print max
(println (apply max temperatures))
;; TODO: print average
(defn avg [array] (double (/ (reduce + array) (count array))))
(println (avg temperatures))