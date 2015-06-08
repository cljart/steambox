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

(def _ false)
(def x true)

;; grid
(def ^:dynamic *grid*
  {
   kick  [ x _ _ _ x _ _ _ ]
   snare [ _ _ x _ _ _ x _ ]
   hihat [ x x x x x x x x ]})

(defn play-beat [beat]
  (hihat)
  (case beat
    0 (kick)
    1 (hi-tom)
    2 (snare)
    3 (lo-tom)
    4 (do
        (kick)
        )
    5 (kick)
    6 (do
        (snare)
        )
    7 []))

;; Schedule one bar (eight beats) of drums
;;
(defn bar-scheduler [bar] ;; bar: 1
  (doseq [beat (range 8)] ;; beat: 0 1 2 3 4 5 6 7
    (let [beat-in-bar (+ (* bar 8) beat) ;;
                                         ;; beat-in-bar: 8 9 10 11 12 13 14 15
          time (metro beat-in-bar)]      ;; time: ...ms ...ms ...ms
      (apply-at time play-beat [beat])))

  (let [beat-8 (+ (* bar 8) 8)
        beat-8-time (metro beat-8)]
    (apply-by beat-8-time bar-scheduler [(+ bar 1)])))

(comment
  (do (def metro (metronome 220))
      (bar-scheduler 0))

  (stop))


(defn -main
  "Start Steambox!"
  [& args]
  (doseq [bar (range 10)]
    (bar-scheduler bar)))

(defn rimshot []
  (lo-tom)
  (java.lang.Thread/sleep 160)
  (hi-tom)
  (java.lang.Thread/sleep 380)
  (crash))

;; (rimshot)


;; Next steps:
;;
;; - [DONE] make beat-scheduler reschedule itself for the next bar
;; - replace hard-coded grid with something in a var or atom
;; - build a GUI
;; - profit
;;
