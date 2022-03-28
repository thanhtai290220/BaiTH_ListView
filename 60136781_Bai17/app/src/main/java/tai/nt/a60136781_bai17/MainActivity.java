package tai.nt.a60136781_bai17;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView LvName;
    ArrayList<String> arrayCourse;
    TextView tv;
    Button btAdd;
    EditText edName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.tv);
        LvName =(ListView) findViewById(R.id.ListViewName);
        btAdd = (Button) findViewById(R.id.btAdd);
        edName =(EditText) findViewById(R.id.edName);


        arrayCourse =new ArrayList<>();
        arrayCourse.add("ti");
        arrayCourse.add("suu");
        arrayCourse.add("dan");
        arrayCourse.add("meo");

        ArrayAdapter adapter = new ArrayAdapter(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                arrayCourse
        );
        //
        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Name = edName.getText().toString();
                arrayCourse.add(Name);
                adapter.notifyDataSetChanged();
            }
        });


        LvName.setAdapter(adapter);
        //
        LvName.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                tv.setText("Position: "+i+ "; Value=" +arrayCourse.get(i));
            }
        });

    }


}