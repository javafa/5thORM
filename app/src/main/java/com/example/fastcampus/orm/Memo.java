package com.example.fastcampus.orm;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "memo")
public class Memo {
    @DatabaseField(generatedId = true) // 자동증가
    int no;
    @DatabaseField
    String title;
    @DatabaseField
    String memo;
    @DatabaseField
    String author;
    @DatabaseField
    long timestamp;

    public Memo(){
        // 디폴트 생성자 필수
    }

    public Memo(String title, String memo, String author, long timestamp){
        this.title = title;
        this.memo = memo;
        this.author = author;
        this.timestamp = timestamp;
    }
}
