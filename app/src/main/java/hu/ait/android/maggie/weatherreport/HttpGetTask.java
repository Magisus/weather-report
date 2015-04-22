package hu.ait.android.maggie.weatherreport;

import android.content.Context;
import android.os.AsyncTask;

import com.google.gson.Gson;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import de.greenrobot.event.EventBus;
import hu.ait.android.maggie.weatherreport.data.WeatherResult;

/**
 * Created by Magisus on 4/22/2015.
 */
public class HttpGetTask extends AsyncTask<String, Void, String> {

    public final static String FILTER_RESULT = "FILTER_RESULT";
    public static final String KEY_RESULT = "KEY_RESULT";

    private Context context;

    public HttpGetTask(Context context) {
        this.context = context;
    }

    @Override
    protected String doInBackground(String... params) {
        String result = "";

        HttpURLConnection connection = null;
        InputStream in = null;

        try {
            URL url = new URL(params[0]);
            connection = (HttpURLConnection) url.openConnection();

            connection.setConnectTimeout(10000);
            connection.setReadTimeout(10000);

            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                in = connection.getInputStream();

                int ch;
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                while ((ch = in.read()) != -1) {
                    out.write(ch);
                }

                result = new String(out.toByteArray());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (connection != null) {
                connection.disconnect();
            }
        }

        return result;
    }

    @Override
    protected void onPostExecute(String result) {
        try {
            Gson gson = new Gson();
            WeatherResult weatherResult = gson.fromJson(result,
                    WeatherResult.class);

            EventBus.getDefault().post(weatherResult);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
