(defproject steambox "0.1.0-SNAPSHOT"
  :description "Drum computer with Overtone and Quil"
  :url "https://github.com/cljart/steambox"
  :license {:name "GNU General Public License version 3"
            :url "http://www.gnu.org/licenses/gpl-3.0.en.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [overtone "0.9.1"]
                 [quil "2.2.5"]]
  :main ^:skip-aot steambox.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
