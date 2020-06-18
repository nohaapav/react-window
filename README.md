# cljsjs/react-window

Clojure react-window package for efficiently rendering large lists and tabular data 

react-window.now.sh

## Packages

* react-window [1.8.5]
* react-window-infinite-loader [1.0.5]
* react-virtualized-auto-sizer [1.0.2]

## Setup

To use cljsjs package from local project repo do following:

1. In `project.clj` setup local repository
```
:repositories {"local" "file:repo"}
```

2. Build package
```
boot package install target
```

3. Deploy `.jar` archive to local project repo e.g.
```
mvn deploy:deploy-file -Dfile=react-window-1.8.5-0.jar -DartifactId=react-window -Dversion=1.8.5-0 -DgroupId=cljsjs -Dpackaging=jar -Durl=file:repo
```

4. Finally add dependency to your maven repository
```
lein deps
```

## Usage

[](dependency)
```clojure
[cljsjs/react-window "1.8.5-0"]
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require ["react-window"]
            ["react-window-infinite-loader"]
            ["react-virtualized-auto-sizer"]))
```

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps

