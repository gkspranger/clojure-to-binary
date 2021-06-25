# Clojure to Binary

### Setup
```bash
export GRAALVM_HOME=/Users/gkspranger/bin/graalvm-ce-java11-21.1.0/Contents/Home
export PATH=$GRAALVM_HOME/bin:$PATH
```

### Test in Leiningen
```bash
lein run '(println "hello world")'
```

### Compile
```bash
lein do clean, uberjar
lein native
```

### Test binary
```bash
./target/binblo '(println "hello world")'
Exception in thread "main" Syntax error compiling fn* at (0:0).
	at clojure.lang.Compiler.analyzeSeq(Compiler.java:7119)
	at clojure.lang.Compiler.analyze(Compiler.java:6793)
	at clojure.lang.Compiler.eval(Compiler.java:7178)
	at clojure.lang.Compiler.eval(Compiler.java:7136)
	at clojure.core$eval.invokeStatic(core.clj:3202)
	at clojure.core$eval.invoke(core.clj:3198)
	at binblo.core$_main.invokeStatic(core.clj:9)
	at binblo.core$_main.doInvoke(core.clj:6)
	at clojure.lang.RestFn.applyTo(RestFn.java:137)
	at binblo.core.main(Unknown Source)
Caused by: com.oracle.svm.core.jdk.UnsupportedFeatureError: Defining classes from new bytecodes run time.
	at com.oracle.svm.core.util.VMError.unsupportedFeature(VMError.java:87)
	at java.lang.ClassLoader.defineClass(ClassLoader.java:419)
	at clojure.lang.DynamicClassLoader.defineClass(DynamicClassLoader.java:46)
	at clojure.lang.Compiler$ObjExpr.getCompiledClass(Compiler.java:4990)
	at clojure.lang.Compiler$FnExpr.parse(Compiler.java:4120)
	at clojure.lang.Compiler.analyzeSeq(Compiler.java:7109)
	... 9 more
```

### Links
- https://huongdanjava.com/install-graalvm-on-macos.html
- https://github.com/BrunoBonacci/graalvm-clojure/blob/master/doc/clojure-graalvm-native-binary.md
- https://github.com/hypirion/lein-shell/blob/master/doc/DOCUMENTATION.md
