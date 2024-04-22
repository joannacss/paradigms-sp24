(def temperatures [69 73 69 68 70 71 68 72 67 71 71 64 65 71 66 71 70 76 73 67 66 71 72 71 63 71 71 75 71 72])
; Continue code here
;; (def average (double (/ (reduce + temperatures)  (count temperatures))))
(defn avg [p] (double (/ (reduce + p)  (count p))))
(println "min = " (apply min temperatures))
(println "max = " (apply max temperatures))
(println "average = " (avg temperatures))