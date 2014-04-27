(ns qbits.alia.uuid
  (:require [clojure.core.typed :as T])
  (:import
   (java.util UUID)
   (com.datastax.driver.core.utils UUIDs)))

(T/ann ^:no-check time-based [-> UUID])
(defn time-based
  "Creates a new time-based (version 1) UUID."
  []
  (UUIDs/timeBased))

(T/ann ^:no-check start-of [Number -> UUID])
(defn start-of
  "Creates a 'fake' time-based UUID that sorts as the smallest
  possible version 1 UUID generated at the provided timestamp."
  [ts]
  (UUIDs/startOf (long ts)))

(T/ann ^:no-check end-of [Number -> UUID])
(defn end-of
  "Creates a 'fake' time-based UUID that sorts as the biggest possible
  version 1 UUID generated at the provided timestamp."
  [ts]
  (UUIDs/endOf (long ts)))

(T/ann ^:no-check unix-timestamp [UUID -> Long])
(defn unix-timestamp
  "Return the unix timestamp contained by the provided time-based UUID."
  [uuid]
  (UUIDs/unixTimestamp uuid))

(T/ann ^:no-check random [-> UUID])
(defn random
  "Creates a new random (version 4) UUID."
  []
  (UUIDs/random))
