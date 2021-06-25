(ns binblo.core
  (:require [clojure.tools.cli :refer [parse-opts]]
            [clojure.pprint :refer [pprint]])
  (:gen-class))

(defn -main
  [& args]
  (let [args (first (:arguments (parse-opts args [])))]
    (eval (read-string args))))
