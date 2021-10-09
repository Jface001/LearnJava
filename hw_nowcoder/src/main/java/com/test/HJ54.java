package com.test;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.Scanner;

/**
 * @Author: Jface
 * @Date: 2021/10/9 21:30
 * @Desc: 表达式求职
 * https://www.nowcoder.com/practice/9566499a2e1546c0a257e885dfdbf30d
 * 思路：获取 JS 脚本执行引擎实现，虽然慢但是可以实现
 */
public class HJ54 {
    public static void main(String[] args) {
        String str = null;
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            str = sc.nextLine();
            ScriptEngineManager manager = new ScriptEngineManager();
            ScriptEngine engine = manager.getEngineByName("js");
            Object result = null;
            try {
                result = engine.eval(str);
                System.out.println(result.toString());
            } catch (ScriptException e) {
                e.printStackTrace();
            }


        }

    }
}
