package edu.ncsu.csc316.dsa;

public class Highway implements Weighted {
    private String name;
    private int length;
    
    public Highway(String n, int l) {
        setName(n);
        setLength(l);
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLength() {
        return length;
    }
    public String getName() {
    	return name;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public int getWeight() {
        return getLength();
    }
}
