package com.example.student.activity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.student.R;
import com.example.student.entity.Insert;
import com.example.student.service.InsertService;
import com.example.student.service.InsertServiceImpl;
import com.example.student.utils.DBUtil;

import java.util.Arrays;
import java.util.List;

public class Insert2Activity extends AppCompatActivity implements View.OnClickListener {
    private Button btnSave, btnCancel;
    private EditText etName, etAge;
    private Spinner spClassmate;

    private List<String> classmates;
    private Insert insert;
    private InsertService insertService;
    private int flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert2);
        insertService = new InsertServiceImpl(this);


        initView();
        initData();
    }

    private void initData() {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle!=null){
            insert= (Insert) bundle.getSerializable("update");
        }
        if (insert!=null){
            flag=insert.getId();
            etName.setText(insert.getName());
            etAge.setText(String.valueOf(insert.getAge()));
        }
    }

    private void initView() {

        etName = findViewById(R.id.name1);
        spClassmate = findViewById(R.id.classname1);
        etAge = findViewById(R.id.old1);


        btnSave = findViewById(R.id.fix1);
        btnCancel = findViewById(R.id.break2);
        btnSave.setOnClickListener(this);
        btnCancel.setOnClickListener(this);
        classmates = Arrays.asList(getResources().getStringArray(R.array.classmate));
        spClassmate.setAdapter(new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                classmates));
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.fix1:
                updata();
                break;
            case R.id.break2:
                finish();
                break;
        }
    }



    private void updata() {
        if(insert == null) {
            insert = new Insert();
        }
        insert.setName(etName.getText().toString());
        insert.setAge(Integer.parseInt(etAge.getText().toString()));
        insert.setClass_mate(spClassmate.getSelectedItem().toString());

        insertService.modify(insert);

        // 将修改的数据返回MainActivity
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putSerializable("insert", insert);
        intent.putExtras(bundle);
        setResult(Activity.RESULT_OK, intent);
        finish();
    }
}
