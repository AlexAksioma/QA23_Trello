package dataproviders;

import models.BoardDTO;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderBoard {
    @DataProvider
    public Iterator<Object[]> dataProvider_deleteBoardPositiveTest() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{BoardDTO.builder().boardTitle("DP_title1").build()});
        list.add(new Object[]{BoardDTO.builder().boardTitle("DP_title2").build()});
        list.add(new Object[]{BoardDTO.builder().boardTitle("DP_title3").build()});
        return list.iterator();
    }

}
