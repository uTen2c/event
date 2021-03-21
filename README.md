![Maven metadata URL](https://img.shields.io/maven-metadata/v?label=event&metadataUrl=http%3A%2F%2Futen2c.github.io%2Frepo%2Fdev%2Futen2c%2Fevent%2Fmaven-metadata.xml)

# event

Event listener

### Groovy DSL
```groovy
repositories {
  maven { url 'https://uten2c.github.io/repo/' }
}

dependencies {
  implementation 'dev.uten2c:event:VERSION'
}
```

### Kotlin DSL
```kotlin
repositories {
  maven("https://uten2c.github.io/repo/")
}

dependencies {
  implementation("dev.uten2c:event:VERSION")
}
```

### Example

```kotlin
class MyEvent(var str: String) : EventBase()

class MyCancellableEvent(var str: String) : EventBaseCancellable()
```

```kotlin
listenEvent<MyEvent> {
    println("MyEvent: ${it.str}")
}

listenEvent<MyCancellableEvent> {
    it.isCancelled = true
}

MyEvent("hello").callEvent()

if (MyCancellableEvent("hello").callEvent()) {
    // If it's canceled, it won't be executed.
    println("Event!")
}
```