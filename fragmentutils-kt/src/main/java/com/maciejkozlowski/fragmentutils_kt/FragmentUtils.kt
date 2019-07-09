package com.maciejkozlowski.fragmentutils_kt

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager


/**
 * Created by Maciej Kozłowski on 08.04.2018.
 */

inline fun <reified T> Fragment.getListenerOrThrowException(): T {
    return getListener<T>()
            ?: throw IllegalStateException("Calling class must implement:  " + T::class.java.simpleName)
}

inline fun <reified T> Fragment.getListener(): T? {
    var listener = getListenerFromTargetFragment<T>()
    if (listener != null) {
        return listener
    }

    listener = getListenerFromParentFragment<T>()
    if (listener != null) {
        return listener
    }

    return getListenerFromActivity()
}

inline fun <reified T> getListener(target: Any?): T? {
    return if (T::class.java.isInstance(target)) {
        T::class.java.cast(target)
    } else {
        null
    }
}

inline fun <reified T> Fragment.getListenerFromTargetFragment(): T? {
    return getListener(targetFragment)
}

inline fun <reified T> Fragment.getListenerFromParentFragment(): T? {
    return getListener<T>(parentFragment)
}

inline fun <reified T> Fragment.getListenerFromActivity(): T? {
    return getListener<T>(activity)
}

inline fun <reified T> FragmentManager.findFragmentByTag(tag: String): T? {
    val fragment = findFragmentByTag(tag)
    return if (fragment is T) {
        fragment
    } else {
        null
    }
}

fun FragmentManager.add(fragment: Fragment, tag: String? = null) {
    beginTransaction().add(fragment, tag).commit()
}

fun FragmentManager.replace(@IdRes containerId: Int, fragment: Fragment, tag: String? = null) {
    beginTransaction().replace(containerId, fragment, tag).commit()
}