package ir.msv.orderservice.data.enumuration;

import lombok.Getter;

/**
 * @author Negin Mousavi 1/25/2025 - Saturday
 */
@Getter
public enum OrderStatus {
    WAITING_FOR_REGISTRATION("در انتظار ثبت"),
    REGISTERED("ثبت شده"),
    ;
    private final String abbr;

    OrderStatus(String abbr) {
        this.abbr = abbr;
    }
}
