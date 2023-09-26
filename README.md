# Easy Try/Catch

---

### Add it to your project
Maven:
```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```
```xml
<dependecy>
    <groupId>com.github.Hobbyshop</groupId>
    <articfactId>EasyTryCatch</articfactId>
    <version>1.1</version>
</dependecy>
```

Gradle:
```groovy
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```
```groovy
dependencies {
    implementation 'com.github.Hobbyshop:EasyTryCatch:1.1'
}
```

### How it works
The library consists of one class called ``EasyTryCatch``. The following example
shows how to emigrate the Easy Try/Catch library into an existing try/catch block.

**Regular try/catch:**
```java
try {
    Thread.sleep(100);      // try code
} catch (InterruptedException e) {
    System.err.println("Thread was interrupted!");      // handle certain exception
} catch (Throwable t) {
    t.printStackTrace();        // print stack trace of any other exception
}
```

**Easy try/catch:**
```java
EasyTryCatch.easyTry(() -> Thread.sleep(100))       // try code
        .catchThrowable(InterruptedException.class, e -> System.err.println("Thread was interrupted!"))     // handle certain exception
        .printUncaughtExceptions();     // print stack trace of any other exceptions
```

### Benefits
Since Easy Try/Catch handles exceptions via lambda functions, a try/catch statement
can easily be put into a single line and with less indentation than the traditional method.\
For example when creating a thread which prints "Hello" every five seconds the use of
Easy Try/Catch can help the code to look a lot cleaner and easier to read.

**Regular try/catch:**
```java
new Thread(() -> {
    while (true) {
        try {
            System.out.println("Hello");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
});
```

**Easy try/catch:**
```java
new Thread(() -> {
    while (true) {
        System.out.println("Hello");
        EasyTryCatch.easyTry(() -> Thread.sleep(5000)).printThrowable(InterruptedException.class);
    }
});
```
