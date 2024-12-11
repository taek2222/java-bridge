package bridge.domain;

import bridge.domain.dto.CountResponse;

public class Count {

    private int count;

    public Count() {
        this.count = 0;
    }

    public void increase() {
        count++;
    }

    public CountResponse createResponse() {
        return new CountResponse(count);
    }
}
