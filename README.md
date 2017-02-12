# processing-ui
A wrapper for Processing's PApplet to aid development with easy to use Views and UI elements.

[![Build Status](https://travis-ci.org/GiantTreeLP/processing-ui.svg?branch=master)](https://travis-ci.org/GiantTreeLP/processing-ui)
[![Build status](https://ci.appveyor.com/api/projects/status/29j811w9nm9h1aot?svg=true)](https://ci.appveyor.com/project/GiantTreeLP/processing-ui)

It's very simple to use:
=

Kotlin:
-

Just extend `PWindow` and override `settings()`:

    class KotlinSample : PWindow() {
        override fun settings() {
            size(600, 400)
        }
    }
    
Then create your `main()` method to launch your sketch:

    fun main(args: Array<String>) {
        PApplet.main(KotlinSample().javaClass)
    }
    
Java:
-

Do it just like with Kotlin:

Extend `PWindow` and override `settings()`:

    public class JavaSample extends PWindow {
        @Override
        public void settings() {
            size(600, 400);
        }

Create you `main()` method and you are ready to launch your sketch:

        public static void main(String[] args) {
            main(JavaSample.class);
        }
    }