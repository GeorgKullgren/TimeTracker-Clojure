(ns timetracker-clojure.core
  (:require clj-time.local clj-time.core))

(defn getTime
  []
  (clj-time.local/local-now))

(defn start-timer
  []
  (getTime))

(defn time-interval
  [start-time stop-time]
  (clj-time.core/in-seconds (clj-time.core/interval start-time stop-time)))
  

(defn stop-timer
  [start-time]
  (time-interval start-time (getTime)))

(defrecord named-timer-record [name start-time spent-time])
  
(defn create-named-timer
  [timer-name]
  (named-timer-record. timer-name (start-timer) 0))

(defn stop-named-timer
  [timer]
  (stop-timer (:start-time timer)))

(stop-timer (start-timer))

(defn -main
  []
  (create-named-timer "myTimer"))



