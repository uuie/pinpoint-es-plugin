
package com.navercorp.pinpoint.plugin.google.es;

import com.navercorp.pinpoint.common.trace.ServiceType;
import com.navercorp.pinpoint.common.trace.ServiceTypeFactory;

import static com.navercorp.pinpoint.common.trace.ServiceTypeProperty.*;

/**
 * 
 * @author chris
 *
 */
public final class ElasticSearchClientConstants {
    private ElasticSearchClientConstants() {
    }

    public static final ServiceType ES_CLIENT_INTERNAL = ServiceTypeFactory.of(2999, "ES_CLIENT_INTERNAL", TERMINAL, RECORD_STATISTICS,INCLUDE_DESTINATION_ID);

    public static final String ES_SCOPE="elasticSearchScope";
    
}
