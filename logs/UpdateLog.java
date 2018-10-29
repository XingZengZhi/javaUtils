package com.lizhen.lizhenDealerOA.util;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author XingZengZhi
 * @date 2018/10/29 14:50 
 * @description 记录更新日志
 * @param 
 * @return 
 */

public class UpdateLog {
    // try {
    //     UpdateLog.setUpdateLog(this.getClass().getCanonicalName() + ".getCode ", "更新微乐APP忘记密码接口");
    // } catch (IOException e) {
    //     e.printStackTrace();
    // }
    public static void main(String[] args) throws IOException {
        setUpdateLog("com.xxx.xxx.xxx.updateUserInfo", " test2");
    }
    public static void setUpdateLog(String methodName, String updateTip)throws IOException {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.now();
        try {
            File updateLog = new File("E://" + localDateTime.format(DateTimeFormatter.ofPattern("yyyyMMdd")) + "_UpdateLog.log");
            if(!updateLog.exists()) {
                updateLog.createNewFile();
            }
            BufferedWriter  out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(updateLog, true), "utf-8"));
            String updateStr = "[" + localDateTime.format(df) + "]" + methodName + updateTip;
            if(updateLog.length() != 0) {
                out.newLine();
            }
            out.write(updateStr);
            out.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
