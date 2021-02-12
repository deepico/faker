(ns faker.random
  (:refer-clojure :exclude [rand rand-nth rand-int])
  (:require [clojure.data.generators :as gen]))

(def rand-nth gen/rand-nth)

(defn rand-int [n] (gen/uniform 0 n))

(defn rand [] (gen/float))

(defmacro with-rand-seed
  [seed & body]
  `(binding [gen/*rnd* (java.util.Random. ~seed)]
     ~@body))
