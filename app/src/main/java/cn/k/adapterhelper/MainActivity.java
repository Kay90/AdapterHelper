package cn.k.adapterhelper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = (ListView) findViewById(R.id.listView);
        List<String> data = new ArrayList<>();
        data.add("123");
        data.add("1234");
        data.add("12345");
        data.add("123456");
        data.add("1234567");
        data.add("12345678");
        BaseAdapterHelper<String> adapter = new BaseAdapterHelper<String>(this, data, R.layout.item) {
            @Override
            protected void convert(ViewHolderHelper helper, String data) {
                helper.getTextView(R.id.text).setText(data);
                helper.getImageView(R.id.image).setBackgroundResource(R.mipmap.ic_launcher);
            }
        };
        listView.setAdapter(adapter);
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
