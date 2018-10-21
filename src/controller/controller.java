package controller;

import Connection.connectWithDatabase;

import javax.speech.Central;
import javax.speech.synthesis.Synthesizer;
import javax.speech.synthesis.SynthesizerModeDesc;
import java.sql.*;
import java.util.ArrayList;
import java.util.Locale;

public class controller {

    //seach tu
    public static String findWord(String text) throws SQLException {
        text  = text.toLowerCase();
        Connection conn = connectWithDatabase.getConnection();
        assert conn != null;
        Statement stmt = conn.createStatement();
        String sql = "select detail from dictionary where word = ?";

        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, text);
            ResultSet rs = pstm.executeQuery();
            String Detail = "";
            while (rs.next()) {
                Detail = rs.getString("detail");
            }
            rs.close();
            stmt.close();
            conn.close();
            return Detail;
        } catch (Exception e) {
            System.out.println(e);
            return "";
        }
    }

    //Goi y
    public static String[] suggestionWord(String text) throws SQLException {
        ArrayList<String> list = new ArrayList<String>();
        text  = text.toLowerCase();
        Connection conn = connectWithDatabase.getConnection();
        assert conn != null;
        String sql = "select word from dictionary where word like ? limit ?";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, text + "%");
            pstm.setInt(2, 50);

            ResultSet rs = pstm.executeQuery();
            int i = 0;
            while (rs.next()) {
                String test = rs.getString("word");
                if (test != null) {
                    list.add(test);
                } else {
                    break;
                }
                i++;
            }
            int k = 0;
            int length = list.size();
            String[] result = new String[length];
            for (k = 0; k < i; k++) {
                result[k] = list.get(k);
            }
            return result;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public static String addWordToDatabase(String word, String detail) {
        word  = word.toLowerCase();
        Connection conn = connectWithDatabase.getConnection();
        assert conn != null;
        String sql = "insert into dictionary values(?, ?)";
        String check = "select word from dictionary where word = ?";
        try {
            PreparedStatement pstm = conn.prepareStatement(check);
            pstm.setString(1, word);
            ResultSet rs = pstm.executeQuery();
            String abc = "";
            while (rs.next()) {
                abc = rs.getString("word");
            }
            if(!abc.equals("")){
                System.out.println("Từ này đã có trong database");
                return "false";
            }
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, word);
            pstm.setString(2, detail);
            pstm.executeUpdate();
            return "true";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String deletaWordFromDatabase(String word){
        word  = word.toLowerCase();
        Connection conn = connectWithDatabase.getConnection();
        assert conn != null;
        String sql = "delete from dictionary where word = ?";
        String check = "select word from dictionary where word = ?";
        try {
            PreparedStatement pstm = conn.prepareStatement(check);
            pstm.setString(1, word);
            ResultSet rs = pstm.executeQuery();
            String abc = "";
            while (rs.next()) {
                abc = rs.getString("word");
            }
            if(abc.equals("")){
                System.out.println("Từ này đã có trong database");
                return "false";
            }
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, word);
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "true";
    }

    public static String editDetail(String word, String detail){
        word = word.toLowerCase();
        Connection con = connectWithDatabase.getConnection();
        String sql = "update dictionary set detail = ? where word = ?";
        String check = "select word from dictionary where word = ?";
        try {
            assert con != null;
            PreparedStatement pstm = con.prepareStatement(check);
            pstm.setString(1, word);
            ResultSet rs = pstm.executeQuery();
            String abc = "";
            while (rs.next()) {
                abc = rs.getString("word");
            }
            if(abc.equals("")){
                System.out.println("Từ này chưa có trong database");
                return "false";
            }
            pstm = con.prepareStatement(sql);
            pstm.setString(1, detail);
            pstm.setString(2, word);
            pstm.executeUpdate();
            return "true";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "true";
    }

    public static void textToSpeech(String text){
        try
        {
            // set property as Kevin Dictionary
            System.setProperty("freetts.voices",
                    "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
            // Register Engine
            Central.registerEngineCentral
                    ("com.sun.speech.freetts.jsapi.FreeTTSEngineCentral");
            Synthesizer synthesizer =
                    Central.createSynthesizer(new SynthesizerModeDesc(Locale.US));
            synthesizer.allocate();
            synthesizer.resume();
            synthesizer.speakPlainText(text, null);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
