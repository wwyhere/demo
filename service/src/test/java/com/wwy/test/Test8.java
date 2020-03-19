package com.wwy.test;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.EvaluatorException;
import org.mozilla.javascript.ScriptableObject;

public class Test8 {
    public static void main(String[] args) {
        Context cx = Context.enter();
        ScriptableObject scope = cx.initStandardObjects();
        Object obj = null;
        String calcFormula="1+2*3";
        try {
            obj = cx.evaluateString(scope, "function validFormula(){var obj = " + calcFormula + ";return obj;} validFormula();", "null", 1, null);
            System.out.println(obj);
        } catch (EvaluatorException e) {
            System.out.println("语法检测错误");
        }
    }
}
