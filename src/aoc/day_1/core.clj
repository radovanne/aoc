(ns aoc.day-1.core)

(defn floor-increment [chr acc]
  (case chr
    \( (inc acc)
    \) (dec acc)
    \n acc))

(defn calc-floor [data-path]
  (let [data (slurp data-path)]
    (loop [[chr & rst] data
           floor 0]
      (if (empty? rst)
        {:floor floor}
        (recur rst (floor-increment chr floor))))))

(defn find-basement-position [data-path]
  (let [data (slurp data-path)]
    (loop [[chr & rst] data
           floor 0
           pos 0]
      (cond
        (= -1 floor) {:pos pos}
        (empty? data) {:floor floor
                       :pos pos
                       :msg "No basement for Santa today."}
        :else (recur rst (floor-increment chr floor) (inc pos))))))

(comment
  (calc-floor "src/aoc/day_1/input_1.txt")
  (find-basement-position "src/aoc/day_1/input_1.txt"))


