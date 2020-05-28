(ns fullstack.main
  (:require [goog.dom :as gdom]
            [reagent.dom :as dom]))

(defn simple-component []
  [:div
   [:p "I am a component!"]
   [:p.someclass
    "I have " [:strong "bold"]
    [:span {:style {:color "red"}} " and red "] "text."]])

(dom/render [simple-component] (gdom/getElement "app"))

; evaluate via Vim-Fireplace with `cpp`
; (.log js/console "Hello from fullstack.main!")
