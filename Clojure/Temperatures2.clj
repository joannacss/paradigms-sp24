; DEMO: reading from command line arguments (*command-line-args*)
(defn myMapping  [x] (Integer/parseInt x))
;; (map (fn [x] (Integer/parseInt x)) *command-line-args*)
(def temperatures (map myMapping *command-line-args*))

; Continue code here
(defn avg [p] (double (/ (reduce + p)  (count p))))
(println "min = " (apply min temperatures))
(println "max = " (apply max temperatures))
(println "average = " (avg temperatures))