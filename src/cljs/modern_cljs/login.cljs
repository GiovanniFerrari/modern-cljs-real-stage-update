;;; namespace declaration
(ns modern-cljs.login
  (:require [domina.core :refer [by-id value]]
            [domina.events :refer [listen! prevent-default]]))


(defn validate-form [e]
  (if (or (empty? (value (by-id "email")))
          (empty? (value (by-id "password"))))
    (do
      (prevent-default e)
      (js/alert "Please, complete the form!"))
    true))

;;; init
(defn ^:export init []
  (if (and js/document
           (aget js/document "getElementById"))
    (listen! (by-id "submit") :click (fn [e] (validate-form e)))))
