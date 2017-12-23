#!/usr/bin/env clj

(require '[sparkledriver.browser :refer [with-browser make-browser fetch!]])
(require '[sparkledriver.element :refer [find-by-xpath* find-by-css* text]])

(def location (first *command-line-args*))

(when-not location
  (println "Call like this: clj tablizer.clj <url>")
  (System/exit 1))

;; Swallow STDERR because jBrowserDriver is noisy as heck.
(System/setErr (java.io.PrintStream. (java.io.ByteArrayOutputStream.)))

(defn parse-table [table]
  (for [row (find-by-css* table "tr")]
    (map (comp clojure.string/trim text) (find-by-css* row "td, th"))))

(defn col-widths [tdata]
  (map (fn [i]
         (apply max (map (comp count #(nth % i [])) tdata)))
       (range (apply max (map count tdata)))))

(defn print-table [table]
  (let [tdata (parse-table table)
        widths (col-widths tdata)]
    (doseq [row tdata]
      (println
       (str (clojure.string/join
             " "
             (map (fn [cell width]
                    (format (str "| %-" width "s") cell))
                  row widths)) " |")))
    (println)))

(with-browser [browser (make-browser)]
  (let [tables (-> (fetch! browser location)
                   (find-by-xpath* "//table"))]
    (run! print-table tables)))
