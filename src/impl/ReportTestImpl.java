package impl;

import enity.ReportTest;

import java.util.List;

/**
 * Created by abc on 2017/11/3.
 */
public class ReportTestImpl extends comm.BaseDao {


    public List<ReportTest> getReportTestList(String flag) {
        String watch = "";

        switch (flag) {

            case "BMI":
                watch = "reporttestbmi";
                break;
            case "AGE":
                watch = "reporttestage";
                break;
            case "SMOKE":
                watch = "reporttestsmoke";
                break;
            case "SBP":
                watch = "reporttestsbp";
                break;
            case "CHOL":
                watch = "reporttestchol";
                break;
            case "DIABETES":
                watch = "reporttestdiabetes";
                break;
        }
        String sql = "select * from " + watch;
        List<ReportTest> list = (List<ReportTest>) super.executeQuery(sql, null, ReportTest.class);

       /* for (ReportTest reportTest : list) {
            int myresult = ReportTest.getMyReportTest(flag, reportTest);

            if (myresult == reportTest.expectgrade) {
                sql = "UPDATE " + watch + " SET fit = 1 WHERE id = " + reportTest.id + "";
            } else {
                sql = "UPDATE " + watch + " SET fit = 0 WHERE id = " + reportTest.id + "";
            }
            int insertresult1 = super.executeUpdate(sql, null);
            sql = "UPDATE " + watch + " SET realitygrade = " + myresult + " WHERE id = " + reportTest.id + "";
            int insertresult2 = super.executeUpdate(sql, null);
        }
         sql = "select * from " + watch;
        list = (List<ReportTest>) super.executeQuery(sql, null, ReportTest.class);*/
        return list;


    }
}
