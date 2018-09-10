package com.maciejkozlowski.fragmentutils_kt

import android.support.annotation.IdRes
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager

/**
 * Created by Maciej Kozłowski on 08.04.2018.
 */

fun <T> Fragment.getListenerOrThrowException(listenerClazz: Class<T>): T {
    return getListener(listenerClazz)
            ?: throw IllegalStateException("Not found " + listenerClazz.simpleName)
}

fun <T> Fragment.getListener(listenerClazz: Class<T>): T? {
    var listener = getListenerFromTargetFragment(listenerClazz)
    if (listener != null) {
        return listener
    }

    listener = getListenerFromParentFragment(listenerClazz)
    if (listener != null) {
        return listener
    }

    listener = getListenerFromActivity(listenerClazz)
    return if (listener != null) {
        listener
    } else {
        null
    }
}

private fun <T> getListener(listenerClass: Class<T>, target: Any?): T? {
    return if (listenerClass.isInstance(target)) {
        listenerClass.cast(target)
    } else {
        null
    }
}

fun <T> Fragment.getListenerFromTargetFragment(listenerClazz: Class<T>): T? {
    return getListener(listenerClazz, targetFragment)
}

fun <T> Fragment.getListenerFromParentFragment(listenerClazz: Class<T>): T? {
    return getListener(listenerClazz, parentFragment)
}

fun <T> Fragment.getListenerFromActivity(listenerClazz: Class<T>): T? {
    return getListener(listenerClazz, activity)
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