package com.example.chicolemevipclient;

//1.2
public class Servico {

    public static final String TAG = "Service Table";

    private int mUnit;

    public int getmUnit() {
        return mUnit;
    }

    public void setmUnit(int mUnit) {
        this.mUnit = mUnit;
    }



    // colunas, membros da classe
    private int mId;
    private String mServiceName;
    private double mPrice;

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmServiceName() {
        return mServiceName;
    }

    public void setmServiceName(String mServiceName) {
        this.mServiceName = mServiceName;
    }

    public double getmPrice() {
        return mPrice;
    }

    public void setmPrice(double mPrice) {
        this.mPrice = mPrice;
    }

    public Servico(int mUnit, int mId, String mServiceName, double mPrice) {
        this.mUnit = mUnit;
        this.mId = mId;
        this.mServiceName = mServiceName;
        this.mPrice = mPrice;
    }

    public Servico(int mUnit, String mServiceName, double mPrice) {
        this.mUnit = mUnit;
        this.mServiceName = mServiceName;
        this.mPrice = mPrice;
    }

    @Override
    public String toString() {
        return "Servico{" +
                "mUnit=" + mUnit +
                ", mId=" + mId +
                ", mServiceName='" + mServiceName + '\'' +
                ", mPrice=" + mPrice +
                '}';
    }
}
