package de.soniro.nursetimer;

import de.soniro.nursetimer.DataSetStore.DataSetStoreResult;
import de.soniro.nursetimer.model.DataSet;
import de.soniro.nursetimer.model.DateTime;
import org.junit.Before;
import org.junit.Test;

import static de.soniro.nursetimer.DataSetStore.DataSetStoreResult.*;
import static de.soniro.nursetimer.model.TimeUnit.MINUTES;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class DataSetStoreTest {

    private static final String SOME_DATASET_ID = "someId";

    private DataSetStore dataSetStore;

    @Before
    public void setUp() throws Exception {
        dataSetStore = new DataSetStore();
    }

    @Test
    public void shouldBeAbleToStoreANewDataSet() {
        DataSet dataSet = someDataSet().build();
        assertThat(dataSetStore.getDataSets().keySet(), hasSize(0));

        DataSetStoreResult storeResult = dataSetStore.store(dataSet);

        assertThat(storeResult, is(CREATED));
        assertThat(dataSetStore.getDataSets().keySet(), hasSize(1));
        assertThat(dataSetStore.getDataSets().get(SOME_DATASET_ID), is(dataSet));
    }

    @Test
    public void shouldBeAbleToEditExistingDataSet() {
        DataSet.DataSetBuilder dataSet = setupDataStoreContainingSomeDataset();

        DataSet updatedDataSet = dataSet.endTime(DateTime.now().minus(5, MINUTES)).build();
        DataSetStoreResult storeResult = dataSetStore.store(updatedDataSet);

        assertThat(storeResult, is(UPDATED));
        assertThat(dataSetStore.getDataSets().keySet(), hasSize(1));
        assertThat(dataSetStore.getDataSets().get(SOME_DATASET_ID), is(updatedDataSet));
    }

    @Test
    public void shouldBeAbleToDeleteDataSet() {
        setupDataStoreContainingSomeDataset();

        DataSetStoreResult storeResult = dataSetStore.delete(SOME_DATASET_ID);

        assertThat(storeResult, is(DELETED));
        assertThat(dataSetStore.getDataSets().keySet(), hasSize(0));
    }

    @Test
    public void shouldNotCrashIfDeletingNonExistingDataSet() {
        DataSetStoreResult storeResult = dataSetStore.delete(SOME_DATASET_ID);

        assertThat(storeResult, is(NOTHING_TO_DELETE));
        assertThat(dataSetStore.getDataSets().keySet(), hasSize(0));

    }

    private DataSet.DataSetBuilder setupDataStoreContainingSomeDataset() {
        DataSet.DataSetBuilder dataSet = someDataSet();
        dataSetStore.store(dataSet.build());
        assertThat(dataSetStore.getDataSets().keySet(), hasSize(1));
        return dataSet;
    }

    private DataSet.DataSetBuilder someDataSet() {
        return DataSet.builder()
                .id(SOME_DATASET_ID)
                .startTime(DateTime.now().minus(32, MINUTES))
                .endTime(DateTime.now());
    }

}