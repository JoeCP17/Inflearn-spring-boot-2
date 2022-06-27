package hello.advanced.trace.hellotrace;

import hello.advanced.trace.TraceStatus;
import org.junit.jupiter.api.Test;

public class HelloTraceV1Test {

    @Test
    void begin_end() {
        HelloTracev1 trace = new HelloTracev1();
        TraceStatus status = trace.begin("hello");
        trace.end(status);
    }

    @Test
    void begin_exception() {
        HelloTracev1 tracev1 = new HelloTracev1();
        TraceStatus status = tracev1.begin("hello");
        tracev1.exception(status, new IllegalStateException());
    }
}
