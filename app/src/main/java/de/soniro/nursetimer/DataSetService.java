package de.soniro.nursetimer;

import de.soniro.nursetimer.model.DataSet;

import java.util.ArrayList;
import java.util.List;

public class DataSetService {

    private DataSetStore dataSetStore;

    public DataSetService(DataSetStore dataSetStore) {
        this.dataSetStore = dataSetStore;
    }

    public List<DataSet> getAllDataSets() {
        return new ArrayList<>(dataSetStore.getDataSets().values());
    }
}
