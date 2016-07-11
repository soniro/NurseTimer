package de.soniro.nursetimer;

import de.soniro.nursetimer.model.DataSet;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class DataSetServiceTest {

    @Mock
    private DataSetStore dataSetStore;

    private DataSetService dataSetService;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        dataSetService = new DataSetService(dataSetStore);
    }

    @Test
    public void shouldReturnAListOfAllStoredDataSets() {
        List<DataSet> dataSetsFromStore = createDataSets(2);
        when(dataSetStore.getDataSets()).thenReturn(dataSetMapFrom(dataSetsFromStore));

        List<DataSet> dataSets = dataSetService.getAllDataSets();

        assertThat(dataSets, is(dataSetsFromStore));
    }

    private Map<String, DataSet> dataSetMapFrom(List<DataSet> dataSets) {
        Map<String, DataSet> dataSetMap = new HashMap<>();
        for (DataSet dataSet : dataSets) {
            dataSetMap.put(dataSet.getId(), dataSet);
        }
        return dataSetMap;
    }

    private List<DataSet> createDataSets(int numberOfDataSets) {
        List<DataSet> dataSets = new ArrayList<>();
        for (int i = 0; i < numberOfDataSets; i++) {
            dataSets.add(DataSet.builder().id("dataSet" + i).build());
        }
        return dataSets;
    }

}