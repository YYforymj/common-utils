package top.yuyublog.common.utils.bean;

import java.util.Map;
import java.util.Objects;

/**
 * @author yumj
 * @createTime 2021/1/14
 */
public class Bean2 {
    private int propertyPrimaryInt;
    private String propertyString;
    private Map propertyMap;

    public Bean2(int propertyPrimaryInt, String propertyString, Map propertyMap) {
        this.propertyPrimaryInt = propertyPrimaryInt;
        this.propertyString = propertyString;
        this.propertyMap = propertyMap;
    }

    public Bean2() {
    }

    public int getPropertyPrimaryInt() {
        return propertyPrimaryInt;
    }

    public void setPropertyPrimaryInt(int propertyPrimaryInt) {
        this.propertyPrimaryInt = propertyPrimaryInt;
    }

    public String getPropertyString() {
        return propertyString;
    }

    public void setPropertyString(String propertyString) {
        this.propertyString = propertyString;
    }

    public Map getPropertyMap() {
        return propertyMap;
    }

    public void setPropertyMap(Map propertyMap) {
        this.propertyMap = propertyMap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bean2)) return false;
        Bean2 bean2 = (Bean2) o;
        return getPropertyPrimaryInt() == bean2.getPropertyPrimaryInt() &&
                Objects.equals(getPropertyString(), bean2.getPropertyString()) &&
                Objects.equals(getPropertyMap(), bean2.getPropertyMap());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPropertyPrimaryInt(), getPropertyString(), getPropertyMap());
    }
}
