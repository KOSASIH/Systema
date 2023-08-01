package com.kosasih.systema;

import com.kosasih.systema.SystemaApp;
import com.kosasih.systema.config.AsyncSyncConfiguration;
import com.kosasih.systema.config.EmbeddedElasticsearch;
import com.kosasih.systema.config.EmbeddedKafka;
import com.kosasih.systema.config.EmbeddedSQL;
import com.kosasih.systema.config.TestSecurityConfiguration;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

/**
 * Base composite annotation for integration tests.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@SpringBootTest(classes = { SystemaApp.class, AsyncSyncConfiguration.class, TestSecurityConfiguration.class })
@EmbeddedElasticsearch
@EmbeddedSQL
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
@EmbeddedKafka
public @interface IntegrationTest {
}
