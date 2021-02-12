(ns faker.name
  "Create fake data for person names"
  (:refer-clojure :exclude [rand rand-nth rand-int])
  (:require [faker.random :refer [rand rand-nth rand-int]]
            [clojure.string :refer [join]]
            [faker.name-data :as nd]))

(defn first-name
  "Create a fake person first name"
  []
  (rand-nth nd/first-names))

(defn last-name
  "Create a fake person last name"
  []
  (rand-nth nd/last-names))

(defn prefix
  "Create a fake person prefix, like in Mr., Mrs., etc."
  []
  (rand-nth nd/prefixes))

(defn suffix
  "Create a fake person suffix, like in Jr., Sr., etc."
  []
  (rand-nth nd/suffixes))

(defn- comb [& funs]
  (fn [] (join " " (map #(%) funs))))

(def ^{:private true} format-probs
  [[(comb prefix first-name last-name) 0.1]
   [(comb first-name last-name suffix) 0.2]
   [(comb first-name last-name) 1]])

(defn one-name []
  (let [p (rand)]
    (some #(and (> (last %) p)
                ((first %)))
          format-probs)))

(defn names
  "Sequence of `n` random names"
  [n]
  (doall
    (repeatedly n one-name)))
