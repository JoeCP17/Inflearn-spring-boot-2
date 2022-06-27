package hello.advanced.trace.hellotrace;

import hello.advanced.trace.TraceStatus;
import org.junit.jupiter.api.Test;

public class HelloTraceV2Test {

    @Test
    void begin_end() {
        HelloTracev1 trace = new HelloTracev1();
        TraceStatus status1 = trace.begin("hello1");
        TraceStatus status2 = trace.beginSync(status1.getTraceId(), "hello2");
        trace.end(status2);
        trace.end(status1);
    }

    @Test
    void begin_exception() {
        HelloTracev1 tracev1 = new HelloTracev1();
        TraceStatus status1 = tracev1.begin("hello1");
        TraceStatus status2 = tracev1.beginSync(status1.getTraceId(), "hello2");

        tracev1.exception(status2, new IllegalStateException());
        tracev1.exception(status1, new IllegalStateException());
    }
}
