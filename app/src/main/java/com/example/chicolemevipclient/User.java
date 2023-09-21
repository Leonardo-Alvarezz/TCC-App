package com.example.chicolemevipclient;

import android.hardware.camera2.CaptureFailure;

import java.net.IDN;

// 1.1
public class User {
    public static final String TAG = "User Table";

    // colunas da tabela do banco de dados
    private int mId;
    private String mUsername;
    private String mPassword;
    private String mEmail;
    private String mCell;
    private String mNivelAcesso;
    private int Qntd_VipClient;

    public User(String mStringPassword, String mStringEmail) {
    }


    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmUsername() {
        return mUsername;
    }

    public void setmUsername(String mUsername) {
        this.mUsername = mUsername;
    }

    public String getmPassword() {
        return mPassword;
    }

    public void setmPassword(String mPassword) {
        this.mPassword = mPassword;
    }

    public String getmEmail() {
        return mEmail;
    }

    public void setmEmail(String mEmail) {
        this.mEmail = mEmail;
    }

    public String getmCell() {
        return mCell;
    }

    public void setmCell(String mCell) {
        this.mCell = mCell;
    }

    public String getmNivelAcesso() {
        return mNivelAcesso;
    }

    public void setmNivelAcesso(String mNivelAcesso) {
        this.mNivelAcesso = mNivelAcesso;
    }

    public int getQntd_VipClient() {
        return Qntd_VipClient;
    }

    public void setQntd_VipClient(int qntd_VipClient) {
        Qntd_VipClient = qntd_VipClient;
    }

    public User(int mId, String mUsername, String mPassword, String mEmail, String mCell, String mNivelAcesso, int qntd_VipClient) {
        this.mId = mId;
        this.mUsername = mUsername;
        this.mPassword = mPassword;
        this.mEmail = mEmail;
        this.mCell = mCell;
        this.mNivelAcesso = mNivelAcesso;
        Qntd_VipClient = qntd_VipClient;
    }

    public User(String mUsername, String mPassword, String mEmail, String mCell, String mNivelAcesso, int qntd_VipClient) {
        this.mUsername = mUsername;
        this.mPassword = mPassword;
        this.mEmail = mEmail;
        this.mCell = mCell;
        this.mNivelAcesso = mNivelAcesso;
        Qntd_VipClient = qntd_VipClient;
    }

    @Override
    public String toString() {
        return "User{" +
                "mId=" + mId +
                ", mUsername='" + mUsername + '\'' +
                ", mPassword='" + mPassword + '\'' +
                ", mEmail='" + mEmail + '\'' +
                ", mCell='" + mCell + '\'' +
                ", mNivelAcesso='" + mNivelAcesso + '\'' +
                ", Qntd_VipClient=" + Qntd_VipClient +
                '}';
    }
}
