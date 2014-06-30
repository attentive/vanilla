(ns {{ns-name}}.web
  (:use compojure.core
        ring.util.response
        [ring.middleware edn json-params file file-info session stacktrace reload])
  (:require compojure.handler
            [taoensso.timbre :as timbre]
            [clojure.core.async :refer [<! >! put! close! go-loop]]
            [hiccup.page :refer [html5 include-js include-css]]))

(timbre/refer-timbre)

(defn main-page []
  (html5
    [:head
     [:link {:href "http://fonts.googleapis.com/css?family=Roboto&subset=latin,cyrillic-ext,cyrillic,latin-ext" 
             :rel "stylesheet"
             :type "text/css"}] 
     [:meta {:charset "utf-8"}] 
     [:meta {:name "viewport" :content "width=device-width, initial-scale=1.0"}] 
     [:meta {:name "description" :content "Sudoku solver with websocket bindigns"}]
     [:title "{{ns-name}}"]
     (include-css "/css/bootstrap.min.css")
     (include-css "/css/bootstrap-custom.css")]

    [:body 
     
     [:div.container-fluid [:div#main.jumbotron [:h1 "Hello World!"]]]

     (include-js "http://code.jquery.com/jquery.js")
     (include-js "/js/bootstrap.min.js")
     (include-js "/js/history.js")
     (include-js "http://fb.me/react-0.10.0.js")
     (include-js "http://d3js.org/d3.v3.min.js")
     (include-js "/js/out/goog/base.js")
     (include-js "/js/main.js")
     [:script {:type "text/javascript"} "goog.require(\"{{ns-name}}.core\")"]]))

(defroutes {{ns-name}}-routes
  ; Main page
  (GET "/{{ns-name}}" req
       (response (main-page))))

(def {{ns-name}}-app
  (-> {{ns-name}}-routes
      ; Need to use "api", not "site" handler to avoid clobbering session by 
      ; double application of wrap-session middleware
      compojure.handler/api
      (wrap-json-params)
      (wrap-edn-params)
      (wrap-file "resources/public")
      (wrap-file-info)))

