(require '[clojure.string :as str])


; hardcodes the file path to the CSV
(def filepath "./data/city_temperatures2.csv")

; parse into rows using str/split
(def rows (str/split (slurp filepath) #"\n"))

; discard header using the `rest` function
(def rows (rest rows))


; parse each row and return a map that is like this:
; {"Honolulu" (list of temps) "Los Angeles" '(list of temps) "Angela" '(list of temps)}
(defn parse-row [row temps_map]
  (let [column (clojure.string/split row #",")
  						city (get column 0)
  						temperature (Float/parseFloat (get column 1))
  					]
  					(assoc temps_map city (conj (get temps_map city '()) temperature))
  	)
)

;;;;; DEBUG ;;;;;
; (def row0 (first rows))
; (println (parse-row row0 {}))



; (def mapped_rows (map (fn [r] (parse-row r {})) rows))
; (println mapped_rows)
; (def mapped_row0 (first mapped_rows))
; (println (get (first {"Los Angeles" '(70.5)}))
; (defn city_reducer [e1 e2] 
; 				(let )
; )
; (reduce my-reducer mapped_rows)

(def entry {"Los Angeles" (70.5)})
(val entry)



; (def data '({"Los Angeles" (70.5)} {"Honolulu" (80.3)} {"South Bend" (55.8)} {"Los Angeles" (71.2)} {"Honolulu" (81.0)} {"South Bend" (54.5)}))

; (defn merge-temps [temp1 temp2]
;   (conj temp1 (second temp2)))

; (defn merge-city-temps [maps]
;   (reduce (fn [acc-map curr-map]
;             (reduce (fn [acc-city-map [city temp]]
;                       (update acc-city-map city merge-temps temp))
;                     acc-map
;                     curr-map))
;           {}
;           maps))

; (println (merge-city-temps data))

;;;;;;;;;;;;;;;
; (println (map (fn [r] (parse-row r {})) rows))
; (defn my-reducer [r1 r2] (parse-row r1 {}))
; (println (reduce my-reducer )