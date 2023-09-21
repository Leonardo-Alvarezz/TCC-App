package com.example.chicolemevipclient;

import android.content.Context;
import android.util.Log;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    public static final String TAG = "CRUD User";

    public static int insertUser(User mUser , Context mContext) {
        //0 não fez o insert
        //1 fez o insert com sucesso

        int vResponse = 0;
        String mSql;
        try{
            mSql = "INSERT INTO usuarios ( Username , Password , Email , Cell , NivelAcesso , Qntd_VipClient ) VALUES ( ? , ? , ? , ? , ? , ? , ?  )";

            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);

            mPreparedStatement.setString(1 , mUser.getmUsername());
            mPreparedStatement.setString(2 , mUser.getmPassword());
            mPreparedStatement.setString(3 , mUser.getmEmail());
            mPreparedStatement.setString(5 , mUser.getmCell());
            mPreparedStatement.setString(6 , mUser.getmNivelAcesso());
            mPreparedStatement.setInt(7 , mUser.getQntd_VipClient());

            vResponse = mPreparedStatement.executeUpdate(); //1 se inseriu com sucesso

        } catch(Exception e){
            Log.e(TAG , e.getMessage());
        }
        return vResponse;
    }

    public static int updateUser(User mUser , Context mContext) {
        //0 não fez o insert
        //1 fez o insert com sucesso

        int vResponse = 0;
        String mSql;
        try{
            mSql = "UPDATE usuarios SET Username=? , Password=? , Email=? , Cell=? , NivelAcesso=? , Qntd_VipClient=? WHERE id=? ";

            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);

            mPreparedStatement.setString(1 , mUser.getmUsername());
            mPreparedStatement.setString(2 , mUser.getmPassword());
            mPreparedStatement.setString(3 , mUser.getmEmail());
            mPreparedStatement.setString(5 , mUser.getmCell());
            mPreparedStatement.setString(6 , mUser.getmNivelAcesso());
            mPreparedStatement.setInt(7 , mUser.getQntd_VipClient());
            mPreparedStatement.setInt(8 , mUser.getmId());

            vResponse = mPreparedStatement.executeUpdate(); //1 se inseriu com sucesso

        } catch(Exception e){
            Log.e(TAG , e.getMessage());
        }
        return vResponse;
    }

    public static int deleteUser(User mUser , Context mContext) {
        //0 não fez o insert
        //1 fez o insert com sucesso

        int vResponse = 0;
        String mSql;
        try{
            mSql = "DELETE FROM usuarios WHERE id=?";

            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);

            mPreparedStatement.setInt(1 , mUser.getmId());

            vResponse = mPreparedStatement.executeUpdate(); //1 se inseriu com sucesso

        } catch(Exception e){
            Log.e(TAG , e.getMessage());
        }
        return vResponse;
    }

    public static int deleteAllUser(Context mContext) {
        //0 não fez o insert
        //1 fez o insert com sucesso

        int vResponse = 0;
        String mSql;
        try{
            mSql = "DELETE FROM usuarios";

            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);

            vResponse = mPreparedStatement.executeUpdate(); //1 se inseriu com sucesso

        } catch(Exception e){
            Log.e(TAG , e.getMessage());
        }
        return vResponse;
    }

    public static List<User> listAllUsers(Context mContext){
        List<User> mUserList = null;
        String mSql;

        try{
            mSql = "SELECT id, Username , Password , Email , Cell , NivelAcesso , Qntd_VipClient FROM usuarios ORDER BY Username ASC";

            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);

            ResultSet mResultSet =mPreparedStatement.executeQuery();
            mUserList = new ArrayList<User>();

            while(mResultSet.next()){
                mUserList.add(new User(
                        mResultSet.getInt(1),
                        mResultSet.getString(2),
                        mResultSet.getString(3),
                        mResultSet.getString(4),
                        mResultSet.getString(5),
                        mResultSet.getString(6),
                        mResultSet.getInt(7)

                ));
            }
        } catch(Exception e){
            Log.e(TAG , e.getMessage());
        }

        return mUserList;
    }

    public static List<User> listAllUsersByCell(int vCell , Context mContext){
        List<User> mUserList = null;
        String mSql;

        try{
            mSql = "SELECT id, Username , Password , Email , Cell , NivelAcesso , Qntd_VipClient FROM usuarios WHERE Cell =" + vCell + " ORDER BY Username ASC";

            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);

            ResultSet mResultSet =mPreparedStatement.executeQuery();
            mUserList = new ArrayList<User>();

            while(mResultSet.next()){
                mUserList.add(new User(
                        mResultSet.getInt(1),
                        mResultSet.getString(2),
                        mResultSet.getString(3),
                        mResultSet.getString(4),
                        mResultSet.getString(5),
                        mResultSet.getString(6),
                        mResultSet.getInt(7)

                ));
            }
        } catch(Exception e){
            Log.e(TAG , e.getMessage());
        }

        return mUserList;
    }

    public static List<User> searchUsersByName(String mName , Context mContext){
        List<User> mUserList = null;
        String mSql;

        try{
            mSql = "SELECT id, Username , Password , Email , Cell , NivelAcesso , Qntd_VipClient FROM usuarios WHERE Username LIKE '%" + mName + "%' ORDER BY Username ASC";

            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);

            ResultSet mResultSet =mPreparedStatement.executeQuery();
            mUserList = new ArrayList<User>();

            while(mResultSet.next()){
                mUserList.add(new User(
                        mResultSet.getInt(1),
                        mResultSet.getString(2),
                        mResultSet.getString(3),
                        mResultSet.getString(4),
                        mResultSet.getString(5),
                        mResultSet.getString(6),
                        mResultSet.getInt(7)

                ));
            }
        } catch(Exception e){
            Log.e(TAG , e.getMessage());
        }

        return mUserList;
    }


    public static String authenticateUser(User mUser, Context mContext){
        String mResponse = "";
        String mSql = "SELECT id, username, email, password FROM usuarios WHERE password LIKE ? AND email LIKE ?";

        try {
            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);
            mPreparedStatement.setString(1, mUser.getmPassword());
            mPreparedStatement.setString(2, mUser.getmEmail());
            ResultSet mResultSet = mPreparedStatement.executeQuery();
            while (mResultSet.next()){
                mResponse = mResultSet.getString(2);
            }
        }catch (Exception e){
            mResponse = "Exception";
            Log.e(TAG , e.getMessage());
            e.printStackTrace();
        }
        return mResponse;
    }
}
