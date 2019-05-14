package pl.rxstudio.valuationofwork;

public class Indicator {
    private String indicatorObjectsGroups;
    private String indicatorObjects;
    private int  indicatorCategory;

    public  Indicator() {}

    public Indicator(String indicatorObjectsGroups, String indicatorObjects, int indicatorCategory) {
        this.indicatorObjectsGroups = indicatorObjectsGroups;
        this.indicatorObjects = indicatorObjects;
        this.indicatorCategory = indicatorCategory;
    }


    public String getIndicatorObjectsGroups() {
        return indicatorObjectsGroups;
    }

    public void setIndicatorObjectsGroups(String indicatorObjectsGroups) {
        this.indicatorObjectsGroups = indicatorObjectsGroups;
    }

    public String getIndicatorObjects() {
        return indicatorObjects;
    }

    public void setIndicatorObjects(String indicatorObjects) {
        this.indicatorObjects = indicatorObjects;
    }

    public int getIndicatorCategory() {
        return indicatorCategory;
    }

    public void setIndicatorCategory(int indicatorCategory) {
        this.indicatorCategory = indicatorCategory;
    }
}
