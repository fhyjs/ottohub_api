package org.eu.hanana.reimu.lib.ottohub.util;

import lombok.Getter;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;
import okio.BufferedSink;
import okio.ForwardingSink;
import okio.Okio;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;

public class ProgressedRequestBody extends RequestBody {
    @Getter
    private final ProgressListener progressListener;
    @Getter
    protected RequestBody requestBody;
    @Getter
    protected long bytesWritten = 0L;
    protected long contentLength = -100L;
    public ProgressedRequestBody(RequestBody requestBody, ProgressListener progressListener){
        this.requestBody =requestBody;
        this.progressListener = progressListener;
    }
    public double getProgress(){
        try {
            return bytesWritten/((float) contentLength());
        } catch (IOException e) {
            return bytesWritten;
        }
    }
    @Override
    public long contentLength() throws IOException {
        if (contentLength==-100) {
             contentLength=this.requestBody.contentLength();
        }
        return this.contentLength;
    }

    @Nullable
    @Override
    public MediaType contentType() {
        return this.requestBody.contentType();
    }

    @Override
    public void writeTo(@NotNull BufferedSink sink) throws IOException {
        long contentLength = contentLength();
        ForwardingSink forwardingSink = new ForwardingSink(sink) {
            @Override
            public void write(@NotNull Buffer source, long byteCount) throws IOException {
                super.write(source, byteCount);
                bytesWritten += byteCount;
                ProgressedRequestBody.this.progressListener.changed(bytesWritten,contentLength,bytesWritten/((double) contentLength));
            }
        };
        BufferedSink bufferedSink = Okio.buffer(forwardingSink);
        this.requestBody.writeTo(bufferedSink);
        bufferedSink.flush();
    }
    public interface ProgressListener{
        void changed(long written,long length,double progress);
    }
}
