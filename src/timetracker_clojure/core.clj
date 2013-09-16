(ns timetracker-clojure.core
  (:require clj-time.local clj-time.core))

(defn getTime
  []
  (clj-time.local/local-now))

(defn start-timer
  []
  (clj-time.local/local-now))

(defn time-interval
  [start-time stop-time]
  (clj-time.core/interval start-time stop-time))
  
  

(defn stop-timer
  [start-time]
  (time-interval start-time (clj-time.local/local-now)))
  

(stop-timer (start-timer))
