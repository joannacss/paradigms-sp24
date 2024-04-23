; hardcodes the file path to the CSV
(def filepath "./data/temperatures.csv")

; parse into rows using slup and str/split by new lines #"\n"
(def rows (clojure.string/split (slurp filepath) #"\n"))

; discard header using the `rest` function
(def rows (rest rows))
(def rows (map (fn [x] (Float/parseFloat x)) rows))
; Continue code here
(defn avg [p] (double (/ (reduce + p)  (count p))))
(println "min = " (apply min rows))
(println "max = " (apply max rows))
(println "average = " (avg rows))