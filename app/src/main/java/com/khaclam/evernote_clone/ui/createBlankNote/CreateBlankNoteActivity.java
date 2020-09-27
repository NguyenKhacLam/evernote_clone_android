package com.khaclam.evernote_clone.ui.createBlankNote;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.khaclam.evernote_clone.R;

import net.dankito.richtexteditor.android.RichTextEditor;
import net.dankito.richtexteditor.android.toolbar.GroupedCommandsEditorToolbar;
import net.dankito.richtexteditor.callback.DidHtmlChangeListener;
import net.dankito.richtexteditor.callback.GetCurrentHtmlCallback;
import net.dankito.richtexteditor.callback.HtmlChangedListener;
import net.dankito.utils.android.permissions.IPermissionsService;
import net.dankito.utils.android.permissions.PermissionsService;

import org.jetbrains.annotations.NotNull;

public class CreateBlankNoteActivity extends AppCompatActivity {
    private RichTextEditor editor;
    private GroupedCommandsEditorToolbar bottomGroupedCommandsToolbar;
    private IPermissionsService permissionsService = new PermissionsService(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_blank_note);

        initViews();
    }

    private void initViews() {
        editor = (RichTextEditor) findViewById(R.id.editor);

        // this is needed if you like to insert images so that the user gets asked for permission to access external storage if needed
        // see also onRequestPermissionsResult() below
        editor.setPermissionsService(permissionsService);

        bottomGroupedCommandsToolbar = (GroupedCommandsEditorToolbar) findViewById(R.id.editorToolbar);
        bottomGroupedCommandsToolbar.setEditor(editor);

        // you can adjust predefined toolbars by removing single commands
//        bottomGroupedCommandsToolbar.removeCommandFromGroupedCommandsView(CommandName.TOGGLE_GROUPED_TEXT_STYLES_COMMANDS_VIEW, CommandName.BOLD);
//        bottomGroupedCommandsToolbar.removeSearchView();


        editor.setEditorFontSize(20);
        editor.setPadding((4 * (int) getResources().getDisplayMetrics().density));

        // some properties you also can set on editor
//        editor.setEditorBackgroundColor(Color.YELLOW)
//        editor.setEditorFontColor(Color.MAGENTA)
//        editor.setEditorFontFamily("cursive")

        // show keyboard right at start up
//        editor.focusEditorAndShowKeyboardDelayed()

        // only needed if you allow to automatically download remote images
//        editor.setDownloadImageConfig(new DownloadImageConfig(DownloadImageUiSetting.AllowSelectDownloadFolderInCode,
//                new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "downloaded_images")));


        /*      Set listeners on RichTextEditor         */

        // get informed when edited HTML changed
        editor.addDidHtmlChangeListener(new DidHtmlChangeListener() {
            @Override
            public void didHtmlChange(boolean didHtmlChange) {
                // e.g. set save button to enabled / disabled
                // btnSave.setEnabled(didHtmlChange);
            }
        });

        // use this listener with care, it may decreases performance tremendously
        editor.addHtmlChangedListener(new HtmlChangedListener() {
            @Override
            public void htmlChangedAsync(@NotNull String html) {
                // htmlChangedAsync() gets called on a background thread, so if you want to use it on UI thread you have to call runOnUiThread()
            }
        });
    }

    // Important: Overwrite onBackPressed and pass it to toolbar.There's no other way that it can get informed of back button presses.
    @Override
    public void onBackPressed() {
        if(bottomGroupedCommandsToolbar.handlesBackButtonPress() == false) {
            super.onBackPressed();
        }
    }

    // only needed if you like to insert images from local device so the user gets asked for permission to access external storage if needed

//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        permissionsService.onRequestPermissionsResult(requestCode, permissions, grantResults);
//
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//    }


    // then when you want to do something with edited html
    private void save() {
        editor.getCurrentHtmlAsync(new GetCurrentHtmlCallback() {

            @Override
            public void htmlRetrieved(@NotNull String html) {
                saveHtml(html);
            }
        });
    }

    private void saveHtml(String html) {
        // ...
    }

}