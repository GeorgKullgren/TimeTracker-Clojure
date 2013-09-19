(ns timetracker-clojure.core-test
  (:require [timetracker-clojure.core :refer :all])
  (:use [midje.sweet]))

(fact "Start timer returns current time"
      (start-timer) => 4
      (provided
       (getTime) => 4))

(fact "Stop running timer returns elapsed time 50"
      (start-timer) => 5
      (provided
       (getTime) => 5)
      (stop-timer truthy) => 55
      (provided
       (getTime) => 7
       (time-interval truthy truthy) => 55))

(fact "Create named timer returns named-timer"
      (create-named-timer "myTimer") => (contains (:name "myTimer")))

(fact "Stop named timer returns elapsed time 40"
      (create-named-timer "myTimer") => (contains (:name "myTimer"))
      (stop-named-timer ..timer..) => 40
      (provided ..timer.. =contains=> {:timer-name "myTimer", :start-time 2}
                (getTime) => 7
                (time-interval truthy truthy) => 40))
