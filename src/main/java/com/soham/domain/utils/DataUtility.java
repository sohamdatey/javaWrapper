package com.soham.domain.utils;

import java.util.Objects;

public class DataUtility {

    /**
     * check if none of the arguments is null and know which argument is null
     * @param objects
     * @param <T>
     */
    public static <T> void requireNonNullsWithArgumentDetails(T ...objects) {
        int count=0;
        for (T t :objects) {
            count++;
            Objects.requireNonNull(t,"argument " + count +"is null");
        }
    }
    /**
     * check if none of the arguments is null
     * @param objects
     * @param <T>
     */
    public static <T> void requireNonNulls(T ...objects) {
        int count=0;
        for (T t :objects) {
            count++;
            Objects.requireNonNull(t);
        }
    }
    /**
     * check if none of the arguments is null with custom exception message.
     * @param objects
     * @param <T>
     */
    public static <T> void requireNonNulls(String message , T ...objects) {
        for (T t :objects) {
            Objects.requireNonNull(t,message);
        }
    }



}
