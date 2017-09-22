package com.comba.android.combacommon.utils;

import java.io.Closeable;
import java.io.IOException;

/**
 * Created by liangchunfeng on 2017/4/25.
 */

public class IOUtils {

    private IOUtils() {
        throw new AssertionError();
    }


    /**
     * Close closable object and wrap {@link IOException} with {@link RuntimeException}
     * @param closeable closeable object
     */
    public static void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                throw new RuntimeException("IOException occurred. ", e);
            }
        }
    }

    /**
     * Close closable and hide possible {@link IOException}
     * @param closeable closeable object
     */
    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                // Ignored
            }
        }
    }

}
