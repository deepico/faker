(ns faker.phone-number
  "Generate fake phone numbers."
  (:refer-clojure :exclude [rand-nth rand-int])
  (:require [faker.random :refer [rand-nth rand-int]]
            [clojure.string :as string]))

(def ^{:private true} formats
  ["###-###-####",
   "(###)###-####",
   "1-###-###-####",
   "###.###.####",
   "###-###-####",
   "(###)###-####",
   "1-###-###-####",
   "###.###.####",
   "###-###-#### x###",
   "(###)###-#### x###",
   "1-###-###-#### x###",
   "###.###.#### x###",
   "###-###-#### x####",
   "(###)###-#### x####",
   "1-###-###-#### x####",
   "###.###.#### x####",
   "###-###-#### x#####",
   "(###)###-#### x#####",
   "1-###-###-#### x#####",
   "###.###.#### x#####"])

(defn phone-number []
  (string/replace (rand-nth formats)
                  #"#"
                  (fn [_] (str (rand-int 10)))))

(defn phone-numbers [n]
  "Sequence of `n` random phone numbers."
  (doall
    (repeatedly n phone-number)))
