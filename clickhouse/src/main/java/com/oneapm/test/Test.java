package com.oneapm.test;

import java.sql.*;

public class Test {
    public static void main(String[] args) {
        String driver = "ru.yandex.clickhouse.ClickHouseDriver";
        String url = "jdbc:clickhouse://10.128.8.33:38123/midata?useSSL=false&useUnicode=true&characterEncoding=UTF-8&autoReconnect=true&failOverReadOnly=false&maxReconnects=10";
        String username = "";
        String password = "";
        Connection conn = null;

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {//这异常要经常处理!(3)
            e.printStackTrace();
        }

        try {
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT\n" +
                    "        app_id,\n" +
                    "        uniqHLL12Merge(visit_count) AS visit_count,\n" +
                    "        uniqHLL12Merge(customer_count) AS customer_count,\n" +
                    "        uniqHLL12Merge(device_uuid_count) AS device_uuid_count,\n" +
                    "        sumMerge(action_count) AS action_count,\n" +
                    "        sumMerge(http_count) AS http_count,\n" +
                    "        sumMerge(http_error_count) AS http_error_count,\n" +
                    "        sumMerge(crash_count) AS crash_count,\n" +
                    "        sumMerge(anr_count) AS anr_count,\n" +
                    "        sumMerge(slow_count) AS slow_count,\n" +
                    "        sumMerge(http_third_count) AS http_third_count\n" +
                    "        FROM all_visit_agg_1m\n" +
                    "        where\n" +
                    "            app_id in (1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21)\n" +
                    "        GROUP BY app_id\n" +
                    "        ORDER BY app_id;");

            ResultSet resultSet = preparedStatement.executeQuery();
            int col = resultSet.getMetaData().getColumnCount();
            System.out.println("+----------------------------+");
            while (resultSet.next()) {
                for (int i = 1; i <= col; i++) {
                    System.out.print(resultSet.getString(i) + "\t");
                    if ((i == 2) && (resultSet.getString(i).length() < 8)) {
                        System.out.print("\t");
                    }
                }
                System.out.println("");
            }
            System.out.println("+----------------------------+");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
