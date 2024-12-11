package bridge.domain;

import bridge.domain.dto.CountResponse;

public class Count {

    private int count = 0;

    public void increment() {
        count++;
    }

    public CountResponse createResponse() {
        return new CountResponse(count);
    }
}
