package com.khaclam.evernote_clone.models;

public class Note {
    private String id;
    private String title;
    private String content;
    private String date;
    private String noteBookId;

    public Note(String id, String title, String content, String date, String noteBookId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.date = date;
        this.noteBookId = noteBookId;
    }

    public String getDate() {
        return date;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getNoteBookId() {
        return noteBookId;
    }
}
