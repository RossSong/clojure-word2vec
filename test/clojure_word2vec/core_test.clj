(ns clojure-word2vec.core-test
  (:require [clojure.test :refer :all]
            [clojure-word2vec.core :refer :all]
            [clojure.java.io :as io]))

(deftest a-test
  (testing "generate a dataset"
    (let [data (create-input-format (io/resource "ulysses.txt"))
          model  (word2vec data)]
    (is (= '("The" "Project" "Gutenberg" "EBook" "of" "Ulysses," "by" "James" "Joyce")
           (first data)))
    (is (= '("all" "were" "so" "this" "one" "him" "like" "And" "I" "as"))
        (get-matches model "woman")))))
