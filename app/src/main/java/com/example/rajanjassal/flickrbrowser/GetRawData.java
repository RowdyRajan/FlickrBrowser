package com.example.rajanjassal.flickrbrowser;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by rajanjassal on 2015-01-08.
 */


enum DownloadStatus {IDLE,PROCESSING,NOT_INITIALISED,FAILED_OR_EMPTY,OK};
public class GetRawData {
    private String Log_Tag = GetRawData.class.getSimpleName();
    private String mRawURL;
    private String mData;
    private DownloadStatus mDownloadStatus;

    public GetRawData(String mRawURL) {
        this.mRawURL = mRawURL;
        mDownloadStatus = DownloadStatus.IDLE;

    }

    public void reset(){
        this.mDownloadStatus = DownloadStatus.IDLE;
        this.mRawURL = null;
        this.mData = null;
    }

    public String getmData() {
        return mData;
    }

    public DownloadStatus getmDownloadStatus() {
        return mDownloadStatus;
    }

    public void setmRawURL(String mRawURL) {
        this.mRawURL = mRawURL;
    }

    public void execute(){
        mDownloadStatus = DownloadStatus.PROCESSING;
        DownLoadRawData downLoadRawData = new DownLoadRawData();
        downLoadRawData.execute(mRawURL);
    }

    public class DownLoadRawData extends AsyncTask<String,Void,String >{

        protected void onPostExecute(String webData){
            mData = webData;
            Log.v(Log_Tag,"Data returned was" + mData);
            if(mData == null){
                if(mRawURL == null){
                    mDownloadStatus = DownloadStatus.NOT_INITIALISED;
                }else {
                    mDownloadStatus = DownloadStatus.FAILED_OR_EMPTY;
                }
            }else{
                //Success
                mDownloadStatus = DownloadStatus.OK;
            }
        }

        protected String doInBackground(String ... params){
            HttpURLConnection urlConnection = null;
            BufferedReader reader = null;

            if(params == null){
                return null;
            }

            try {
                URL url = new URL(params[0]);

                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.connect();

                InputStream inputStream = urlConnection.getInputStream();
                if(inputStream == null){
                    return null;
                }

                StringBuffer buffer = new StringBuffer();

                reader = new BufferedReader(new InputStreamReader(inputStream));

                String line;
                while((line = reader.readLine())!=null) {
                    buffer.append(line + "\n");
                }
                return buffer.toString();
            }catch(IOException e){
                Log.e(Log_Tag, "Error", e);
                return null;
            }finally {
                if(urlConnection != null){
                    urlConnection.disconnect();
                }

                if(reader != null){
                    try{
                        reader.close();
                    }catch(final IOException e){
                        Log.e(Log_Tag, "Error closing stream", e);
                    }
                }
            }

        }
    }
}
