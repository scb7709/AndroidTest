package enity;

/**
 * Created by abc on 2017/11/3.
 */
public class ReportTest {
    public int id;
    public int grade;
    public double flag;
    public int expectgrade;
    public int realitygrade;
    public int fit;


    public String getFlag(String flag, double Flag) {
        String result = "";
        switch (flag) {
            case "年龄":
                result = (int) Flag + "";
                break;
            case "吸烟":
            case "糖尿病":
                if (Flag == 1.0) {
                    result = "是";
                } else {
                    result = "否";
                }

                break;
            default:
                result = Flag + "";
                break;
        }
        return result;
    }

    public static int getMyReportTest(String flag, ReportTest reportTest) {
        int getMyReportTest = 0;
        switch (flag) {
            case "BMI":
                if (reportTest.grade == 1) {
                    if (reportTest.flag < 24) {
                        getMyReportTest = 0;
                    } else if (reportTest.flag <= 27.9) {
                        getMyReportTest = 1;
                    } else if (reportTest.flag >= 28) {
                        getMyReportTest = 2;
                    }
                } else {
                    if (reportTest.flag < 24) {
                        getMyReportTest = 0;
                    } else if (reportTest.flag < 28) {
                        getMyReportTest = 1;
                    } else if (reportTest.flag >= 28) {
                        getMyReportTest = 2;
                    }
                }
                break;
            case "AGE":
                if (reportTest.flag <= 39) {
                    getMyReportTest = 0;
                } else if (reportTest.flag <= 44) {
                    getMyReportTest = 1;
                } else if (reportTest.flag <= 49) {
                    getMyReportTest = 2;
                } else if (reportTest.flag <= 54) {
                    getMyReportTest = 3;
                } else if (reportTest.flag <= 59) {
                    getMyReportTest = 4;
                } else if (reportTest.flag <= 64) {
                    getMyReportTest = 5;
                } else if (reportTest.flag <= 69) {
                    getMyReportTest = 6;
                } else if (reportTest.flag <= 74) {
                    getMyReportTest = 7;
                } else if (reportTest.flag <= 79) {
                    getMyReportTest = 8;
                } else if (reportTest.flag <= 84) {
                    getMyReportTest = 9;
                } else if (reportTest.flag <= 89) {
                    getMyReportTest = 10;
                } else if (reportTest.flag <= 94) {
                    getMyReportTest = 11;
                } else if (reportTest.flag <= 99) {
                    getMyReportTest = 12;
                }
                break;
            case "SMOKE":
                if (reportTest.grade == 1) {
                    if (reportTest.flag == 0) {
                        getMyReportTest = 0;
                    } else {
                        getMyReportTest = 2;
                    }
                } else {
                    if (reportTest.flag == 0) {
                        getMyReportTest = 0;
                    } else {
                        getMyReportTest = 1;
                    }
                }
                break;
            case "SBP":
                if (reportTest.grade == 1) {
                    if (reportTest.flag < 120) {
                        getMyReportTest = -2;
                    } else if (reportTest.flag < 130) {
                        getMyReportTest = 0;
                    } else if (reportTest.flag < 140) {
                        getMyReportTest = 1;
                    } else if (reportTest.flag < 160) {
                        getMyReportTest = 2;
                    } else if (reportTest.flag < 180) {
                        getMyReportTest = 5;
                    } else {
                        getMyReportTest = 8;
                    }
                } else {
                    if (reportTest.flag < 120) {
                        getMyReportTest = -2;
                    } else if (reportTest.flag < 130) {
                        getMyReportTest = 0;
                    } else if (reportTest.flag < 140) {
                        getMyReportTest = 1;
                    } else if (reportTest.flag < 160) {
                        getMyReportTest = 2;
                    } else if (reportTest.flag < 180) {
                        getMyReportTest = 3;
                    } else {
                        getMyReportTest = 4;
                    }
                }
                break;
            case "CHOL":
                if (reportTest.flag < 5.2) {
                    getMyReportTest = 0;
                } else {
                    getMyReportTest = 1;
                }
                break;
            case "DIABETES":
                if (reportTest.grade == 1) {
                    if (reportTest.flag ==0) {
                        getMyReportTest = 0;
                    } else {
                        getMyReportTest = 1;
                    }
                } else {
                    if (reportTest.flag ==0) {
                        getMyReportTest = 0;
                    } else {
                        getMyReportTest = 2;
                    }


                }
                break;
        }
        return getMyReportTest;
    }
}
