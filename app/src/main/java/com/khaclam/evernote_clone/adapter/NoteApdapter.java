package com.khaclam.evernote_clone.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.khaclam.evernote_clone.R;
import com.khaclam.evernote_clone.models.Note;

import java.util.ArrayList;

public class NoteApdapter extends RecyclerView.Adapter<NoteApdapter.NoteViewHolder> {
    private LayoutInflater inflater;
    private ArrayList<Note> notes;
    private NoteListerner listerner;

    public NoteApdapter(LayoutInflater inflater) {
        this.inflater = inflater;
    }

    public void setNotes(ArrayList<Note> notes) {
        this.notes = notes;
        notifyDataSetChanged();
    }

    public void setListerner(NoteListerner listerner) {
        this.listerner = listerner;
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.row_single_note, parent, false);
        return new NoteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        Note note = notes.get(position);
        holder.bindData(note);
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public class NoteViewHolder extends RecyclerView.ViewHolder{
        private TextView tvDate, tvTitle, tvDescription;

        public NoteViewHolder(@NonNull View itemView) {
            super(itemView);
            initViews();
        }

        private void initViews() {
            tvDate = itemView.findViewById(R.id.noteDate);
            tvTitle = itemView.findViewById(R.id.noteTitle);
            tvDescription = itemView.findViewById(R.id.noteDescription);
        }

        private void bindData(Note note){
            tvDate.setText(note.getDate());
            tvTitle.setText(note.getTitle());
            tvDescription.setText(note.getContent());
        }
    }

    public interface NoteListerner{
        void onNoteClick(Note note);
    }
}
