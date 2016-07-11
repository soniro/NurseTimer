package de.soniro.nursetimer;

import de.soniro.nursetimer.model.DataSet;

import java.util.HashMap;
import java.util.Map;

import static de.soniro.nursetimer.DataSetStore.DataSetStoreResult.*;

public class DataSetStore {

    private Map<String, DataSet> dataSets = new HashMap<>();

    public Map<String, DataSet> getDataSets() {
        return dataSets;
    }

    public DataSetStoreResult store(DataSet dataSet) {
        DataSet overwrittenDataSet = dataSets.put(dataSet.getId(), dataSet);
        if (overwrittenDataSet == null) {
            return CREATED;
        } else {
            return UPDATED;
        }
    }

    public DataSetStoreResult delete(String dataSetId) {
        DataSet deletedDataSet = dataSets.remove(dataSetId);
        if (deletedDataSet == null) {
            return NOTHING_TO_DELETE;
        } else {
            return DELETED;
        }
    }

    public enum DataSetStoreResult {
        CREATED, UPDATED, DELETED, NOTHING_TO_DELETE;
    }
}
