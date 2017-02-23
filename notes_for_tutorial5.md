1) In section Pure HTML/CSS page the error message returned by Safari is:

TypeError: null is not an object (evaluating 'login_form.onsubmit = modern_cljs.login.validate_form')


2) At the beginning of section bREPLing with the Shopping Calculator
the tests in the repl return:

```clj
cljs.user=> (value (by-id "quantity"))
#object[TypeError TypeError: null is not an object (evaluating '(el).type')]
getValue@http://localhost:3000/js/main.out/goog/dom/forms.js:317:51
domina$core$value@http://localhost:3000/js/main.out/domina/core.js:1170:31


eval code
eval@[native code]
http://localhost:3000/js/main.out/weasel/repl.js:30:499
http://localhost:3000/js/main.out/weasel/repl.js:39:4
G__11966__2@http://localhost:3000/js/main.out/cljs/core.js:34214:110
G__11966@http://localhost:3000/js/main.out/cljs/core.js:34481:24
http://localhost:3000/js/main.out/weasel/repl.js:186:75
fireListeners@http://localhost:3000/js/main.out/goog/events/eventtarget.js:284:27
dispatchEventInternal_@http://localhost:3000/js/main.out/goog/events/eventtarget.js:381:39
dispatchEvent@http://localhost:3000/js/main.out/goog/events/eventtarget.js:196:56
onMessage_@http://localhost:3000/js/main.out/goog/net/websocket.js:426:21
[native code]
```


In order to have it working, I had to close the pages 
http://localhost:3000/shopping.html and 
http://localhost:3000/index.html
and quit and restart the repl. 

3) As in the previous tutorial, when requiring a library in the repl, the result nil is not returned, only a blank line. 

4) Section: A short troubleshooting session
Here is my output:
``` clj
cljs.user=> (l/validate-form)

#object[TypeError TypeError: null is not an object (evaluating '(el).type')]
getValue@http://localhost:3000/js/main.out/goog/dom/forms.js:317:51
domina$core$value@http://localhost:3000/js/main.out/domina/core.js:1170:31
modern_cljs$login$validate_form@http://localhost:3000/js/main.out/modern_cljs/login.js:6:54


eval code
eval@[native code]
http://localhost:3000/js/main.out/weasel/repl.js:30:499
http://localhost:3000/js/main.out/weasel/repl.js:39:4
G__11966__2@http://localhost:3000/js/main.out/cljs/core.js:34214:110
G__11966@http://localhost:3000/js/main.out/cljs/core.js:34481:24
http://localhost:3000/js/main.out/weasel/repl.js:186:75
fireListeners@http://localhost:3000/js/main.out/goog/events/eventtarget.js:284:27
dispatchEventInternal_@http://localhost:3000/js/main.out/goog/events/eventtarget.js:381:39
dispatchEvent@http://localhost:3000/js/main.out/goog/events/eventtarget.js:196:56
onMessage_@http://localhost:3000/js/main.out/goog/net/websocket.js:426:21
[native code]

cljs.user=> (.-onsubmit (by-id "loginForm"))
#object[TypeError TypeError: null is not an object (evaluating 'domina.core.by_id.call(null,"loginForm").onsubmit')]



eval code
eval@[native code]
http://localhost:3000/js/main.out/weasel/repl.js:30:499
http://localhost:3000/js/main.out/weasel/repl.js:39:4
G__11966__2@http://localhost:3000/js/main.out/cljs/core.js:34214:110
G__11966@http://localhost:3000/js/main.out/cljs/core.js:34481:24
http://localhost:3000/js/main.out/weasel/repl.js:186:75
fireListeners@http://localhost:3000/js/main.out/goog/events/eventtarget.js:284:27
dispatchEventInternal_@http://localhost:3000/js/main.out/goog/events/eventtarget.js:381:39
dispatchEvent@http://localhost:3000/js/main.out/goog/events/eventtarget.js:196:56
onMessage_@http://localhost:3000/js/main.out/goog/net/websocket.js:426:21
[native code]
cljs.user=> (.-onload js/window)
#object[modern_cljs$login$init "function modern_cljs$login$init(){
if(cljs.core.truth_((function (){var and__7101__auto__ = document;
if(cljs.core.truth_(and__7101__auto__)){
return document.getElementById;
} else {
return and__7101__auto__;
}
})())){
var login_form = document.getElementById("loginForm");
return login_form.onsubmit = modern_cljs.login.validate_form;
} else {
return null;
}
}"]
cljs.user=> (l/init)

#object[TypeError TypeError: null is not an object (evaluating 'login_form.onsubmit = modern_cljs.login.validate_form')]
modern_cljs$login$init@http://localhost:3000/js/main.out/modern_cljs/login.js:23:18


eval code
eval@[native code]
http://localhost:3000/js/main.out/weasel/repl.js:30:499
http://localhost:3000/js/main.out/weasel/repl.js:39:4
G__11966__2@http://localhost:3000/js/main.out/cljs/core.js:34214:110
G__11966@http://localhost:3000/js/main.out/cljs/core.js:34481:24
http://localhost:3000/js/main.out/weasel/repl.js:186:75
fireListeners@http://localhost:3000/js/main.out/goog/events/eventtarget.js:284:27
dispatchEventInternal_@http://localhost:3000/js/main.out/goog/events/eventtarget.js:381:39
dispatchEvent@http://localhost:3000/js/main.out/goog/events/eventtarget.js:196:56
onMessage_@http://localhost:3000/js/main.out/goog/net/websocket.js:426:21
[native code]
cljs.user=> (s/init)
#object[modern_cljs$shopping$calculate "function modern_cljs$shopping$calculate(){
var quantity = domina.core.value.call(null,domina.core.by_id.call(null,"quantity"));
var price = domina.core.value.call(null,domina.core.by_id.call(null,"price"));
var tax = domina.core.value.call(null,domina.core.by_id.call(null,"tax"));
var discount = domina.core.value.call(null,domina.core.by_id.call(null,"discount"));
domina.core.set_value_BANG_.call(null,domina.core.by_id.call(null,"total"),(((quantity * price) * ((1) + (tax / (100)))) - discount).toFixed((2)));

return false;
}"]
cljs.user=> 
```

