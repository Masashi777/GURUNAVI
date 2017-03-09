package com.lifeistech.android.gurunavi_sample;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OptionalDataException;
import java.io.StreamCorruptedException;

/**
 * Created by Masashi Hamaguchi on 2017/03/09.
 */

public class ByteConverter {

    public static byte[] fromObject(Object object) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutput output = new ObjectOutputStream(bos);
        output.writeObject(object);
        byte[] bytes = bos.toByteArray();
        output.close();
        bos.close();
        return bytes;

    }

    public static Object toObject(byte[] bytes) throws OptionalDataException, StreamCorruptedException, ClassNotFoundException, IOException {
        return new ObjectInputStream(new ByteArrayInputStream(bytes)).readObject();
    }
}
