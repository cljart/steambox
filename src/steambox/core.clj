(ns steambox.core
  (:require [overtone.live :refer :all]
            [clojure.java.io :as io])
  (:gen-class))

(defn resource-sample [name]
  (sample (.getPath (io/resource name))))


(def cowbell (resource-sample "cowbell_FF_1.wav"))
(def crash (resource-sample "crash1_OH_FF_1.wav"))
(def hihat (resource-sample "hihatClosed_OH_F_1.wav"))
(def hi-tom (resource-sample "hiTom_OH_FF_1.wav"))
(def kick (resource-sample "kick_OH_F_1.wav"))
(def lo-tom (resource-sample "loTom_OH_FF_1.wav"))
(def ride (resource-sample "ride1_OH_FF_1.wav"))
(def snare (resource-sample "snare_OH_F_1.wav"))


(defn -main
  "Start Steambox!"
  [& args]
  (println "Welcome to Steambox *madly waves drum sticks*!"))
