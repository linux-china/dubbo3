package com.alibaba.com.caucho.hessian.io;

import java.io.IOException;
import java.util.Optional;

/**
 * Java 8 optional deserializer
 *
 * @author linux_china
 */
public class OptionalDeserializer extends AbstractDeserializer {
    @Override
    public Class getType() {
        return Optional.class;
    }

    @Override
    public Object readObject(AbstractHessianInput in) throws IOException {
        Object obj = in.readObject();
        if (obj == null) {
            return Optional.empty();
        } else {
            return Optional.of(obj);
        }
    }
}
