package data;

import dataService.SaveFundData;
import org.junit.Before;
import org.junit.Test;

import java.sql.Date;

import static org.junit.Assert.*;

/**
 * @author Qiang
 * @date 8/28/16
 */
public class SaveFundDataImplTest {
    SaveFundData service;
    @Before
    public void setUp() throws Exception {
        service = new SaveFundDataImpl();
    }

    @Test
    public void updateFundData() throws Exception {

    }

    @Test
    public void updateFundData1() throws Exception {
        service.updateFundData(new Date(2016,8,26));

    }

}