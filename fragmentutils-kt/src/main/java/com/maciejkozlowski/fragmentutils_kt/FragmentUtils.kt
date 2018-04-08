package com.maciejkozlowski.fragmentutils_kt

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

fun <T> FragmentManager.findFragmentByTag(fragmentClass: Class<T>, tag: String): T? {
    val fragment = findFragmentByTag(tag)
    return if (fragmentClass.isInstance(fragment)) {
        fragmentClass.cast(fragment)
    } else {
        null
    }

}
