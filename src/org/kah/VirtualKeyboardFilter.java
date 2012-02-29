package org.kah;

import java.util.ArrayList;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Activity demonstrating filtering a list using
 * {@link ListView#setTextFilterEnabled(boolean)} with a virtual keyboard, for
 * input. As far as I know, this only works up to Android 2.3.3.
 * 
 * @author Kah Goh
 */
public class VirtualKeyboardFilter extends ListActivity {

    /**
     * {@inheritDoc}
     */
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

    /**
     * {@inheritDoc}
     */
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

    /**
     * Displays the virtual keyboard.
     */
    private void showKeyboard() {
	final InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

	if (imm != null) {
	    imm.showSoftInput(getListView(), 0, new ResultReceiver(
		    new Handler()) {

		@Override
		protected void onReceiveResult(int resultCode, Bundle resultData) {
		    if (resultCode == InputMethodManager.RESULT_SHOWN
			    || resultCode == InputMethodManager.RESULT_UNCHANGED_SHOWN) {
			Toast.makeText(getApplicationContext(),
				R.string.keyboardShown, Toast.LENGTH_SHORT)
				.show();
		    } else {
			Toast.makeText(getApplicationContext(),
				R.string.keyboardHidden, Toast.LENGTH_LONG)
				.show();
		    }
		}
	    });
	} else {
	    Toast.makeText(this, R.string.noInputManager, Toast.LENGTH_LONG)
		    .show();
	}
    }
}
