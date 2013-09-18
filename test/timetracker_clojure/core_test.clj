(ns timetracker-clojure.core-test
  (:require [timetracker-clojure.core :refer :all])
  (:use [midje.sweet]))

(fact "Should return current time"
      (start-timer) => 4
      (provided
       (getTime) => 4))


