;;;; This file is part of algebolic. Copyright (C) 2014-, Jony Hudson.
;;;;
;;;; Not for distribution.

(ns algebolic.utility.random
  "Random number generators and associated functions. These mirror the functions in clojure.core, but
  use java's ThreadLocalRandom which works well with multi-threading."
  (:refer-clojure :exclude [rand rand-int rand-nth])
  (:import java.util.concurrent.ThreadLocalRandom))

(defn- nextDouble
  []
  (.nextDouble (ThreadLocalRandom/current)))

(defn rand
  ([] (nextDouble))
  ([n] (* n (rand))))

(defn rand-int
  [n]
  (int (rand n)))

(defn rand-nth
  [l]
  (nth l (rand-int (count l))))