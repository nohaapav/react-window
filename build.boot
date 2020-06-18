(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]
                 [cljsjs/react "16.8.6-0"]
                 [cljsjs/react-dom "16.8.6-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.8.5")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom {:project     'cljsjs/react-window
      :version     +version+
      :description "React components for efficiently rendering large lists and tabular data"
      :url         "https://react-window.now.sh/"
      :scm         {:url "https://github.com/bvaughn/react-window"}
      :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (run-commands :commands [["npm" "install" "--include-dev"]
                            ["npm" "run" "build:dev"]
                            ["npm" "run" "build:prod"]
                            ["rm" "-rf" "./node_modules"]])
   (sift :move {#".*react-window.inc.js"     "cljsjs/react-window/development/react-window.inc.js"
                #".*react-window.min.inc.js" "cljsjs/react-window/production/react-window.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :foreign-libs [{:file           #"react-window.inc.js"
                              :file-min       #"react-window.min.inc.js"
                              :provides       ["react-window"
                                               "react-window-infinite-loader"
                                               "react-virtualized-auto-sizer"]
                              :global-exports '{"react-window"                     ReactWindow
                                                "react-window-infinite-loader"     ReactWindowInfiniteLoader
                                                "react-virtualized-auto-sizer"     ReactVirtualizedAutoSizer}
                              :requires       ["react" "react-dom"]}]
              :externs [#"react-window.ext.js"])
   (pom)
   (jar)
   (validate-checksums)))