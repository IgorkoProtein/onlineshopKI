package kupchack.com.ua;

public class OrderDetails {
    private int orderId;
    private int productId;
    private String productName;
    private int quantity;
    private double unitCoast;
    private double subtotal;

    public OrderDetails() {
        this.orderId = -1;
        this.productId = -1;
        this.productName = " ";
        this.quantity = -1;
        this.unitCoast = -1.1;
        this.subtotal = -1.1;
    }

    public OrderDetails(int orderId, int productId, String productName, int quantity, double unitCoast, double subtotal) {
        this.orderId = orderId;
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.unitCoast = unitCoast;
        this.subtotal = subtotal;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitCoast() {
        return unitCoast;
    }

    public void setUnitCoast(double unitCoast) {
        this.unitCoast = unitCoast;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public static OrderDetails createOrderDet(){ return new OrderDetails();}

    @Override
    public String toString() {
        return "OrderDetails{" +
                "orderId=" + orderId +
                ", productId=" + productId +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                ", unitCoast=" + unitCoast +
                ", subtotal=" + subtotal +
                '}';
    }
}
