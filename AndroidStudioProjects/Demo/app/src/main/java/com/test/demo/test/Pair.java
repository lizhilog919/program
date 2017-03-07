package com.test.demo.test;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * Created by lizhi
 * 17-3-7
 */
public class Pair implements Externalizable {
    @Override
    public void readExternal(ObjectInput input) throws IOException, ClassNotFoundException {
    }

    @Override
    public void writeExternal(ObjectOutput output) throws IOException {

    }
}
