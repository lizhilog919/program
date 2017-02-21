// IDogManager.aidl
package com.test.demo.aidl;
import com.test.demo.aidl.Dog;
// Declare any non-default types here with import statements

interface IDogManager {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);

    List<Dog> getDogList();

    void addDog(in Dog dog);
}
