package pl.rxstudio.valuationofwork;

public class Indicator {
    private String indicatorObjectsGroups;
    private String indicatorObjects;
    private int  indicatorCategory;

    public static String  internalArea;
    public static double  indicatorZ;
    public static double  architectsFee;
    public static double  additives;
    public static double  feeRate;
    public static double  indicatorW;


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






    public double getIndicatorZ() {
        return indicatorZ;
    }

    public void setIndicatorZ(double indicatorZ) {
        this.indicatorZ = indicatorZ;
    }

    public double getArchitectsFee() {
        return architectsFee;
    }

    public void setArchitectsFee(double architectsFee) {
        this.architectsFee = architectsFee;
    }

    public double getAdditives() {
        return additives;
    }

    public void setAdditives(double additives) {
        this.additives = additives;
    }

    public double getFeeRate() {
        return feeRate;
    }

    public void setFeeRate(double feeRate) {
        this.feeRate = feeRate;
    }

    public double getIndicatorW() {
        return indicatorW;
    }

    public void setIndicatorW(double indicatorW) {
        this.indicatorW = indicatorW;
    }
}
