package com.test.start;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.seg.common.Term;

import java.util.List;

/**
 * @Author Jface
 * @Date 2021/8/20 19:47
 * @Since version-1.0
 * @Desc 测试HanLP的使用
 */
public class Demo5HanLP {
    public static void main(String[] args) {
        List<Term> terms = HanLP.segment("我永远喜欢你");
        for (Term term : terms) {
            System.out.println(term.word);
        }

    }
}
