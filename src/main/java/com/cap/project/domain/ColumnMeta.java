package com.cap.project.domain;

import lombok.*;

@Data

@Builder
public class ColumnMeta {
    private String columnId;
    private String title;
    private int position;

    public ColumnMeta() {
    }

    public ColumnMeta(String columnId, String title, int position) {
        this.columnId = columnId;
        this.title = title;
        this.position = position;
    }

    public String getColumnId() {
        return columnId;
    }

    public void setColumnId(String columnId) {
        this.columnId = columnId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
