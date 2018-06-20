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
}
