package model;

public class Word {
    String key;
    String value;
    boolean isShowed;

    public Word(String key, String value) {
        setKey(key);
        setValue(value);
    }

    @Override
    public String toString() {
        return "\n"+key+ " : "+value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key.trim().toLowerCase();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value.trim().toLowerCase();
    }

    public boolean isShowed() {
        return isShowed;
    }

    public void setShowed(boolean showed) {
        isShowed = showed;
    }



}
