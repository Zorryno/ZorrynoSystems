# ZorrynoSystems
Adds some methods and classes to make the work easier and faster

### How to Include
Maven
```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
<dependencies>
    <dependency>
        <groupId>com.github.Zorryno</groupId>
        <artifactId>ZorrynoSystems</artifactId>
        <version>1.1</version>
        <scope>provided</scope>
    </dependency>
</dependencies>
```

Gradle
```groovy
repositories {
    maven { url 'https://jitpack.io' }
}
dependencies {
    compileOnly "com.github.Zorryno:ZorrynoSystems:1.0"
}
```



### What does this API have?
- #### Custom Config and Messages Config
You can easy create a .yml file in the resources folder and use it in your code
```JAVA
public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        Config config = new Config(example.yml, this);
        Messages messages = new Messages(messages.yml, this);
    }
}
```

- #### MetaData Methods
This API brings a few usefull methods to handle with Metadatable Objects  
Simply use:
```JAVA
MetaData.getMetaData(target, key);
MetaData.setMetaData(plugin, target, key, saveObject);
MetaData.hasMetaData(target, key);
MetaData.removeMetaData(plugin, target, key);
```

- #### MathMethods
The last thing are some Math Methods like map or constrain  
You can use:
```JAVA
MathMethods.map(x, from_low, from_high, to_low, to_high);
MathMethods.constrain(x, min, max);
```
