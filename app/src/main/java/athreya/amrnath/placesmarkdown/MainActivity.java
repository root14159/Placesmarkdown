package athreya.amrnath.placesmarkdown;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView text = (TextView)findViewById(R.id.textView);
        listView = (ListView) findViewById(R.id.listView);
        final ArrayList<String> general = new ArrayList<String>();
        general.add("click to add place");
        Intent k = getIntent();
        String dave =k.getStringExtra("address");
        if(dave!=null){
            text.setText(dave);
            general.add(dave);
            dave = null;
        }
            //text.setText(dave);
            ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, general);
            listView.setAdapter(arrayAdapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Intent j = new Intent(getApplicationContext(), MapsActivity.class);
                    startActivity(j);


                }
            });

    }
}
