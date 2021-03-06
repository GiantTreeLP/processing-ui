# processing-ui
A wrapper for Processing's PApplet to aid development with easy to use Views and UI elements.

[![Build Status](https://travis-ci.org/GiantTreeLP/processing-ui.svg?branch=master)](https://travis-ci.org/GiantTreeLP/processing-ui)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.gianttreelp/gtlp-processing-ui/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.github.gianttreelp/gtlp-processing-ui)
[![Dependencies](https://app.updateimpact.com/badge/831936721338896384/processing-ui.svg?config=test)](https://app.updateimpact.com/latest/831936721338896384/processing-ui)
[![Dependency Status](https://www.versioneye.com/user/projects/58a71847b4d2a20055fcb868/badge.svg?style=flat)](https://www.versioneye.com/user/projects/58a71847b4d2a20055fcb868)
[![GitHub release](https://img.shields.io/github/release/gianttreelp/processing-ui.svg)](https://github.com/GiantTreeLP/processing-ui/releases)

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
