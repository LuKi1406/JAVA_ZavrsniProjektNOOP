package view;

import java.util.EventListener;

public interface OrderDetailsFormListener extends EventListener {

    void orderDetailsEventOccurred(OrderDetailEvent orderDetailEvent);
}
