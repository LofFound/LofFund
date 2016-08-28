package po;

import java.sql.Date;

/**
 * 基金日数据
 * @author Qiang
 * @date 8/28/16
 */
public class FundDateDataPO {
    public String code;
    public Date date;
    public double open;
    public double close;
    public  double high;
    public double low;


    public FundDateDataPO(double close, String code, Date date, double high, double low, double open) {
        this.close = close;
        this.code = code;
        this.date = date;
        this.high = high;
        this.low = low;
        this.open = open;
    }
}
