(ns faker.core-test
  (:use (faker name lorem phone-number internet address))
  (:require [faker.company :as company])
  (:use
     clojure.test
     [clojure.string :only (split)]))

(deftest test-name-generation
  (is (names 1))
  (is (first-name))
  (is (last-name))
  (is (prefix))
  (is (suffix))
  (let [many (map #(split % #" ") (names 10000))
        count-simple (count (filter #(= 2 (count %)) many))]
    (is (and (> count-simple 7000) (< count-simple 9000)))))

(deftest test-lorem-generation
  (is (words 10))
  (is (sentences 10))
  (is (paragraphs 10)))

(deftest test-phone-numbers
  (is (phone-numbers 10)))

(deftest test-company
  (is (company/suffix))
  (is (company/catch-phrase))
  (is (company/bs))
  (is (company/names 10)))

(deftest test-internet
  (is (domain-suffix))
  (is (domain-name))
  (is (domain-word))
  (is (user-name))
  (is (email))
  (is (free-email))
  (is (take 10 emails)))

(deftest test-address
  (is (zip-code))
  (is (us-state))
  (is (us-state-abbr))
  (is (city-prefix))
  (is (city-suffix))
  (is (street-suffix))
  (is (city))
  (is (street-name))
  (is (secondary-address))
  (is (street-address))
  (is (uk-county))
  (is (uk-country))
  (is (uk-postcode)))
