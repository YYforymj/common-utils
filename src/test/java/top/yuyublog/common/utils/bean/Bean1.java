package top.yuyublog.common.utils.bean;

/**
 * @author yumj
 * @createTime 2021/1/14
 */
public class Bean1 {
    private int propertyPrimaryInt;
    private long propertyPrimaryLong;
    private String propertyString;

    public Bean1(int propertyPrimaryInt, long propertyPrimaryLong, String propertyString) {
        this.propertyPrimaryInt = propertyPrimaryInt;
        this.propertyPrimaryLong = propertyPrimaryLong;
        this.propertyString = propertyString;
    }

    public Bean1() {
    }

    public int getPropertyPrimaryInt() {
        return propertyPrimaryInt;
    }

    public void setPropertyPrimaryInt(int propertyPrimaryInt) {
        this.propertyPrimaryInt = propertyPrimaryInt;
    }

    public long getPropertyPrimaryLong() {
        return propertyPrimaryLong;
    }

    public void setPropertyPrimaryLong(long propertyPrimaryLong) {
        this.propertyPrimaryLong = propertyPrimaryLong;
    }

    public String getPropertyString() {
        return propertyString;
    }

    public void setPropertyString(String propertyString) {
        this.propertyString = propertyString;
    }
}
