(require '[clojure.tools.nrepl.server :refer [start-server]])

(let [port (or (some-> (first *command-line-args*)
                       (java.lang.Long/parseLong))
               7888)]
  (start-server :port port)
  (println "Started nREPL on port" port))
