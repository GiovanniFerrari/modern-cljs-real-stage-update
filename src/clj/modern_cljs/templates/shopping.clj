(ns modern-cljs.templates.shopping
  (:require [net.cgrand.enlive-html :refer [deftemplate set-attr]]
            [modern-cljs.remotes :refer [calculate]]
            ;; added the requirement for the form validators
            [modern-cljs.shopping.validators :refer [validate-shopping-form]]))

;; template renamed
(deftemplate update-shopping-form "shopping.html"
  [quantity price tax discount errors] ; added errors argument
  [:#quantity] (set-attr :value quantity)
  [:#price] (set-attr :value price)
  [:#tax] (set-attr :value tax)
  [:#discount] (set-attr :value discount)
  [:#total] (set-attr :value
                      (format "%.2f" (double (calculate quantity price tax discount)))))

;; new intermediate function
(defn shopping [q p t d]
  (update-shopping-form q p t d (validate-shopping-form q p t d)))
