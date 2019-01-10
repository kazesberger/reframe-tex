(ns reframe-tex.views
  (:require
   [re-frame.core :as re-frame]
   [reframe-tex.subs :as subs]
   [reframe-tex.events :as events]))

(defn demo-input []
  (let [name (re-frame/subscribe [::subs/name])]
    [:input {:placeholder "your name goes here"
             :type        "text"
             :value @name
             :on-change   #(re-frame/dispatch [::events/name-change (-> % .-target .-value)])}]))

(defn main-panel []
  (let [name (re-frame/subscribe [::subs/name])]
    [:div
     [:h1 "Hello from " @name]
     [demo-input]]))

