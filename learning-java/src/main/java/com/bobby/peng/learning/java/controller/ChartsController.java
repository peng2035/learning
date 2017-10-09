package com.bobby.peng.learning.java.controller;

import com.bobby.peng.learning.java.common.CommonResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.misc.Contended;

/**
 * Created by peng2035 on 16-12-3.
 */
@Contended
@RequestMapping("/charts")
public class ChartsController {

    @ResponseBody
    public CommonResponse<String> showTree() {
        return new CommonResponse<>();
    }

}
