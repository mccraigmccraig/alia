(def alia-version "4.0.0-beta3")
(def clj-version "1.9.0-alpha14")
(defproject mccraigmccraig/alia-manifold alia-version
  :url "https://github.com/mpenet/alia"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure ~clj-version]
                 [cc.qbits/alia ~alia-version]
                 [manifold "0.1.5"]]
  :global-vars {*warn-on-reflection* true})
