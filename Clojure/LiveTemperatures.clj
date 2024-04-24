; hardcodes the file path to the CSV
(def filepath "./data/temperatures.csv")

; parse into rows using slup and str/split by new lines #"\n"

; discard header using the `rest` function

; use `map` to make it a collection of floating point numbers

; define `avg` function that computes the average


; print metrics
; (println "min = " (apply min rows))
; (println "max = " (apply max rows))
; (println "average = " (avg rows))