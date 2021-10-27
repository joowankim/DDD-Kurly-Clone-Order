package com.codesoom.dddkurlycloneorder.order.domain.models.vo;

import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
@NoArgsConstructor
public class OrderState {

    private enum State {
        PAYMENT_FINISHED("payment finished"),
        PRODUCT_BEING_PREPARED("product being prepared"),
        SHIPPING_START("shipping start"),
        SHIPPING("shipping"),
        DELIVERY_COMPLETED("delivery completed"),
        CANCELED("order canceled");

        private final String value;

        State(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    @Column
    private String value;

    private OrderState(String value) {
        this.value = value;
    }

    public static OrderState valueOf(State state) {
        return new OrderState(state.getValue());
    }

    public static State getPaymentFinished() {
        return State.PAYMENT_FINISHED;
    }

    public static State getProductBeingPrepared() {
        return State.PRODUCT_BEING_PREPARED;
    }

    public static State getShippingStart() {
        return State.SHIPPING_START;
    }

    public static State getShipping() {
        return State.SHIPPING;
    }

    public static State getDeliveryCompleted() {
        return State.DELIVERY_COMPLETED;
    }

    public static State getCanceled() {
        return State.CANCELED;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderState that)) return false;
        return Objects.equals(getValue(), that.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }
}
