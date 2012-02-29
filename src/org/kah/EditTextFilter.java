package org.kah;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

/**
 * Activity demonstrating filtering a list. The content is filtered as the
 * content of the {@link EditText} is changed.
 * 
 * @author Kah Goh
 */
public class EditTextFilter extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.main);

	// This array list will be updated each time.
	final ArrayList<String> data = new ArrayList<String>();
	data.add("apple");
	data.add("banana");
	data.add("grape");
	data.add("orange");
	data.add("pear");
	data.add("peach");
	data.add("tomato");

	final ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
		R.layout.item, R.id.itemName, data);

	ListView listView = (ListView) findViewById(R.id.list);
	listView.setAdapter(dataAdapter);

	final EditText filterEditor = (EditText) findViewById(R.id.editFilter);

	// Add a listener to the EditText that will update the filter.
	filterEditor.addTextChangedListener(new TextWatcher() {

	    @Override
	    public void onTextChanged(CharSequence s, int start, int before,
		    int count) {
		updateText();
	    }

	    @Override
	    public void beforeTextChanged(CharSequence s, int start, int count,
		    int after) {
		updateText();
	    }

	    @Override
	    public void afterTextChanged(Editable s) {
		updateText();
	    }

	    private void updateText() {
		// Update the filter according to the contents of the field.
		dataAdapter.getFilter().filter(
			filterEditor.getText().toString());
	    }
	});
    }
}
