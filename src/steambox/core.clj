(ns steambox.core
  (:require [overtone.live :refer :all]
            [clojure.java.io :as io])
  (:gen-class))

(defn resource-sample [name]
  (sample (.getPath (io/resource name))))


(def cowbell (resource-sample "cowbell_FF_1.wav"))
(def crash1 (resource-sample "crash1_OH_FF_1.wav"))
(def hihatClosed (resource-sample "hihatClosed_OH_F_1.wav"))
(def hiTom (resource-sample "hiTom_OH_FF_1.wav"))
(def kick (resource-sample "kick_OH_F_1.wav"))
(def loTom (resource-sample "loTom_OH_FF_1.wav"))
(def ride1 (resource-sample "ride1_OH_FF_1.wav"))
(def snare (resource-sample "snare_OH_F_1.wav"))


(defn -main
  "Start Steambox!"
  [& args]
  (println "Welcome to Steambox *madly waves drum sticks*!"))
