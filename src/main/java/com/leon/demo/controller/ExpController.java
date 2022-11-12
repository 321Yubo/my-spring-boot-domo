package com.leon.demo.controller;

import clojure.lang.IFn;
import clojure.lang.LazySeq;
import clojure.lang.PersistentArrayMap;
import clojure.lang.Ratio;
import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;

import com.leon.demo.entity.RunExp;
import com.leon.demo.po.CsvDataSet;
import com.leon.demo.util.ClojureUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@Slf4j
public class ExpController {

    private static final String cljDemo = "ppdsp.demo";

    /**
     * 加载clojure命名空间
     */
    static {
        ClojureUtil.requireNameSpace(cljDemo);
    }
    @RequestMapping(value = "runExpWithThreads", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public String runExpWithThreads(@RequestBody RunExp runExp){
        log.info("前端传参{}", JSON.toJSONString(runExp));
        testRunExpWithThreads(runExp);
        return "done";
    }

    public static void testRunExpWithThreads(RunExp runExp) {

        IFn initConfig = ClojureUtil.referClojureFn(cljDemo, "init-config");
        initConfig.invoke(ClojureUtil.arem_all_interleavedFile);
        double growth_rate_kt = Double.parseDouble(runExp.getGrowth_rate_k());
        int cycle_sizet = Integer.parseInt(runExp.getCycle_size());
        IFn runExpInvoke = ClojureUtil.referClojureFn(cljDemo, "run-exp-threads");
        runExpInvoke.invoke(growth_rate_kt, Lists.newArrayList(cycle_sizet),runExp.getThreads_per_configuration(), runExp.getThreads_per_evaluation());
    }
    @ResponseBody
    @RequestMapping(value = "runExp", method = {RequestMethod.POST, RequestMethod.GET})
    public Map<String, Object> runExp(@RequestBody RunExp runExp) {
        log.info("获取前端参数growth_rate_k:" + runExp.getGrowth_rate_k());
        log.info("获取前端参数cycle_size:" + runExp.getCycle_size());
        double growth_rate_kt = Double.parseDouble(runExp.getGrowth_rate_k());
        int cycle_sizet = Integer.parseInt(runExp.getCycle_size());
        testRunExp(growth_rate_kt, cycle_sizet);
        log.info("获取返回值------------------");
        Map<String, Object> params = getParams();
        log.info("获取返回值params------------------"+params);
        return params;
    }

    @RequestMapping(value = "/getParams", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public Map<String, Object> getParams() {
        return testRunDemo();
    }

    public static void testRunExp(double growth_rate_k, int cycle_size) {
        IFn initConfig = ClojureUtil.referClojureFn(cljDemo, "init-config");
        initConfig.invoke(ClojureUtil.arem_all_interleavedFile);

        IFn runExp = ClojureUtil.referClojureFn(cljDemo, "run-exp");
        runExp.invoke(growth_rate_k, Lists.newArrayList(cycle_size));
    }

    public static Map<String, Object> testRunDemo() {
        IFn initConfig = ClojureUtil.referClojureFn(cljDemo, "init-config");
        initConfig.invoke(ClojureUtil.arem_all_interleavedFile);

        IFn makeData = ClojureUtil.referClojureFn(cljDemo, "make-data");
        makeData.invoke(ClojureUtil.logisticFile);

        IFn getAccuracy = ClojureUtil.referClojureFn(cljDemo, "get-accuracy");
        Double accuracy = ((Ratio) getAccuracy.invoke()).doubleValue();
        accuracy = (double) Math.round(accuracy * 10000) / 10000;

        IFn getPrivacy = ClojureUtil.referClojureFn(cljDemo, "get-privacy");
        List<CsvDataSet.Privacy> privacyList = (List<CsvDataSet.Privacy>) ((LazySeq) getPrivacy.invoke()).stream().map(p -> {
            CsvDataSet.Privacy privacy = new CsvDataSet.Privacy();
            privacy.setName(String.valueOf(((PersistentArrayMap) p).get("0_Strategy")));
            Double value = (Double) ((PersistentArrayMap) p).get(
                    "Total Mean prob. of ε-privacy breach");
            privacy.setValue((double) Math.round(value * 1000) / 1000);
            return privacy;
        }).collect(Collectors.toList());

        Map<String, Object> result = new HashMap<>();
        result.put("accuracy", accuracy);
        result.put("privacyList", privacyList);
        return result;
    }

}
