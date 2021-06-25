(defproject binblo "0.1.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.10.2"]
                 [org.clojure/tools.cli "1.0.206"]]
  :main binblo.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}
             :dev {:plugins [[lein-shell "0.5.0"]]}}
  :aliases
  {"native" ["shell"
             "native-image"
             "--report-unsupported-elements-at-runtime"
             "--initialize-at-build-time"
             "--no-server"
             "-jar"
             "./target/uberjar/${:uberjar-name:-${:name}-${:version}-standalone.jar}"
             "-H:Name=./target/${:name}"]})
