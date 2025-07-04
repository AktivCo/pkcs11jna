# Keep JNA classes to avoid obfuscation issues
-dontwarn java.awt.*

# Keep all JNA classes and members
-keep class com.sun.jna.** { *; }

# Keep class members (fields/methods) of any subclass of JNA
-keep class * implements com.sun.jna.** { *; }
