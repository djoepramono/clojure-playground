# Clojure Playground

by Djoe Pramono

---

# Clojure

A dynamic and functional LISP dialect.

Its core is small based on lambda calculus principle

Separate language from a platform, i.e. needs a run time like JVM

---

# A LISP dialect

Stands for List Processor.

Code as Data

```
(+ 2 3)
```

that line of code above is actually a list

---

# The setup

Java + Clojure + Calva (VS Code Extension)

oh and `rlwrap` is awesome optional

---

# An amazing REPL

Clojure has an amazing REPL, and Calva integrates with it well

---

# Variables and immutability

There are `def` and `let`

We can redefine the binding multiple times

The data value once set is immutable

However we can create a copy of the original data and modify it

---

# Functions

There are a few ways to create a function `def` and `defn`

Functions in clojure can have different arity

We can chain a value with functions with `->` and `-->`

---

# Higher order functions

A function that return another function

---

# Recursion

Instead of loop, it uses recursion

But we have to be careful of stack overflow

---
# Back to the boring but essential bits

`edn` file

How to execute from a command line

How to import JAVA library / Clojure function in another file

---

# Coming up

Sum Type, Product Type, and Pattern Matching
