(ns binblo.core
  (:require [clojure.tools.cli :refer [parse-opts]]
            [selmer.parser :as parser]
            [clojure.edn :as edn])
  (:gen-class))

(defn load-edn! [data]
  (edn/read-string data))

(defn render-template! [template data]
  (parser/render template data))

(def cli-options
  [["-d" "--data DATA" "template data"
    :parse-fn #(load-edn! %)
    :validate [#(map? %) "must be in Clojure hash-map format:
                          https://clojuredocs.org/clojure.core/hash-map"]]
   ["-t" "--template TEMPLATE" "template"]
   ["-h" "--help"]])

(defn -main
  [& args]
  (let [parsed-options (parse-opts args cli-options)
        _arguments (:arguments parsed-options)
        options (:options parsed-options)]
    (println (render-template! (:template options) (:data options)))))

(comment
  
  (-main "-d" "{:a 1}" "{:b 2}" "-t" "hello {{a}}")
  
  )