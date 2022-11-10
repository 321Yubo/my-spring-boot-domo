package com.leon.demo.po;

import clojure.lang.IFn;
import clojure.lang.LazySeq;
import clojure.lang.PersistentArrayMap;
import clojure.lang.Ratio;
import com.google.common.collect.Lists;
import com.leon.demo.util.ClojureUtil;

import java.util.List;
import java.util.stream.Collectors;

public class CsvDataSet {

  private static final String cljDemo = "ppdsp.demo";

  /**
   * 加载clojure命名空间
   */
  static {
    ClojureUtil.requireNameSpace(cljDemo);
  }

  public static void testRunExp() {
    IFn initConfig = ClojureUtil.referClojureFn(cljDemo, "init-config");
    initConfig.invoke("src/main/resources/arem_all_interleaved.csv");

    IFn runExp = ClojureUtil.referClojureFn(cljDemo, "run-exp");
    runExp.invoke(0.01,Lists.newArrayList(300));
  }

  public static void testRunDemo() {
    IFn initConfig = ClojureUtil.referClojureFn(cljDemo, "init-config");
    initConfig.invoke("src/main/resources/arem_all_interleaved.csv");

    IFn makeData = ClojureUtil.referClojureFn(cljDemo, "make-data");
    makeData.invoke("workspace/arem/logistic-cumulative.edn");

    IFn getAccuracy = ClojureUtil.referClojureFn(cljDemo, "get-accuracy");
    Double accuracy = ((Ratio) getAccuracy.invoke()).doubleValue();

    IFn getPrivacy = ClojureUtil.referClojureFn(cljDemo, "get-privacy");
    List<Privacy> privacyList = (List<Privacy>)((LazySeq) getPrivacy.invoke()).stream().map(p-> {
      Privacy privacy = new Privacy();
      privacy.setName(String.valueOf(((PersistentArrayMap)p).get("0_Strategy")));
      privacy.setValue((Double) ((PersistentArrayMap)p).get("Total Mean prob. of ε-privacy breach"));
      return privacy;
    }).collect(Collectors.toList());

    System.out.println();
  }

  public static class Privacy {
    private String name;
    private double value;

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public double getValue() {
      return value;
    }

    public void setValue(double value) {
      this.value = value;
    }
  }

  public static void main(String[] args) {
    testRunDemo();
  }


}
