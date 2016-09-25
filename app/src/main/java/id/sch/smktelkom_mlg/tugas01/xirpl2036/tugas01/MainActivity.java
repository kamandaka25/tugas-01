package id.sch.smktelkom_mlg.tugas01.xirpl2036.tugas01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText Ednama;
    TextView tv1, tv2, tv3, tv4;
    Button Butt;
    RadioGroup Group;
    CheckBox cb1, cb2,cb3;
    Spinner spin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Ednama = (EditText) findViewById(R.id.Nama) ;
        tv1 = (TextView) findViewById(R.id.t1);
        tv2= (TextView)findViewById(R.id.t2);
        tv3= (TextView)findViewById(R.id.t3);
        tv4 =(TextView)findViewById(R.id.t4);
        Butt =(Button)findViewById(R.id.inibutton);
        Group= (RadioGroup)findViewById(R.id.RG);
        cb1= (CheckBox)findViewById(R.id.basket);
        cb2= (CheckBox)findViewById(R.id.voli);
        cb3= (CheckBox)findViewById(R.id.futsal);
        spin= (Spinner)findViewById(R.id.jurusan);

        Butt.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                doProcess();
                deClick();
            }
        });
    }

    private void deClick() {
    String hasil = null;
        if (Group.getCheckedRadioButtonId() != -1){
            RadioButton rb = (RadioButton)
                    findViewById(Group.getCheckedRadioButtonId());
            hasil = rb.getText().toString();
        }
        if (hasil == null){
            tv2.setText("Belum Memlih");
        }
        else{
            tv2.setText("Ekstrakulikuler anda: "+ hasil);
        }
        tv3.setText("Jurusaan: "+ spin.getSelectedItem().toString());

        String hasil4 = "Hobby anda:  \nl";
        int startlen = hasil4.length();
        if (cb1.isChecked()) hasil4+=cb1.getText()+"\n";

        if (cb2.isChecked()) hasil4+=cb2.getText()+"\n";

        if (cb3.isChecked()) hasil4+=cb3.getText()+"\n";

        if (hasil.length()==startlen) hasil4+="belum memilih";
        tv4.setText(hasil4);





    }

    private void doProcess() {
        if (isValid())
        {
            String nn1 = Ednama.getText().toString();
            tv1.setText("nama:  "+ nn1);
        }
    }

    private boolean isValid() {
        boolean valid = true;
        String nn1= Ednama.getText().toString()

        if (nn1.isEmpty()) {
            Ednama.setError("mohon isi nama anda");
            valid = false;
        }
        else if (nn1.length() < 2)
        {
            Ednama.setError("nama harus lebih dari 2 karakter");
            valid = false;
        }
        else
        {
            Ednama.setError(null);
        }
        return valid;


                 }
}
