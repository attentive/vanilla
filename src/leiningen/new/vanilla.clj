(ns leiningen.new.vanilla
  (:use [leiningen.new.templates :only [renderer name-to-path sanitize-ns ->files]]))

(def render (renderer "vanilla"))

(defn vanilla
  [name]
  (let [data {:name name
              :ns-name (sanitize-ns name)
              :sanitized (name-to-path name)}]
    (->files data ["project.clj" (render "project.clj" data)]
["dev/user.clj" (render "user.clj" data)]
["src/clj/{{sanitized}}/core.clj" (render "core.clj" data)]
["src/clj/{{sanitized}}/response.clj" (render "response.clj" data)]
["src/clj/{{sanitized}}/web.clj" (render "web.clj" data)]
["resources/public/fonts/glyphicons-halflings-regular.woff" (render "glyphicons_halflings_regular.woff")]
["resources/public/fonts/glyphicons-halflings-regular.eot" (render "glyphicons_halflings_regular.eot")]
["resources/public/js/history.js" (render "history.js")]
["resources/public/app/fonts/glyphicons-halflings-regular.svg" (render "glyphicons_halflings_regular.svg")]
["resources/public/app/fonts/glyphicons-halflings-regular.ttf" (render "glyphicons_halflings_regular.ttf")]
["resources/public/app/fonts/glyphicons-halflings-regular.eot" (render "glyphicons_halflings_regular.eot")]
["resources/public/img/glyphicons-halflings-white.png" (render "glyphicons_halflings_white.png")]
["resources/public/css/bootstrap-custom.css" (render "bootstrap_custom.css")]
["resources/public/app/fonts/glyphicons-halflings-regular.woff" (render "glyphicons_halflings_regular.woff")]
["resources/public/css/bootstrap-theme.css" (render "bootstrap_theme.css")]
["resources/public/img/glyphicons-halflings.png" (render "glyphicons_halflings.png")]
["resources/public/css/bootstrap-responsive.css" (render "bootstrap_responsive.css")]
["resources/public/css/bootstrap-theme.min.css" (render "bootstrap_theme.min.css")]
["resources/public/css/bootstrap.css" (render "bootstrap.css")]
["resources/public/css/bootstrap-responsive.min.css" (render "bootstrap_responsive.min.css")]
["resources/public/css/bootstrap.min.css" (render "bootstrap.min.css")]
["resources/public/fonts/glyphicons-halflings-regular.svg" (render "glyphicons_halflings_regular.svg")]
["resources/public/fonts/glyphicons-halflings-regular.ttf" (render "glyphicons_halflings_regular.ttf")]
)))
