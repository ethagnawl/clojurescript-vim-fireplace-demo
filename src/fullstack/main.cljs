(ns fullstack.main
  (:require [goog.dom :as gdom]
            [reagent.core :as rcore]
            [reagent.dom :as dom]))

(def name_ (rcore/atom "world"))

(defn simple-component []
  [:p "Hello, " @name_ "!"])

(dom/render [simple-component]
            (gdom/getElement "app"))

; evaluate via Vim-Fireplace with `cpp` or `:CljsEval`
; (in-ns 'fullstack.main)
; (.log js/console @name_)
; (reset! name_ "Sarah")
