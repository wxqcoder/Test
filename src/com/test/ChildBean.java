package com.test;

public class ChildBean {

    private String childName;

    private String childSex;

    private int childAge;

    public ChildBean(){
        
    }
    
    public ChildBean(String childName, String childSex, int childAge) {
        this.childName = childName;
        this.childSex = childSex;
        this.childAge = childAge;
    }

     
    public String getChildName() {
        return childName;
    }


    public void setChildName(String childName) {
        this.childName = childName;
    }


    public String getChildSex() {
        return childSex;
    }


    public void setChildSex(String childSex) {
        this.childSex = childSex;
    }


    public int getChildAge() {
        return childAge;
    }


    public void setChildAge(int childAge) {
        this.childAge = childAge;
    }
    
    
    
	public String toString() {
		return "ChildBean [childName=" + childName + ", childSex=" + childSex + ", childAge=" + childAge + "]";
	}


    

}