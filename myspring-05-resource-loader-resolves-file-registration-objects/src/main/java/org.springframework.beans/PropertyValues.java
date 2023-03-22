package org.springframework.beans;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class PropertyValues {

    List<PropertyValue> propertyValueList;


    public PropertyValues() {
        this(new ArrayList<PropertyValue>());
    }

    public PropertyValues(List<PropertyValue> propertyValueList) {
        this.propertyValueList = propertyValueList;
    }

    public void addPropertyValue(PropertyValue propertyValue) {
        propertyValueList.add(propertyValue);
    }

    public PropertyValue[] getPropertyValueList() {
        return this.propertyValueList.toArray(new PropertyValue[0]);
    }


    public Object getPropertyValue(String name) {
        for (PropertyValue propertyValue : propertyValueList) {
            if (Objects.equals(name, propertyValue.getName())) {
                return propertyValue.getValue();
            }
        }
        return null;
    }

}
