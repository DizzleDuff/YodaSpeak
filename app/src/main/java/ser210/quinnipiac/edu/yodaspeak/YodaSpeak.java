package ser210.quinnipiac.edu.yodaspeak;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class YodaSpeak extends AsyncTask<String, String, String> {
    // URL and corresponding Key from API
    static String URLFORMAT = "https://yoda.p.mashape.com/yoda?sentence=%s&mashape-key=%s";
    static String KEY = "8d92hSqi2hmsh3erwbsTfDZ3Y4oQp1atUhijsnN2HmfEEiRXVw";
    private MainFragmentActivity main;

    private MainFragmentActivity fragmentActivity;

    public YodaSpeak(MainFragmentActivity m) {
        main = m;
    }

    // making connection to website
    @Override
    protected String doInBackground(String... strings) {
        String result;
        BufferedReader reader = null;
        HttpURLConnection urlConnection = null;

        if (strings[0].length() == 0) return null;

        try {
            URL url = new URL(String.format(URLFORMAT, URLEncoder.encode(strings[0], "UTF-8"), KEY));
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            InputStream in = urlConnection.getInputStream();
            if (in == null) return null;
            reader = new BufferedReader(new InputStreamReader(in));
            String line;
            String msg = "";
            while ((line = reader.readLine()) != null) {
                msg += line + '\n';
            }
            if (msg.length() == 0) return null;
            return msg;
        } catch (Exception e) {
            Log.e("Exception e: ", e.getMessage());
        } finally {
            try {
                if (reader != null)
                    reader.close();
                if (urlConnection != null)
                    urlConnection.disconnect();
            } catch (Exception e2) {
                Log.e("Exception e2: ", e2.getMessage());
            }
        }
        // if unable to connect to website return
        return "Error.\nYoda API is down as usual.";
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        main.showMessage(s);
    }
}
