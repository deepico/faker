(ns faker.company
  "Create fake company data"
  (:refer-clojure :exclude [rand-nth rand-int])
  (:require [faker.random :refer [rand-nth rand-int]]
            [faker.name :as fkname]
            [clojure.string :refer [join]]
            [faker.company-data :as cd]))

(defn suffix
  "Return a random company suffix, like Inc or Group."
  []
  (rand-nth cd/suffixes))

(defn- phrase [source]
  (join " " (map #(rand-nth %) source)))

(defn catch-phrase
  "Return a random company catch phrase."
  []
  (phrase cd/catch-phrase-words))

(defn bs
  "Return random company BS goals."
  []
  (phrase cd/bs-words))

(def ^{:private true} formats
  [#(str (first (fkname/names 1)) " " (suffix))
   #(str (fkname/last-name) "-" (fkname/last-name))
   #(format "%s, %s and %s" (fkname/last-name) (fkname/last-name) (fkname/last-name))])

(defn names [n]
  "seq of `n` random company names"
  (doall
    (repeatedly n
      (fn []
        ((rand-nth formats))))))
