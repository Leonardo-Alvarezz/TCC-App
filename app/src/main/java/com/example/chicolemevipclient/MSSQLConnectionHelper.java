package com.example.chicolemevipclient;

// 0

import android.content.Context;
import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MSSQLConnectionHelper {
    public static final String TAG = "Connection Database";

    // os dados recebidos pelas variaveis estão esrrados, devem ser mudados pelos nossos do SOMEE
    private static String mStringConnectionUrl;

    private static String mStringServerIpName = "chicobd.mssql.somee.com";

    private static String mStringUserName = "Pyisaac17_SQLLogin_1";

    private static String mStringPassword = "xyl3m6ie5h";

    private static String mStringDatabase = "BancoTCC-ChicoLeme";

    public static Connection getConnection(Context mContext){

        Connection mConnection = null;

        try{
            StrictMode.ThreadPolicy mPolicy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(mPolicy);

            Class.forName("net.sourceforge.jtds.jdbc;Driver");

            mStringConnectionUrl = "jdbc:jtds:sqlserver://" + mStringServerIpName +
                    ";databaseName=" + mStringDatabase +
                    ";user=" + mStringUserName +
                    ";password=" + mStringPassword + ";";

            mConnection = DriverManager.getConnection(mStringConnectionUrl);

            Log.i(TAG , "Connection Successful");

        } catch(ClassNotFoundException e){
            String mMessage = "Class Not Found " + e.getMessage();
            Log.e(TAG , mMessage);
        } catch(SQLException e){
            String mMessage = "Database Fail " + e.getMessage();
            Log.e(TAG , mMessage);
        } catch(Exception e){
            String mMessage = "Failure Unknown " + e.getMessage();
            Log.e(TAG , mMessage);
        }

        return mConnection;
    }

}
