package com.example.fastcampus.orm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.j256.ormlite.dao.Dao;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView textNo,textAuthor,textDate;
    EditText editTitle, editContent;
    Button btnPost;
    TextView list;

    DBConnect con;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // DB 연결
        con = new DBConnect(this);
        //
        textNo = findViewById(R.id.textNo);
        textAuthor = findViewById(R.id.textAuthor);
        textDate = findViewById(R.id.textDate);
        list = findViewById(R.id.list);
        //
        editTitle = findViewById(R.id.editTitle);
        editContent = findViewById(R.id.editContent);
        //
        btnPost = findViewById(R.id.btnPost);
        btnPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 여기서 화면의 값을 가져오고
                String title = editTitle.getText().toString();
                String content = editContent.getText().toString();
                // 필수값 가져오기
                long timestamp = System.currentTimeMillis();
                timestamp = timestamp + 150;
                String author = textAuthor.getText().toString();
                try {
                    Memo memo = new Memo(title, content, author, timestamp);
                    Dao<Memo, Integer> memoDao = con.getMemoDao();
                    memoDao.create(memo);
                    loadData();
                } catch (Exception e) {
                    Toast.makeText(getBaseContext(), "DB 오류:"+e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });
        loadData();
    }

    private void loadData(){
        try {
            // dao 를 가져오고
            Dao<Memo, Integer> memoDao = con.getMemoDao();
            // memo 테이블의 전체 목록을 가져온다
            List<Memo> data = memoDao.queryForAll();
            // 먼저 목록을 삭제하고
            list.setText("");
            // 새로운 목록을 입력한다
            for(Memo memo : data){
                list.append(memo.no + ":" + memo.title + ":" + memo.timestamp + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
