# FragmentUtils
[![](https://jitpack.io/v/mac229/FragmentUtils.svg)](https://jitpack.io/#mac229/FragmentUtils)

Provides communication with parent Fragment or Activity.

## Android X
Since version 1.1.0 library's been using from Android X.

## Getting started

In your project level `build.gradle`:

```groovy
allprojects {
    repositories {
        // ...
        maven { url 'https://jitpack.io' }
    }
}
```

And in your app level `build.gradle`:

For **java** version
```groovy
dependencies {
    implementation 'com.github.mac229.FragmentUtils:fragmentutils:1.2.1'
}
```
For **kotlin** version
```groovy
dependencies {
    implementation 'com.github.mac229.FragmentUtils:fragmentutils-kt:1.2.1'
}
```

## Usage in Java

#### Step 1. Implement listener in your Activity or parent Fragment:

```java
public class MainActivity extends AppCompatActivity implements ReplaceFragmentListener  {
```

#### Step 2. Get listener in your Fragment
```java
    private ReplaceFragmentListener replaceFragmentListener;
    
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        replaceFragmentListener = FragmentUtils.getListener(this, ReplaceFragmentListener.class);
    }
```

## Kotlin

```groovy
dependencies {
    implementation 'com.github.mac229.FragmentUtils:fragmentutils-kt:1.2.1'
}
```

#### Step 1. Implement listener in your Activity or parent Fragment:

```kotlin
class MainActivity : AppCompatActivity(), ReplaceFragmentListener {
```

#### Step 2. Get listener in your Fragment
```kotlin
    private var replaceFragmentListener: ReplaceFragmentListener? = null

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        replaceFragmentListener = getListener()
    }
```

## Features - You can use additional features in both - java and kotlin versions

1. Get listener or throw exception when parent doesn't implement listener:
```kotlin
    private lateinit var replaceFragmentListener: ReplaceFragmentListener

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        replaceFragmentListener = getListenerOrThrowException()
    }
```

2. You also can use generic `findFragmentByTag`:
```kotlin
    val fragment = supportFragmentManager.findFragmentByTag(TAG)
```
