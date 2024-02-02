package dataproviders;

import models.BoardDTO;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderBoard {
    @DataProvider
    public Iterator<Object[]> dataProvider_deleteBoardPositiveTest() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{BoardDTO.builder().boardTitle("DP_title1").build()});
        //list.add(new Object[]{BoardDTO.builder().boardTitle("DP_title2").build()});
        //list.add(new Object[]{BoardDTO.builder().boardTitle("DP_title3").build()});
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> dataProvider_deleteBoardPositiveTestFile() {
        List<Object[]> list = new ArrayList<>();
        String path = "src/test/resources/board_titles.csv";
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(path)));
            String line = bufferedReader.readLine();  //email@mail,password123,Frodo
            while (line != null) {
                String[] split = line.split(",");
                list.add(new Object[]{BoardDTO.builder().boardTitle(split[0]).build()});
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return list.iterator();
    }
}









