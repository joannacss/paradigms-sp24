(require '[clojure.string :as str])


; hardcodes the file path to the CSV
(def filepath "./data/city_temperatures.csv")

; parse into rows using slup and str/split by new lines #"\n"
(def rows (str/split (slurp filepath) #"\n"))

; discard header using the `rest` function
(def rows (rest rows))


; declare a function `parse-row` returns a map that is like this:
; {"city" (temperature)}



; map from a list of rows to {Los Angeles (70.5), Honolulu (80.3), South Bend (55.8), Los Angeles (71.2), Honolulu (81), South Bend (54.5),...}
; store in a variable `mapped_rows`




; use the `reduce` function to merge temperatures by city
; goal is to create a map that looks like this:
; {"Los Angeles" (70.5 71.2 ...), "Honolulu" (80.3 81.0 ...), "South Bend" (55.8 54.5 ...)}
; store it on a variable `temperatures_map`


; reducer function that takes `e1` `e2` and updates `e1` with what is in `e2`


; merge two maps



; Average function
(defn avg [p] (double (/ (reduce + p)  (count p))))


; Use `for` to compute the statistics per city
(println "Statistics temperatures per city")
(println 		(for [[city temperatures] temperatures_map]
					 {city 
					 		{"min" (apply min temperatures) "max" (apply max temperatures) "avg" (avg temperatures)}
						} ))

