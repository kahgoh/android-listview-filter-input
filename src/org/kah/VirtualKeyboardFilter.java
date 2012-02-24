package org.kah;

import java.util.ArrayList;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Toast;

public class VirtualKeyboardFilter extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);

	// This array list will be updated each time.
	final ArrayList<String> data = new ArrayList<String>();
	data.add("apple");
	data.add("banana");
	data.add("grape");
	data.add("orange");
	data.add("pear");
	data.add("peach");
	data.add("tomato");

	ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
		R.layout.item, R.id.itemName, data);

	setListAdapter(dataAdapter);
	getListView().setTextFilterEnabled(true);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
	super.onWindowFocusChanged(hasFocus);
	if (hasFocus) {
	    getListView().post(new Runnable() {

		@Override
		public void run() {
		    showKeyboard();
		}
	    });
	}
    }

    private void showKeyboard() {
	final InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

	if (imm != null) {
	    imm.showSoftInput(getListView(), 0);
	    Toast.makeText(getApplicationContext(), R.string.keyboardShown,
		    Toast.LENGTH_SHORT).show();
	} else {
	    Toast.makeText(this, R.string.noInputManager, Toast.LENGTH_LONG)
		    .show();
	}
    }
}
