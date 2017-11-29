[b]Java CS2D Map Library[/b]

Version 0.1 (Alpha, expect bugs)

[i]Have you ever felt tired of doing repetitive things in the map editor such as placing several hundred trees or adding random decals everywhere? This library may help you by allowing you to write Java code that can programmatically create and modify maps![/i]

This is a Java code library for Java developers that allows loading or saving cs2d maps. Moreover, new maps can be created and modified directly in Java from scratch. Things like tiles and backgrounds can be changed, entities can be created and edited and much more!

[u] :ugly: NOTE: Please note that regular cs2d users wont have much use for this, as you need at least some java development skills to be able to use this.[/u]

Features:
 :*: Saving cs2d maps
 :*: Loading cs2d maps
 :*: Changing tiles
 :*: Changing/Adding entities
 :*: Changing metadata like author of map
 :*: Changing tileset/backgrounds
[i]And much more[/i]

For more detailed info and instructions, check out [url=https://github.com/EnderCrypt/Cs2dJavaMapLibrary/wiki]The Wiki[/url]
 
[more=Maven Dependency][code]<repositories>
  <repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
  </repository>
</repositories>
  
<dependencies>
  <dependency>
    <groupId>com.github.EnderCrypt</groupId>
    <artifactId>Cs2dJavaMapLibrary</artifactId>
    <version>41b21f44c9</version>
  </dependency>
</dependencies>[/code][/more]

[i]Please note that due to the early stage in development of this library, its quite possible that maps generated may turn out to be corrupted. if you receive a corrupted map then please send it to me so i could debug and track down what caused the problem.[/i]

Github: [url]https://github.com/EnderCrypt/Cs2dJavaMapLibrary[/url]

[more=Screenshot Description]Screenshot 1: [i]De_dust with the walls converted to breakable entities[/i]
Screenshot 2: [i]A random procedurally generated cave map (500 x 500)[/i][/more]