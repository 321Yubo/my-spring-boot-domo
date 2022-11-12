package com.leon.demo.util;

import clojure.java.api.Clojure;
import clojure.lang.IFn;
import org.springframework.util.ClassUtils;

public class ClojureUtil {
    private static final IFn require = Clojure.var("clojure.core", "require");

    /**
     * 加载指定的Clojure空间 使用相应空间的函数前必须先调用该函数加载相应空间
     *
     * @param ns
     */
    public static final void requireNameSpace(String ns) {
        require.invoke(Clojure.read(ns));
    }

    /**
     * 引用指定空间中的相应Clojure函数 注意：先加载相应函数
     */
    public static final IFn referClojureFn(String ns, String fn) {
        return Clojure.var(ns, fn);
    }

   public static String path = ClassUtils.getDefaultClassLoader().getResource("").getPath();
   //public static String path = "/export/test/";
  // public static String path = "/Users/zhoushaowei3/Documents/111/11/";
    public static String arem_all_interleavedFile = path + "arem_all_interleaved.csv";
    public static String logisticFile = path + "logistic-cumulative.edn";

}
