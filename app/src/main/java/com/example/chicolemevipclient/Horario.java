package com.example.chicolemevipclient;

//1.3
public class Horario {

    public static final String TAG = "Horario Table";

    //colunas, membros da classe
    private int mId;
    private String Date;
    private String Hour;

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getHour() {
        return Hour;
    }

    public void setHour(String hour) {
        Hour = hour;
    }

    public Horario(int mId, String date, String hour) {
        this.mId = mId;
        Date = date;
        Hour = hour;
    }

    public Horario(String date, String hour) {
        Date = date;
        Hour = hour;
    }

    @Override
    public String toString() {
        return "Horario{" +
                "mId=" + mId +
                ", Date='" + Date + '\'' +
                ", Hour='" + Hour + '\'' +
                '}';
    }
}
