# Vim-Fireplace ClojureScript Demo

## What?
This demo shows developers how to interact with a recent version of
the ClojureScript REPL (specifically CLJS >= v1.10.741 and its new `:bundle`
feature) via Vim-Fireplace and their _many_ friends.

## Why?
When I saw the announcement about ClojureScript 1.10.741 and its new NPM
and JavaScript bundler (e.g. Webpack) integration options, I decided to try to
resurrect my old Vim/ClojureScript development environment and use it to run
through the examples provided in the new guide.

Needless to say, _a lot_ has changed in the last ~five years and my old setup
did not work with the latest versions of ... just about everything: Vim,
Vim-Fireplace, Clojure, ClojureScript, Figwheel, Piggieback, etc.

So, I undertook a month long adventure to try and get this environment working,
document what I could and make it available to others. I sought and received
help from lots of people on Stack Overflow, /r/clojurescript and elsewhere.

I was also buoyed by the two recent releases of Figwheel (v0.2.5/6) which added
support for these new CLJS features in a very short amount of time.

## How?
You can follow along by [installing Clojure and the CLI tools](https://www.clojure.org/guides/getting_started) and
cloning this repository.

### Dependencies
The required dependencies are defined in deps.edn. I was only able to get this
workflow running with the specified versions. Others may work, especially newer
versions, but I ran into issues with older versions of CLJS (>= 1.10.741 && < 1.10.773), nrepl, etc.

The dependencies will be installed by the Clojure CLI when it is first run or
they change.

### REPL Driven Development
#### Shell
Launch a Clojure REPL using the Clojure CLI tools and the Rebel Readline:

`clojure -A:rebel`

#### Clojure REPL
```
(require '[fullstack.helpers :refer :all])  ;; import nREPL helpers
(start-nrepl-server!)                       ;; start nREPL server on 7888

;; Some people run the following commands using Vim-Fireplace's `:CljEval`
;; command but I found that to be a little clunky.
;; If I do end up using this workflow regularly, I'll consider packaging these
;; steps up in a VimScript helper function.
;; Out of habit, I send them from vim to a parallel tmux pane using vim-slime.

(require 'figwheel.main.api)    ;; require Figwheel's scripting API
(figwheel.main.api/start "dev") ;; start Figwheel build (using dev.cljs.edn) and REPL
```

#### Vim CLI
```
:Piggieback (figwheel.main.api/repl-env "dev") " connect to the CLJS REPL
```

#### Vim-Fireplace
You should now have an active connection to the ClojureScript REPL from within
Vim and you can start evaluating forms using [the various Vim-Fireplace
commands](https://github.com/tpope/vim-fireplace/blob/master/doc/fireplace.txt#L126-L312).

For example, try evaluating the following using `cpp` :

`(.log js/console "Hello, world!")`

If the environment is working as expected, you'll see an entry in your
browser's JavaScript console.

From there, you can begin interacting with the program running in your browser
from Vim.

For example, try evaluating the following forms (see src/fullstack/main.cljs):

```
(in-ns 'fullstack.main)
(reset! name_ "Sarah")
```

... and switching back to your browser. The application's contents should have
been updated to reflect the evaluated code.

## Thanks
### David Nolen
David's release announcement and the guide for using the new NPM and JavaScript
bundler were excellent and exciting enough to get me to revisit this
development environment. The ClojureScript program found in fullstack.main was
taken directly from the guide, which is linked below.
### Bruce Hauman
Bruce's Figwheel library, documentation and guides were a tremendous help in
getting this environment up and running. The contents of fullstack.helpers and
most of the "steps" required to get the REPL running and connected were taken
directly from the Figwheel/Vim guide linked below.

Rebel Readline is also a wonderful library and makes the Clojure/Script REPL
more helpful, useful and beautiful.
### Tim Pope
Thanks to Tim Pope for Vim-Fireplace and every other line in my .vimrc which
begins with `Plug 'tpope`.

## Resources
- https://github.com/tpope/vim-fireplace/
- https://clojurescript.org/news/2020-04-24-bundle-target
- https://clojurescript.org/guides/webpack
- https://github.com/bhauman/figwheel-main/releases/tag/v0.2.6
- https://figwheel.org/docs/npm.html
- https://figwheel.org/docs/vim.html
- https://figwheel.org/docs/scripting_api.html
