# FragmentUtils
Provides communication with parent Fragment or Activity.

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
    implementation 'com.github.mac229.FragmentUtils:fragmentutils:1.0.1'
}
```
For **kotlin** version
```groovy
dependencies {
    implementation 'com.github.mac229.FragmentUtils:fragmentutils-kt:1.0.1'
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
    implementation 'com.github.mac229.FragmentUtils:fragmentutils-kt:1.0.1'
}
```

#### Step 1. Implement listener in your Activity or parent Fragment:

```kotlin
class MainActivity : AppCompatActivity(), ReplaceFragmentListener {
```

#### Step 2. Get listener in your Fragment
```kotlin
    private lateinit var replaceFragmentListener: ReplaceFragmentListener

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        replaceFragmentListener = activity as ReplaceFragmentListener
    }
```
