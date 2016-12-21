package com.alibaba.com.caucho.hessian.io;

import java.io.IOException;
import java.util.Optional;

/**
 * Java 8 Optional Serializer
 *
 * @author linux_china
 */
public class OptionalSerializer extends AbstractSerializer {

    public void writeObject(Object obj, AbstractHessianOutput out) throws IOException {
        if (obj == null)
            out.writeNull();
        else if (obj.getClass().equals(Optional.class)) {
            Optional optional = (Optional) obj;
            if (!optional.isPresent()) {
                out.writeNull();
            } else {
                out.writeObject(optional.get());
            }
        }

    }
}
