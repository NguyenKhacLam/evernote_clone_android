package com.khaclam.evernote_clone.ui.allNote;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.github.clans.fab.FloatingActionButton;
import com.khaclam.evernote_clone.R;
import com.khaclam.evernote_clone.adapter.NoteApdapter;
import com.khaclam.evernote_clone.models.Note;
import com.khaclam.evernote_clone.ui.createBlankNote.CreateBlankNoteActivity;

import java.util.ArrayList;

public class AllNoteFragment extends Fragment implements NoteApdapter.NoteListerner, View.OnClickListener {
    private RecyclerView recyclerView;
    private NoteApdapter apdapter;

    private FloatingActionButton blankBtn, imgBtn, audioBtn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_all_note,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initViews();
        loadData();
    }

    private void loadData() {
        ArrayList<Note> notes = new ArrayList<>();
        notes.add(new Note("sdas465","Idea 1","Android's bottom app bar component APIs provide support for the navigation icon, action items, overflow menu and more for informing the user as to what each action performs. While optional, their use is strongly encouraged.", "Monday","15431asd"));
        notes.add(new Note("sdas465","Idea 2","Android's bottom app bar component APIs provide support for the navigation icon, action items, overflow menu and more for informing the user as to what each action performs. While optional, their use is strongly encouraged.", "Monday","15431asd"));
        notes.add(new Note("sdas465","Idea 3","Android's bottom app bar component APIs provide support for the navigation icon, action items, overflow menu and more for informing the user as to what each action performs. While optional, their use is strongly encouraged.", "Monday","15431asd"));
        notes.add(new Note("sdas465","Idea 4","Android's bottom app bar component APIs provide support for the navigation icon, action items, overflow menu and more for informing the user as to what each action performs. While optional, their use is strongly encouraged.", "Monday","15431asd"));
        notes.add(new Note("sdas465","Idea 5","Android's bottom app bar component APIs provide support for the navigation icon, action items, overflow menu and more for informing the user as to what each action performs. While optional, their use is strongly encouraged.", "Monday","15431asd"));
        notes.add(new Note("sdas465","Idea 6","Android's bottom app bar component APIs provide support for the navigation icon, action items, overflow menu and more for informing the user as to what each action performs. While optional, their use is strongly encouraged.", "Monday","15431asd"));
        apdapter.setNotes(notes);
    }

    private void initViews() {
        recyclerView = getActivity().findViewById(R.id.allNoteRcView);

        recyclerView.setHasFixedSize(true);
        apdapter = new NoteApdapter(getLayoutInflater());
        apdapter.setListerner(this);
        recyclerView.setAdapter(apdapter);

        blankBtn = getActivity().findViewById(R.id.noteBlankText);
        imgBtn = getActivity().findViewById(R.id.notePhotoText);
        audioBtn = getActivity().findViewById(R.id.noteAudioText);

        blankBtn.setOnClickListener(this);
        imgBtn.setOnClickListener(this);
        audioBtn.setOnClickListener(this);
    }

    @Override
    public void onNoteClick(Note note) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.noteBlankText:
                Toast.makeText(getContext(), "Blank", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getContext(), CreateBlankNoteActivity.class));
                break;
            case R.id.notePhotoText:
                Toast.makeText(getContext(), "Photo", Toast.LENGTH_SHORT).show();
                break;
            case R.id.noteAudioText:
                Toast.makeText(getContext(), "Audio", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
