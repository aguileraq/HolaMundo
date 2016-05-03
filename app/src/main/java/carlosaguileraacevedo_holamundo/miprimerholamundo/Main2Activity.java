package carlosaguileraacevedo_holamundo.miprimerholamundo;

import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    ArrayList<String> data = new ArrayList<String>();
    ArrayAdapter<String> adaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ListView my_list = (ListView)findViewById(R.id.my_list);
        Button act_return = (Button)findViewById(R.id.btn_return);
        Button btn_update = (Button)findViewById(R.id.btn_update);
        final EditText txtdata = (EditText) findViewById(R.id.txt_data);

        /*Adaptor permite convertir una lista decadenas a infomración que se puede visualizar en un list view*/
        adaptor = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, data);
        my_list.setAdapter(adaptor);

        btn_update.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                /*CharSequence txt = txtdata.getText();
                data.add(txt.toString());
                adaptor.notifyDataSetChanged();*/

                SQLiteDatabase db = SQLiteDatabase.openDatabase("/storage/emulated/sdc0/DB/Agenda.sqlite",null,SQLiteDatabase.OPEN_READONLY);
            }
        });
        act_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
