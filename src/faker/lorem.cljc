(ns faker.lorem
  "Create fake textual data"
  (:refer-clojure :exclude [rand-nth rand-int])
  (:require [faker.random :refer [rand-nth rand-int]]
            [clojure.string :refer [join capitalize]]
            [faker.lorem-data :as ld]))

(defn words
  "Lazy sequence of random latin words"
  [n]
  (doall
    (repeatedly n #(rand-nth ld/latin-words))))

(defn sentences
  "Lazy sequence of random latin sentences.

  (sentences 5) will generate a sequence of random sentences between
  5 and 5 + 5 words.
  (sentences) will generate random sentences between 4 and 4 + 5 words."
  ([n] (sentences n 4))
  ([n word-count]
   (doall
     (map
       (fn [wc]
         (str (capitalize (join " " (words wc))) "."))
       (repeatedly n #(+ word-count (rand-int 6)))))))

(defn paragraphs
  "Sequence of random latin paragraphs.

  (paragraphs 5) will generate a sequence of random paragraphs between
  5 and 5 + 2 sentences.
  (paragraphs) will generate random paragraphs between 3 and 3 + 2 sentences"
  ([n] (paragraphs n 3))
  ([n sentence-count]
   (doall
     (map
       (fn [sc]
         (join " " (sentences sc)))
       (repeatedly n #(+ sentence-count (rand-int 3)))))))
