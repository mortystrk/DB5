package igor.bstu.by.db5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import hash.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private final String fileName = "Lab.txt";
    private HashTable hashTable;
    private File file;
    private EditText key, value, keySearch;
    private TextView valueView;

    private boolean ExistBase(String fileName){
        boolean flag;
        File file = new File(super.getFilesDir(), fileName);
        if(flag = file.exists()){
            Log.d("Log_05", "Файл " + fileName + " существует");
        }
        else{
            Log.d("Log_05", "Файл " + fileName + " не найден");
        }
        return flag;
    }

    private void CreateFile(){
        try{
            file.createNewFile();
            Log.d("Log_05", "Файл " + fileName + " создан");
        } catch (IOException e) {
            Log.d("Log_05", "Файл " + fileName + " не создан");
        }
    }

    public void onSaveInHashTable(View view){
        hashTable.Insert(key.getText().toString(), value.getText().toString(),
                file);
        key.setText("");
        value.setText("");
    }

    public void onSearchFromHashTable(View view) throws FileNotFoundException {
         valueView.setText(hashTable.Find(keySearch.getText().toString(), file));
    }

    public void onOpenFile(View view){
        Intent intent = new Intent(this, FileContent.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        file = new File(super.getFilesDir(), fileName);
        if(!ExistBase(fileName)){
            CreateFile();
        }

        hashTable = new HashTable();
        key = (EditText) findViewById(R.id.editKey);
        value = (EditText) findViewById(R.id.editValue);
        keySearch = (EditText) findViewById(R.id.keySearch);
        valueView = (TextView) findViewById(R.id.valueView);
    }
}
