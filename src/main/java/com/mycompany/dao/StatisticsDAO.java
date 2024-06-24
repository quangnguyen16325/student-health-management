package com.mycompany.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

public class StatisticsDAO {
    private final DecimalFormat decimalFormat = new DecimalFormat("#.##");
    private final String dbURL = "jdbc:sqlserver://QUANGNGUYEN;databaseName=QLSKSV;useUnicode=true&characterEncoding=UTF-8;user=sa;password=12345;encrypt=true;trustServerCertificate=true";

    public void genderDistributionSummary(JLabel maleTotal, JLabel femaleTotal, JLabel malePercentLabel, JLabel femalePercentLabel) {
        try (Connection conn = DriverManager.getConnection(dbURL);
            PreparedStatement stmt = conn.prepareStatement("SELECT gender, COUNT(*) as count FROM details GROUP BY gender")) {
            ResultSet rs = stmt.executeQuery();
            int maleCount = 0, femaleCount = 0, sumGender;
            double malePercent, femalePercent;
            while (rs.next()) {
                String gender = rs.getString("gender");
                int count = rs.getInt("count");

                if ("Male".equalsIgnoreCase(gender)) {
                    maleCount = count;
                } else if ("Female".equalsIgnoreCase(gender)) {
                    femaleCount = count;
                }
            }
            sumGender = maleCount + femaleCount;
            malePercent = (maleCount * 100.0) / sumGender;
            femalePercent = 100.0 - malePercent;
            maleTotal.setText(String.valueOf(maleCount));
            femaleTotal.setText(String.valueOf(femaleCount));
            malePercentLabel.setText(String.valueOf(decimalFormat.format(malePercent)));
            femalePercentLabel.setText(String.valueOf(decimalFormat.format(femalePercent)));
        } catch (SQLException ex) {
            Logger.getLogger(StatisticsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void avgStatistic(JLabel totalStudentLabel, JLabel totalStudentLabel1, JLabel totalStudentLabel2, JLabel avgHeightLabel, JLabel avgWeightLabel, JLabel avgBMILabel) {
        try (Connection conn = DriverManager.getConnection(dbURL);
             PreparedStatement stmt = conn.prepareStatement("SELECT height, weight, bmi FROM healths")) {
            ResultSet rs = stmt.executeQuery();
            int count = 0;
            double totalHeight = 0.0;
            double totalWeight = 0.0;
            double totalBMI = 0.0;
            while (rs.next()) {
                double height = rs.getDouble("height");
                double weight = rs.getDouble("weight");
                double bmi = rs.getDouble("bmi");

                totalHeight += height;
                totalWeight += weight;
                totalBMI += bmi;

                count++;
            }
            double averageHeight = count > 0 ? totalHeight / count : 0.0;
            double averageWeight = count > 0 ? totalWeight / count : 0.0;
            double averageBMI = count > 0 ? totalBMI / count : 0.0;

            String averageHeightText = decimalFormat.format(averageHeight);
            String averageWeightText = decimalFormat.format(averageWeight);
            String averageBMIText = decimalFormat.format(averageBMI);

            totalStudentLabel.setText(String.valueOf(count));
            totalStudentLabel1.setText(String.valueOf(count));
            totalStudentLabel2.setText(String.valueOf(count));
            avgHeightLabel.setText(averageHeightText);
            avgWeightLabel.setText(averageWeightText);
            avgBMILabel.setText(averageBMIText);

        } catch (SQLException ex) {
            Logger.getLogger(StatisticsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void bloodGroupStatistics(JLabel groupALabel, JLabel groupBLabel, JLabel groupABLabel, JLabel groupOLabel) {
        try (Connection conn = DriverManager.getConnection(dbURL);
             PreparedStatement stmt = conn.prepareStatement("SELECT bloodType, COUNT(*) as count FROM healths GROUP BY bloodType")) {
            ResultSet rs = stmt.executeQuery();
            int grACount = 0, grBCount = 0, grABCount = 0, grOCount = 0;
            while (rs.next()) {
                String bloodType = rs.getString("bloodType");
                int count = rs.getInt("count");

                switch (bloodType.toUpperCase()) {
                    case "GROUP A":
                        grACount = count;
                        break;
                    case "GROUP B":
                        grBCount = count;
                        break;
                    case "GROUP AB":
                        grABCount = count;
                        break;
                    case "GROUP O":
                        grOCount = count;
                        break;
                }
            }
            groupALabel.setText(String.valueOf(grACount));
            groupBLabel.setText(String.valueOf(grBCount));
            groupABLabel.setText(String.valueOf(grABCount));
            groupOLabel.setText(String.valueOf(grOCount));

        } catch (SQLException ex) {
            Logger.getLogger(StatisticsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void healthStatusStatistics(JLabel exceLabel, JLabel goodLabel, JLabel aveLabel, JLabel fairLabel, JLabel poorLabel, JLabel veryPoorLabel) {
        try (Connection conn = DriverManager.getConnection(dbURL);
            PreparedStatement stmt = conn.prepareStatement("SELECT healthStatus, COUNT(*) as count FROM healths GROUP BY healthStatus")) {
            ResultSet rs = stmt.executeQuery();
            int exceCount = 0, goodCount = 0, aveCount = 0, fairCount = 0, poorCount = 0, veryPoorCount = 0;
            while (rs.next()) {
                String healthStatus = rs.getString("healthStatus");
                int count = rs.getInt("count");

                switch (healthStatus) {
                    case "Sức khỏe rất tốt":
                        exceCount = count;
                        break;
                    case "Sức khỏe tốt":
                        goodCount = count;
                        break;
                    case "Sức khỏe khá":
                        aveCount = count;
                        break;
                    case "Sức khỏe trung bình":
                        fairCount = count;
                        break;
                    case "Sức khỏe kém":
                        poorCount = count;
                        break;
                    case "Sức khỏe rất kém":
                        veryPoorCount = count;
                        break;
                }
            }
            exceLabel.setText(String.valueOf(exceCount));
            goodLabel.setText(String.valueOf(goodCount));
            aveLabel.setText(String.valueOf(aveCount));
            fairLabel.setText(String.valueOf(fairCount));
            poorLabel.setText(String.valueOf(poorCount));
            veryPoorLabel.setText(String.valueOf(veryPoorCount));

        } catch (SQLException ex) {
            Logger.getLogger(StatisticsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
