package kupchack.com.ua;

import java.util.ArrayList;

public class Order {
    private int orderId;
    private String dateCreated;
    private String dateShipped;
    private String customerName;
    private String customerId;
    private OrderDetails orderDetails;
    private ShippingInfo shippingInfo;

    public Order() {
        this.orderId = -1;
        this.dateCreated = " ";
        this.dateShipped = " ";
        this.customerName = " ";
        this.customerId = " ";
        orderDetails = OrderDetails.createOrderDet();
        shippingInfo = ShippingInfo.createShipping();
    }

    public Order(int orderId, String dateCreated, String dateShipped, String customerName, String customerId, OrderDetails orderDetails, ShippingInfo shippingInfo) {
        this.orderId = orderId;
        this.dateCreated = dateCreated;
        this.dateShipped = dateShipped;
        this.customerName = customerName;
        this.customerId = customerId;
        this.orderDetails = orderDetails;
        this.shippingInfo = shippingInfo;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getDateShipped() {
        return dateShipped;
    }

    public void setDateShipped(String dateShipped) {
        this.dateShipped = dateShipped;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public OrderDetails getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(OrderDetails orderDetails) {
        this.orderDetails = orderDetails;
    }

    public ShippingInfo getShippingInfo() {
        return shippingInfo;
    }

    public void setShippingInfo(ShippingInfo shippingInfo) {
        this.shippingInfo = shippingInfo;
    }

    public static ArrayList<Order> createArrayList(){ return new ArrayList<Order>(); }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", dateCreated='" + dateCreated + '\'' +
                ", dateShipped='" + dateShipped + '\'' +
                ", customerName='" + customerName + '\'' +
                ", customerId='" + customerId + '\'' +
                ", orderDetails=" + orderDetails +
                ", shippingInfo=" + shippingInfo +
                '}';
    }
}
