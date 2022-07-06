package com.alevel.web.dto.response;

import com.alevel.persistence.entity.order.Order;
import org.aspectj.weaver.ast.Or;

public class OrderResponseDto extends ResponseDto {

    private Long cartId;
    private String customerName;
    private String customerAddress;
    private String customerEmail;
    private String customerPhone;

    private String status;

    public OrderResponseDto() {

    }

    public OrderResponseDto(Order order) {
        setId(order.getId());
        setCreated(order.getCreated());
        setUpdated(order.getUpdated());
        setVisible(order.getVisible());
        setStatus(order.getStatus());
        this.cartId = order.getCartId();
        this.customerName = order.getCustomerName();
        this.customerAddress = order.getCustomerAddress();
        this.customerEmail = order.getCustomerEmail();
        this.customerPhone = order.getCustomerPhone();
        this.status = order.getStatus();
    }

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
