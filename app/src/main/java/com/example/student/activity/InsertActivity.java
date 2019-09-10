package com.example.student.activity;

import android.app.Activity;
import android.content.Intent;
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

import java.util.Arrays;
import java.util.List;

public class InsertActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnSave, btnCancel;
    private EditText etName, etAge;
    private Spinner spClassmate;

    private List<String> classmates;
    private Insert insert;
    private InsertService insertService;
    private String flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        insertService = new InsertServiceImpl(this);

        initView();
    }



    private void initView() {
        etName = findViewById(R.id.name);
        spClassmate = findViewById(R.id.classname);
        etAge = findViewById(R.id.old);


        btnSave = findViewById(R.id.ok);
        btnCancel = findViewById(R.id.break1);
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
        switch (view.getId()) {
            case R.id.ok:
                updateInsert();
                break;
            case R.id.break1:
                finish();
        }
    }

    private void updateInsert() {
        if(insert == null) {
            insert = new Insert();
        }
        insert.setName(etName.getText().toString());
        insert.setAge(Integer.parseInt(etAge.getText().toString()));
        insert.setClass_mate(spClassmate.getSelectedItem().toString());

            insertService.insert(insert);

        // 将修改的数据返回MainActivity
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putSerializable("insert", insert);
        intent.putExtras(bundle);
        setResult(Activity.RESULT_OK, intent);
        finish();
    }
    }
