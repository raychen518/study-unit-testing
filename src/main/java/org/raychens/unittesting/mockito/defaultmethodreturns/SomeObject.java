package org.raychens.unittesting.mockito.defaultmethodreturns;

import java.util.List;
import java.util.Map;

/**
 * <pre>
 * There are 8 primitive data types in Java, as follows.
 * - Integer: byte, short, int, long
 * - Floating-point: float, double
 * - Boolean: boolean
 * - Character: char
 * </pre>
 */
public class SomeObject {

    private byte byteValue;
    private short shortValue;
    private int intValue;
    private long longValue;
    private float floatValue;
    private double doubleValue;
    private boolean booleanValue;
    private char charValue;
 
    private Integer integerWrapper;
    private Double doubleWrapper;
    private Boolean booleanWrapper;
    private Character characterWrapper;

    private String string;
    private Object object;

    private Object[] array;
    private List<Object> list;
    private Map<String, Object> map;

    public Object[] getArray() {
        return array;
    }

    public boolean getBooleanValue() {
        return booleanValue;
    }

    public Boolean getBooleanWrapper() {
        return booleanWrapper;
    }

    public byte getByteValue() {
        return byteValue;
    }

    public Character getCharacterWrapper() {
        return characterWrapper;
    }

    public char getCharValue() {
        return charValue;
    }

    public double getDoubleValue() {
        return doubleValue;
    }

    public Double getDoubleWrapper() {
        return doubleWrapper;
    }

    public float getFloatValue() {
        return floatValue;
    }

    public Integer getIntegerWrapper() {
        return integerWrapper;
    }

    public int getIntValue() {
        return intValue;
    }

    public List<Object> getList() {
        return list;
    }

    public long getLongValue() {
        return longValue;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public Object getObject() {
        return object;
    }

    public short getShortValue() {
        return shortValue;
    }

    public String getString() {
        return string;
    }

    public void setArray(Object[] array) {
        this.array = array;
    }

    public void setBooleanValue(boolean booleanValue) {
        this.booleanValue = booleanValue;
    }

    public void setBooleanWrapper(Boolean booleanWrapper) {
        this.booleanWrapper = booleanWrapper;
    }

    public void setByteValue(byte byteValue) {
        this.byteValue = byteValue;
    }

    public void setCharacterWrapper(Character characterWrapper) {
        this.characterWrapper = characterWrapper;
    }

    public void setCharValue(char charValue) {
        this.charValue = charValue;
    }

    public void setDoubleValue(double doubleValue) {
        this.doubleValue = doubleValue;
    }

    public void setDoubleWrapper(Double doubleWrapper) {
        this.doubleWrapper = doubleWrapper;
    }

    public void setFloatValue(float floatValue) {
        this.floatValue = floatValue;
    }

    public void setIntegerWrapper(Integer integerWrapper) {
        this.integerWrapper = integerWrapper;
    }

    public void setIntValue(int intValue) {
        this.intValue = intValue;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }

    public void setLongValue(long longValue) {
        this.longValue = longValue;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public void setShortValue(short shortValue) {
        this.shortValue = shortValue;
    }

    public void setString(String string) {
        this.string = string;
    }

}
