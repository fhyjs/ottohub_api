package org.eu.hanana.reimu.lib.ottohub.util;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;
import okio.Okio;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.io.InputStream;

public class InputStreamRequestBody extends RequestBody {
    protected final MediaType type;
    protected final InputStream is;
    protected long length = -1;

    public InputStreamRequestBody(InputStream inputStream,MediaType mediaType){
        this.type= mediaType;
        this.is = inputStream;
    }

    public InputStreamRequestBody setLength(long length) {
        this.length = length;
        return this;
    }

    @Nullable
    @Override
    public MediaType contentType() {
        return type;
    }

    @Override
    public long contentLength() throws IOException {
        return length;
    }

    @Override
    public void writeTo(@NotNull BufferedSink sink) throws IOException {
        byte[] buffer = new byte[8 * 1024]; // 8KB缓冲区
        int read;
        try (InputStream input = is) {
            while ((read = input.read(buffer)) != -1) {
                sink.write(buffer, 0, read);
            }
        }
    }
}
