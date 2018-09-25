package com.maciejkozlowski.fragmentutils;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

/**
 * Created by Maciej Kozłowski on 08.04.2018.
 */
public final class FragmentUtils {

    private FragmentUtils() {

    }

    @NonNull
    public static <T> T getListenerOrThrowException(Fragment fragment, Class<T> listenerClazz) {
        T listener = getListener(fragment, listenerClazz);
        if (listener == null) {
            throw new IllegalStateException("Not found " + listenerClazz.getSimpleName());
        }

        return listener;
    }

    @Nullable
    public static <T> T getListener(Fragment fragment, Class<T> listenerClazz) {
        T listener = getListenerFromTargetFragment(fragment, listenerClazz);
        if (listener != null) {
            return listener;
        }

        listener = getListenerFromParentFragment(fragment, listenerClazz);
        if (listener != null) {
            return listener;
        }

        listener = getListenerFromActivity(fragment, listenerClazz);
        if (listener != null) {
            return listener;
        }

        return null;
    }

    @Nullable
    private static <T> T getListener(Class<T> listenerClass, Object object) {
        if (listenerClass.isInstance(object)) {
            return listenerClass.cast(object);
        } else {
            return null;
        }
    }

    @Nullable
    public static <T> T getListenerFromTargetFragment(Fragment fragment, Class<T> listenerClazz) {
        return getListener(listenerClazz, fragment.getTargetFragment());
    }

    @Nullable
    public static <T> T getListenerFromParentFragment(Fragment fragment, Class<T> listenerClazz) {
        return getListener(listenerClazz, fragment.getParentFragment());
    }

    @Nullable
    public static <T> T getListenerFromActivity(Fragment fragment, Class<T> listenerClazz) {
        return getListener(listenerClazz, fragment.getActivity());
    }

    @Nullable
    public static <T> T findFragmentByTag(FragmentManager fragmentManager, Class<T> fragmentClass, String tag) {
        Fragment fragment = fragmentManager.findFragmentByTag(tag);
        if (fragmentClass.isInstance(fragment)) {
            return fragmentClass.cast(fragment);
        } else {
            return null;
        }
    }
}
