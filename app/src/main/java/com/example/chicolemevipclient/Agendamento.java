package com.example.chicolemevipclient;

//1.4
public class Agendamento {
    public static final String TAG = "Agend Table";

    //colunas, membros da classe
    private int mId;
    private int mUserId;
    private int mServiceId;
    private int mHorarioId;

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public int getmUserId() {
        return mUserId;
    }

    public void setmUserId(int mUserId) {
        this.mUserId = mUserId;
    }

    public int getmServiceId() {
        return mServiceId;
    }

    public void setmServiceId(int mServiceId) {
        this.mServiceId = mServiceId;
    }

    public int getmHorarioId() {
        return mHorarioId;
    }

    public void setmHorarioId(int mHorarioId) {
        this.mHorarioId = mHorarioId;
    }

    public Agendamento(int mId, int mUserId, int mServiceId, int mHorarioId) {
        this.mId = mId;
        this.mUserId = mUserId;
        this.mServiceId = mServiceId;
        this.mHorarioId = mHorarioId;
    }

    public Agendamento(int mUserId, int mServiceId, int mHorarioId) {
        this.mUserId = mUserId;
        this.mServiceId = mServiceId;
        this.mHorarioId = mHorarioId;
    }

    @Override
    public String toString() {
        return "Agendamento{" +
                "mId=" + mId +
                ", mUserId=" + mUserId +
                ", mServiceId=" + mServiceId +
                ", mHorarioId=" + mHorarioId +
                '}';
    }
}
