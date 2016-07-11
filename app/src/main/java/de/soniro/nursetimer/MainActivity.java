package de.soniro.nursetimer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;
import de.soniro.nursetimer.model.DataSet;
import de.soniro.nursetimer.model.DateTime;
import de.soniro.nursetimer.ui.DataSetAdapter;

import static de.soniro.nursetimer.model.TimeUnit.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DataSetStore dataSetStore = new DataSetStore();
        addSampleData(dataSetStore);
        DataSetService dataSetService = new DataSetService(dataSetStore);
        DataSetAdapter adapter = new DataSetAdapter(this, dataSetService.getAllDataSets());

        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
    }

    private void addSampleData(DataSetStore dataSetStore) {
        dataSetStore.store(DataSet.builder()
                .id("dataSet1")
                .startTime(DateTime.now().minus(2, DAYS).minus(43, MINUTES))
                .endTime(DateTime.now().minus(2, DAYS))
                .build());
        dataSetStore.store(DataSet.builder()
                .id("dataSet2")
                .startTime(DateTime.now().minus(1, DAYS).minus(2, HOURS))
                .endTime(DateTime.now().minus(1, DAYS).minus(75, MINUTES))
                .build());
        dataSetStore.store(DataSet.builder()
                .id("dataSet3")
                .startTime(DateTime.now().minus(50, MINUTES))
                .endTime(DateTime.now().minus(15, MINUTES))
                .build());
    }

}
