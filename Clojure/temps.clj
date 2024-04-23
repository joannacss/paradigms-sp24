(defn parse-row [row data]
  (let [columns (clojure.string/split row #",")
        city (nth columns 0)
        temperature (Float/parseFloat (nth columns 1))]

    (update data city #(conj (or % []) temperature))))

(defn rows-to-map [rows]
  (reduce #(parse-row %1 %2) {} rows))

;; Example usage:
(let [filepath "./data/city_temperatures.csv"
      rows (clojure.string/split (slurp filepath) #"\n")
      data (rows-to-map rows)]
  (prn data))
