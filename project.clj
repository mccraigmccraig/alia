(def driver-version "2.1.7.1")
(defproject mccraigmccraig/alia "2.7.2.1"
  :description "Cassandra CQL3 client for Clojure - datastax/java-driver wrapper"
  :url "https://github.com/mpenet/alia"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [org.clojure/core.memoize "0.5.6"
                  :exclusions [org.clojure/core.cache]]
                 [org.clojure/core.cache "0.6.4"]
                 [cc.qbits/commons "0.4.2"]
                 [cc.qbits/hayt "3.0.0-rc1"]
                 [com.datastax.cassandra/cassandra-driver-core ~driver-version
                  :classifier "shaded"
                  :exclusions [io.netty/*]]
                 [com.datastax.cassandra/cassandra-driver-dse ~driver-version
                  :exclusions [io.netty/*]]
                 [org.clojure/core.async "0.1.346.0-17112a-alpha"]]
  :profiles {:1.4  {:dependencies [[org.clojure/clojure "1.4.0"]]}
             :1.5  {:dependencies [[org.clojure/clojure "1.5.1"]]}
             :1.6  {:dependencies [[org.clojure/clojure "1.6.0"]]}
             :1.8  {:dependencies [[org.clojure/clojure "1.8.0-SNAPSHOT"]]}
             :dev  {:dependencies [[org.xerial.snappy/snappy-java "1.0.5"]
                                   [net.jpountz.lz4/lz4 "1.2.0"]
                                   [clj-time "0.8.0"]
                                   [com.taoensso/nippy "2.9.0"]
                                   [cc.qbits/tardis "1.0.0"]
                                   [codox "0.8.10"]
                                   [manifold "0.1.1-alpha3"]
                                   [org.slf4j/slf4j-log4j12 "1.7.3"]]}}
  :jar-exclusions [#"log4j.properties"]
  :codox {:src-dir-uri "https://github.com/mpenet/alia/blob/master/"
          :src-linenum-anchor-prefix "L"
          :defaults {:doc/format :markdown}
          :exclude [qbits.alia.enum
                    qbits.alia.utils
                    qbits.alia.codec
                    qbits.alia.codec.udt
                    qbits.alia.codec.tuple
                    qbits.alia.cluster-options]}
  :global-vars {*warn-on-reflection* true})
