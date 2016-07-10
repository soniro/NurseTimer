package de.soniro.nursetimer.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import de.soniro.nursetimer.DataSet;
import de.soniro.nursetimer.R;

import java.util.List;

import static de.soniro.nursetimer.TimeUnit.MINUTES;

public class DataSetAdapter extends ArrayAdapter<DataSet> {

    public DataSetAdapter(Context context, List<DataSet> dataSets) {
        super(context, 0, dataSets);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        DataSet dataSet = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_dataset, parent, false);
        }

        TextView startTimeTextView = (TextView) convertView.findViewById(R.id.startTime);
        TextView endTimeTextView = (TextView) convertView.findViewById(R.id.endTime);
        TextView durationTextView = (TextView) convertView.findViewById(R.id.duration);

        startTimeTextView.setText(dataSet.getStartTime().toString());
        endTimeTextView.setText(dataSet.getEndTime().toString());
        durationTextView.setText(dataSet.getDuration(MINUTES) + " minutes");

        return convertView;
    }
}