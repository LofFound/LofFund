package data;

import dataService.SaveFundData;
import po.FundDateDataPO;
import tool.DataSuperClass;
import tool.IOHelper;

import java.io.FileNotFoundException;
import java.rmi.RemoteException;
import java.sql.Array;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Qiang
 * @date 8/28/16
 */
public class SaveFundDataImpl extends DataSuperClass implements SaveFundData {

    private final String tableName = "fund";

    public SaveFundDataImpl() throws RemoteException {
        super();
    }


    public boolean updateFundData(Date start, Date end) {

        return false;
    }

    public boolean updateFundData(Date date) {
        List<String> fundList = getAllFundCodeList();
        for (String fund : fundList){
            System.out.println(fund);
        }
        return false;
    }


    private boolean writeToDataBase(FundDateDataPO po){
        String sql = super.bulidAddSQL(tableName , 6);
        try {
            preState = conn.prepareStatement(sql);
            preState.setDate(0,po.date);
            preState.setString(1, po.code);
            preState.setDouble(2,po.open);
            preState.setDouble(3,po.close);
            preState.setDouble(4, po.high);
            preState.setDouble(5,po.low);
            affectRows = preState.executeUpdate();
        }  catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        if(affectRows == 0){
            return false;
        }

        return true;
    }

    private static List<String> getAllFundCodeList(){
        try {
            List<String> funds = IOHelper.getFileData("code.txt");
            List<String> newFunds = new ArrayList<String>(funds.size());
            for (String fund : funds){
                if (fund.length() > 8){
                    fund = fund.substring(2,8) + "." + fund.substring(0,2);
                    newFunds.add(fund);
                }






            }


            return  newFunds;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }




}
