package com.bobby.peng.learning.spring.test.kafka;

import com.bobby.peng.learning.spring.kafka.KafkaConfig;
import com.bobby.peng.learning.spring.kafka.Listener;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.*;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;


/**
 * Created by bobby.peng on 28/03/2018.
 */
@ContextConfiguration(classes = {KafkaConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class KafkaTest {


    @Autowired
    private Listener listener;

    @Autowired
    private KafkaTemplate<String, String> template;

    @Test
    public void testSimple() throws Exception {
        template.send("annotated1", "0", "foo");
        template.flush();
    }
}
