(ns qbits.alia.enum
  (:require
   [clojure.string :as string]
   [clojure.core.typed :as T])
  (:import
   (com.datastax.driver.core
    ConsistencyLevel
    HostDistance
    ProtocolOptions$Compression
    WriteType)
   (clojure.lang IPersistentMap Keyword)))

(T/def-alias EnumMap (U [Keyword -> Any] (IPersistentMap Keyword Any)))

(T/ann ^:no-check enum-values->map [T/List -> EnumMap])
(defn enum-values->map
  [enum-values]
  (reduce
   (fn [m hd]
     (assoc m (-> (.name ^Enum hd)
                  (.toLowerCase)
                  (string/replace "_" "-")
                  keyword)
            hd))
   {}
   enum-values))

(T/def-alias TWriteType (U ':cas ':batch-log ':counter ':unlogged-batch ':batch
                           ':simple))
(T/ann ^:no-check write-type [TWriteType -> WriteType])
(def write-type (enum-values->map (WriteType/values)))

(T/def-alias TConsistencyLevel (U ':each-quorum ':one ':local-quorum ':quorum
                                  ':three ':all ':serial ':two ':local-serial
                                  ':local-one ':any))
(T/ann ^:no-check consistency-level [TConsistencyLevel -> ConsistencyLevel])
(def consistency-level (enum-values->map (ConsistencyLevel/values)))

(T/def-alias THostDistance (U ':ignored ':remote ':local))
(T/ann ^:no-check host-distance [THostDistance -> HostDistance])
(def host-distance (enum-values->map (HostDistance/values)))

(T/def-alias TCompression (U ':lz4 ':snappy ':none))
(T/ann ^:no-check compression [TCompression -> ProtocolOptions$Compression])
(def compression (enum-values->map (ProtocolOptions$Compression/values)))
