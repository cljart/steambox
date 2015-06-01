(ns steambox.core
  (:gen-class)
  (:require [overtone.live :refer :all]
            [clojure.java.io :as io]))

(defn resource-sample [name]
  (sample (.getPath (io/resource name))))

(def kick (resource-sample "kick_OH_F_1.wav"))
(def snare (resource-sample "snare_OH_F_1.wav"))
(def hihat (resource-sample "hihatClosed_OH_F_1.wav"))
(def hi-tom (resource-sample "hiTom_OH_FF_1.wav"))
(def lo-tom (resource-sample "loTom_OH_FF_1.wav"))
(def cowbell (resource-sample "cowbell_FF_1.wav"))
(def crash (resource-sample "crash1_OH_FF_1.wav"))
(def ride (resource-sample "ride1_OH_FF_1.wav"))


;; metronome
(def metro (metronome 180))

;; grid

(defn play-beat [beat]
  ;;(hihat)
  (case beat
    0 (kick)
    1 []
    2 (snare)
    3 []
    4 (do
        (kick)
        (cowbell))
    5 (kick)
    6 (do
        (snare)
        (crash))
    7 []))

(defn beat-scheduler [bar]
  (doseq [beat (range 8)]
    (let [time (metro (+ (* bar 8) beat))]
      (apply-by time play-beat [beat]))))

(defn -main
  "Start Steambox!"
  [& args]
  (doseq [bar (range 1 10)]
    (beat-scheduler bar)))

(defn rimshot []
  (lo-tom)
  (java.lang.Thread/sleep 160)
  (hi-tom)
  (java.lang.Thread/sleep 380)
  (crash))

;; (rimshot)


;; Next steps:
;;
;; - make beat-scheduler reschedule itself for the next bar
;; - replace hard-coded grid with something in a var or atom
;; - build a GUI
;; - profit
;;
