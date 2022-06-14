# java17-features
Examples of convenient Java 17 features that went GA between Java 11 and Java 17.

Look under src/main/test for what some of the new features look like.
* (16) New localized "time of day" support to make call tree logic sound more human or something.
* (16) Stream.toList(); convenience over Stream.toCollection(Collectors.toList())
* (16) Records (get getters/setters for free without writing boilerplate)! Kind of like Kotlin, but also not -- Java records are completely immutable.
* (16) instanceof pattern matching
* (15) Multi-line text blocks
* (14) Switch expressions
* (12) Compact numbers (1M, 3B)

For additional research, reading the JEP for a particular feature tends to be useful in understanding why the feature was added. 
JEPS are typically in plain English and discuss pros/cons of different roads taken and not taken.

Things that are interesting theoretically but that I don't care about showing:
* (17) Sealed classes, when you don't want just anyone to implement/extend your interfaces/classes, but still want them to be public.
* (17) New abstraction for random number generation.
* (17) New abstraction for time `java.time.InstantSource`. Seems potentially useful for testing.
* 

Full list of new features is at:
* https://www.oracle.com/java/technologies/javase/17-relnote-issues.html
* https://www.oracle.com/java/technologies/javase/16-relnote-issues.html
* https://www.oracle.com/java/technologies/javase/15-relnote-issues.html
* https://www.oracle.com/java/technologies/javase/14-relnote-issues.html
* https://www.oracle.com/java/technologies/javase/13-relnote-issues.html