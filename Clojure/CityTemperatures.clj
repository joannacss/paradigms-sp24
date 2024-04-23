(require '[clojure.string :as str])


; hardcodes the file path to the CSV
(def filepath "./data/city_temperatures2.csv")

; parse into rows using slup and str/split by new lines #"\n"
(def rows (str/split (slurp filepath) #"\n"))

; discard header using the `rest` function
(def rows (rest rows))


; parse each row and return a map that is like this:
; {"Honolulu" (temp) "Los Angeles" '(list of temps) "South Bend" '(list of temps)}
(defn parse-row [row]
  (let [column (clojure.string/split row #",")
  						city (get column 0)
  						temperature (Float/parseFloat (get column 1))
  					]
  					{city (list temperature)}  					
  	)
)
; map from a list of rows to {Los Angeles (70.5), Honolulu (80.3), South Bend (55.8 54.5)}
(def mapped_rows (map parse-row rows))
; (println mapped_rows)



(defn map-merger [x y] (concat (or  x '()) y))


(defn city-reducer [e1 e2]
			(let [e2_city (key (first e2))
									e2_temp (val (first e2))] 
									(update e1 e2_city map-merger e2_temp)
			)
)

; Creates a map that looks like this:
; {Los Angeles (70.5 71.2), Honolulu (80.3 81.0), South Bend (55.8 54.5)}
(def temperatures_map (reduce city-reducer mapped_rows))
(defn avg [p] (double (/ (reduce + p)  (count p))))
(println temperatures_map)

(println "Statistics temperatures per city")
(println 		(for [[city temperatures] temperatures_map]
					 {city 
					 		{"min" (apply min temperatures) "max" (apply max temperatures) "avg" (avg temperatures)}
						} ))

