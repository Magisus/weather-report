package hu.ait.android.maggie.weatherreport;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import de.greenrobot.event.EventBus;
import hu.ait.android.maggie.weatherreport.data.WeatherResult;


public class MainActivity extends ActionBarActivity {

    private static final String URL_BASE = "http://api.openweathermap.org/data/2.5/weather?q=";
    private static final String CELSIUS_LABEL = "°C";
    private static final String FAHRENHEIT_LABEL = "°F";

    private TextView currentTempText;
    private TextView loTempText;
    private TextView highTempText;
    private TextView humidityText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentTempText = (TextView) findViewById(R.id.currentTempText);
        loTempText = (TextView) findViewById(R.id.loTempText);
        highTempText = (TextView) findViewById(R.id.highTempText);
        humidityText = (TextView) findViewById(R.id.humidityText);

        final EditText cityEdit = (EditText) findViewById(R.id.cityEdit);

        Button getWeatherBtn = (Button) findViewById(R.id.getWeatherBtn);
        getWeatherBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String query = URL_BASE + cityEdit.getText().toString() + "&units=metric";

                new HttpGetTask(getApplicationContext()).execute(query);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        EventBus.getDefault().unregister(this);
    }

    public void onEventMainThread(WeatherResult result){
        currentTempText.setText(result.getMain().getTemp() + CELSIUS_LABEL);
        loTempText.setText("Lo: " + result.getMain().getTempMin() + CELSIUS_LABEL);
        highTempText.setText("Hi: " + result.getMain().getTempMax() + CELSIUS_LABEL);
        humidityText.setText("Humidity: " + result.getMain().getHumidity() + "%");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
