package kupchack.com.ua;

public class ShippingInfo {
    private int shippingId;
    private String shippingType;
    private int shippingCost;
    private int shippingRegionId;

    public ShippingInfo() {
        this.shippingId = -1;
        this.shippingType = " ";
        this.shippingCost = -1;
        this.shippingRegionId = -1;
    }

    public ShippingInfo(int shippingId, String shippingType, int shippingCost, int shippingRegionId) {
        this.shippingId = shippingId;
        this.shippingType = shippingType;
        this.shippingCost = shippingCost;
        this.shippingRegionId = shippingRegionId;
    }

    public int getShippingId() {
        return shippingId;
    }

    public void setShippingId(int shippingId) {
        this.shippingId = shippingId;
    }

    public String getShippingType() {
        return shippingType;
    }

    public void setShippingType(String shippingType) {
        this.shippingType = shippingType;
    }

    public int getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(int shippingCost) {
        this.shippingCost = shippingCost;
    }

    public int getShippingRegionId() {
        return shippingRegionId;
    }

    public void setShippingRegionId(int shippingRegionId) {
        this.shippingRegionId = shippingRegionId;
    }

    public static ShippingInfo createShipping(){ return new ShippingInfo();}

    @Override
    public String toString() {
        return "ShippingInfo{" +
                "shippingId=" + shippingId +
                ", shippingType='" + shippingType + '\'' +
                ", shippingCost=" + shippingCost +
                ", shippingRegionId=" + shippingRegionId +
                '}';
    }
}
